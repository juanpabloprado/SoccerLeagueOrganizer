package com.juanpabloprado.team;

import com.juanpabloprado.team.list.TeamByNameComparator;
import com.juanpabloprado.util.PrompterUtil;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamManager implements TeamManagerContract {
  private List<Team> teams;
  private Set<Player> availablePayers;
  private List<Player> players;
  private ArrayList<Player> roster;

  public TeamManager(Player[] availablePayers) {
    this.availablePayers = new HashSet<Player>(Arrays.asList(availablePayers));
    this.teams = new ArrayList<Team>();
    this.players = new ArrayList<Player>(this.availablePayers);
  }

  @Override public void addTeam(Team team) {
    if (teams.size() < availablePayers.size()) {
      teams.add(team);
    } else {
      throw new TeamException("Does not allow more teams to be created than there are players.");
    }
  }

  @Override public void showTeams() {
    if (teams.size() > 0) {
      Collections.sort(teams, new TeamByNameComparator());
      PrompterUtil.displayTeamsTitle();
      PrompterUtil.printPrettyList(teams);
    } else {
      throw new TeamException("The team list is empty");
    }
  }

  @Override public Team chooseTeam(int index) {
    return teams.get(index);
  }

  @Override public void showAvailablePlayers() {
    if (availablePayers.size() > 0) {
      refillPlayers();
      PrompterUtil.displayPlayersTitle();
      Collections.sort(players);
      PrompterUtil.printPrettyList(players);
    } else {
      throw new TeamException("The players list is empty");
    }
  }

  private void refillPlayers() {
    players.clear();
    players.addAll(availablePayers);
  }

  @Override public Player choosePlayer(int index) {
    return players.get(index);
  }

  @Override public void addPlayer(Player player, Team toTeam) {
    availablePayers.remove(player);
    toTeam.getPlayers().add(player);
  }

  @Override public void removePlayer(Player player, Team fromTeam) {
    availablePayers.add(player);
    fromTeam.getPlayers().remove(player);
  }

  @Override public void showTeamRoster(Team fromTeam) {
    roster = new ArrayList<Player>(fromTeam.getPlayers());
    if(roster.size() > 0) {
      Collections.sort(roster);
      PrompterUtil.displayTeamTitle(fromTeam.getName());
      PrompterUtil.printPrettyList(roster);
    } else {
      throw new TeamException("The players list is empty");
    }
  }

  @Override public Player choosePlayerFromTeam(int index) {
    return roster.get(index);
  }

  public class TeamException extends RuntimeException {
    public TeamException(String message) {
      super(message);
    }
  }
}
