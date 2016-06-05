package com.juanpabloprado.model;

import java.util.Objects;
import java.util.Set;

public class Team {
  private String name;
  private String coachName;
  Set<Player> players;

  public Team(String name, String coachName, Set<Player> players) {
    this.name = name;
    this.coachName = coachName;
    this.players = players;
  }

  public String getName() {
    return name;
  }

  public String getCoachName() {
    return coachName;
  }

  public Set<Player> getPlayers() {
    return players;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Team team = (Team) o;
    return Objects.equals(name, team.name) &&
        Objects.equals(coachName, team.coachName) &&
        Objects.equals(players, team.players);
  }

  @Override public int hashCode() {
    return Objects.hash(name, coachName, players);
  }

  @Override public String toString() {
    return name;
  }
}
