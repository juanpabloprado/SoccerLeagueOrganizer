package com.juanpabloprado.player;

import com.juanpabloprado.menu.MenuPrompter;
import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import com.juanpabloprado.team.TeamManager;
import com.juanpabloprado.util.PrompterUtil;

public class PlayerPrompterHelper {

  private MenuPrompter menuPrompter;

  public PlayerPrompterHelper(MenuPrompter menuPrompter) {
    this.menuPrompter = menuPrompter;
  }

  public interface PlayerListener {
    void onPlayerSelected(Player player, Team team);
  }

  public void selectPlayer(PlayerListener listener) {
    try {
      int teamSelected = menuPrompter.promptForTeam();
      Team team = menuPrompter.chooseTeam(teamSelected);
      int playerSelected = menuPrompter.promptForPlayer();
      Player player = menuPrompter.teamManagerContract.choosePlayer(playerSelected - 1);
      listener.onPlayerSelected(player, team);
    } catch (TeamManager.TeamException e) {
      PrompterUtil.displayError(e, "You may want to add some teams first");
    }
  }
}
