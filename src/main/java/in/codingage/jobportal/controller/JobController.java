package in.codingage.jobportal.controller;

import in.codingage.jobportal.model.Job;
import in.codingage.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Job")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/create")
    public ResponseEntity<Job> postJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.postJob(job));
    }

    @GetMapping("/readById")
    public ResponseEntity<?> getJobById(@RequestParam String id) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return ResponseEntity.status(404).body("Job not found");
        }
        return ResponseEntity.ok(job);
    }


    @GetMapping("/readAll")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PutMapping("/updateById")
    public ResponseEntity<?> updateJob(@RequestParam String id, @RequestBody Job updatedJob) {
        try {
            if (id == null || id.isEmpty()) {
                return ResponseEntity.badRequest().body("Job ID cannot be null or empty.");
            }
            Job job = jobService.updateJob(id, updatedJob);
            return ResponseEntity.ok(job);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating job: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteJob(@RequestParam String id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }
}
