package com.JobSearchPortal.JobSearchPortal.Service;

import com.JobSearchPortal.JobSearchPortal.Model.Job;
import com.JobSearchPortal.JobSearchPortal.Model.Type;
import com.JobSearchPortal.JobSearchPortal.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepo jobRepo;


    public String addJob(Job job) {
        jobRepo.save(job);
        return "Job Posted";

    }

    public List<Job> getAllJob() {
        Iterable<Job> jobList = jobRepo.findAll();
        return (List<Job>) jobList;
        }

    public Optional<Job> getJobId(Long jobId) {
          return jobRepo.findById(jobId);

    }

    public String deleteJob(Long jobId) {
        if(jobRepo.existsById(jobId)){
           Optional<Job> job = jobRepo.findById(jobId);
            job.ifPresent(value -> jobRepo.delete(value));
            return "job removed";

        }
        return "InvalidId";
    }

    public List<Job> findByJobTitle(String jobTitle) {
        return jobRepo.findByJobTitle(jobTitle);
    }

    public List<Job> findByJobSalaryGreaterThanEqual(Double jobSalary) {
        return jobRepo.findByJobSalaryGreaterThanEqual(jobSalary);
    }

    public List<Job> findByJobSalaryBetweenAndJobTitle(Double salary1, Double salary2, String title) {
        return jobRepo.findByJobSalaryBetweenAndJobTitle(salary1,salary2,title);
    }

    public List<Job> findByJobType(Type type) {
        return jobRepo.findByJobType(type);
    }
 //custom Query
    public  String updateJobTypeWithId(String type, Long jobId) {
       jobRepo.updateJobTypeWithId(type,jobId);
       return "JobType Updated";
    }

    public String deleteJobById(Long jobId) {
        jobRepo.deleteJobById(jobId);
        return "job Removed successfully";
    }

    public String addJobWithCustomQuery(Job job) {
        jobRepo.addJobWithCustomQuery(job.getJobId(),job.getJobTitle(),job.getJobDescription(),job.getJobLocation(),job.getJobSalary(),job.getCompanyEmail(),job.getCompanyName(),job.getEmployerName(),job.getJobType().toString(),job.getAppliedDate());
        return "Job Posted Using Custom Query";
    }

    public List<Job> getJobBasedOnCondition(String jobType, Double salary) {
        return jobRepo.getJobBasedOnCondition(jobType,salary);
    }
}


