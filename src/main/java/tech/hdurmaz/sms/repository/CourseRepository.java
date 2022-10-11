package tech.hdurmaz.sms.repository;


import tech.hdurmaz.sms.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
    Course findCourseByCourseCode(String word);
}
