package com.juanpabloprado.team.report;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamByHeightReport {
  Map<Integer, Map<Player, String>> playersByHeight = new HashMap<>();
  Map<Player, String> playersPerHeight;
  List<Integer> playersHeight;

  public TeamByHeightReport(
      List<Team> teams) {

    for (Team team : teams) {
      playersPerHeight = new HashMap<>();
      for (Player player : team.getPlayers()) {
        int currentHeight = player.getHeightInInches();
        playersPerHeight.put(player, team.getName());
        playersByHeight.put(currentHeight, playersPerHeight);
      }
    }
  }

  public Map<Integer, Map<Player, String>> getPlayersByHeight() {
    return playersByHeight;
  }
}
