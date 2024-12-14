package com.helios.helios.utils.strategy.strategy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class NameSearchStrategy implements ContactSearchStrategy {
  @Override
  public List<String> search(List<String> contacts, String query) {
    return contacts.stream()
        .filter(contact -> contact.contains(query))
        .collect(Collectors.toList());
  }
}