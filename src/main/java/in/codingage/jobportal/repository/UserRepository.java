package in.codingage.jobportal.repository;


import in.codingage.jobportal.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {


    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
