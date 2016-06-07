package com.juanpabloprado.player;

import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;

public class RemovesPlayerPrompter extends PlayerPrompter {
  public RemovesPlayerPrompter(MenuPrompter menuPrompter) {
    super(menuPrompter);
  }

  @Override protected Player choosePlayer(int i) {
    return menuPrompter.teamManagerContract.choosePlayerFromTeam(i);
  }

  @Override public int promptForPlayer(Team team) {
    menuPrompter.teamManagerContract.showTeamRoster(team);
    return Integer.parseInt(
        console.readLine("%nPlease insert the number of the player you wish to remove: "));
  }
}
