package com.gdu.myapp.service;

import java.util.List;

import com.gdu.myapp.dto.ContactDto;

public interface ContactService {
  public int addContact(ContactDto contactDto);
  public int modifyContact(ContactDto contactDto);
  public int deleteContact(int notice_no);
  public List<ContactDto> getContactList();
  public ContactDto getContactByNo(int notice_no);
}
