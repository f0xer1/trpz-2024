package com.helios.helios.utils.strategy.strategy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupSearchStrategy implements ContactSearchStrategy {
  @Override
  public List<String> search(List<String> contacts, String query) {
    return contacts.stream()
        .filter(contact -> contact.split(" ")[1].equals(query))
        .collect(Collectors.toList());
  }
}
