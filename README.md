# commentapp-be

Clone the"projectcomment" project folder in your machine.

Note: This backend is done using springboot framework with H2 in-memory database so each time you run the backend application previously added/updated data will be vanished but only
data present in data.sql file under resource folder will be there initially.

Recomment to import the project folder in Ecllipse IDE.

choose the java file "Projectcommentpplication" right click and run as java application.

default port number is localhost:8080, if you want to make change change port number in application.properties, server.port property but not recommended since front will look for
port number 8080.

to view H2 database - http://localhost:8080/h2-console
click "connect".