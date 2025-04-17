package in.codingage.jobportal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Application")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Application {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String location;
    private String jobTitle;
    private String experience;
    private String resumeUrl;
    private String status;
    private Date appliedAt;
    private String jobId;
    private String userId;




}
