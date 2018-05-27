package com.hro.core.cstream.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 消息消费者
 */
@EnableBinding(Sink.class)
public class MsgReceiver {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @StreamListener(Sink.INPUT)
    private void receive(Object payload) {
        logger.info("MessageReceive payload->{}", payload);
    }

}
