package in.codingage.jobportal.controller;

import in.codingage.jobportal.model.User;
import in.codingage.jobportal.service.UserService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "https://jobportalbackend-cd60.onrender.com")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/createUser")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.loginUser(user.getEmail(), user.getPassword()));
    }


    @GetMapping("/readAll")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }


    @GetMapping("readById")
    public ResponseEntity<User> getUserById(@RequestParam String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("readByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PutMapping("updateUser")
    public User updateUser(@RequestParam String id, @RequestParam User updatedUser) {
        User user = userService.updateUser(id,updatedUser);
        return user;
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }


}
