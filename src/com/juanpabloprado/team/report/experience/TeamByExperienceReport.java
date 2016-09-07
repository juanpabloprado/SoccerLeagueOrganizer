package com.juanpabloprado.team.report.experience;

import com.juanpabloprado.dto.TeamPlayer;
import com.juanpabloprado.model.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeamByExperienceReport {
  private Map<Boolean, List<TeamPlayer>> playersByExperience;
  private List<TeamPlayer> players = new ArrayList<>();

  public TeamByExperienceReport(
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

    playersByExperience
        = players.stream().collect(Collectors.groupingBy(TeamPlayer::isPreviousExperience));
  }

  Map<Boolean, List<TeamPlayer>> getPlayersByExperience() {
    return playersByExperience;
  }
}
