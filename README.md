The project was developed using:
  - Spring Boot and the OkHttp library for the backend app
  - React.js for the frontend app
  - MySQL database
  - Gradle

Instructions

1. Download the ZIP file with the project

2. Add your database in the config file located at:
src/main/resources/application.properties (no need to create tables)

3. In the root folder, start the server app running the command:
gradle bootRun

4. In another terminal tab, go to the folder: 
kry-react-client

5. Download dependencies and run:
npm install && npm start

6. You will be directed to 
http://localhost:3000

But that is empty, it's the place where the login page could be.
To acces the homepage, go instead to

http://localhost:3000/endpoints
