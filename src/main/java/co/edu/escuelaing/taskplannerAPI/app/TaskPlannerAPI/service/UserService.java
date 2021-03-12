package co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.service;

import co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);
}
