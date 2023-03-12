package com.qpolla.auth.data.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserResponseDto {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  private List<String> roles;

  public UserResponseDto(String accessToken, Long id, String username, String email, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
  }
}
