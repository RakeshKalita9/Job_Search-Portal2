package com.JobSearchPortal.JobSearchPortal.Controller;

import com.JobSearchPortal.JobSearchPortal.Model.Job;
import com.JobSearchPortal.JobSearchPortal.Model.Type;
import com.JobSearchPortal.JobSearchPortal.Service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    @Autowired
    JobService jobService;
    //CrudMethod
    //add Job
    @PostMapping("job")
    public String addJob(@Valid @RequestBody Job job){
        return jobService.addJob(job);
    }
    //GetAllJob
    //getAllJob
    @GetMapping("job")
    public List<Job> getAllJob(){
      return jobService.getAllJob();
    }
    //get a Job By id

    @GetMapping("job/jobId/{jobId}")
    public Optional<Job> getJobId(@PathVariable Long jobId){
        return jobService.getJobId(jobId);
    }
    @DeleteMapping("job/jobId/{jobId}")
    public String deleteJob(@PathVariable Long jobId){
        return jobService.deleteJob(jobId);
    }

    // Custom Finder

    @GetMapping("job/jobTitle/{jobTitle}")
    public List<Job> findByJobTitle(@PathVariable String jobTitle){
        return jobService.findByJobTitle(jobTitle);
    }
    //returns all job Greater than input job salary
    @GetMapping("job/jobSalary/{jobSalary}")
    public List<Job> findByJobSalaryGreaterThanEqual(@PathVariable Double jobSalary){
        return jobService.findByJobSalaryGreaterThanEqual(jobSalary);
    }
    @GetMapping("job/jobSalary1/{Salary1}/jobSalary2/{Salary2}/jobTitle/{title}")
    public List<Job> findByJobSalaryBetweenAndJobTitle(@PathVariable Double Salary1,@PathVariable Double Salary2,@PathVariable String title){
        return jobService.findByJobSalaryBetweenAndJobTitle(Salary1,Salary2,title);
    }
    @GetMapping("job/jobType/{type}")
    public List<Job> findByJobType(@PathVariable Type type){
        return jobService.findByJobType(type);
    }

    //custom query
    @PutMapping("job/custom/jobType/{type}/jobId/{jobId}")
    public String updateJobTypeWithId(@Valid @PathVariable Type type,@PathVariable Long jobId){
        return jobService.updateJobTypeWithId(type.toString(),jobId);
    }
    @DeleteMapping("job/custom/jobId/{jobId}")
    public String deleteJobById(@PathVariable Long jobId){
        return jobService.deleteJobById(jobId);
    }
    @PostMapping("job/custom")
    public String addJobWithCustomQuery(@Valid @RequestBody Job job){
        return jobService.addJobWithCustomQuery(job);
    }
    @GetMapping("job/custom/jobType/{jobType}/jobSalary/{Salary}")
    public List<Job> getJobBasedOnCondition(@Valid @PathVariable Type jobType,@Valid @PathVariable Double Salary){
        return jobService.getJobBasedOnCondition(jobType.toString(),Salary);
    }













}
