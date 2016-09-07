package com.juanpabloprado.team.report.experience;

import com.juanpabloprado.dto.TeamPlayer;
import com.juanpabloprado.team.report.TeamReporter;
import com.juanpabloprado.util.PrompterUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeamsByExperienceReporter extends TeamReporter {

  private TeamByExperienceReport report;

  public TeamsByExperienceReporter(TeamByExperienceReport report) {
    this.report = report;
  }

  @Override public void printReport() {

    Set<Map.Entry<Boolean, List<TeamPlayer>>> entries = report.getPlayersByExperience().entrySet();

    PrompterUtil.displayTeamPlayersTitle();
    for (Map.Entry<Boolean, List<TeamPlayer>> integerMapEntry : entries) {
      List<TeamPlayer> players = integerMapEntry.getValue();
      PrompterUtil.printPrettyList(players);
    }
  }
}
