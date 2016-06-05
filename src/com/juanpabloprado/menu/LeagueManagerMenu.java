package com.juanpabloprado.menu;

public class LeagueManagerMenu {

  private String[] menuItems;

  public LeagueManagerMenu(String[] menuItems) {
    this.menuItems = menuItems;
  }

  public String[] getMenuItems() {
    return menuItems;
  }

  public String getFormattedMenu() {
    String formattedMenu = "";
    for (int i = 0; i < menuItems.length; i++) {
      formattedMenu += String.format("[%d] %s%n", i + 1, menuItems[i]);
    }
    return formattedMenu;
  }
}
