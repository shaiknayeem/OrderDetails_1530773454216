

   _____ _          __  __      _     _           
  / ____| |        / _|/ _|    | |   | |          
 | (___ | | ____ _| |_| |_ ___ | | __| | ___ _ __ 
  \___ \| |/ / _` |  _|  _/ _ \| |/ _` |/ _ \ '__|
  ____) |   < (_| | | | || (_) | | (_| |  __/ |   
 |_____/|_|\_\__,_|_| |_| \___/|_|\__,_|\___|_|   

       _                  
      | |                 
      | | __ ___   ____ _ 
  _   | |/ _` \ \ / / _` |
 | |__| | (_| |\ V / (_| |
  \____/ \__,_| \_/ \__,_|
                          
                          

                                         
                                         

This project was generated by Skaffolder

For more documentation visit https://skaffolder.com/#/documentation


--------------
PREREQUISITES
--------------

    - maven
    - jdk 1.7
    - My SQL Database


--------------
CONFIGURE DATABASE
--------------

On database execute the SQL script  script/schemaDb_OrderDetails_db.sql  generated in folder /script.
--------------
BUILD FRONTEND
--------------

If you are using Angular 4 frontend type:

	cd src/client
	npm install
	npm run build
	
if you want to keep updating frontend type:

	npm run watch

--------------
START APPLICATION
--------------

For start the application open a command line in the project's folder an type:

    mvn spring-boot:run

This will start a lite java server on your pc and run the application.

Go to http://localhost:8080


--------------
START WITH DOCKER
--------------

To start the application with Docker:

 - Install Docker

 - Change db URL in src/main/resources/config/dev.properties to: 
    'mongodb://database:27017'

 - Run command:
    docker-compose up --build

 - Go to 
    http://localhost:3000


    After code changes you need to rebuild container running:
        docker-compose up --build

--------------
SWAGGER API DOCS
--------------

You can find the swagger-ui page on:

http://localhost:8080/swagger-ui.html


