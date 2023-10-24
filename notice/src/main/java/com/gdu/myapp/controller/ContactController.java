package com.gdu.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp.dto.ContactDto;
import com.gdu.myapp.service.ContactService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j  // private static final Logger log = LoggerFactory.getLogger(ContactController.class);
@RequiredArgsConstructor  // private final ContactService contactService;에 @Autowired를 하기 위한 코드이다.
@Controller
public class ContactController {

  // ContactController를 실행할 때 org.slf4j.Logger가 동작한다.
  // private static final Logger log = LoggerFactory.getLogger(ContactController.class);
  
  private final ContactService contactService;
  
  
  @RequestMapping(value="/notice/detail2.do", method=RequestMethod.GET)
  public String l() {
    return "notice/detail2";
  }
  
  @RequestMapping(value="/notice/list.do", method=RequestMethod.GET)
  public String list(Model model) {
    List<ContactDto> contactList = contactService.getContactList();
    model.addAttribute("contactList", contactList);
    return "notice/list";
  }
  
  @RequestMapping(value="/notice/write.do", method=RequestMethod.GET)
  public String write() {
    return "notice/write";
  }
  
  @RequestMapping(value="/notice/add.do", method=RequestMethod.POST)
  public String add(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    log.info("add:" + contactDto);
    int addResult = contactService.addContact(contactDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/notice/list.do";
  }
  
  @RequestMapping(value="/notice/detail.do", method=RequestMethod.GET)
  public String detail(@RequestParam(value="notice_no", required=false, defaultValue="0") int notice_no, Model model) {
    log.info("detail:" + notice_no);
    model.addAttribute("contact", contactService.getContactByNo(notice_no));
    return "notice/detail";
  }
  
  @RequestMapping(value="/notice/modify.do", method=RequestMethod.POST)
  public String modify(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    log.info("modify:" + contactDto);
    int modifyResult = contactService.modifyContact(contactDto);
    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/notice/detail.do?notice_no=" + contactDto.getNotice_no();
  }
  
  @RequestMapping(value="/notice/delete.do", method=RequestMethod.POST)
  public String delete(@RequestParam(value="notice_no", required=false, defaultValue="0") int notice_no, RedirectAttributes redirectAttributes) {
    log.info("delete:" + notice_no);
    int deleteResult = contactService.deleteContact(notice_no);
    redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
    return "redirect:/notice/list.do";
  }
  
}
