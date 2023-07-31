# Use uma imagem base do OpenJDK para Java 11
FROM openjdk:17


# Copiar o arquivo JAR do seu projeto Spring Boot para dentro do contêiner
COPY target/superTrunfoFrutas-0.0.1-SNAPSHOT.jar /


# Comando para executar o JAR quando o contêiner iniciar
CMD ["java", "-jar", "/superTrunfoFrutas-0.0.1-SNAPSHOT.jar"]