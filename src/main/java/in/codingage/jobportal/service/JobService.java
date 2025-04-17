package in.codingage.jobportal.service;

import in.codingage.jobportal.model.Job;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobService {
    Job postJob(Job job);

    List<Job> getAllJobs();

    Job updateJob(String id, Job updatedJob);

    void deleteJob(String id);

    Job getJobById(String id);
}
