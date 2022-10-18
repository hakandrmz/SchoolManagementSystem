package tech.hdurmaz.sms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.hdurmaz.sms.entity.enums.InstructorType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorDto {

    private String name;
    private String address;
    private String phoneNumber;
    private double salary;

    @Enumerated(EnumType.STRING)
    private InstructorType type;
}
