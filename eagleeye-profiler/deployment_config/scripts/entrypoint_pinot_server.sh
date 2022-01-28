#!/usr/bin/env bash

sleep 10
/opt/pinot/bin/pinot-admin.sh StartServer -zkAddress zookeeper:2181
