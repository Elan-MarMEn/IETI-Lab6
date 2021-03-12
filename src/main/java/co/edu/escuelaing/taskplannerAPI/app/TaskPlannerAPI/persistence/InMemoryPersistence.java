package co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.persistence;

import co.edu.escuelaing.taskplannerAPI.app.TaskPlannerAPI.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPersistence {
    private Map<String,User> persistence = new HashMap<>();

    public InMemoryPersistence(){
        persistence.put("147A",new User("147A","Luis","124"));
        persistence.put("1A7B",new User("1A7B","Julian","7465"));
        persistence.put("2GG8",new User("2GG8","jose","191955"));
    }

    public List<User> getDataset(){
        List<User> userList = new ArrayList<>();
        for (String user: persistence.keySet()) {
            userList.add(persistence.get(user));
        }
        return userList;
    }

    public User getUserById(String idusr){
        return persistence.get(idusr);
    }

    public User addUser(User usr){
        persistence.put(usr.getUserId(),usr);
        return  usr;
    }

    public User updateUser(User usr){
        persistence.get(usr.getUserId()).setName(usr.getName());
        persistence.get(usr.getUserId()).setPassword(usr.getPassword());
        return persistence.get(usr.getUserId());
    }

    public void removeUser(String usr){
        persistence.remove(usr);
    }
}
