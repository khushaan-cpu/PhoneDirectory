package phonedirectory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import phonedirectory.model.Contact;
import phonedirectory.model.User;
import phonedirectory.service.ContactService;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/contacts")
    public String getUserContacts(Model model, HttpSession session) {
        User user = (User)session.getAttribute("loggeduser");
        List<Contact> contacts = contactService.getUserContacts(user.getId());
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @RequestMapping("/contacts/newcontact")
    public String newContact() {
        return "contacts/create";
    }

    @RequestMapping(value = "/contacts/create", method = RequestMethod.POST)
    public String createContact(Contact newContact, HttpSession session) {
        User user = (User) session.getAttribute("loggeduser");
        newContact.setUser(user);
        contactService.createContact(newContact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.DELETE)
    public String deleteContact(@RequestParam(name="contactId") Integer contactId) {
        contactService.deleteContact(contactId);
        return "redirect:/contacts";
    }
}