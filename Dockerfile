FROM tutum/tomcat

RUN rm -rf /tomcat/webapps/*

# Set workdir  petclinic
WORKDIR /petclinic-docker

RUN mv /petclinic-docker/target/petclinic.war /tomcat/webapps/petclinic.war &&\
    rm -rf /petclinic-docker