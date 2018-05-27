package com.hro.core.cstream.jms;

import com.hro.core.cstream.jms.interfaces.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 消息生产者
 */
@EnableBinding(SinkSender.class)
public class MsgSender {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SinkSender sinkSender;

    public void send(String msg) {
        logger.info("MsgSender send ->{}", msg);
        Message<String> message = MessageBuilder.withPayload(msg).build();
        sinkSender.output().send(message);
    }

}
