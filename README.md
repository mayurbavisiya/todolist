How to get project in your folder

$ git clone https://github.com/mayurbavisiya/todolist.git


Run Project

1) Spring boot app.
   You can simply run app, by running TodoApplication.java.
   Either you can run, by simply deploying war(mvn clean install) file to deployment server.
   
   Note: Before running application make sure postgresql is running.
	 * Default port is 5432 if your DB is running in different port , you can change in application.properties.
	 * DB Username I have kept sylvain and no password.
	 * Create Empty database with the name task_manager. If you have different you can simply update in property file.
	 * No need to create tables it will create automatically, Dyring startup of the application.
	 * I have defined server port 9999. Because that port I have to mention in vue router to route the request.(If you change it, You will need to change it in http-common.js in /src folder inside vuesourcecode.

2) Vue js app
   install vue and vue-router by follow ommand
	* npm install vue 
	* npm install vue-router
	* npm install (This commad is for, If any package is missing it will add)  
	* npm run serve (to start the application)
   
   It will show you the URL where to open. Default port is 8080
   You can run the app by http://localhost:8080/


Technolgy and version

Backend:

	* Spring boot : 2.2.6.RELEASE
	* Java : 1.8
	* DB : postgresql 12
	* Deployment Server: Tomcat

FrontEnd :
 
	* Vue : 2.6
	* Runtime Enviornment : Node js

Note: Lombok is added in the pom.xml(Also created getter setter method) Because InelliJ has that plugin by default. But for the other IDE you need to install it manually. So to avoid that for now getter setter is created in Entities.

Functionality and Workflow.

	Home Page : All the list of assigned Task will show. On click it shows details(Completed /pending)
	All User : List all the users and on click on User Shows details(there is a option to update or delete)
	Add User : TO Add new users
	Add Task : TO add new Task
	Assign Task : Where one can assign the task to user
	Assigned Task: Shows task those are assigned to user and there is a option to mark complete.
	
	ScreenShot is attached for every screen.

Note:	
	I Kept it sample, And try to cover basic needs of the TODO list. Did not created user login modules and all(As I did not have work with vue js before and time duration was short.)


Reference:

As I am beginner with the vue Js.Front end took my 75% of the time. I got big help from the below reference for vue.
In the backend you will see, I tried to maintain quality of the code.

https://developer.okta.com/blog/2018/11/20/build-crud-spring-and-vue

https://vuejs.org/

https://stackoverflow.com/

https://github.com/   
   
		
		
