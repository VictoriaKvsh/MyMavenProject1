<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
   <body>
      <%@ include file="fragments/header.jsp"%>
      <form action = "user" method = "POST">
         First Name: <input type = "text" value="${param.firstName}">
         <br />
         Last Name: <input type = "text" value="${param.lastName}">
         <br />
        
                
                <fmt:parseDate pattern="MM/dd/yyyy" value="${param.birthdate}" var="parsedDate" />
<fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd" />
                
          BirthDate: <input type = "text" value="${parsedDate}"/>
         <br />
          
        
          
          
         <input type="radio" id="male" value="${param.male==true}">
			<label for="male">Male</label><br>
		 <input type="radio" id="female" value="${param.male==false}">
			<label for="female">Female</label><br>
                  
         <input type = "submit" value = "Submit" />
      </form>
      <!--POST localhost:8080/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
   </body>
</html>