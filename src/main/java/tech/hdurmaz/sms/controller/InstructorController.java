package tech.hdurmaz.sms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hdurmaz.sms.dto.InstructorDTO;
import tech.hdurmaz.sms.entity.Instructor;
import tech.hdurmaz.sms.entity.InstructorSalaryLog;
import tech.hdurmaz.sms.service.InstructorService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InstructorController {

    @Autowired
    private final InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<InstructorDTO> getAllInstructors(){
        return new ResponseEntity(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("instructors/{id}")
    public ResponseEntity<InstructorDTO> getInstructorById(@PathVariable long id){
        return new ResponseEntity(instructorService.findById(id),HttpStatus.OK);
    }

    @PostMapping("instructor/add")
    public ResponseEntity<InstructorDTO> addNewInstructor(@RequestBody InstructorDTO instructorDTO){
        instructorService.save(instructorDTO);
        return new ResponseEntity("Instructor added to database",HttpStatus.OK);
    }

    @DeleteMapping("instructor/delete/{id}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable long id){
        instructorService.deleteById(id);
        return new ResponseEntity<>("Instructed with id " + id + " deleted",HttpStatus.OK);
    }

    @PutMapping("instructor/update")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody InstructorDTO instructorDTO){
        return new ResponseEntity(instructorService.update(instructorDTO),HttpStatus.OK);
    }

    @PutMapping("instructor/updatesalary/{id}/{salaryRate}")
    public ResponseEntity<InstructorDTO> updateSalary(@PathVariable long id,
                                                      @PathVariable double salaryRate){
        instructorService.updateSalary(id,salaryRate);
        return new ResponseEntity("Instructor with id " + id + " updated.", HttpStatus.OK);
    }

    @GetMapping("instructor/getSalaryLogs")
    public ResponseEntity<InstructorSalaryLog> getAllSalaryChangesLogs(){
        return new ResponseEntity(instructorService.getAllInstructorSalaryLogs(),HttpStatus.OK);
    }

    @GetMapping("instructor/getSalaryLogsByInstructorId/{id}")
    public ResponseEntity<InstructorSalaryLog> getAllSalaryLogsByInstructorId(@PathVariable Long id){


        Optional<List<InstructorSalaryLog>> salaryLogs = instructorService.getInstructorSalaryLogsByInstructorId(id);
        if(salaryLogs.isPresent()){
            return new ResponseEntity(salaryLogs,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("instructor/getSalaryLogsBetweenTwoDate/{firstDate}/{lastDate}")
    public ResponseEntity<InstructorSalaryLog> getSalaryChangesBetweenTwoDate(@PathVariable LocalDateTime firstDate,
                                                                              @PathVariable LocalDateTime lastDate){
        Optional<List<InstructorSalaryLog>> salaryLogs = instructorService.getSalaryLogsBetweenTwoDate(firstDate,lastDate);
        if(salaryLogs.isPresent()){
            return new ResponseEntity(salaryLogs,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}












