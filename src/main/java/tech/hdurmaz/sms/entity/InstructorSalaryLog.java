package tech.hdurmaz.sms.entity;

import lombok.*;
import tech.hdurmaz.sms.entity.enums.SalaryChangeType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorSalaryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long instructorId;
    private double salaryBefore;
    private double salaryAfter;

    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;

    @Enumerated(EnumType.STRING)
    private SalaryChangeType type;

    @NonNull
    private LocalDateTime date;

}
