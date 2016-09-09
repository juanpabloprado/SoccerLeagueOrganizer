package com.juanpabloprado.team;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;

public interface TeamManagerContract {

  void showTeams();

  Team chooseTeam(int index);

  void addTeam(Team team);

  void showTeam(Team team);

  void showAvailablePlayers();

  Player choosePlayer(int index);

  void addPlayer(Player player, Team toTeam);

  void removePlayer(Player player, Team fromTeam);

  void generateHeightReport();

  void generateExperienceReport();
}
