<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%@
taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>c3n7 security</title>
  </head>
  <body>
    <h2>Tight security</h2>
    <hr />

    <p>c3n7 doesn't play games. We are serious.</p>

    <hr />
    <br />
    User: <security:authentication property="principal.username" />
    <br />
    <br />
    Roles(s): <security:authentication property="principal.authorities" />

    <br />

    <security:authorize access="hasRole('MANAGER')">
      <p>
        <a href="${pageContext.request.contextPath}/leaders">
          LeaderShip Meeting
        </a>
        (Only for Manager peeps)
      </p>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
      <p>
        <a href="${pageContext.request.contextPath}/systems">
          IT Systems Meeting
        </a>
        (Only for Admin peeps)
      </p>
    </security:authorize>

    <hr />
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
      <input type="submit" value="Logout" />
    </form:form>
  </body>
</html>
