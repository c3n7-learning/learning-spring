<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <link
      href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
      rel="stylesheet"
    />

    <title>Input Form</title>
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

    <div class="container-sm mt-5">
      <h2>Student Registration Form</h2>

      <form:form action="processForm" modelAttribute="student" cssClass="w-25" >
        <div class="mt-2">First Name</div>        
        <form:input path="firstName" cssClass="form-control" />

        <div class="mt-2">Last Name</div>        
        <form:input path="lastName" cssClass="form-control" />

        <div class="mt-2">Country</div>        
        <form:select path="country" cssClass="form-select">
          <form:options items="${theCountryOptions}"/>
        </form:select>

        <div class="mt-2">Favorite Language</div>
        <div>
          <form:radiobuttons path="favoriteLanguage" class="form-check-input" items="${student.favoriteLanguageOptions}"/>
        </div>

        <input type="submit" value="Submit" class="btn btn-primary mt-2">
      </form:form>

    </div>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
