package agenda.repository.classes;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import agenda.model.Activity;
import agenda.repository.interfaces.RepositoryActivity;

public class RepositoryActivityMock implements RepositoryActivity {

	private List<Activity> activities;
	
	public RepositoryActivityMock()
	{
		activities = new LinkedList<Activity>();
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		try {
//			Activity act = new Activity(df.parse("03/20/2013 12:00"), 
//					df.parse("03/20/2013 14:00"),
//					null,
//					"Meal break",
//					"Memo");
//			activities.add(act);
//			act = new Activity(df.parse("03/21/2013 12:00"), 
//					df.parse("03/21/2013 14:00"),
//					null,
//					"Meal break",
//					"Memo");
//			activities.add(act);
//			act = new Activity(df.parse("03/22/2013 12:00"), 
//					df.parse("03/22/2013 14:00"),
//					null,
//					"Meal break",
//					"Memo");
//			activities.add(act);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	}
	
	@Override
	public List<Activity> getActivities() {
		return new LinkedList<Activity>(activities);
	}

	@Override
	public boolean addActivity(Activity activity) {
		int  i = 0;
		boolean conflicts = false;
		
		while( i < activities.size() )
		{
			if ( activities.get(i).getStart().compareTo(activity.getDuration()) < 0 &&
					activity.getStart().compareTo(activities.get(i).getDuration()) < 0 )
				conflicts = true;
			i++;
		}
		if ( !conflicts )
		{
			activities.add(activity);
			return true;
		}
		return false;
//		for (int i = 0; i< activities.size(); i++)
//		{
//			if (activity.intersect(activities.get(i))) return false;
//		}	
//		int index = activities.indexOf(activity);
//		//if (index >= 0 ) return false;
//		activities.add(activity);
//		return true;
	}

	@Override
	public boolean removeActivity(Activity activity) {
		int index = activities.indexOf(activity);
		if (index<0) return false;
		activities.remove(index);
		return true;
	}

	@Override
	public boolean saveActivities() {
		return true;
	}

	@Override
	public int count() {
		return activities.size();
	}

	@Override
	public List<Activity> activitiesByName(String name) {
		List<Activity> result = new LinkedList<Activity>();
		for (Activity a : activities)
			if (a.getName().equals(name)) result.add(a);
		return result;
	}

	@Override
	public List<Activity> activitiesOnDate(String name, Date d) {
		List<Activity> result1 = new LinkedList<Activity>();
		for (Activity a : activities)
			if (a.getName().equals(name))
				if ((a.getStart().getYear() == d.getYear() &&
						a.getStart().getMonth() == d.getMonth() &&
						a.getStart().getDate() == d.getDate()) ||
						( a.getDuration().getYear() == d.getYear() &&
								a.getDuration().getMonth() == d.getMonth() &&
								a.getDuration().getDate() == d.getDate())) result1.add(a);
		List<Activity> result = new LinkedList<Activity>();
		while (result1.size() > 0 )
		{
			Activity ac = result1.get(0);
			int index = 0;
			for (int i = 1; i<result1.size(); i++)
				if (ac.getStart().compareTo(result1.get(i).getStart())>0)
				{
					index = i;
					ac = result1.get(i);
				}

			result.add(ac);
			result1.remove(index);
		}
		return result;
	}

}
