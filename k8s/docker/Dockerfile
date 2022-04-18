FROM java:openjdk-8-jdk
RUN echo "Creating Docker Image..."


COPY ./files/mule-ee-distribution-standalone-4.4.0.zip /opt/mule/
WORKDIR /opt/mule
RUN unzip mule-ee-distribution-standalone-4.4.0.zip && \
    rm mule-ee-distribution-standalone-4.4.0.zip

RUN echo "Deploy Mule ESB"
CMD ["mule-enterprise-standalone-4.4.0/bin/mule"]