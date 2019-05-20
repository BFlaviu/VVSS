package Integration;

import agenda.controller.ServiceActivity;
import agenda.controller.ServiceContact;
import agenda.exceptions.InvalidFormatException;
import agenda.model.Activity;
import agenda.model.Contact;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.classes.RepositoryContactMock;
import agenda.repository.interfaces.RepositoryActivity;
import agenda.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BigBang {
    private RepositoryActivity rep;
    private RepositoryContact repCon;
    private ServiceContact serviceContact;
    private ServiceActivity serviceActivity;
    private static int contactSize;
    private static int activitySize;

    @Before
    public void setUp() throws Exception {
        repCon = new RepositoryContactFile();
        rep = new RepositoryActivityFile(repCon);
        serviceContact = new ServiceContact(repCon);
        serviceActivity = new ServiceActivity(rep);
        contactSize = serviceContact.getContacts().size();
        activitySize = serviceActivity.getActivities().size();
    }

    @Test
    public void A_Test() {
        Contact c = new Contact();
        try {
             c = new Contact("name", "address1", "+4071122334455", "email");
        } catch (
        InvalidFormatException e) {
            assertTrue(false);
        }

        if (serviceContact.addContact(c)){
            assertTrue(true);
        }
        else
            assertTrue(false);

        assert contactSize + 1 == serviceContact.getContacts().size();
    }

    @Test
    public void B_Test() {

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            Activity act = new Activity("name1",
                    df.parse("01/01/2017 12:00"),
                    df.parse("01/01/2018 13:00"),
                    null,
                    "Lunch break");
            assertTrue(rep.addActivity(act));
        } catch (Exception e) {
            assertTrue(false);
        }

        assert activitySize + 1 == serviceActivity.getActivities().size();
    }

    @Test
    public void C_Test() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            Activity act = new Activity("name1",
                    df.parse("01/01/2017 12:00"),
                    df.parse("01/01/2018 13:00"),
                    null,
                    "Lunch break");
            assertTrue(rep.addActivity(act));
        } catch (Exception e) {
            assertTrue(false);
        }

        Calendar c = Calendar.getInstance();
        c.set(2017, Calendar.JANUARY, 1);
        List<Activity> result = rep.activitiesOnDate("name1", c.getTime());

        assertTrue(result.size() == 1);
    }

    @Test
    public void A_B_C_Test() {

        //F01
        Contact c = new Contact();
        try {
            c = new Contact("name", "address1", "+4071122334455", "email");
        } catch (
                InvalidFormatException e) {
            assertTrue(false);
        }

        if (serviceContact.addContact(c)){
            assertTrue(true);
        }
        else
            assertTrue(false);

        //F02
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            Activity act = new Activity("name1",
                    df.parse("01/01/2017 17:00"),
                    df.parse("01/01/2017 19:00"),
                    null,
                    "Lunch break");
            Activity act2 = new Activity("name1",
                    df.parse("01/01/2017 12:00"),
                    df.parse("01/01/2017 13:00"),
                    null,
                    "Lunch break");
            assertTrue(rep.addActivity(act));
            assertTrue(rep.addActivity(act2));
        } catch (Exception e) {
            assertTrue(false);
        }

        //F03
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.JANUARY, 1);
        List<Activity> result = rep.activitiesOnDate("name1", calendar.getTime());


        assertTrue(result.size() == 2);

        assert result.get(0).getStart().compareTo(result.get(1).getStart()) < 0;
    }
}
