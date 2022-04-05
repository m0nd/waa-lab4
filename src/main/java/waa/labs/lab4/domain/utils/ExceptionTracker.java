package waa.labs.lab4.domain.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exception")
public class ExceptionTracker {
    static final String principleName = "rbroome";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long transactionId;

    LocalDate date;
    LocalDate time;
    String principle;
    String operation;
    String exceptionType;
}
