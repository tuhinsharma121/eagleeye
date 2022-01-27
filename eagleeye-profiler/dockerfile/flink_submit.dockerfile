FROM maven:3.6-jdk-8-slim AS builder

# Get Click Count job and compile it
COPY eagleeye-profiler /opt/eagleeye-profiler
WORKDIR /opt/eagleeye-profiler
RUN mvn clean install


FROM flink:1.13.1-scala_2.12-java8

WORKDIR /opt/flink/bin

# Copy Click Count Job
COPY --from=builder /opt/eagleeye-profiler/target/eagleeye-profiler-*.jar /opt/ClickCountJob.jar

ADD ./eagleeye-profiler/deployment_config/scripts/entrypoint_flink_submit.sh /bin/entrypoint.sh
RUN chmod +x /bin/entrypoint.sh
ENTRYPOINT ["/bin/entrypoint.sh"]