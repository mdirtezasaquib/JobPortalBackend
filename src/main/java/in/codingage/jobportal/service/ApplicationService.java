package in.codingage.jobportal.service;

import in.codingage.jobportal.model.Application;

import java.util.List;

public interface ApplicationService {

    Application applyForJob(Application application);

    List<Application> getApplicationsByUser(String userId);

    Application updateApplicationStatus(String id, String status);

    void deleteApplication(String id);

    List<Application> getAllApplications();
}
