FROM {{REGISTRY}}actinver-spring-boot-8-image:8-jre-actinver
EXPOSE 8080
USER microuser
COPY target/{{artifactId}}.jar app.jar
CMD ["java", "-jar", "app.jar"]