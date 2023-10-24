package com.gdu.myapp;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.myapp.dao.ContactDao;
import com.gdu.myapp.dto.ContactDto;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContactUnitTest {

  @Autowired  // Spring Container에서 ContactDao 객체(Bean)를 가져온다.
  private ContactDao contactDao;
  
  @Test  // 테스트를 수행한다.
  public void test01_삽입테스트() {
    ContactDto contactDto = new ContactDto(0, 0, "제목", "내용");
    int insertResult = contactDao.insert(contactDto);
    assertEquals(1, insertResult);  // insertResult가 1이면 테스트 성공이다.
  }
  
  @Test  // 테스트를 수행한다.
  public void test02_조회테스트() {
    int notice_no = 1;
    ContactDto contactDto = contactDao.selectContactByNo(notice_no);
    assertNotNull(contactDto);  // contactDto가 not null이면 테스트 성공이다.
  }
  
  @Test  // 테스트를 수행한다.
  public void test03_삭제테스트() {
    int notice_no = 1;
    int deleteResult = contactDao.delete(notice_no);
    assertEquals(1, deleteResult);  // deleteResult가 1이면 테스트 성공이다.
    // assertNull(contactDao.selectContactByNo(contact_no));  select 결과가 null이면 테스트 성공이다.
  }

}