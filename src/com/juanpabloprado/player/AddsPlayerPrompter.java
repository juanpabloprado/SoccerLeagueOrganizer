package com.juanpabloprado.player;

import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;

public class AddsPlayerPrompter extends BasePlayerPrompter {

  public AddsPlayerPrompter(MenuPrompter menuPrompter) {
    super(menuPrompter);
  }

  @Override protected Player choosePlayer(int i) {
    return menuPrompter.teamManagerContract.choosePlayer(i);
  }

  @Override public int promptForPlayer(Team ignored) {
    menuPrompter.teamManagerContract.showAvailablePlayers();
    System.out.printf("%nPlease insert the number of the player you wish to add: ");
    return Integer.parseInt(readLine());
  }
}
