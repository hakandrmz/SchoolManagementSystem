package tech.hdurmaz.sms.mappers;


import tech.hdurmaz.sms.dto.CourseDTO;
import tech.hdurmaz.sms.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    void updateCourseFromDto(CourseDTO courseDTO, @MappingTarget Course course);
    void updateCourseDtoFromCourse(Course course, @MappingTarget CourseDTO courseDTO);
}
