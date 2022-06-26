<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
      <div class="d-flex justify-content-between align-items-center">
        <h4>Customers</h4>
        <a href="showFormForAdd" class="btn btn-success mb-3"> Add Customer </a>
      </div>

      <table class="table table-striped rounded">
        <thead class="">
          <tr class="bg-success text-white">
            <th scope="col" class="rounded">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="tempCustomer" items="${customer}">
            <c:url var="updateLink" value="/customer/showFormForUpdate">
              <c:param name="customerId" value="${tempCustomer.id}" />
              Update
            </c:url>

            <tr>
              <td>${tempCustomer.firstName}</td>
              <td>${tempCustomer.lastName}</td>
              <td>${tempCustomer.email}</td>
              <td>
                <a href="${updateLink}" class="btn btn-sm btn-dark"> Update </a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </section>

    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
