package dev.patika.homework05.service;

import dev.patika.homework05.dto.InstructorDTO;
import dev.patika.homework05.entity.Instructor;
import dev.patika.homework05.entity.InstructorSalaryLog;
import dev.patika.homework05.entity.enums.SalaryChangeType;
import dev.patika.homework05.exception.InstructorIsAlreadyExistException;
import dev.patika.homework05.exception.InstructorIsNotExistException;
import dev.patika.homework05.exception.InstructorLogIsNotExistException;
import dev.patika.homework05.mappers.InstructorMapper;
import dev.patika.homework05.repository.InstructorRepository;
import dev.patika.homework05.repository.SalaryLogRepository;
import dev.patika.homework05.utils.ClientRequestInfo;
import dev.patika.homework05.utils.ErrorMessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;
    @Autowired(required = false)
    private InstructorMapper instructorMapper;
    @Autowired
    private SalaryLogRepository salaryLogRepository;
    @Autowired(required = false)
    private ClientRequestInfo clientRequestInfo;

    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    public Optional<Instructor> findById(long id) {
        Optional<Instructor> instructor = Optional.of(instructorRepository.findById(id)
                .orElseThrow(() -> new InstructorIsNotExistException(ErrorMessageConstants.INSTRUCTOR_IS_NOT_EXIST)));
        if(instructor.isPresent()){
            return instructor;
        }
        throw new InstructorIsNotExistException(ErrorMessageConstants.INSTRUCTOR_IS_NOT_EXIST);

    }

    public String save(InstructorDTO instructorDTO) {
        if(this.isExistOnDatabase(instructorDTO.getPhoneNumber())){
            throw new InstructorIsAlreadyExistException(ErrorMessageConstants.INSTRUCTOR_PHONE_NUMBER_MUST_BE_UNIQUE);
        }else {
            Instructor instructor = new Instructor();
            instructorMapper.updateInstructorFromDto(instructorDTO,instructor);
            instructorRepository.save(instructor);
            return "Instructor with id:" + instructorDTO.getId() + " saved";
        }
    }

    /**
     * Method that saves the instructor to database for data loader
     * @param instructor
     * @return Saved Instructor Object
     */
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void deleteById(long id) {
        try {
            instructorRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new InstructorIsNotExistException(ErrorMessageConstants.INSTRUCTOR_IS_NOT_EXIST);
        }
    }

    /**
     * method for update an existing instructor from database
     * @param instructorDTO
     */
    @Transactional
    public InstructorDTO update(InstructorDTO instructorDTO) {
        Instructor instructor = instructorRepository.findById(instructorDTO.getId())
                .orElseThrow(() -> new InstructorIsNotExistException(ErrorMessageConstants.INSTRUCTOR_IS_NOT_EXIST));
        instructorMapper.updateInstructorFromDto(instructorDTO,instructor);
        return instructorDTO;
    }

    /**
     *
     * @param id
     * @param salaryRate
     */
    @Transactional
    public void updateSalary(long id, double salaryRate) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new InstructorIsNotExistException(ErrorMessageConstants.INSTRUCTOR_IS_NOT_EXIST));
         this.saveSalaryChangesToDatabase(instructor,salaryRate);
         instructor.setSalary(this.calculateSalary(instructor.getSalary(),salaryRate));
         instructorRepository.save(instructor);
    }

    public List<InstructorSalaryLog> getAllInstructorSalaryLogs(){
        return (List<InstructorSalaryLog>) salaryLogRepository.findAll();
    }

    /**
     *
     * @param id
     * @return list of salary logs in database
     */
    public Optional<List<InstructorSalaryLog>> getInstructorSalaryLogsByInstructorId(Long id) {
        Optional<List<InstructorSalaryLog>> salaryLogs = Optional.of(salaryLogRepository.findByInstructorId(id));
        if(salaryLogs.isPresent()){
            return salaryLogs;
        }else {
            throw new InstructorLogIsNotExistException(ErrorMessageConstants.INSTRUCTOR_LOG_IS_NOT_EXIST);
        }
    }

    @Transactional
    private void saveSalaryChangesToDatabase(Instructor instructor,double salaryRate){
        InstructorSalaryLog serviceSalaryLogger = new InstructorSalaryLog();
        serviceSalaryLogger.setInstructorId(instructor.getId());
        serviceSalaryLogger.setDate(LocalDateTime.now());

        if(salaryRate > 0) {
            serviceSalaryLogger.setType(SalaryChangeType.INCREASE);
        }else {
            serviceSalaryLogger.setType(SalaryChangeType.DECREASE);
        }

        serviceSalaryLogger.setClientUrl(clientRequestInfo.getClientUrl());
        serviceSalaryLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        serviceSalaryLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        serviceSalaryLogger.setSalaryBefore(instructor.getSalary());
        serviceSalaryLogger.setSalaryAfter(this.calculateSalary(instructor.getSalary(),salaryRate));
        salaryLogRepository.save(serviceSalaryLogger);
    }

    private double calculateSalary(double salary, double salaryRate) {
        return salary + salary*(salaryRate/100);
    }

    /**
     * method for checking if phone number exist in database
     * @param phoneNumber
     * @return
     */
    private boolean isExistOnDatabase(String phoneNumber) {
        Instructor instructor = instructorRepository.findInstructorsByPhoneNumber(phoneNumber);
        if (instructor == null) {
            return false;
        }else {
            return true; }
    }

    public Optional<List<InstructorSalaryLog>> getSalaryLogsBetweenTwoDate(LocalDateTime firstDate, LocalDateTime lastDate) {
        Optional<List<InstructorSalaryLog>> salaryLogs = Optional.of(salaryLogRepository.findByDateGreaterThanEqualAndDateLessThan(firstDate,lastDate));
        if(salaryLogs.isPresent()){
            return salaryLogs;
        }
        throw new InstructorIsNotExistException(ErrorMessageConstants.INSTRUCTOR_IS_NOT_EXIST);
    }
}
