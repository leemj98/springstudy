package com.gdu.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.myapp.dao.ContactDao;
import com.gdu.myapp.dto.ContactDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // private final ContactDao contactDao;에 @Autowired를 하기 위한 코드이다.
@Service  // ContactService 타입의 객체(Bean)을 Spring Container에 저장한다.
public class ContactServiceImpl implements ContactService {

  private final ContactDao contactDao;
  
  @Override
  public int addContact(ContactDto contactDto) {
    int addResult = contactDao.insert(contactDto);
    return addResult;
  }

  @Override
  public int modifyContact(ContactDto contactDto) {
    int modifyResult = contactDao.update(contactDto);
    return modifyResult;
  }

  @Override
  public int deleteContact(int notice_no) {
    int deleteResult = contactDao.delete(notice_no);
    return deleteResult;
  }

  @Override
  public List<ContactDto> getContactList() {
    return contactDao.selectList();
  }

  @Override
  public ContactDto getContactByNo(int notice_no) {
    return contactDao.selectContactByNo(notice_no);
  }

}
