package com.helios.helios.utils.strategy.strategy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusSearchStrategy implements ContactSearchStrategy {
  @Override
  public List<String> search(List<String> contacts, String query) {
    return contacts.stream()
        .filter(contact -> contact.endsWith(query))
        .collect(Collectors.toList());
  }
}
