package com.zloerysandbox.sandbox.domain;

public class SpendProfile {

  private String profile_str;

  public SpendProfile(String input_str) {
    this.profile_str = input_str;
  }

  @Override
  public String toString() {
    return "SpendProfile{" +
        "profile_str='" + profile_str + '\'' +
        '}';
  }
}
