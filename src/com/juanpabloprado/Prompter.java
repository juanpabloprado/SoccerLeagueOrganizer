package com.juanpabloprado;

import java.io.Console;

public class Prompter {
  private static final Console console = System.console();

  private int currentMenuItem;
  private LeagueManagerMenu menu;

  public Prompter(LeagueManagerMenu menu) {
    this.menu = menu;
  }

  public void displayWelcome() {
    CharSequence separator = "\n=============\n";
    System.out.printf("%nSoccer League Organizer %s", separator);
  }

  public void promptMenu() {
    currentMenuItem =
        Integer.parseInt(console.readLine("%nPlease choose an option from the menu below:%n%s",
            menu.getFormattedMenu()));
    System.out.println(currentMenuItem);
  }
}
