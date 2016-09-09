package com.juanpabloprado.team;

import com.juanpabloprado.BasicPrompter;
import com.juanpabloprado.util.PrompterUtil;

public class TeamPrompter extends BasicPrompter {
  private final TeamManagerContract manager;

  public TeamPrompter(TeamManagerContract manager) {
    this.manager = manager;
  }

  public Integer promptForTeam() {
    manager.showTeams();
    System.out.printf("%nPlease insert the number of the team: ");
    return PrompterUtil.tryParse(readLine());
  }
}
