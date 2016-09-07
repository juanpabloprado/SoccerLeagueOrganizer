package com.juanpabloprado.player;

import com.juanpabloprado.BasicPrompter;
import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import com.juanpabloprado.roster.Roster;
import com.juanpabloprado.team.TeamManager;
import com.juanpabloprado.util.PrompterUtil;

public abstract class BasePlayerPrompter extends BasicPrompter {

  protected MenuPrompter menuPrompter;

  public BasePlayerPrompter(MenuPrompter menuPrompter) {
    this.menuPrompter = menuPrompter;
  }

  public void selectPlayer(PlayerListener listener) {
    try {
      Integer teamSelected = promptForTeam();
      if(teamSelected == null) {
        System.out.printf("Please choose a valid option%n");
        selectPlayer(listener);
      } else {
        Team team = chooseTeam(teamSelected);
        try {
          int playerSelected = promptForPlayer(team);
          Player player = choosePlayer(playerSelected - 1);
          listener.onPlayerSelected(player, team);
        } catch (TeamManager.TeamException | Roster.RosterException e) {
          PrompterUtil.displayError(e, "You may want to add some players to the team first");
        }
      }
    } catch (TeamManager.TeamException | Roster.RosterException e) {
      PrompterUtil.displayError(e, "You may want to add some teams first");
    }
  }

  private Team chooseTeam(int teamSelected) {
    Team team = menuPrompter.teamManagerContract.chooseTeam(teamSelected - 1);
    System.out.printf("You chose the %s team%n", team);
    return team;
  }

  private Integer promptForTeam() {
    menuPrompter.teamManagerContract.showTeams();
    System.out.printf("%nPlease insert the number of the team: ");
    return PrompterUtil.tryParse(readLine());
  }

  protected abstract Player choosePlayer(int i);

  public abstract int promptForPlayer(Team team);
}
