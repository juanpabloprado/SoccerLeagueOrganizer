package com.juanpabloprado.player;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;

public interface PlayerListener {
  void onPlayerSelected(Player player, Team team);
}
