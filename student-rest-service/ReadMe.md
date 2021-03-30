To run the Spring Boot REST service on external tomcat or any other server, following changes need to be made
1. Exclude the embeded tomcat from web starter dependency in pom.xml

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
		<!-- to exclude the embeded tomcat -->
		<exclusions>
			<exclusion>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-tomcat</artifactId>
			</exclusion>
		</exclusions>
	</dependency>
	
	And add it as compile time dependency as it will be required while cretaing war
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>compile</scope>
	</dependency>

2. Add below in pom.xml in order to create war
	<packaging>war</packaging>
   
3. To change war file name, add below tag in <build> tag in pom.xml
   
   <finalName>${artifactId}</finalName>
   
4. Extend the main class from SpringBootServletInitializer
5. Run Maven -> Install to create war file.
6. Copy war file into webapps directory of external tomcat and start the tomcat there
7. To access this service, the default application context will be war file name. e.g. http://localhost:8008/<war-file-name>/REST URI path
   If this service is to be run at '/' context path, then rename the war to ROOT.war and then deploy it. Access the service like
   http://localhost:8008/REST URI path