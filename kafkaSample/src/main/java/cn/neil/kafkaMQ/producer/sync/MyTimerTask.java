package cn.neil.kafkaMQ.producer.sync;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by hzxiaozhikun on 2017/10/31.
 */
public class MyTimerTask extends TimerTask {
    private KafkaMsgSender kmc;
    private int times;
    private long ts;
    private String uuid;
    private int cnt = 0;

    public MyTimerTask(KafkaMsgSender kmc, int times, long ts, String uuid){
        this.kmc = kmc;
        this.times = times;
        this.ts = ts;
        this.uuid = uuid;
    }
    @Override
    public void run() {

//        long ts = 1509436800000L;
//        String uuid = "32372b0c167b26c3cfd6f185d9e5f9af";
        if(cnt != 0 && (cnt % times) == 0){
            ts = ts + 60000;
        }

        for (int i = 0; i < this.times; i++) {
            long ts = System.currentTimeMillis();
            String s1 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\"" +
                     + ts +
                    "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

            String s2 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"android\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\"" +
                    + ts +
                    "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

            String s3 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"web\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\"" +
                    + ts +
                    "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

            String s4 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"wap\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\"" +
                    + ts +
                    "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

            String msg = s1;
            if(uuid.startsWith("t1-")){
                msg = s1;
            } else if(uuid.startsWith("t2-")){
                msg = s2;
            } else if(uuid.startsWith("t3-")){
                msg = s3;
            } else if(uuid.startsWith("t4-")){
                msg = s4;
            }

            System.out.println("事件时间:" + new Date(ts) + "  uuid:" + (uuid + cnt) + "  序号:" + cnt + " Thread:" + Thread.currentThread().getName());

            kmc.sendKafkaMsg(msg);
            cnt ++;
        }

    }
}
