package com.helios.helios.web.controller;

import com.helios.helios.utils.strategy.context.ContactManager;
import com.helios.helios.utils.strategy.strategy.GroupSearchStrategy;
import com.helios.helios.utils.strategy.strategy.NameSearchStrategy;
import com.helios.helios.utils.strategy.strategy.StatusSearchStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@AllArgsConstructor
public class ContactController {

  private final ContactManager contactManager;

  @Autowired
  public ContactController(ContactManager contactManager) {
    this.contactManager = contactManager;
  }
  private List<String> contacts = Arrays.asList(
      "John Doe (Work) online",
      "Jane Smith (Family) offline",
      "Alice Johnson (Friends) online",
      "Bob Brown (Work) offline"
  );

  @GetMapping("/searchByName")
  public List<String> searchByName(@RequestParam String query) {
    contactManager.updateStrategy(new NameSearchStrategy());
    return contactManager.searchContacts(contacts, query);
  }

  @GetMapping("/searchByGroup")
  public List<String> searchByGroup(@RequestParam String query) {
    contactManager.updateStrategy(new GroupSearchStrategy());
    return contactManager.searchContacts(contacts, query);
  }

  @GetMapping("/searchByStatus")
  public List<String> searchByStatus(@RequestParam String query) {
    contactManager.updateStrategy(new StatusSearchStrategy());
    return contactManager.searchContacts(contacts, query);
  }
}

