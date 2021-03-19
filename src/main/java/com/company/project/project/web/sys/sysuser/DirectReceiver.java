package com.company.project.project.web.sys.sysuser;

import com.company.project.configurer.DirectRabbitConfig;
import com.company.project.project.model.SysUser;
import com.company.project.project.service.SysUserService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    private static final Logger message_log = LoggerFactory.getLogger("message-error");

    @Resource
    private SysUserService sysUserService;

//    @RabbitHandler
    @RabbitListener(queues = DirectRabbitConfig.QUEUE_NAME, ackMode = "MANUAL")
    public void process(@Payload SysUser sysUser, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
//    public void process(Message msg, @Payload SysUser sysUser, ) throws IOException {
        System.out.println("DirectReceiver消费者收到消息  : " + sysUser);
        System.out.println(sysUser.getUsername());
        System.out.println(deliveryTag);
//        long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
////        channel.basicNack(deliveryTag,false,true);
        try{
            sysUserService.save(sysUser);
            channel.basicAck(deliveryTag, false);
        }catch (Exception e){
            //消费失败，不重新入列，记录日志，人工处理
            log.error("插入失败",e);
            log.error("处理失败的数据:" + sysUser);
            message_log.error("处理失败的数据:" + sysUser);
            channel.basicReject(deliveryTag, false);
        }

        channel.basicAck(deliveryTag, false);
    }

}