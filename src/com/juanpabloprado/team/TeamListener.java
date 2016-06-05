package com.juanpabloprado.team;

public interface TeamListener {
  void onCreate(String teamName, String teamCoach);

  void onPlayerAdded();

  void onPlayerRemoved();
}
