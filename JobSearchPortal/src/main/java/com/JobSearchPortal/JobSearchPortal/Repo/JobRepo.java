package com.JobSearchPortal.JobSearchPortal.Repo;

import com.JobSearchPortal.JobSearchPortal.Model.Job;
import com.JobSearchPortal.JobSearchPortal.Model.Type;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobRepo extends CrudRepository<Job,Long> {
     public List<Job> findByJobTitle(String jobTitle);


    List<Job> findByJobSalaryGreaterThanEqual(Double jobSalary);

    List<Job> findByJobSalaryBetweenAndJobTitle(Double salary1, Double salary2, String title);

    List<Job> findByJobType(Type type);
    //custom Query
    @Modifying
    @Transactional
    @Query(value ="update JOB set JOB_TYPE=:type where JOB_ID=:jobId",nativeQuery = true)
    void updateJobTypeWithId(String type, Long jobId);
    @Modifying
    @Transactional
    @Query(value = "delete from JOB where JOB_ID=:jobId",nativeQuery = true)
    void deleteJobById(Long jobId);

    @Modifying
    @Transactional
    @Query(value = "insert into JOB values (:appliedDate,:jobSalary,:jobId,:companyEmail,:companyName,:employerName,:jobDescription,:jobLocation,:jobTitle,:string)",nativeQuery = true)
    void addJobWithCustomQuery(Long jobId,String jobTitle, String jobDescription,String jobLocation, Double jobSalary,String companyEmail,String companyName,String employerName, String string,LocalDate appliedDate);

    @Query(value = "select * from JOB where JOB.JOB_TYPE=:jobType and JOB.JOB_SALARY>=:salary",nativeQuery = true)
    List<Job> getJobBasedOnCondition(String jobType, Double salary);
}
