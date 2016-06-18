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

    Set<Map.Entry<Integer, Map<Player, String>>> entries = report.getPlayersByHeight().entrySet();

    for (Map.Entry<Integer, Map<Player, String>> integerMapEntry : entries) {

      System.out.printf("Height %d inches%n", integerMapEntry.getKey());
      Map<Player, String> value = integerMapEntry.getValue();

      for (Map.Entry<Player, String> playerStringEntry : value.entrySet()) {
        System.out.printf("%s, %s %n", playerStringEntry.getKey().toString(), playerStringEntry.getValue());
      }
    }
  }
}
