package com.juanpabloprado.team.report.list;

import com.juanpabloprado.model.Player;
import java.util.Comparator;

public class PlayerByHeightComparator implements Comparator<Player> {

  @Override public int compare(Player lhsPlayer, Player rhsPlayer) {
    return ((Integer) lhsPlayer.getHeightInInches()).compareTo(rhsPlayer.getHeightInInches());
  }

  @Override public boolean equals(Object object) {
    return object == this;
  }
}
