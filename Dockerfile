FROM tomcat

RUN rm -rf /tomcat/webapps/*

# Set workdir  petclinic
WORKDIR /petclinic-docker


RUN curl -o petclinic.war http://10.63.39.117:8081/artifactory/api/storage/libs-snapshot-local/org/springframework/samples/spring-petclinic/1.0.0-SNAPSHOT/spring-petclinic-1.0.0-20160416.092617-2.war

ADD petclinic.war

CMD ["catalina.sh", "run"]

