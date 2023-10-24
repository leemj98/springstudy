package com.gdu.myapp.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gdu.myapp.dao.NoticeDao;
import com.gdu.myapp.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {

  private final NoticeDao noticeDAO;
  
  @Override
  public List<NoticeDto> getNoticeList() {
    return noticeDAO.getNoticeList();
  }

  @Override
  public NoticeDto getNotice(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("notice_no"));
    int notice_no = Integer.parseInt(opt.orElse("0"));
    return noticeDAO.getNotice(notice_no);
  }

  @Override
  public int addNotice(HttpServletRequest request) {
    NoticeDto notice = new NoticeDto();
    notice.setGubun(Integer.parseInt(request.getParameter("gubun")));
    notice.setTitle(request.getParameter("title"));
    notice.setContent(request.getParameter("content"));
    return noticeDAO.addNotice(notice);
  }

  @Override
  public int modifyNotice(HttpServletRequest request) {
    NoticeDto notice = new NoticeDto();
    notice.setGubun(Integer.parseInt(request.getParameter("gubun")));
    notice.setTitle(request.getParameter("title"));
    notice.setContent(request.getParameter("content"));
    notice.setNotice_no(Integer.parseInt(request.getParameter("notice_no")));
    return noticeDAO.modifyNotice(notice);
  }

  @Override
  public int removeNotice(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("notice_no"));
    int notice_no = Integer.parseInt(opt.orElse("0"));
    return noticeDAO.removeNotice(notice_no);
  }

}
