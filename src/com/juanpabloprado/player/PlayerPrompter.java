package com.juanpabloprado.player;

import com.juanpabloprado.BasicPrompter;
import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import com.juanpabloprado.roster.Roster;
import com.juanpabloprado.team.TeamManager;
import com.juanpabloprado.util.PrompterUtil;

public abstract class PlayerPrompter extends BasicPrompter {

  protected MenuPrompter menuPrompter;

  public PlayerPrompter(MenuPrompter menuPrompter) {
    this.menuPrompter = menuPrompter;
  }

  public interface PlayerListener {
    void onPlayerSelected(Player player, Team team);
  }

  public void selectPlayer(PlayerListener listener) {
    try {
      int teamSelected = promptForTeam();
      Team team = chooseTeam(teamSelected);
      try {
        int playerSelected = promptForPlayer(team);
        Player player = choosePlayer(playerSelected - 1);
        listener.onPlayerSelected(player, team);
      } catch (TeamManager.TeamException | Roster.RosterException e) {
        PrompterUtil.displayError(e, "You may want to add some players to the team first");
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

  private int promptForTeam() {
    menuPrompter.teamManagerContract.showTeams();
    return Integer.parseInt(console.readLine("%nPlease insert the number of the team: "));
  }

  protected abstract Player choosePlayer(int i);

  public abstract int promptForPlayer(Team team);
}
