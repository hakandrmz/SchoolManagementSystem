package tech.hdurmaz.sms.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.hdurmaz.sms.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
    Course findCourseByCourseCode(String word);
}
