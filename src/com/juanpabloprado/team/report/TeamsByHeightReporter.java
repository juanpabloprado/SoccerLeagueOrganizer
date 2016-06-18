package com.juanpabloprado.team.report;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeamsByHeightReporter extends TeamReporter {

  private TeamByHeightReport report;

  public TeamsByHeightReporter(TeamByHeightReport report) {
    this.report = report;
  }

  @Override public void printReport() {

    Set<Map.Entry<Integer, List<Player>>> entries = report.getPlayersByHeight().entrySet();

    for (Map.Entry<Integer, List<Player>> integerMapEntry : entries) {

      System.out.printf("Height %d inches%n", integerMapEntry.getKey());
      List<Player> players = integerMapEntry.getValue();

      for (Player player : players) {
        System.out.printf("%s, %n", player.toString());
      }

    }
  }
}
