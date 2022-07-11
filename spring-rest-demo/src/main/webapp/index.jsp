<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Spring Rest Demo</title>
  </head>
  <body>
    <h2>Spring REST Demo</h2>
    <hr />
    <a href="${pageContext.request.contextPath}/test/hello">Hello</a>
    <br />
    <br />
    <a href="${pageContext.request.contextPath}/api/students">
      Get All Students
    </a>
  </body>
</html>
