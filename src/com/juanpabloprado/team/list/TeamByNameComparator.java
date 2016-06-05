package com.juanpabloprado.team.list;

import com.juanpabloprado.model.Team;
import java.util.Comparator;

public class TeamByNameComparator implements Comparator<Team>{

  @Override public int compare(Team lhsTeam, Team rhsTeam) {
    return lhsTeam.getName().compareToIgnoreCase(rhsTeam.getName());
  }

  @Override public boolean equals(Object object) {
    return object == this;
  }
}
