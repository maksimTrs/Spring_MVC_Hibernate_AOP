package com.spring.mvc.entities;


import lombok.*;
import org.apache.log4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Table(name = "employees")
@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor  // custom constructor for all fields with @NonNull
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name = "name")
    @Size(min = 2, max = 30, message = "Wrong name length! [2,30]")
    private String name;
    @NonNull
    @Column(name = "surname")
    private String surname;
    @NonNull
    @Column(name = "department")
    @NotBlank(message = "Must not be empty!")
    private String department;
    @NonNull
    @Column(name = "salary")
    @Min(value = 0, message = "Min val from 0")
    @Max(value = 1_000_000, message = "Add correct salary value!")
    private BigInteger salary;
}
