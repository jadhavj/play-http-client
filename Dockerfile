FROM java:8
ENV APP_HOME /opt
WORKDIR $APP_HOME
ADD target/universal/play-http-client-1.0-SNAPSHOT .
ADD run_http.sh .
ENTRYPOINT ["sh","/opt/run_http.sh"]
EXPOSE 2555 9000
