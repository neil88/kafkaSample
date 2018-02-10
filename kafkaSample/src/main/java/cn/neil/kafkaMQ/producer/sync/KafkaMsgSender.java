package cn.neil.kafkaMQ.producer.sync;

import cn.neil.kafkaMQ.common.Constants;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import cn.neil.kafkaMQ.utilities.CommonUtil;

import java.util.Date;
import java.util.Properties;

/**
 * Created by hzxiaozhikun on 2017/10/31.
 */
public class KafkaMsgSender implements Runnable{
    private Properties props;
    private ProducerConfig config;
    private Producer<String, String> producer;

    private String msg;

    private String topic;

    public KafkaMsgSender(){
        props = CommonUtil.getProperties(false);
        config = new ProducerConfig(props);

        producer = new Producer<String, String>(config);
    }

    public KafkaMsgSender(String msg, String topic){
        this();
        this.msg = msg;
        this.topic = topic;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void sendKafkaMsg(String msg){
        sendKafkaMsg(msg, Constants.topic);
    }

    public void sendKafkaMsg(String msg, String topic){
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, msg);
        producer.send(data);
        System.out.println("线程:" + Thread.currentThread().getName() + "    ts:"+ new Date());
    }

    @Override
    public void run() {
        sendKafkaMsg(msg, topic);
    }
}