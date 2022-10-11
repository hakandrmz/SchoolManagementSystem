package tech.hdurmaz.sms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends AbstractBaseEntity{

    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
    @ToString.Exclude
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

}
