package com.juanpabloprado.team.report.height;

import com.juanpabloprado.dto.TeamPlayer;
import com.juanpabloprado.model.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeamByHeightReport {
  private Map<Integer, List<TeamPlayer>> playersByHeight;
  private List<TeamPlayer> players = new ArrayList<>();

  public TeamByHeightReport(
      List<Team> teams) {

    for (Team team : teams) {
      team.getPlayers()
          .forEach(player -> {
            TeamPlayer teamPlayer = new TeamPlayer(player.getFirstName(), player.getLastName(),
                player.getHeightInInches(), player.isPreviousExperience());
            teamPlayer.setTeamName(team.getName());
            players.add(teamPlayer);
          });
    }

    playersByHeight
        = players.stream().collect(Collectors.groupingBy(TeamPlayer::getHeightInInches));
  }

  Map<Integer, List<TeamPlayer>> getPlayersByHeight() {
    return playersByHeight;
  }
}
