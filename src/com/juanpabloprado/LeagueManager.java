package com.juanpabloprado;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Players;

public class LeagueManager {

  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!
    LeagueManagerMenu menu = new LeagueManagerMenu(
        new String[] {"Create a new team", "Add players to a team", "Remove players from a team"});
    Prompter prompter = new Prompter(menu);
    prompter.displayWelcome();
    prompter.promptMenu();
  }
}
