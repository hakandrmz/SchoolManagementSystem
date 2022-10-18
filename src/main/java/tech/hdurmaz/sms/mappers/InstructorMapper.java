package tech.hdurmaz.sms.mappers;


import tech.hdurmaz.sms.dto.InstructorDTO;
import tech.hdurmaz.sms.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    void updateInstructorFromDto(InstructorDTO instructorDTO, @MappingTarget Instructor instructor);
    void updateInstructorDTOFromInstructor(Instructor instructor, @MappingTarget InstructorDTO instructorDTO);
}
