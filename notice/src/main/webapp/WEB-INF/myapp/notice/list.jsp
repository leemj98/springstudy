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
<script>
  
  $(function(){
    fnAddResult();
    fnDeleteResult();
  })
  
  function fnAddResult(){
    var addResult = '${addResult}';
    if(addResult !== ''){
      if(addResult === '1'){
        alert('공지사항이 등록되었습니다.');
      } else {
    	alert('공지사항 등록이 실패했습니다.');
      }
    }
  }
  
  function fnDeleteResult(){
    var deleteResult = '${deleteResult}';
    if(deleteResult !== ''){
      if(deleteResult === '1'){
        alert('공지사항이 삭제되었습니다.');
      } else {
    	alert('공지사항 삭제가 실패했습니다.');
      }
    }
  }
  
</script>
</head>
<body>

  <div>
    <h3>고양이 상사에 오신것을 환영합니다</h3>
    <img src="${contextPath}/resources/image/animal10.jpg" width="192px">
    <br>
    <table border="1">
      <thead>
        <tr>
          <td>공지사항</td>
          <td>제목</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${contactList}" var="c">
          <tr>
            <td>${c.notice_no}</td>
            <td><a href="${contextPath}/notice/detail.do?notice_no=${c.notice_no}">${c.title}</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <br>
    <div>
      <a href="${contextPath}/notice/write.do">새로운 공지 작성하러 가기</a>
    </div>
  </div>

</body>
</html>