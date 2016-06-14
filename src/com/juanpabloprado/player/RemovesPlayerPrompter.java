package com.juanpabloprado.player;

import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import com.juanpabloprado.roster.Roster;

public class RemovesPlayerPrompter extends BasePlayerPrompter {
  private Roster roster;

  public RemovesPlayerPrompter(MenuPrompter menuPrompter) {
    super(menuPrompter);
    roster = new Roster();
  }

  @Override protected Player choosePlayer(int i) {
    return roster.choosePlayerFromTeam(i);
  }

  @Override public int promptForPlayer(Team team) {
    roster.showTeamRoster(team);
    System.out.printf("%nPlease insert the number of the player you wish to remove: ");
    return Integer.parseInt(
        readLine());
  }
}
