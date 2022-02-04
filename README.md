# Eagleeye

A realtime ingestion and profiling engine for fast data.

There are 3 docker-compose files:  
`docker-compose-service.yaml` - this contains all the 4 services ( kafka, pinot, flink, superset)  
`docker-compose-initialize.yaml` - this contains the logic to configure pinot tables listen to respective kafka topic for realtime ingestion.  
`docker-compose-invoke.yaml` - this contains the dummy data generator (written in python) and the flink profiler job (written in java)  

##Steps to run the project.

1. Build the services
```
docker-compose -f docker-compose-service.yaml build
docker-compose -f docker-compose-initialize.yaml build
docker-compose -f docker-compose-invoke.yaml build
```

2. Bring up the services (wait for 1-2 minutes in between while running the following 3 commands)
```
docker-compose -f docker-compose-service.yaml up -d
docker-compose -f docker-compose-initialize.yaml up -d
docker-compose -f docker-compose-invoke.yaml up -d
```

The services can be accessed from the web UI:  
kafka - http://0.0.0.0:9999  
pinot - http://0.0.0.0:9000  
flink - http://0.0.0.0:8081  
superset - http://0.0.0.0:8088  

## Configure superset dashboard

1. Create a Pinot database connection  
connection string - `pinot://pinot-broker:8099/query/sql?controller=http://pinot-controller:9000/`  

2. Import dashboard - `threathunt_dashboard.json`


##To Bring down the services
```
docker-compose -f docker-compose-service.yaml down
docker-compose -f docker-compose-initialize.yaml down
docker-compose -f docker-compose-invoke.yaml down
```