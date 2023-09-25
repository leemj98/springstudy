package com.gdu.app.xml03;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
  private List<String> subjects;
  private Set<String> contacts;
  private Map<String, String> friends;
}
