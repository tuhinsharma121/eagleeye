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
import com.redhat.eagleeye.records.IpProfile;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.Date;

/**
 * A simple {@link ProcessWindowFunction}, which wraps a count of {@link NetworkEvent}s into an
 * instance of {@link IpProfile}.
 *
 **/
public class IpProfileCollector
		extends ProcessWindowFunction<IpProfileAccumulator, IpProfile, String, TimeWindow> {

	@Override
	public void process(
			final String ip,
			final Context context,
			final Iterable<IpProfileAccumulator> elements,
			final Collector<IpProfile> out) throws Exception {

		IpProfileAccumulator profile = elements.iterator().next();

		out.collect(new IpProfile(new Date(context.window().getStart()), new Date(context.window().getEnd()), ip, profile.getTotalBytes(),profile.getRequestCount(),profile.getFileCount()));
	}
}
