package com.juanpabloprado.roster;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import com.juanpabloprado.util.PrompterUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Roster implements RosterContract {
  private List<Player> roster;

  @Override public void showTeamRoster(Team fromTeam) {
    roster = new ArrayList<Player>(fromTeam.getPlayers());
    if(roster.size() > 0) {
      Collections.sort(roster);
      PrompterUtil.displayTeamTitle(fromTeam.getName());
      PrompterUtil.printPrettyList(roster);
    } else {
      throw new RosterException("The players list is empty");
    }
  }

  @Override public Player choosePlayerFromTeam(int index) {
    return roster.get(index);
  }

  public class RosterException extends RuntimeException {
    public RosterException(String message) {
      super(message);
    }
  }
}
