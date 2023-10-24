package com.gdu.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDto {
  private int notice_no;
  private int gubun;
  private String title;
  private String content;
}
