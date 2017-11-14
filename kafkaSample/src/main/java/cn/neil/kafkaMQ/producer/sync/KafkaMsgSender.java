package cn.neil.kafkaMQ.producer.sync;

import cn.neil.kafkaMQ.common.Constants;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import cn.neil.kafkaMQ.utilities.CommonUtil;

import java.util.Properties;

/**
 * Created by hzxiaozhikun on 2017/10/31.
 */
public class KafkaMsgSender {
    private Properties props;
    private ProducerConfig config;
    private Producer<String, String> producer;

    public KafkaMsgSender(){
        props = CommonUtil.getProperties(false);
        config = new ProducerConfig(props);
        producer = new Producer<String, String>(config);
    }

    public void sendKafkaMsg(String msg){

        long runtime = System.currentTimeMillis();
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(Constants.topic, msg);
        producer.send(data);
    }
}