package co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.service.imp;

import co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.persistence.InMemoryPersistence;
import co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.service.UserService;
import co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Userservice")
public class UserServiceImp implements UserService {

    private InMemoryPersistence inMemoryPersistence = new InMemoryPersistence();

    @Override
    public List<User> getAll() {
        return inMemoryPersistence.getDataset();
    }

    @Override
    public User getById(String userId) {
        return inMemoryPersistence.getUserById(userId);
    }

    @Override
    public User create(User user) {
        return inMemoryPersistence.addUser(user);
    }

    @Override
    public User update(User user) {
        return inMemoryPersistence.updateUser(user);
    }

    @Override
    public void remove(String userId) {
        inMemoryPersistence.removeUser(userId);
    }
}
