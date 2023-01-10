FROM java:8

VOLUME /tmp

# COPY target/demo-1.0.jar demo-1.0.jar

ADD demo-1.0.jar /test.jar

# RUN bash -c "touch /demo-1.0.jar"

EXPOSE 8082

ENTRYPOINT ["java","-jar","/test.jar"]