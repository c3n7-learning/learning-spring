<!DOCTYPE html>
<html>
  <head>
    <link
      href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
      rel="stylesheet"
    />

    <title>Hello World</title>
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
      <h2>Hello World of Spring</h2>

      Student name: ${param.studentName}

      <br /><br />

      The message: ${message}
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
