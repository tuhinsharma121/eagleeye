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

package com.redhat.eagleeye.functions;

import com.redhat.eagleeye.records.IpProfileAccumulator;
import com.redhat.eagleeye.records.NetworkEvent;
import org.apache.flink.api.common.functions.AggregateFunction;

/**
 * An {@link AggregateFunction} which simply counts {@link NetworkEvent}s.
 *
 */
public class IpProfileAggregator implements AggregateFunction<NetworkEvent, IpProfileAccumulator, IpProfileAccumulator> {
	@Override
	public IpProfileAccumulator createAccumulator() {
		return new IpProfileAccumulator(0L,0L,0L);
	}

	@Override
	public IpProfileAccumulator add(final NetworkEvent value, final IpProfileAccumulator accumulator) {
		Long requestCount = accumulator.getRequestCount()+1;
		Long totalBytes = accumulator.getTotalBytes()+ value.getBytes();
		long isFile = value.getIsFile() ? 1L : 0L;
		Long fileCount = accumulator.getFileCount()+isFile;
		return new IpProfileAccumulator(requestCount,totalBytes,fileCount);
	}

	@Override
	public IpProfileAccumulator getResult(final IpProfileAccumulator accumulator) {
		return accumulator;
	}

	@Override
	public IpProfileAccumulator merge(final IpProfileAccumulator a, final IpProfileAccumulator b) {
		Long requestCount = a.getRequestCount()+a.getRequestCount();
		Long totalBytes = b.getTotalBytes()+b.getRequestCount();
		Long fileCount = b.getFileCount()+b.getFileCount();
		return new IpProfileAccumulator(requestCount,totalBytes,fileCount);
	}
}
