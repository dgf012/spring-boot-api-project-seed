package com.company.project.project.web.sys.sysuser;

import com.company.project.project.model.SysUser;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
//监听的队列名称 TestDirectQueue
public class DirectReceiver {
 
//    @RabbitHandler
    @RabbitListener(queues = "TestDirectQueue", ackMode = "MANUAL")
    public void process(@Payload SysUser sysUser, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
//    public void process(Message msg, @Payload SysUser sysUser, ) throws IOException {
        System.out.println("DirectReceiver消费者收到消息  : " + sysUser);
        System.out.println(sysUser.getUsername());
//        long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
////        channel.basicNack(deliveryTag,false,true);
        channel.basicAck(deliveryTag, false);
    }
 
}