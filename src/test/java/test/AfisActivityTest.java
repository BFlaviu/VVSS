package test;


import agenda.model.Activity;
import agenda.model.Contact;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.interfaces.RepositoryActivity;
import agenda.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class AfisActivityTest {

	RepositoryActivity rep;

	@Before
	public void setUp() throws Exception {
		RepositoryContact repcon = new RepositoryContactFile();
		rep = new RepositoryActivityFile(repcon);
	}

	@Test
	public void testCase1() {
		for (Activity act : rep.getActivities())
			rep.removeActivity(act);

		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20, 12, 00);
		Date start = c.getTime();

		c.set(2013, 3 - 1, 20, 12, 30);
		Date end = c.getTime();

		Activity act = new Activity("name1", start, end,
				new LinkedList<Contact>(), "description2");

		rep.addActivity(act);

		c.set(2013, 3 - 1, 20);

		List<Activity> result = rep.activitiesOnDate("name1", c.getTime());
		assertTrue(result.size() == 1);
	}

	@Test
	public void testCase2() {
		for (Activity act : rep.getActivities())
			rep.removeActivity(act);

		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20, 12, 00);
		Date start = c.getTime();

		c.set(2013, 3 - 1, 20, 12, 30);
		Date end = c.getTime();

		Activity act = new Activity("name1", start, end,
				new LinkedList<Contact>(), "description2");

		rep.addActivity(act);

		c.set(2013, 3 - 1, 20);
		try {
			rep.activitiesOnDate(((Object) 1).toString(), c.getTime());
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCase3() {
		for (Activity act : rep.getActivities())
			rep.removeActivity(act);

		try {
			rep.activitiesOnDate("name1", (Date)(Object)"ASD");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCase4() {
		for (Activity act : rep.getActivities())
			rep.removeActivity(act);

		try {
			rep.addActivity((Activity)(Object)1);
			
			Calendar c = Calendar.getInstance();
			c.set(2013, 3 - 1, 20);
			rep.activitiesOnDate("name1", c.getTime());
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCase5() {
		for (Activity act : rep.getActivities())
			rep.removeActivity(act);
	
		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20);
		List<Activity> result = rep.activitiesOnDate("name1", c.getTime());
		
		assertTrue(result.size() == 0);
	}
}
