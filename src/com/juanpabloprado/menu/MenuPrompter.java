package com.juanpabloprado.menu;

import com.juanpabloprado.BasicPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import com.juanpabloprado.player.AddsPlayerPrompter;
import com.juanpabloprado.player.PlayerListener;
import com.juanpabloprado.player.RemovesPlayerPrompter;
import com.juanpabloprado.team.TeamManager;
import com.juanpabloprado.team.TeamManagerContract;
import com.juanpabloprado.util.PrompterUtil;
import java.util.HashSet;

public class MenuPrompter extends BasicPrompter {
  private AddsPlayerPrompter addPlayerPrompter;
  private RemovesPlayerPrompter removePlayerPrompter;

  private int currentMenuItem;
  private LeagueManagerMenu menu;
  public TeamManagerContract teamManagerContract;

  public MenuPrompter(LeagueManagerMenu menu) {
    this.menu = menu;
    addPlayerPrompter = new AddsPlayerPrompter(this);
    removePlayerPrompter = new RemovesPlayerPrompter(this);
  }

  public void promptMenu() {
    System.out.printf("%nPlease choose an option from the menu below:%n%s",
        menu.getFormattedMenu());
    int optionSelected =
        Integer.parseInt(readLine());
    if (isValidOption(optionSelected)) {
      currentMenuItem = optionSelected;
      onOptionsMenuSelected();
    } else {
      System.out.println("Invalid option, please try again");
      promptMenu();
    }
  }

  private void onOptionsMenuSelected() {
    switch (currentMenuItem) {
      case 1:
        promptsForAddingTeam();
        promptMenu();
        break;
      case 2:
        promptsForAddingPlayers();
        promptMenu();
        break;
      case 3:
        promptsForRemovingPlayers();
        promptMenu();
        break;
      case 4:
        promptsForGeneratingReports();
        promptMenu();
        break;
      case 5:
        break;
    }
  }

  private void promptsForGeneratingReports() {
    teamManagerContract.generateHeightReport();
  }

  private void promptsForRemovingPlayers() {
    removePlayerPrompter.selectPlayer(new PlayerListener() {
      @Override public void onPlayerSelected(Player player, Team team) {
        removePlayer(player, team);
      }
    });
  }

  private void removePlayer(Player player, Team team) {
    teamManagerContract.removePlayer(player, team);
    System.out.printf("%n%s was removed successfully to team %s, which now has %d players%n",
        player.getLastName(), team, team.getPlayers().size());
  }

  private void promptsForAddingPlayers() {
    addPlayerPrompter.selectPlayer(new PlayerListener() {
      @Override public void onPlayerSelected(Player player, Team team) {
        addPlayer(player, team);
      }
    });
  }

  private void addPlayer(Player player, Team team) {
    teamManagerContract.addPlayer(player, team);
    System.out.printf("%n%s was added successfully to team %s, which now has %d players%n",
        player.getLastName(), team, team.getPlayers().size());
  }

  private void promptsForAddingTeam() {
    System.out.printf("%nWhat name do you want for your team?%n");
    String teamName = readLine();
    if (!teamName.isEmpty()) {
      System.out.printf("%nWhat is the name of your team's coach?%n");
      String teamCoach = readLine();
      if (!teamCoach.isEmpty()) {
        try {
          teamManagerContract.addTeam(new Team(teamName, teamCoach, new HashSet<Player>()));
        } catch (TeamManager.TeamException e) {
          PrompterUtil.displayError(e, "You may want to create more players first.");
        }
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
