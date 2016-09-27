/*
 * Copyright (c) 2012-2015 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The Apache License v2.0 is available at
 * http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */
package org.jmqtt.interception;


import org.jmqtt.core.packet.ConnectPacket;
import org.jmqtt.core.packet.PublishPacket;
import org.jmqtt.interception.messages.InterceptAcknowledgedMessage;
import org.jmqtt.session.model.Subscription;

/**
 * This interface is to be used internally by the broker components.
 * <p>
 * An interface is used instead of a class to allow more flexibility in changing
 * an implementation.
 * <p>
 * Interceptor implementations forward notifications to a <code>InterceptHandler</code>,
 * that is normally a field. So, the implementations should act as a proxy to a custom
 * intercept handler.
 *
 * @author Wagner Macedo
 * @see InterceptHandler
 */
public interface Interceptor {

    void notifyClientConnected(ConnectPacket msg);

    void notifyClientDisconnected(String clientID, String username);

    void notifyTopicPublished(PublishPacket msg, String clientID, final String username);

    void notifyTopicSubscribed(Subscription sub, final String username);

    void notifyTopicUnsubscribed(String topic, String clientID, final String username);

    void notifyMessageAcknowledged(InterceptAcknowledgedMessage msg);

    boolean addInterceptHandler(InterceptHandler interceptHandler);

    boolean removeInterceptHandler(InterceptHandler interceptHandler);
}
