#!/usr/bin/env bash

flink run -c com.redhat.eagleeye.IpProfiler /opt/eagleeye-profiler.jar --bootstrap.servers kafka:9092 --checkpointing --event-time  --detached


