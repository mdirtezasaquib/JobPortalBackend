package in.codingage.jobportal.controller;


import in.codingage.jobportal.model.Application;
import in.codingage.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Application")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/create")
    public ResponseEntity<Application> applyForJob(@RequestBody Application application) {
        application.setStatus("Pending");
        application.setAppliedAt(new Date());
        return ResponseEntity.ok(applicationService.applyForJob(application));
    }


    @GetMapping("/readAll")
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/readByUserId")
    public ResponseEntity<List<Application>> getApplicationsByUser(@RequestParam String userId) {
        return ResponseEntity.ok(applicationService.getApplicationsByUser(userId));
    }


    @PutMapping("updateApplication")
    public ResponseEntity<Application> updateApplicationStatus ( @RequestParam String id, @RequestParam String status) {
        return ResponseEntity.ok(applicationService.updateApplicationStatus(id, status));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteApplication(@RequestParam String id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok("Application deleted successfully");
    }


}
