import json
import random
import time
from datetime import datetime

import numpy as np
from kafka import KafkaProducer

# "Beer Cartel", "Brand Labs"
ip_list = ["32.534.234.12", "534.324.56.23", "43.23.2.3", "423.412.43.3", "75.24.65.12"]
state_code_list = ['US-CA', 'US-FL', 'US-NY', 'US-TX']

def get_page_visit_event():
    ip = np.random.choice(ip_list, 1, p=[0.4225, 0.25, 0.2, 0.075, 0.0525])[0]
    is_file = np.random.choice(["true", "false"], 1, p=[0.3, 0.7])[0]
    state_code = np.random.choice(state_code_list, 1, p=[0.1, 0.2, 0.3, 0.4])[0]

    byte = int(100000*(1+np.random.rand()))

    datetime_obj = datetime.utcnow()
    event_timestamp = datetime_obj.strftime("%d-%m-%Y %H:%M:%S")
    day = datetime_obj.strftime("%d")
    month = datetime_obj.strftime("%m")
    year = datetime_obj.strftime("%Y")
    hour = datetime_obj.strftime("%H")
    minute = datetime_obj.strftime("%M")
    second = datetime_obj.strftime("%S")

    my_dict = {
        "ip": ip,
        "eventTimestamp": event_timestamp,
        "isFile": is_file,
        "stateCode": state_code,
        "bytes": byte,
        "year": year,
        "month": month,
        "day": day,
        "hour": hour,
        "minute": minute,
        "second": second
    }
    return my_dict


def dict_to_binary(the_dict):
    d = json.dumps(the_dict)
    binary = str.encode(d)
    return binary


bootstrap_server = 'kafka:9092'
topic = "networkeventtopic"


def main():
    producer = KafkaProducer(bootstrap_servers=[bootstrap_server])

    i = 0
    while True:
        i += 1
        time_to_wait = np.random.random(1)[0]
        time.sleep(time_to_wait)
        my_dict = get_page_visit_event()
        value = dict_to_binary(my_dict)
        producer.send(topic=topic, value=value)
        if i % 100 == 0:
            print(i)


if __name__ == "__main__":
    main()
