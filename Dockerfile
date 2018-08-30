FROM java:8
ENV APP_HOME /app
WORKDIR $APP_HOME
ADD play-http-client/target/universal/play-http-client-1.0-SNAPSHOT.tgz .
ADD run_http.sh .
RUN groupadd -r securityapp && useradd -r -G root -g securityapp securityapp &&  \
		chown -R securityapp:root /app && \
		chmod 777 /app/play-http-client-1.0-SNAPSHOT  && \
		chmod -R 775 /app/
USER securityapp
ENTRYPOINT ["sh","/app/run_http.sh"]
EXPOSE 2555 9000
