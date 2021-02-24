FROM openjdk:netcat
RUN mkdir -p /usr/local/specialroutes-services
ADD @project.build.finalName@.jar /usr/local/specialroutes-service/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh
