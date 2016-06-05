package com.juanpabloprado;

import java.util.List;

public class PrompterUtil {
  public static void displayWelcome() {
    CharSequence separator = "\n=============\n";
    System.out.printf("%nSoccer League Organizer %s", separator);
  }

  public static void displayError(Exception e, String message) {
    System.out.printf("%s, %s%n", e.getMessage(), message);
  }

  public static void printPrettyList(List list) {
    for (int i = 0, listSize = list.size(); i < listSize; i++) {
      Object item = list.get(i);
      System.out.printf("%d. %s%n", i + 1, item.toString());
    }
  }
}
