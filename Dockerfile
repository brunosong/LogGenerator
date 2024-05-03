FROM openjdk:17

# MAVEN HOME 설정이 제대로 되어 있지 않으면 에러가 날 수 있어 주석
# https://stackoverflow.com/questions/77676345/apache-maven-plugins-3-11-0-compile-issue
#CMD ["./mvnw", "clean", "package"]

COPY target/LogGenerator.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]