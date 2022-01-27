#!/usr/bin/env bash

flink run -c com.redhat.eagleeye.ClickEventCount /opt/ClickCountJob.jar --bootstrap.servers kafka:9092 --checkpointing --event-time  --detached


