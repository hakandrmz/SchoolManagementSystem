package tech.hdurmaz.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private long id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;

}
