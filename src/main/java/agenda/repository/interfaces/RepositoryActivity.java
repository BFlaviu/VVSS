package agenda.repository.interfaces;

import java.util.Date;
import java.util.List;

import agenda.model.Activity;

public interface RepositoryActivity {

	List<Activity> getActivities();
	boolean addActivity(Activity activity);
	boolean removeActivity(Activity activity);
	boolean saveActivities();
	int count();
	List<Activity> activitiesByName(String name);
	List<Activity> activitiesOnDate(String name, Date d);
	
}
