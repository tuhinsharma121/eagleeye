# Eagleeye


1. Build the services
```
docker-compose -f docker-compose-service.yaml build
docker-compose -f docker-compose-initialize.yaml build
docker-compose -f docker-compose-invoke.yaml build
```

2. Bring up the services
```
docker-compose -f docker-compose-service.yaml up -d
docker-compose -f docker-compose-initialize.yaml up -d
docker-compose -f docker-compose-invoke.yaml up -d
```

3. Bring down the services
```
docker-compose -f docker-compose-service.yaml down
docker-compose -f docker-compose-initialize.yaml down
docker-compose -f docker-compose-invoke.yaml down
```

