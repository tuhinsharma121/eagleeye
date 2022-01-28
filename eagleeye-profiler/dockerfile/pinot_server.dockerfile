FROM apachepinot/pinot:0.9.0-SNAPSHOT-5976922d8-20210904-jdk8

ADD ./eagleeye-profiler/deployment_config/scripts/entrypoint_pinot_server.sh /bin/entrypoint.sh
RUN chmod +x /bin/entrypoint.sh
ENTRYPOINT ["/bin/entrypoint.sh"]
