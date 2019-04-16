package test;


import agenda.model.Activity;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.interfaces.RepositoryActivity;
import agenda.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddActivityTest {
	private Activity act;
	private RepositoryActivity rep;
	private RepositoryActivity repFile;
	
	@Before
	public void setUp() throws Exception {
		rep = new RepositoryActivityMock();
		RepositoryContact repcon = new RepositoryContactFile();
		repFile = new RepositoryActivityFile(repcon);
	}
	
	@Test
	public void testCase1()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", 
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertTrue(1 == rep.count());
	}
	
	@Test
	public void testCase2()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try{
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
			
			act = new Activity("name1",
					df.parse("03/21/2013 12:00"), 
					df.parse("03/21/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
		}
		catch(Exception e){}	
		int c = rep.count();
		assertTrue( c == 2);
		for (Activity a : rep.getActivities())
			rep.removeActivity(a);
	}
	
	@Test
	public void testCase3()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try{
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:30"), 
					df.parse("03/20/2013 13:30"),
					null,
					"Lunch break");
			assertFalse(rep.addActivity(act));
		}
		catch(Exception e){}	
		assertTrue( 1 == rep.count());
		rep.saveActivities();
		for (Activity a : rep.getActivities())
			rep.removeActivity(a);
	}
	
	@Test
	public void testCase4()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try{
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
			
			act = new Activity("name1",
					df.parse("03/20/2013 13:30"), 
					df.parse("03/20/2013 14:00"),
					null,
					"Curs");
			rep.addActivity(act);
			
			act = new Activity("name1",
					df.parse("03/20/2013 13:30"), 
					df.parse("03/20/2013 14:30"),
					null,
					"Lunch break");
			assertFalse(rep.addActivity(act));			
		}
		catch(Exception e){}	
		assertTrue( 2 == rep.count());
		for (Activity a : rep.getActivities())
			rep.removeActivity(a);
	}
	
	@Test
	public void testCase5()
	{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try{
			for (Activity a : rep.getActivities())
				rep.removeActivity(a);
			
			act = new Activity("name1",
					df.parse("03/20/2013 12:00"), 
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			rep.addActivity(act);
			
			assertFalse(rep.addActivity(act));			
		}
		catch(Exception e){}	
		assertTrue( 1 == rep.count());
		for (Activity a : rep.getActivities())
			rep.removeActivity(a);
	}

	@Test
	public void testCase6() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {

			act = new Activity("name1",
					df.parse("03/20/2014 12:00"),
					df.parse("03/20/2013 13:00"),
					null,
					"Lunch break");
			repFile.addActivity(act);
			assertFalse(repFile.addActivity(act));
		} catch (Exception e) {
		}
	}

	@Test
	public void testCase7() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {

			act = new Activity("name1",
					df.parse("01/01/2018 12:00"),
					df.parse("01/01/2017 13:00"),
					null,
					"Lunch break");

			assertFalse(repFile.addActivity(act));
		} catch (Exception e) {
		}
	}

	@Test
	public void testCase8() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {

			act = new Activity("name1",
					df.parse("01/01/2012 12:00"),
					df.parse("01/01/2017 13:00"),
					null,
					"Lunch break");

			assertFalse(repFile.addActivity(act));
		} catch (Exception e) {
		}
	}

	@Test
	public void testCase9() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {

			act = new Activity("name1",
					df.parse("01/01/2017 12:00"),
					df.parse("01/01/2018 13:00"),
					null,
					"Lunch break");
			assertTrue(repFile.addActivity(act));
		} catch (Exception e) {
		}
	}
}
