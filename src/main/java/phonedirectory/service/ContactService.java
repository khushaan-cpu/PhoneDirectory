package phonedirectory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phonedirectory.model.Contact;
import phonedirectory.repository.ContactRepository;

import java.util.Date;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public List<Contact> getUserContacts(Integer userId) {
        return repository.getUserContacts(userId);
    }

    public void createContact(Contact newContact) {
        repository.createContact(newContact);
    }


    public void deleteContact(Integer contactId) {
        repository.deleteContact(contactId);
    }

}