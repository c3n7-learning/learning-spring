<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--prettier-ignore-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Custom Login</title>
  </head>
  <body>
    <h3>Login</h3>
    <form:form
      action="${pageContext.request.contextPath}/authenticateTheUser"
      method="POST"
    >
      <c:if test="${param.error != null}">
        <i>Sorry! You've entered an invalid username/password</i>
      </c:if>
      <p></p>
      <p>
        <span>User name</span>
        <input type="text" name="username" />
      </p>

      <p>
        <span>Password</span>
        <input type="password" name="password" />
      </p>

      <input type="submit" value="Login" />
    </form:form>
  </body>
</html>
