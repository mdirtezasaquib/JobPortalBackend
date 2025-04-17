package in.codingage.jobportal.service.impl;

import in.codingage.jobportal.model.Job;
import in.codingage.jobportal.repository.JobRepository;
import in.codingage.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;


    public Job postJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getJobById(String id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }


    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }


    public Job updateJob(String id, Job updatedJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);

        if (!optionalJob.isPresent()) {
            throw new RuntimeException("Job not found with ID: " + id);
        }

        Job existingJob = optionalJob.get();
        existingJob.setTitle(updatedJob.getTitle());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setLocation(updatedJob.getLocation());
        existingJob.setSalary(updatedJob.getSalary());
        existingJob.setCategoryId(updatedJob.getCategoryId());

        return jobRepository.save(existingJob);
    }


    public void deleteJob(String id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with ID: " + id);
        }
        jobRepository.deleteById(id);
    }
}
