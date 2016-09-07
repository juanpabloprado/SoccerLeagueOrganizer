package com.juanpabloprado;

import com.juanpabloprado.menu.LeagueManagerMenu;
import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Players;
import com.juanpabloprado.team.TeamManager;

public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!

    LeagueManagerMenu menu = new LeagueManagerMenu(
        new String[] {"Create a new team", "Add players to a team", "Remove players from a team", "Generate team reports", "Show teams", "Exit"});
    MenuPrompter menuPrompter = new MenuPrompter(menu);
    final TeamManager teamManager = new TeamManager(players);
    menuPrompter.setTeamManagerContract(teamManager);
    menuPrompter.start();
  }
}
