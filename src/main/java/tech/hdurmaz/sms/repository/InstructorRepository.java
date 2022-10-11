package tech.hdurmaz.sms.repository;


import tech.hdurmaz.sms.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    Instructor findInstructorsByPhoneNumber(String word);
}
