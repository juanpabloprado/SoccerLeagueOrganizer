package com.juanpabloprado.roster;

import com.juanpabloprado.model.Player;
import com.juanpabloprado.model.Team;


public interface RosterContract {

  void showTeamRoster(Team fromTeam) throws Roster.RosterException;

  Player choosePlayerFromTeam(int index);
}
