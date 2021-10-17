package dev.patika.homework05.mappers;


import dev.patika.homework05.dto.StudentDTO;
import dev.patika.homework05.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    void updateStudentFromDto(StudentDTO studentDTO, @MappingTarget Student Student);
    void updateStudentDtoFromStudent(Student Student, @MappingTarget StudentDTO studentDTO);
}
