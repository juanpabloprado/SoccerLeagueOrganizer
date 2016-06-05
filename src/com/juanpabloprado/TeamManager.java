package com.juanpabloprado;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import java.util.ArrayList;
import java.util.List;

public class TeamManager {
  private List<Team> teams;
  private Player[] players;

  public TeamManager(Player[] players) {
    this.players = players;
    this.teams = new ArrayList<Team>();
  }

  public void addTeam(Team team) {
    if (teams.size() < players.length) {
      teams.add(team);
    } else {
      throw new TeamException("Does not allow more teams to be created than there are players.");
    }
  }

  public class TeamException extends RuntimeException {
    public TeamException(String message) {
      super(message);
    }
  }
}
