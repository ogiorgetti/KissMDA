/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package de.crowdcode.kissmda.cartridges.simplejava;

import javax.inject.Singleton;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import de.crowdcode.kissmda.cartridges.simplejava.extension.TypesExtensionHandler;

/**
 * Guice Module for SimpleJavaTransformer.
 * 
 * @author Lofi Dewanto
 * @version 1.0.0
 * @since 1.0.0
 */
public class SimpleJavaModule extends AbstractModule {

	// Create one event bus for the whole time
	private final EventBus eventBus = new EventBus("SimpleJava EventBus");

	/**
	 * Configure the Guice module.
	 */
	@Override
	protected void configure() {
		registerHandlers();
	}

	/**
	 * Register all the handlers, listeners and extensions.
	 */
	protected void registerHandlers() {
		eventBus.register(new TypesExtensionHandler());
	}

	@Provides
	@Singleton
	private EventBus provideEventBus() {
		return eventBus;
	}
}
