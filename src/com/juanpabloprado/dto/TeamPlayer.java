package com.juanpabloprado.dto;

import com.juanpabloprado.model.Player;

public class TeamPlayer extends Player {
  private String teamName;

  public TeamPlayer(String firstName, String lastName, int heightInInches,
      boolean previousExperience) {
    super(firstName, lastName, heightInInches, previousExperience);
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  @Override public String toString() {
    return String.format("%-30s ", teamName) + super.toString();
  }
}
