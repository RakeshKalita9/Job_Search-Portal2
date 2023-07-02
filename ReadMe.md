<h1 style="color:blue;text-align:center;" ><b>Job_Search_Portal</h1>

<h1 style="color:blue;";><b>DataBase </h1>
<p>H2-Database<p>

<h1 style="color:blue;";><b>Data Flow </h1>
<p>Controller -- > Controller package handels all type of Api request. our Api requests are handeled by JobController </p>
<p>Model --> Inside model package we store our Job entity as Job class </p>
<p>Service--> Inside the service package,we write all type of the business logic inside JobService</p>
<p>Repo -->Inside the Repo Package there is a JobRepo Interface and it Inherits Crud Repo</p>
<h1 style="color:blue;";><b>Git Commands </h1>
$ git init
<br>
$ git status
<br>
$ git add
<br>
$ git  commit -m "rakeshCommit"
<br>
$ git remote add origin https://github.com/rakesh1234-png/Job_Search-Portal2.git
<br>
$ git push -u origin master

<br>
<h1 style="color:blue;";><b>Application Properties</h1>
spring.datasource.url=jdbc:h2:mem:h2db
<br>
spring.datasource.driverClassName=org.h2.Driver
<br>
spring.datasource.username=sa
<br>
spring.datasource.password=root
<br>
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
<br>
spring.h2.console.enabled=true
<br>
spring.jpa.properties.hibernate.show_sql=true
<br>
spring.jpa.properties.hibernate.use_sql_comments=true
<br>
spring.jpa.properties.hibernate.format_sql=true
