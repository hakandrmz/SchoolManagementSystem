package tech.hdurmaz.sms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.hdurmaz.sms.entity.InstructorSalaryLog;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SalaryLogRepository extends CrudRepository<InstructorSalaryLog,Long> {

    List<InstructorSalaryLog> findByInstructorId(Long id);

    @Query("select i from InstructorSalaryLog i where i.date < ?1")
    List<InstructorSalaryLog> findByDateGreaterThanEqualAndDateLessThan(LocalDateTime firstDate, LocalDateTime lastDate);

}
