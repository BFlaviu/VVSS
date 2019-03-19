package agenda.controller;

import agenda.model.Contact;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.interfaces.RepositoryContact;

public class ServiceContact {

    RepositoryContact repo;

    public ServiceContact(RepositoryContact repo){
        this.repo=repo;
    }

    public void addContact(Contact c){
        repo.addContact(c);
    }
}
