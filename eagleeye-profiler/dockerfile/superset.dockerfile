FROM apache/superset:1.3.1

# Switching to root to install the required packages
USER root

# Install pinotdb driver to connect to Pinot
#COPY requirements-db.txt requirements-db.txt

RUN pip install pinotdb==0.3.3
RUN pip install snowflake-sqlalchemy==1.2.5
RUN pip install sqlalchemy-redshift==0.8.4
RUN pip install psycopg2==2.9.1

# Switching back to using the `superset` user
USER superset

RUN superset fab create-admin \
                     --username admin \
                     --firstname Superset \
                     --lastname Admin \
                     --email admin@superset.com \
                     --password admin && \
             superset db upgrade && \
             superset init \
