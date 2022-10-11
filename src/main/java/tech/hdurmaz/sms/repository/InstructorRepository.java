package tech.hdurmaz.sms.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.hdurmaz.sms.entity.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    Instructor findInstructorsByPhoneNumber(String word);
}
