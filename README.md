<h4>Department Management REST API</h4>
 
<strong>Overview: </strong>

This REST API is built using Spring Boot and provides endpoints for managing departments. The API supports GET, POST, PUT, PATCH, DELETE, and HEAD requests.
 
<strong>Endpoints:</strong>
*Department Endpoints*
- *GET /departments*: Retrieves a list of all departments.
- *POST /departments*: Creates a new department. Request body should contain department details in JSON format.
- *GET /departments/{id}*: Retrieves a department by ID.
- *GET /departments/name/{name}*: Retrieves a department by name.
- *PUT /departments/{id}*: Updates an existing department.
- *PATCH /departments/{id}*: Partially updates an existing department.
- *DELETE /departments/{id}*: Deletes a department by ID.
- *HEAD /departments/{id}*: Retrieves metadata about a department.

  *Try These*
  - POST : http://localhost:8082/departments
  - GET : http://localhost:8082/departments
  - GET : http://localhost:8082/departments/2
  - GET : http://localhost:8082/departments/sales
  - DELETE : http://localhost:8082/departments/1
  - PUT : http://localhost:8082/departments/2
  - PATCH : http://localhost:8082/departments/patch/2
  - HEAD : http://localhost:8082/2
 
<strong>Usage</strong>
To use this API, start the Spring Boot application and send HTTP requests to the endpoints listed above. You can use tools like Postman, cURL, or your preferred HTTP client to interact with the API.
 
<strong>Notes</strong>
- Spring Boot automatically allows all HTTP methods, including OPTIONS, so it's not explicitly implemented in this API.
- This API uses JSON format for request and response bodies.
 
<strong>Contributing</strong>

Contributions are welcome! If you'd like to contribute to this project, please fork the repository, make your changes, and submit a pull request.
 
License
This project is licensed under the MIT License. See the LICENSE file for details.
