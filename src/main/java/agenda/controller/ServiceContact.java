package agenda.controller;

import agenda.model.Contact;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.interfaces.RepositoryContact;

public class ServiceContact {

    RepositoryContact repo;

    public ServiceContact(RepositoryContact repo){
        this.repo=repo;
    }

    public boolean addContact(Contact c){
        try{
            Integer.parseInt(c.getAddress());
            return false;
        } catch (Exception e){

        }
        if (c.getName().length()<1 || c.getName().length()>50 || c.getName().matches(".*[0123456789%$#@!^&*].*"))
            return false;
        else if (c.getAddress().length()<1 || c.getAddress().length()>255){
            return false;
        }
        else {
            repo.addContact(c);
            return true;
        }
    }
}
