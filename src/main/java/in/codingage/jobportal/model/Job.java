package in.codingage.jobportal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Job")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {


    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private String companyName;
    private String salary;
    private String type;
    private String employerId;
    private String categoryId;
    private Date postedAt;


}
