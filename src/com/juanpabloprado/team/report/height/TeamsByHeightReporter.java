package com.juanpabloprado.team.report.height;

import com.juanpabloprado.dto.TeamPlayer;
import com.juanpabloprado.team.report.TeamReporter;
import com.juanpabloprado.util.PrompterUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeamsByHeightReporter extends TeamReporter {

  private TeamByHeightReport report;

  public TeamsByHeightReporter(TeamByHeightReport report) {
    this.report = report;
  }

  @Override public void printReport() {

    Set<Map.Entry<Integer, List<TeamPlayer>>> entries = report.getPlayersByHeight().entrySet();

    PrompterUtil.displayTeamPlayersTitle();
    for (Map.Entry<Integer, List<TeamPlayer>> integerMapEntry : entries) {
      List<TeamPlayer> players = integerMapEntry.getValue();
      PrompterUtil.printPrettyList(players);
    }
  }
}
