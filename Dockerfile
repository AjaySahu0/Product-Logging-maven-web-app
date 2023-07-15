FROM tomcat:8.0.20-jre8

COPY target/Product-Logging-maven-web-app*.war /usr/local/tomcat/webapps/Product-Logging-maven-web-app.war
