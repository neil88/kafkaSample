package cn.neil.kafkaMQ.producer.sync;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cn.neil.kafkaMQ.common.Constants;
import cn.neil.kafkaMQ.utilities.CommonUtil;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class SyncProduce {
	public static void main(String[] args) throws Exception {
        dmaccessuvlast30min();
//        yxAccumulatedInMin();
//        dmaccessuvlast30minWaterMark();
    }

    /**
     * 每分钟累计流水
     */
    private static void yxAccumulatedInMin() {
        KafkaMsgSender producer = new KafkaMsgSender();
        String s1 = "{\"fields\":[{\"field_value\":1.0,\"field_name\":\"realtotalprice\"},{\"field_value\":\"0.0\",\"field_name\":\"giftcardprice\"},{\"field_value\":\"0\",\"field_name\":\"cancelstatus\"},{\"field_value\":\"10.0\",\"field_name\":\"exptotalprice\"},{\"field_value\":\"0\",\"field_name\":\"source\"},{\"field_value\":\"0.0\",\"field_name\":\"costprice\"},{\"field_value\":49949908,\"field_name\":\"userid\"},{\"field_value\":\"5\",\"field_name\":\"platform\"},{\"field_value\":\"2\",\"field_name\":\"paymethod\"},{\"field_value\":\"0\",\"field_name\":\"visiblestatus\"},{\"field_value\":206.0,\"field_name\":\"activityrealtotalprice\"},{\"field_value\":[\"paymethod\",\"paytime\",\"status\"],\"field_name\":\"binlog_update_fields\"},{\"field_value\":\"22274192\",\"field_name\":\"id\"},{\"field_value\":\"206.0\",\"field_name\":\"realprice\"},{\"field_value\":\"10.0\",\"field_name\":\"expsyspayprice\"},{\"field_value\":1509632535062,\"field_name\":\"createtime\"},{\"field_value\":\"UPDATE\",\"field_name\":\"binlog_event_type\"},{\"field_value\":\"305.0\",\"field_name\":\"totalprice\"},{\"field_value\":\"0.0\",\"field_name\":\"redpacketprice\"},{\"field_value\":\"0.0\",\"field_name\":\"corpcouponprice\"},{\"field_value\":\"";
        String s2 = "\",\"field_name\":\"paytime\"},{\"field_value\":\"79.0\",\"field_name\":\"activityprice\"},{\"field_value\":\"0.0\",\"field_name\":\"expuserprice\"},{\"field_value\":\"\",\"field_name\":\"corpname\"},{\"field_value\":\"1\",\"field_name\":\"status\"}],\"table_name\":\"dwd_order\"}";
        long ts = 1509465000000L;//2017/10/31 23:50:00
//        long ts = 1510415400000L;//2017/11/11 23:50:00
//        String msg = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-10-26 00:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af1, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af1\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601599937}";
        for(int i=0; i < 11; i++ ){
            if(i>0){
                ts += 60000;
            }
            producer.sendKafkaMsg(s1 + ts + s2);
            try {
                Thread.sleep(1005L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void dmaccessuvlast30minWaterMark() throws Exception {
        KafkaMsgSender kms = new KafkaMsgSender();

        String uuid = "32372b0c167b26c3cfd6f185d9e5f9af";
        String s1 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\",\"field_value\":\"{\\\"uuid\\\":\\\"32372b0c167b26c3cfd6f185d9e5f9af1\\\",\\\"frequency\\\":\\\"10\\\",\\\"ch_Id\\\":\\\"AppStore\\\",\\\"net_type\\\":\\\"wifi\\\",\\\"events\\\":[{\\\"timestamp_a\\\":1508601577953,\\\"page_name\\\":\\\"\\\",\\\"sequence\\\":1386,\\\"event_name\\\":\\\"click_mainpagetab\\\",\\\"event_action\\\":\\\"click\\\",\\\"parameters\\\":{\\\"sequen\\\":4,\\\"userType\\\":\\\"0\\\"},\\\"log_source\\\":\\\"app\\\",\\\"frompage\\\":\\\"yanxuan:\\\\/\\\\/homepage_newarrival\\\",\\\"locpage\\\":\\\"yanxuan:\\\\/\\\\/homepage_newarrival\\\"}],\\\"idfa\\\":\\\"8CE99531-34D8-445D-A860-7301AE849BF6\\\",\\\"YXS_v\\\":\\\"1\\\",\\\"app_v\\\":\\\"YANXUAN3.4.0\\\",\\\"OS_V\\\":\\\"ios11.0\\\",\\\"abtest_info\\\":\\\"\\\",\\\"model_Id\\\":\\\"iPhone 6S\\\",\\\"resolution\\\":\\\"375*667\\\",\\\"account\\\":\\\"m13348937348@163.com\\\",\\\"timestamp_s\\\":1508601599937}\"},{\"field_name\":\"ts\",\"field_value\":\"";
        String s2 = String.valueOf(System.currentTimeMillis());
        String s3 = "\"},{\"field_name\":\"secondCateId\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"\\\"";
        String s4 = uuid;
        String s5 = "\\\"\"},{\"field_name\":\"itemId\"},{\"field_name\":\"date\",\"field_value\":\"2017-10-31 00:00:00,062\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2017-10-31\"}]}";
        String msg = new StringBuilder(s1).append(s2).append(s3).append(s4).append(s5).toString();


        Thread.sleep(15000);
        kms.sendKafkaMsg(msg);
        msg = new StringBuilder(s1).append(String.valueOf(System.currentTimeMillis())).append(s3).append(s4).append("1").append(s5).toString();
        kms.sendKafkaMsg(msg);

        Thread.sleep(15000);
        kms.sendKafkaMsg(msg);
        msg = new StringBuilder(s1).append(String.valueOf(System.currentTimeMillis())).append(s3).append(s4).append("2").append(s5).toString();
        System.out.println("end");

    }

    /**
     * 最近30分钟访问uv
     */
    private static void dmaccessuvlast30min() {
//        long ts1 = 1509436800000L;//2017/10/31 16:00:00
//        long ts2 = 1509436860000L;//2017/10/31 16:01:00
//        long ts3 = 1509436920000L;//2017/10/31 16:02:00
//        long ts4 = 1509436980000L;//2017/10/31 16:03:00
        long ts1 = System.currentTimeMillis();
        long ts2 = ts1 + 60000 * 1;
        long ts3 = ts1 + 60000 * 2;
        long ts4 = ts1 + 60000 * 3;

        String uuid = "32372b0c167b26c3cfd6f185d9e5f9af";

        KafkaMsgSender kms = new KafkaMsgSender();
        MyTimerTask task1 = new MyTimerTask(kms,2, ts1, "t1-" + uuid);
        MyTimerTask task2 = new MyTimerTask(kms,2, ts2, "t2-" + uuid);
        MyTimerTask task3 = new MyTimerTask(kms,2, ts3, "t3-" + uuid);
        MyTimerTask task4 = new MyTimerTask(kms,2, ts4, "t4-" + uuid);


        Long initalDelay = 60L;
        Long period = 60L;
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4);
        scheduledExecutorService.scheduleAtFixedRate(task1, 0*initalDelay, period, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(new MyTimerTask(kms,2, ts2, "tt-" + uuid), 70 , TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task2, 1*initalDelay, period, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(task3, 2*initalDelay, period, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task4, 3*initalDelay, period, TimeUnit.SECONDS);
    }

    private static void defaultMethod() {
        System.out.println("SyncProduce start!");

        long events = Constants.producerCount;

        Properties props = CommonUtil.getProperties(false);
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);

        for (long nEvents = 0; nEvents < events; nEvents++) {

            long runtime = System.currentTimeMillis();
            String ip = "192.168.3." + nEvents;
			String msg = runtime + ",www.example.com," + ip;
			KeyedMessage<String, String> data = new KeyedMessage<String, String>(Constants.topic, msg);
			producer.send(data);
    		System.out.println("SyncProduce send data! ip=" + ip + " msg=" + msg);
        }

        producer.close();
    }
}
