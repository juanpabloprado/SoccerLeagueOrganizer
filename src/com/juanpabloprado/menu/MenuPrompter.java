package com.juanpabloprado.menu;

import com.juanpabloprado.team.TeamListener;
import com.juanpabloprado.team.TeamManagerContract;
import com.juanpabloprado.util.PrompterUtil;
import java.io.Console;

public class MenuPrompter {
  private static final Console console = System.console();

  public void setTeamListener(TeamListener teamListener) {
    this.teamListener = teamListener;
  }

  private int currentMenuItem;
  private LeagueManagerMenu menu;
  private TeamListener teamListener;
  private TeamManagerContract teamManagerContract;

  public MenuPrompter(LeagueManagerMenu menu) {
    this.menu = menu;
  }

  public void promptMenu() {
    int optionSelected =
        Integer.parseInt(console.readLine("%nPlease choose an option from the menu below:%n%s",
            menu.getFormattedMenu()));
    if (isValidOption(optionSelected)) {
      currentMenuItem = optionSelected;
      onOptionsMenuSelected();
      System.out.println(currentMenuItem);
    } else {
      System.out.println("Invalid option, please try again");
      promptMenu();
    }
  }

  private void onOptionsMenuSelected() {
    switch (currentMenuItem) {
      case 1:
        promptsForTeam();
        promptMenu();
        break;
      case 2:
        promptsForAddingPlayers();
        promptMenu();
        break;
      case 3:
        promptMenu();
        break;
      case 4:
        break;
    }
  }

  private void promptsForAddingPlayers() {
    teamManagerContract.showTeams();
  }


  public void promptsForTeam() {
    String teamName = console.readLine("%nWhat name do you want for your team?%n");
    if (!teamName.isEmpty()) {
      String teamCoach = console.readLine("%nWhat is the name of your team's coach?%n");
      if (!teamCoach.isEmpty()) {
        teamListener.onCreate(teamName, teamCoach);
      }
    }
  }

  private boolean isValidOption(int optionSelected) {
    return optionSelected > 0 && optionSelected <= menu.getMenuItems().length;
  }

  public void start() {
    PrompterUtil.displayWelcome();
    promptMenu();
  }

  public void setTeamManagerContract(TeamManagerContract teamManagerContract) {
    this.teamManagerContract = teamManagerContract;
  }
}
