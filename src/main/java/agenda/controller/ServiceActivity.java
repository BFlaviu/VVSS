package agenda.controller;

import agenda.model.Activity;
import agenda.repository.interfaces.RepositoryActivity;

import java.util.Date;
import java.util.List;

public class ServiceActivity {

    RepositoryActivity repo;

    public ServiceActivity(RepositoryActivity repo){
        this.repo = repo;
    }

    public boolean addActivity(Activity act){
        if (repo.addActivity(act))
            return true;
        return false;
    }

    public List<Activity> getActivities(String name, Date d){
        return repo.activitiesOnDate(name,d);
    }
}
