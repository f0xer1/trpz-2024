package com.helios.helios.utils.strategy.strategy;

import java.util.List;

public interface ContactSearchStrategy {
  List<String> search(List<String> contacts, String query);
}
