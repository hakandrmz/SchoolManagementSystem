package dev.patika.homework05.repository;


import dev.patika.homework05.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
    Course findCourseByCourseCode(String word);
}
