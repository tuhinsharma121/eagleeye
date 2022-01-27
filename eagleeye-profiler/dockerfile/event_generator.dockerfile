FROM python:3.7.9

RUN pip3 install kafka-python==2.0.2
RUN pip3 install numpy==1.21.1

COPY ./eagleeye-profiler/visit_generator.py /visit_generator.py
