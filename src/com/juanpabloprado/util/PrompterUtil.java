package com.juanpabloprado.util;

import java.util.List;

public class PrompterUtil {
  private static final String SEPARATOR = "\n=============\n";

  public static void displayWelcome() {
    System.out.printf("%nSoccer League Organizer %s", SEPARATOR);
  }

  public static void displayTeamsTitle() {
    System.out.printf("%nTEAMS %s", SEPARATOR);
    System.out.printf("%-2s %-30s %n", "#", "NAME");
  }

  public static void displayError(Exception e, String message) {
    System.out.printf("%s, %s%n", e.getMessage(), message);
  }

  public static void printPrettyOrderedList(List list) {
    for (int i = 0, listSize = list.size(); i < listSize; i++) {
      Object item = list.get(i);
      System.out.printf("%-2d %s%n", i + 1, item.toString());
    }
  }

  public static void printPrettyList(List list) {
    for (int i = 0, listSize = list.size(); i < listSize; i++) {
      Object item = list.get(i);
      System.out.printf("%s%n", item.toString());
    }
  }

  public static void displayPlayersTitle() {
    System.out.printf("%nPLAYERS %s", SEPARATOR);
    System.out.printf("%-2s %-30s %-10s %s%n", "#", "NAME", "HEIGHT", "EXPERIENCE");
  }

  public static void displayTeamPlayersTitle() {
    System.out.printf("%nPLAYERS %s", SEPARATOR);
    System.out.printf("%-30s %-30s %-10s %s%n", "TEAM", "NAME", "HEIGHT", "EXPERIENCE");
  }

  public static void displayTeamTitle(String name) {
    System.out.printf("%n%s %s", name, SEPARATOR);
    System.out.printf("%-2s %-30s %-10s %s%n", "#", "NAME", "HEIGHT", "EXPERIENCE");
  }

  public static Integer tryParse(String text) {
    try {
      return Integer.parseInt(text);
    } catch (NumberFormatException e) {
      return null;
    }
  }
}
