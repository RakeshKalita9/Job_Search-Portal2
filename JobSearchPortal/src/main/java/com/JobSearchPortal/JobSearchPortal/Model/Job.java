package com.JobSearchPortal.JobSearchPortal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Job {
    @NotNull
    @Id
    private Long jobId;
    @NotBlank
    private String jobTitle;
    @NotEmpty
    private String jobDescription;
    @NotBlank
    private String jobLocation;
    @Min(value = 20000,message = "salary cant be less than 20000 ")
    private Double jobSalary;
    @Email
    private String companyEmail;
    @NotEmpty
    private String companyName;
    @NotBlank
    private String employerName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type jobType;
    @NotNull
    private LocalDate appliedDate;
}
