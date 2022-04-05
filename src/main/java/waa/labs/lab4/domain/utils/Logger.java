package waa.labs.lab4.domain.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import waa.labs.lab4.domain.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Logger {
    @Transient
    public static final String PRINCIPLE_NAME = "rbroome";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long transactionId;

    LocalDate date;
    LocalTime time;

    String principle;
    String operation;
}
