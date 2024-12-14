package com.helios.helios.utils.strategy.context;


import com.helios.helios.utils.strategy.strategy.ContactSearchStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactManager {
  private ContactSearchStrategy strategy;

  public ContactManager(ContactSearchStrategy strategy) {
    this.strategy = strategy;
  }
  public List<String> searchContacts(List<String> contacts, String query) {
    return strategy.search(contacts, query);
  }
  public void updateStrategy(ContactSearchStrategy strategy) {
    this.strategy = strategy;
  }
}
