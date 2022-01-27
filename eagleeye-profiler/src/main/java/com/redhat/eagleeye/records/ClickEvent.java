/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redhat.eagleeye.records;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

/**
 * A simple event recording a click on a {@link ClickEvent#bytes} at time {@link ClickEvent#eventTimestamp}.
 */
public class ClickEvent {

    //using java.util.Date for better readability
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date eventTimestamp;
    private String ip;
    private boolean isFile;
    private long bytes;
    private String stateCode;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;
    private String second;

    public ClickEvent() {
    }

    public ClickEvent(final Date timestamp, String ip, String isFile, final String bytes, final String stateCode, String year, String month, String day, String hour, String minute, String second) {
        this.eventTimestamp = timestamp;
        this.ip = ip;
        this.isFile = Boolean.parseBoolean(isFile);
        this.bytes = Long.parseLong(bytes);
        this.stateCode = stateCode;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Date getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(final Date eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public long getBytes() {
        return bytes;
    }

    public void setBytes(final long bytes) {
        this.bytes = bytes;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(final String stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ClickEvent that = (ClickEvent) o;
        return Objects.equals(eventTimestamp, that.eventTimestamp) && Objects.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventTimestamp, bytes);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClickEvent{");
        sb.append("timestamp=").append(eventTimestamp);
        sb.append(", pageType='").append(bytes).append('\'');
        sb.append(", stateCode='").append(stateCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean getIsFile() {
        return isFile;
    }

    public void setIsFile(boolean isFile) {
        this.isFile = isFile;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
