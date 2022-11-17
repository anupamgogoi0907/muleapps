FROM adoptopenjdk/openjdk11
MAINTAINER anupam.gogoi.br@avenuecode.com
COPY /build/libs/market-1.0.0.jar /opt/app/market-1.0.0.jar
WORKDIR "/opt/app/"
ENTRYPOINT ["java","-jar","market-1.0.0.jar"]