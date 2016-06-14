package com.juanpabloprado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicPrompter {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  protected String readLine() {
    try {
      return br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
