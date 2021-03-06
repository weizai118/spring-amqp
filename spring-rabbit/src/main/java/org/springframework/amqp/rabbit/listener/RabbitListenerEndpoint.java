/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.amqp.rabbit.listener;


/**
 * Model for a Rabbit listener endpoint. Can be used against a
 * {@link org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer
 * RabbitListenerConfigurer} to register endpoints programmatically.
 *
 * @author Stephane Nicoll
 * @author Gary Russell
 * @since 1.4
 */
public interface RabbitListenerEndpoint {

	/**
	 * @return the id of this endpoint. The id can be further qualified
	 * when the endpoint is resolved against its actual listener
	 * container.
	 * @see RabbitListenerContainerFactory#createListenerContainer
	 */
	String getId();

	/**
	 * @return the group of this endpoint or null if not in a group.
	 * @since 1.5
	 */
	String getGroup();

	/**
	 * @return the concurrency of this endpoint.
	 * @since 2.0
	 */
	String getConcurrency();

	/**
	 * Override of the default autoStartup property.
	 * @return the autoStartup.
	 * @since 2.0
	 */
	Boolean getAutoStartup();

	/**
	 * Setup the specified message listener container with the model
	 * defined by this endpoint.
	 * <p>This endpoint must provide the requested missing option(s) of
	 * the specified container to make it usable. Usually, this is about
	 * setting the {@code queues} and the {@code messageListener} to
	 * use but an implementation may override any default setting that
	 * was already set.
	 * @param listenerContainer the listener container to configure
	 */
	void setupListenerContainer(MessageListenerContainer listenerContainer);

}
