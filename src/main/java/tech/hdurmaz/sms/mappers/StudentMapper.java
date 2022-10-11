package tech.hdurmaz.sms.mappers;


import tech.hdurmaz.sms.dto.StudentDTO;
import tech.hdurmaz.sms.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    void updateStudentFromDto(StudentDTO studentDTO, @MappingTarget Student Student);
    void updateStudentDtoFromStudent(Student Student, @MappingTarget StudentDTO studentDTO);
}
