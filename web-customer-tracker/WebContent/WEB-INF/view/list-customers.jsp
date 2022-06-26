<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>List Customers</title>
  </head>
  <body>
    <section>
      <header>
        <h2>CRM - Customer Relationship Manager</h2>
      </header>

      <div>
        <table>
          <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="tempCustomer" items="${customer}">
              <tr>
                <td>${tempCustomer.firstName}</td>
                <td>${tempCustomer.lastName}</td>
                <td>${tempCustomer.email}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </section>
  </body>
</html>
