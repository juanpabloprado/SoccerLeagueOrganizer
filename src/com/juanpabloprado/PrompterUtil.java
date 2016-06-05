package com.juanpabloprado;

public class PrompterUtil {
  public static void displayWelcome() {
    CharSequence separator = "\n=============\n";
    System.out.printf("%nSoccer League Organizer %s", separator);
  }

  public static void displayError(Exception e, String message) {
    System.out.printf("%s, %s%n", e.getMessage(), message);
  }
}
