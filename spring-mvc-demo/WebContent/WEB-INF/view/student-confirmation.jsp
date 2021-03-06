<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <link
      href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
      rel="stylesheet"
    />

    <title>Student Confirmation</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Spring MVC Demo</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="/spring-mvc-demo">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/spring-mvc-demo/hello/showForm"
                >Hello Form</a
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container mt-5">
      <h2>Student Confirmed</h2>

      <p class="mt-2">${student.firstName} ${student.lastName}</p>
      <p class="mt-2">Country ${student.country}</p>
      <p class="mt-2">Favorite Language ${student.favoriteLanguage}</p>
      <p class="mt-4">Operating Systems</p>
      <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
          <li>${temp}</li>
        </c:forEach>
      </ul>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
