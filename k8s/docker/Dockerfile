FROM anupamgogoi/ubuntu-java:latest

COPY ./files/mule-ee-distribution-standalone-4.4.0.zip /opt/mule/

WORKDIR /opt/mule
RUN unzip mule-ee-distribution-standalone-4.4.0.zip && \
    rm mule-ee-distribution-standalone-4.4.0.zip
# COPY ./conf/wrapper.conf /opt/mule/mule-enterprise-standalone-4.4.0/conf
COPY ./files/mock.jar /opt/mule/mule-enterprise-standalone-4.4.0/apps

EXPOSE 8081
CMD ["mule-enterprise-standalone-4.4.0/bin/mule"]