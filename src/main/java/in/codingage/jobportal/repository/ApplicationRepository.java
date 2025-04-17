package in.codingage.jobportal.repository;

import in.codingage.jobportal.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Application,String> {


    List<Application> findByUserId(String userId);
}
