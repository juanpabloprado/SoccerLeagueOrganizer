package com.juanpabloprado.menu;

import com.juanpabloprado.BasicPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import com.juanpabloprado.player.AddsPlayerPrompter;
import com.juanpabloprado.player.PlayerListener;
import com.juanpabloprado.player.RemovesPlayerPrompter;
import com.juanpabloprado.team.TeamManager;
import com.juanpabloprado.team.TeamManagerContract;
import com.juanpabloprado.team.TeamPrompter;
import com.juanpabloprado.util.PrompterUtil;
import java.util.HashSet;

public class MenuPrompter extends BasicPrompter {
  private AddsPlayerPrompter addPlayerPrompter;
  private RemovesPlayerPrompter removePlayerPrompter;

  private int currentMenuItem;
  private LeagueManagerMenu menu;
  public TeamManagerContract teamManagerContract;
  private TeamPrompter teamPrompter;

  public MenuPrompter(LeagueManagerMenu menu) {
    this.menu = menu;
    addPlayerPrompter = new AddsPlayerPrompter(this);
    removePlayerPrompter = new RemovesPlayerPrompter(this);
  }

  public void promptMenu() {
    System.out.printf("%nPlease choose an option from the menu below:%n%s",
        menu.getFormattedMenu());
    Integer optionSelected =
        PrompterUtil.tryParse(readLine());

    if (optionSelected != null && isValidOption(optionSelected)) {
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
        promptsForShowingTeams();
        promptMenu();
        break;
      case 6:
        promptsForShowingMyTeam();
        promptMenu();
        break;
      case 7:
        break;
    }
  }

  private void promptsForShowingMyTeam() {
    Integer teamId = teamPrompter.promptForTeam();
    if(teamId != null) {
      teamManagerContract.showTeam(teamManagerContract.chooseTeam(teamId -1));
    }
    else {
      System.out.println("Invalid option, please try again");
      promptsForShowingMyTeam();
    }
  }

  private void promptsForShowingTeams() {
    teamManagerContract.showTeams();
    System.out.printf("%nPlease insert the number of the team: ");
  }

  private void promptsForGeneratingReports() {
    System.out.printf("%nWhat kind of report do you want to generate%n");
    System.out.printf("%n[1] Height report%n[2] Experience report%n");
    Integer optionSelected = PrompterUtil.tryParse(readLine());
    if(optionSelected != null) {
      switch (optionSelected) {
        case 1:
          teamManagerContract.generateHeightReport();
          break;
        case 2:
          teamManagerContract.generateExperienceReport();
          break;
      }
    }

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

  public void start(TeamManagerContract teamManagerContract) {
    this.teamManagerContract = teamManagerContract;
    teamPrompter = new TeamPrompter(teamManagerContract);
    PrompterUtil.displayWelcome();
    promptMenu();
  }

}
