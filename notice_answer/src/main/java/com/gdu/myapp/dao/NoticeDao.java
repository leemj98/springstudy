package com.gdu.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.myapp.dto.NoticeDto;

@Repository
public class NoticeDao {

  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  private String sql;
  
  private Connection getConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GD", "1111");
  }
  
  private void close() {
    try {
      if(rs != null) rs.close();
      if(ps != null) ps.close();
      if(con != null) con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public List<NoticeDto> getNoticeList() {
    List<NoticeDto> list = new ArrayList<NoticeDto>();
    try {
      con = getConnection();
      sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T ORDER BY NOTICE_NO DESC";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        NoticeDto notice = new NoticeDto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
        list.add(notice);
      }
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return list;
  }
  
  public NoticeDto getNotice(int notice_no) {
    NoticeDto notice = null;
    try {
      con = getConnection();
      sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T WHERE NOTICE_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, notice_no);
      rs = ps.executeQuery();
      if(rs.next()) {
        notice = new NoticeDto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
      }
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return notice;
  }
  
  public int addNotice(NoticeDto notice) {
    int addResult = 0;
    try {
      con = getConnection();
      sql = "INSERT INTO NOTICE_T VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
      ps = con.prepareStatement(sql);
      ps.setInt(1, notice.getGubun());
      ps.setString(2, notice.getTitle());
      ps.setString(3, notice.getContent());
      addResult = ps.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return addResult;
  }
  
  public int modifyNotice(NoticeDto notice) {
    int modifyResult = 0;
    try {
      con = getConnection();
      sql = "UPDATE NOTICE_T SET GUBUN = ?, TITLE = ?, CONTENT = ? WHERE NOTICE_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, notice.getGubun());
      ps.setString(2, notice.getTitle());
      ps.setString(3, notice.getContent());
      ps.setInt(4, notice.getNotice_no());
      modifyResult = ps.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return modifyResult;
  }

  public int removeNotice(int notice_no) {
    int result = 0;
    try {
      con = getConnection();
      sql = "DELETE FROM NOTICE_T WHERE NOTICE_NO = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, notice_no);
      result = ps.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return result;
  }
  
}
