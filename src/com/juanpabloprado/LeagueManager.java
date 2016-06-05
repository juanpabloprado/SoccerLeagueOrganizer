package com.juanpabloprado;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Players;
import com.juanpabloprado.model.Team;
import java.util.HashSet;

public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!

    LeagueManagerMenu menu = new LeagueManagerMenu(
        new String[] {"Create a new team", "Add players to a team", "Remove players from a team"});
    MenuPrompter menuPrompter = new MenuPrompter(menu);
    final TeamManager teamManager = new TeamManager(players);

    menuPrompter.setTeamListener(new TeamListener() {
      @Override public void onCreate(String teamName, String teamCoach) {
        try {
          teamManager.addTeam(new Team(teamName, teamCoach, new HashSet<Player>()));
        } catch (TeamManager.TeamException e) {
          PrompterUtil.displayError(e, "You may want to create more players first.");
        }
      }
    });
    menuPrompter.start();
  }
}
