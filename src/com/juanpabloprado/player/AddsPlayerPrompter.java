package com.juanpabloprado.player;

import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;

public class AddsPlayerPrompter extends PlayerPrompter {

  public AddsPlayerPrompter(MenuPrompter menuPrompter) {
    super(menuPrompter);
  }

  @Override protected Player choosePlayer(int i) {
    return menuPrompter.teamManagerContract.choosePlayer(i);
  }

  @Override public int promptForPlayer(Team ignored) {
    menuPrompter.teamManagerContract.showAvailablePlayers();
    return Integer.parseInt(
        console.readLine("%nPlease insert the number of the player you wish to add: "));
  }
}
