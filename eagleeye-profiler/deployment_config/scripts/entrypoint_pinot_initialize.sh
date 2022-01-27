#!/usr/bin/env bash

/opt/pinot/bin/pinot-admin.sh AddTable \
-schemaFile /pinot-schemas/network-event-schema.json \
-tableConfigFile /pinot-schemas/network-event-table-realtime.json \
-controllerHost pinot-controller  \
-controllerPort 9000 \
-exec

/opt/pinot/bin/pinot-admin.sh AddTable \
-schemaFile /pinot-schemas/ipprofile-profile-schema.json \
-tableConfigFile /pinot-schemas/ipprofile-profile-table-realtime.json \
-controllerHost pinot-controller  \
-controllerPort 9000 \
-exec

