<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>

  $(function(){
    fnModifyResult();
    fnDeleteContact();
    fnListContact();
  })
  
  function fnModifyResult(){
    var modifyResult = '${modifyResult}';
    if(modifyResult !== ''){
      if(modifyResult === '1'){
        alert('공지사항이 수정되었습니다.');
      } else {
        alert('공지사항이 삭제됐습니다.');
      }
    }
  }
  
  function fnDeleteContact(){
  $('#btn_delete').click(function(){
    if(confirm('공지사항을 삭제할까요?')){
      $('#frm_detail').attr('action', '${contextPath}/notice/delete.do');
      $('#frm_detail').submit();
    }
  })
  }

  function fnListContact(){
  $('#btn_list').click(function(){
    location.href = '${contextPath}/notice/list.do';
  })
  }
  
</script>
</head>
<body>

  <div>
    <h3>공지 작성하기</h3>
    <form method="post" action="${contextPath}/notice/add.do">
      <div>
        <label for="gubun">구분</label>
        <select id="gubun">
          <option value="1" name="1">일반</option>
          <option value="2"  name="2">긴급</option>
        </select>
      </div>
      <div>
        <label for="title">제목</label>
        <input type="text" id="title" name="title">
      </div>
      <div>
        <label for="content">내용</label>
        <textarea id ="content" name="content" cols="50" rows="10"></textarea>
      </div>
      <div>
        <button type="submit">작성완료</button>
        <button type="button" id="btn_list">목록</button>
      </div>
    </form>
  </div>

</body>
</html>