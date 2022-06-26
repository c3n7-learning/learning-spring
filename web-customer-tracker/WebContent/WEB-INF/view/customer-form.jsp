<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <link
      href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
      rel="stylesheet"
    />

    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>List Customers</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-success">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">CRM - Customer Relationship Manager</a>
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
              <a
                class="nav-link"
                href="${pageContext.request.contextPath}/customer/list"
                >Home</a
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <section class="container mt-5">
      <h4 class="mb-4">Add Customer</h4>

      <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        <!-- need to associate this data with customer id -->
        <form:hidden path="id" />

        <div class="form-group">
          <label>First Name</label>
          <form:input
            type="text"
            path="firstName"
            placeholder="First Name"
            class="form-control"
          />
        </div>

        <div class="form-group mt-1">
          <label>Last Name</label>
          <form:input
            type="text"
            path="lastName"
            placeholder="Last Name"
            class="form-control"
          />
        </div>

        <div class="form-group mt-1">
          <label>Email</label>
          <form:input
            type="email"
            path="email"
            placeholder="Email"
            class="form-control"
          />
        </div>

        <button type="submit" class="btn btn-success mt-3">Submit</button>
      </form:form>
    </section>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
