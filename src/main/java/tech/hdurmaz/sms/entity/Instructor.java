package tech.hdurmaz.sms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import tech.hdurmaz.sms.entity.enums.InstructorType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Instructor extends AbstractBaseEntity{

    @Enumerated(EnumType.STRING)
    @NonNull
    private InstructorType type;

    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String phoneNumber;
    @NonNull
    private double salary;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnore
    private List<Course> courses;

}
