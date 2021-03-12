package co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.controllers;

import co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.model.User;
import co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    @Qualifier("Userservice")
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAll(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/id/{userid}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable String userid) {
        try {
            return new ResponseEntity<>(userService.getById(userid),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.create(user),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.update(user),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String userid) {
        try {
            userService.remove(userid);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
