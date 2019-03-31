package test;

import agenda.controller.ServiceContact;
import agenda.exceptions.InvalidFormatException;
import agenda.model.Contact;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.classes.RepositoryContactMock;
import agenda.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class AddContactTest {

	private Contact con;
	private RepositoryContact rep;
	
	@Before
	public void setUp() throws Exception {
		rep = new RepositoryContactMock();
	}
	
	@Test
	public void testCase1()
	{
		try {
			con = new Contact("name", "address1", "+4071122334455","email");
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		//int n = rep.count();
		rep.addContact(con);
		for(Contact c : rep.getContacts())
			if (c.equals(con))
			{
				assertTrue(true);
				break;
			}
		//assertTrue(n+1 == rep.count());
	}
	
	@Test
	public void testCase2()
	{
		try{
			rep.addContact((Contact) new Object());
		}
		catch(Exception e)
		{
			assertTrue(true);
		}	
	}
	
	@Test
	public void testCase3()
	{
		for(Contact c : rep.getContacts())
			rep.removeContact(c);
		
		try {
			con = new Contact("name", "address1", "+071122334455","email");
			rep.addContact(con);
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		int n  = rep.count();
		if (n == 1) 
			if (con.equals(rep.getContacts().get(0))) assertTrue(true);
			else assertTrue(false);
		else assertTrue(false);
	}

	@Test
	public void testCase4(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Andrei", "Adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase5(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("1234", "432", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(false);
			}
			else
				assertTrue(true);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase6(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Andrei23%", "adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(false);
			}
			else
				assertTrue(true);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase7(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("M", "adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase8(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("", "adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(false);
			}
			else
				assertTrue(true);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase9(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Mi", "adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase10(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("MabcdefghiMabcdefghiMabcdefghiMabcdefghiMabcdefghi", "adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase11(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("MabcdefghiMabcdefghiMabcdefghiMabcdefghiMabcdefgh", "adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase12(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("MabcdefghiMabcdefghiMabcdefghiMabcdefghiMabcdefghij", "adresa", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(false);
			}
			else
				assertTrue(true);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase13(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Ion", "A", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase14(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Ion", "", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(false);
			}
			else
				assertTrue(true);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase15(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Ion", "Ad", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase16(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Ion", "AdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdres", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase17(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Ion", "AdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdre", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

	@Test
	public void testCase18(){
		try {
			ServiceContact contactService = new ServiceContact(rep);
			con = new Contact("Ion", "AdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdresAdress", "+071122334455","email");
			if (contactService.addContact(con)){
				assertTrue(false);
			}
			else
				assertTrue(true);
		}catch (Exception e ) {
			assertTrue(false);
		}
	}

}
