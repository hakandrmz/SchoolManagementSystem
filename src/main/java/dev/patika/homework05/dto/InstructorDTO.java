package dev.patika.homework05.dto;


import dev.patika.homework05.entity.enums.InstructorType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO {

    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Hakan")
    private String name;

    @ApiModelProperty(example = "Uskudar/Istanbul")
    private String address;

    @ApiModelProperty(example = "5389759463")
    private String phoneNumber;

    @ApiModelProperty(example = "10101")
    private double salary;

    @Enumerated(EnumType.STRING)
    private InstructorType type;
}
