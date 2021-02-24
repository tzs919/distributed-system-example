FROM openjdk:sec
RUN mkdir -p /usr/local/configserver
ADD @project.build.finalName@.jar /usr/local/configserver/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
