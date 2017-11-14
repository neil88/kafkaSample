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
            String s1 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\",\"field_value\":\"{\\\"uuid\\\":\\\"32372b0c167b26c3cfd6f185d9e5f9af1\\\",\\\"frequency\\\":\\\"10\\\",\\\"ch_Id\\\":\\\"AppStore\\\",\\\"net_type\\\":\\\"wifi\\\",\\\"events\\\":[{\\\"timestamp_a\\\":1508601577953,\\\"page_name\\\":\\\"\\\",\\\"sequence\\\":1386,\\\"event_name\\\":\\\"click_mainpagetab\\\",\\\"event_action\\\":\\\"click\\\",\\\"parameters\\\":{\\\"sequen\\\":4,\\\"userType\\\":\\\"0\\\"},\\\"log_source\\\":\\\"app\\\",\\\"frompage\\\":\\\"yanxuan:\\\\/\\\\/homepage_newarrival\\\",\\\"locpage\\\":\\\"yanxuan:\\\\/\\\\/homepage_newarrival\\\"}],\\\"idfa\\\":\\\"8CE99531-34D8-445D-A860-7301AE849BF6\\\",\\\"YXS_v\\\":\\\"1\\\",\\\"app_v\\\":\\\"YANXUAN3.4.0\\\",\\\"OS_V\\\":\\\"ios11.0\\\",\\\"abtest_info\\\":\\\"\\\",\\\"model_Id\\\":\\\"iPhone 6S\\\",\\\"resolution\\\":\\\"375*667\\\",\\\"account\\\":\\\"m13348937348@163.com\\\",\\\"timestamp_s\\\":1508601599937}\"},{\"field_name\":\"ts\",\"field_value\":\"";
            String s2 = String.valueOf((ts + cnt));
            String s3 = "\"},{\"field_name\":\"secondCateId\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"\\\"";
            String s4 = uuid + cnt;
            String s5 = "\\\"\"},{\"field_name\":\"itemId\"},{\"field_name\":\"date\",\"field_value\":\"2017-10-31 00:00:00,062\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2017-10-31\"}]}";
            String msg = new StringBuilder(s1).append(s2).append(s3).append(s4).append(s5).toString();
            System.out.println("事件时间:" + new Date(ts + cnt) + "  uuid:" + (uuid + cnt) + "  序号:" + cnt + " Thread:" + Thread.currentThread().getName());

            kmc.sendKafkaMsg(msg);
            cnt ++;
        }

    }
}
