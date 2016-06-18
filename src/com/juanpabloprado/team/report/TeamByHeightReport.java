package com.juanpabloprado.team.report;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TeamByHeightReport {
  Map<Integer, List<Player>> playersByHeight;
  List<Player> players = new ArrayList<>();

  public TeamByHeightReport(
      List<Team> teams) {

    for (Team team : teams) {
      players.addAll(team.getPlayers());
    }

    playersByHeight
        = players.stream().collect(Collectors.groupingBy(Player::getHeightInInches));
  }

  public Map<Integer, List<Player>> getPlayersByHeight() {
    return playersByHeight;
  }
}
