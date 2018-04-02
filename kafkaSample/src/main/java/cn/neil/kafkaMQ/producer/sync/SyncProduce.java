package cn.neil.kafkaMQ.producer.sync;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cn.neil.kafkaMQ.common.Constants;
import cn.neil.kafkaMQ.utilities.CommonUtil;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.commons.lang.StringUtils;

public class SyncProduce {
    public static void main(String[] args) throws Exception {
        //        dmaccessuvlast30minWaterMark();
        //        yxAccumulatedInMin();
        //                dmaccessuvlast30min();
//                        dailyAccessUv();
        //        dwdaccess();
//                dmYxAccessItemCate();
        //        dailyAccessHourUv();
        //        dmsupplierpopaymentjob();
//        dmSupplierTemplateJob();
        //        dailyAccessMinuteUv();

//        dmGoodsCateItemSaleQtyRankJob();

        dmYxAccessUvBuMinuteAccuJob();

    }

    private static void dailyAccessMinuteUv() throws InterruptedException {
        String msg1 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2018-01-11 23:57:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af3001, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af3001\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601599937}";
        String msg2 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 00:00:00,065,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af4, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af4\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";
        String msg3 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 00:00:00,070,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af5, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af5\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";
        String msg4 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 00:00:00,075,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af6, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af6\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";

        String msg5 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 00:00:00,080,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af6, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af7\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";
        String msg6 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 23:59:00,080,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af806, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af806\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";

        KafkaMsgSender kms1 = new KafkaMsgSender();
        KafkaMsgSender kms2 = new KafkaMsgSender();
        KafkaMsgSender kms3 = new KafkaMsgSender();
        KafkaMsgSender kms4 = new KafkaMsgSender();
        KafkaMsgSender kms5 = new KafkaMsgSender();
        KafkaMsgSender kms6 = new KafkaMsgSender();

        kms1.sendKafkaMsg(msg1, "datahub-canal-1503973606232");
        //        kms2.sendKafkaMsg(msg2, "datahub-canal-1503973606232");
        //        kms3.sendKafkaMsg(msg3, "datahub-canal-1503973606232");
        //        kms4.sendKafkaMsg(msg4, "datahub-canal-1503973606232");
        //        kms5.sendKafkaMsg(msg5, "datahub-canal-1503973606232");
        //        kms5.sendKafkaMsg(msg6, "datahub-canal-1503973606232");
    }

    private static void dmSupplierTemplateJob() {
        String topic = "ATOM-STREAMING-TB_YX_PMS_FIN_VERIFICATION";
        //插入
        String s1 = "{\"entryType\":\"ROW_DATA\",\"logFilename\":\"mysql-bin.000037\",\"eventType\":\"INSERT\",\"rows\":[{\"paymentNum\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":true,\"value\":\"unCreated\",\"key\":false},\"verifiedMoney\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":true,\"value\":\"1425816.0\",\"key\":false},\"shouldPay\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":true,\"value\":\"0.0\",\"key\":false},\"verifiedQuantity\":{\"sqlType\":4,\"mysqlType\":\"int(11)\",\"updated\":true,\"value\":\"4968\",\"key\":false},\"instockGoodsValue\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":true,\"value\":\"1425816.0\",\"key\":false},\"instockGoodsQuantity\":{\"sqlType\":4,\"mysqlType\":\"int(11)\",\"updated\":true,\"value\":\"4968\",\"key\":false},\"instockLot\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":true,\"value\":\"Isfsp-171225-000001\",\"key\":false},\"itemName\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":true,\"value\":\"日本制造 手榨味淋\",\"key\":false},\"createrUid\":{\"sqlType\":12,\"mysqlType\":\"varchar(128)\",\"updated\":true,\"value\":\"admin\",\"key\":false},\"shouldPayNow\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,4)\",\"updated\":true,\"value\":\"0.0\",\"key\":false},\"createTime\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20)\",\"updated\":true,\"value\":\"1520926508584\",\"key\":false},\"advancePayment\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":true,\"value\":\"1435000.0\",\"key\":false},\"purchaseOrder\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":true,\"value\":\"YC16100572-20170522-3\",\"key\":false},\"id\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20) unsigned\",\"updated\":true,\"value\":\"20044724\",\"key\":true},\"approveTime\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20)\",\"updated\":true,\"value\":\"\",\"key\":false},\"inhouseId\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20) unsigned\",\"updated\":true,\"value\":\"0\",\"key\":false},\"skuId\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20)\",\"updated\":true,\"value\":\"1203007\",\"key\":false}}],\"schemaName\":\"cg_yanxuan\",\"transactionId\":\"181615701\",\"tableName\":\"TB_YX_PMS_FIN_VERIFICATION\",\"delay\":762,\"nanoTimestamp\":1520926508761469025,\"filePosition\":421561592,\"commitTimestamp\":1520926508000,\"executeTime\":1520926508000,\"timestamp\":1520926508762}";

        //插入
        String s = "{\"entryType\":\"ROW_DATA\",\"logFilename\":\"mysql-bin.000034\",\"eventType\":\"INSERT\",\"rows\":[{\"purchasingPrice\":{\"sqlType\":3,\"mysqlType\":\"decimal(10,2)\",\"updated\":true,\"value\":\"30.0\",\"key\":false},\"paymentNum\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":true,\"value\":\"PMSP-YC17020051-21\",\"key\":false},\"quantity\":{\"sqlType\":4,\"mysqlType\":\"int(11)\",\"updated\":true,\"value\":\"2475\",\"key\":false},\"id\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20) unsigned\",\"updated\":true,\"value\":\"20001447\",\"key\":true},\"skuId\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20)\",\"updated\":true,\"value\":\"1470013\",\"key\":false}}],\"schemaName\":\"cg_yanxuan\",\"transactionId\":\"153837025\",\"tableName\":\"TB_YX_PMS_FIN_PAYMENT_DETAIL_SKU\",\"delay\":187,\"filePosition\":167008684,\"commitTimestamp\":1515515416000,\"executeTime\":1515515417003,\"timestamp\":1515515416187}";

        //存在 删除操作
        String s2 = "{\"entryType\":\"ROW_DATA\",\"logFilename\":\"mysql-bin.000037\",\"eventType\":\"UPDATE\",\"rows\":[{\"paymentNum\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":true,\"value\":\"PMSP-YC16100572-92\",\"key\":false},\"verifiedMoney\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":false,\"value\":\"1425816.0\",\"key\":false},\"shouldPay\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":false,\"value\":\"0.0\",\"key\":false},\"verifiedQuantity\":{\"sqlType\":4,\"mysqlType\":\"int(11)\",\"updated\":false,\"value\":\"4968\",\"key\":false},\"instockGoodsValue\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":false,\"value\":\"1425816.0\",\"key\":false},\"instockGoodsQuantity\":{\"sqlType\":4,\"mysqlType\":\"int(11)\",\"updated\":false,\"value\":\"4968\",\"key\":false},\"instockLot\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":false,\"value\":\"Isfsp-171225-000001\",\"key\":false},\"itemName\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":false,\"value\":\"日本制造 手榨味淋\",\"key\":false},\"createrUid\":{\"sqlType\":12,\"mysqlType\":\"varchar(128)\",\"updated\":false,\"value\":\"admin\",\"key\":false},\"shouldPayNow\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,4)\",\"updated\":false,\"value\":\"0.0\",\"key\":false},\"createTime\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20)\",\"updated\":false,\"value\":\"1520926508584\",\"key\":false},\"advancePayment\":{\"sqlType\":3,\"mysqlType\":\"decimal(16,2)\",\"updated\":false,\"value\":\"1435000.0\",\"key\":false},\"purchaseOrder\":{\"sqlType\":12,\"mysqlType\":\"varchar(64)\",\"updated\":false,\"value\":\"YC16100572-20170522-3\",\"key\":false},\"id\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20) unsigned\",\"updated\":false,\"value\":\"20044724\",\"key\":true},\"approveTime\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20)\",\"updated\":false,\"value\":\"\",\"key\":false},\"inhouseId\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20) unsigned\",\"updated\":false,\"value\":\"0\",\"key\":false},\"skuId\":{\"sqlType\":-5,\"mysqlType\":\"bigint(20)\",\"updated\":false,\"value\":\"1203007\",\"key\":false}}],\"schemaName\":\"cg_yanxuan\",\"transactionId\":\"181615701\",\"tableName\":\"TB_YX_PMS_FIN_VERIFICATION\",\"delay\":762,\"nanoTimestamp\":1520926508761619974,\"filePosition\":421563201,\"commitTimestamp\":1520926508000,\"executeTime\":1520926508000,\"timestamp\":1520926508762}";

        KafkaMsgSender kms = new KafkaMsgSender();

        kms.sendKafkaMsg(s1, topic);

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
        for (int i = 0; i < 11; i++) {
            if (i > 0) {
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
        //分钟 * 每分钟次数
        int cnt = 6 * 5;
        //每次发送间隔
        int interval = 10000;

        List<Long> tsList = new ArrayList<>(cnt);
        Long ts = System.currentTimeMillis() - cnt * interval;

        for (int i = 0; i < cnt; i++) {
            tsList.add(ts + i * interval);
        }
        Collections.shuffle(tsList);

        //发送消息
        KafkaMsgSender kms = new KafkaMsgSender();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String uuid = "32372b0c167b26c3cfd6f185d9e5f9af";
        String s1 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\",\"field_value\":\"{\\\"uuid\\\":\\\"32372b0c167b26c3cfd6f185d9e5f9af1\\\",\\\"frequency\\\":\\\"10\\\",\\\"ch_Id\\\":\\\"AppStore\\\",\\\"net_type\\\":\\\"wifi\\\",\\\"events\\\":[{\\\"timestamp_a\\\":1508601577953,\\\"page_name\\\":\\\"\\\",\\\"sequence\\\":1386,\\\"event_name\\\":\\\"click_mainpagetab\\\",\\\"event_action\\\":\\\"click\\\",\\\"parameters\\\":{\\\"sequen\\\":4,\\\"userType\\\":\\\"0\\\"},\\\"log_source\\\":\\\"app\\\",\\\"frompage\\\":\\\"yanxuan:\\\\/\\\\/homepage_newarrival\\\",\\\"locpage\\\":\\\"yanxuan:\\\\/\\\\/homepage_newarrival\\\"}],\\\"idfa\\\":\\\"8CE99531-34D8-445D-A860-7301AE849BF6\\\",\\\"YXS_v\\\":\\\"1\\\",\\\"app_v\\\":\\\"YANXUAN3.4.0\\\",\\\"OS_V\\\":\\\"ios11.0\\\",\\\"abtest_info\\\":\\\"\\\",\\\"model_Id\\\":\\\"iPhone 6S\\\",\\\"resolution\\\":\\\"375*667\\\",\\\"account\\\":\\\"m13348937348@163.com\\\",\\\"timestamp_s\\\":1508601599937}\"},{\"field_name\":\"ts\",\"field_value\":\"";
        String s2;
        String s3 = "\"},{\"field_name\":\"secondCateId\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"\\\"";
        String s4 = uuid;
        String s5 = "\\\"\"},{\"field_name\":\"itemId\"},{\"field_name\":\"date\",\"field_value\":\"2017-10-31 00:00:00,062\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2017-10-31\"}]}";

        int times = 0;
        for (Long tmpTs: tsList) {
            String msg = new StringBuilder(s1).append(tmpTs.toString())
                .append(s3).append(s4).append("-").append(times++).append(s5)
                .toString();
            kms.sendKafkaMsg(msg);
            System.out.println("事件时间:" + df.format(new Date(tmpTs)) + "  于:"
                + df.format(new Date()));
            Thread.sleep(10000);
        }

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
        MyTimerTask task1 = new MyTimerTask(kms, 2, ts1, "t1-" + uuid);
        MyTimerTask task2 = new MyTimerTask(kms, 2, ts2, "t2-" + uuid);
        MyTimerTask task3 = new MyTimerTask(kms, 2, ts3, "t3-" + uuid);
        MyTimerTask task4 = new MyTimerTask(kms, 2, ts4, "t4-" + uuid);

        Long initalDelay = 60L;
        Long period = 60L;

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
            4);

        scheduledExecutorService.scheduleAtFixedRate(task1, 0 * initalDelay,
            period, TimeUnit.SECONDS);
        //测试延时发送超时 延时超过2分钟
        //        scheduledExecutorService.schedule(new MyTimerTask(kms,2, ts1, "t1-001-" + uuid), 55 , TimeUnit.SECONDS);
        //        scheduledExecutorService.schedule(new MyTimerTask(kms,2, ts1 + 3100L, "t1002-" + uuid), 31 , TimeUnit.SECONDS);
        //        scheduledExecutorService.schedule(new MyTimerTask(kms,2, ts1, "t1-003-" + uuid), 185 , TimeUnit.SECONDS);

        //        scheduledExecutorService.schedule(new MyTimerTask(kms,2, ts2, "tt1-" + uuid), 116 , TimeUnit.SECONDS);
        //        scheduledExecutorService.schedule(new MyTimerTask(kms,2, ts2, "tt2-" + uuid), 117 , TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(task2, 1 * initalDelay,
            period, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(task3, 2 * initalDelay,
            period, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task4, 3 * initalDelay,
            period, TimeUnit.SECONDS);
    }

    private static void defaultMethod() {
        System.out.println("SyncProduce start!");

        long events = Constants.producerCount;

        Properties props = CommonUtil.getProperties(false);
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(
            config);

        for (long nEvents = 0; nEvents < events; nEvents++) {

            long runtime = System.currentTimeMillis();
            String ip = "192.168.3." + nEvents;
            String msg = runtime + ",www.example.com," + ip;
            KeyedMessage<String, String> data = new KeyedMessage<String, String>(
                Constants.topic, msg);
            producer.send(data);
            System.out
                .println("SyncProduce send data! ip=" + ip + " msg=" + msg);
        }

        producer.close();
    }



    private static void dailyAccessUv() {
        String msg1 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-10-26 00:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af3, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af3\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601599937}";
        String msg2 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-10-26 00:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af4, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af4\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";
        String msg3 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-10-26 00:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af5, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af5\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";
        String msg4 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-10-26 00:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af6, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af6\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";

        KafkaMsgSender kms1 = new KafkaMsgSender();
        KafkaMsgSender kms2 = new KafkaMsgSender();
        KafkaMsgSender kms3 = new KafkaMsgSender();
        KafkaMsgSender kms4 = new KafkaMsgSender();
        //        kms.sendKafkaMsg(msg, "datahub-canal-1503973606232");
        //        kms.sendKafkaMsg(msg1, "datahub-canal-1503973606232");

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(
            4);

        kms1.setMsg(msg1);
        kms1.setTopic("datahub-canal-1503973606232");
        kms2.setMsg(msg2);
        kms2.setTopic("datahub-canal-1503973606232");
        kms3.setMsg(msg3);
        kms3.setTopic("datahub-canal-1503973606232");
        kms4.setMsg(msg4);
        kms4.setTopic("datahub-canal-1503973606232");

        scheduledExecutorService.scheduleAtFixedRate(kms1, 0L, 45L,
            TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(kms2, 0L, 90L,
            TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(kms3, 0L, 90L,
            TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(kms4, 0L, 90L,
            TimeUnit.SECONDS);

    }

    private static void dailyAccessHourUv() throws InterruptedException {
        String msg1 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 00:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af3, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af3\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601599937}";
        String msg2 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 01:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af4, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af4\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";
        String msg3 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 02:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af5, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af5\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";
        String msg4 = "{hostIp=10.160.246.127,fileName=main.2017-10-22.15}[INFO ]2017-12-21 03:00:00,062,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.0, logLevel=DAILYREMOTE, username=m13348937348@163.com, clientIp=117.139.208.9, deviceId=32372b0c167b26c3cfd6f185d9e5f9af6, categroy=main, payload={\"uuid\":\"32372b0c167b26c3cfd6f185d9e5f9af6\",\"frequency\":\"10\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"events\":[{\"timestamp_a\":1508601577953,\"page_name\":\"\",\"sequence\":1386,\"event_name\":\"click_mainpagetab\",\"event_action\":\"click\",\"parameters\":{\"sequen\":4,\"userType\":\"0\"},\"log_source\":\"app\",\"frompage\":\"yanxuan:\\/\\/homepage_newarrival\",\"locpage\":\"yanxuan:\\/\\/homepage_newarrival\"}],\"idfa\":\"8CE99531-34D8-445D-A860-7301AE849BF6\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios11.0\",\"abtest_info\":\"\",\"model_Id\":\"iPhone 6S\",\"resolution\":\"375*667\",\"account\":\"m13348937348@163.com\",\"timestamp_s\":1508601959937}";

        KafkaMsgSender kms1 = new KafkaMsgSender();
        KafkaMsgSender kms2 = new KafkaMsgSender();
        KafkaMsgSender kms3 = new KafkaMsgSender();
        KafkaMsgSender kms4 = new KafkaMsgSender();
        kms1.sendKafkaMsg(msg1, "datahub-canal-1503973606232");
        Thread.currentThread().sleep(60000L);

        kms2.sendKafkaMsg(msg2, "datahub-canal-1503973606232");
        Thread.currentThread().sleep(60000L);

        kms3.sendKafkaMsg(msg3, "datahub-canal-1503973606232");
        Thread.currentThread().sleep(60000L);

        kms4.sendKafkaMsg(msg4, "datahub-canal-1503973606232");
        Thread.currentThread().sleep(60000L);
    }

    private static void dwdaccess() {
        String s1 = "{hostIp=192.168.201.223,fileName=stat.web.log}2017-11-21 06:18:45.273 [INFO] [BiLogWapServiceImpl] [cmd:visit,anonId:b6c6efb9-a08d-48c8-b65a-c1b70b0eb739,source:web_gg_mail_jiaobiao_7,userId:0,userName:null,url:/item/detail?id=1092001&from=web_gg_mail_jiaobiao_7,ip:113.128.88.89]";
        String s2 = "{hostIp=192.168.201.223,fileName=stat.web.log}2017-11-21 15:40:57.743 [INFO] [BiLogWapServiceImpl] [cmd:visit,anonId:b516d786-0aab-4896-a5a4-9c57aa765719,source:web_rk_urs_urs_1,userId:0,userName:null,url:/item/list?categoryId=1010000&subCategoryId=1010001&from=web_rk_urs_urs_1,ip:223.104.188.219]";
        String s3 = "{hostIp=192.168.201.223,fileName=stat.web.log}2017-11-21 20:22:00.632 [INFO] [BiLogWapServiceImpl] [cmd:visit,anonId:7dd3b540-a008-4c53-99b2-b60611837a8f,source:web_gg_mail_jiaobiao_2,userId:0,userName:null,url:/item/list?categoryId=1010000&subCategoryId=1035002&from=web_gg_mail_jiaobiao_2,ip:218.26.55.249]";

        String s4 = "{hostIp=192.168.201.223,fileName=web_access_log}10.170.155.120 - - [20/Nov/2017:00:06:39 +0800] \"GET /item/detail?id=1333003&_stat_area=0&_stat_referer=search&_stat_query=%E9%A3%9E%E6%9C%BA%E6%9D%AF&_stat_count=2 HTTP/1.1\" 200 60298 19 \"117.136.32.61\" \"Mozilla/5.0 (Linux; U; Android 6.0.1; zh-CN; ATH-AL00 Build/HONORATH-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/40.0.2214.89 UCBrowser/11.4.1.939 Mobile Safari/537.36\" \"http://m.you.163.com/search?_stat_search=userhand&keyword=%E9%A3%9E%E6%9C%BA%E6%9D%AF\" \"00794f46-981c-43eb-b4fd-243b741b34df\" \"aos_out_3\" \"-\"";
        String s5 = "{hostIp=192.168.201.223,fileName=web_access_log}10.170.155.138 - - [20/Nov/2017:00:42:36 +0800] \"GET /item/list?categoryId=1005001 HTTP/1.1\" 200 710007 380 \"42.90.232.112\" \"Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_3 like Mac OS X) AppleWebKit/603.3.8 (KHTML, like Gecko) Mobile/14G60 Bestpay/6.5.4\" \"https://m.you.163.com/item/list?categoryId=1010000\" \"6ce45359-7fb0-402a-8e7d-6d0a75c4d7f5\" \"web_out_cps_yizhifu_0\" \"-\"";
        String s6 = "{hostIp=192.168.201.223,fileName=web_access_log}10.170.155.82 - - [20/Nov/2017:00:11:00 +0800] \"GET /item/list?categoryId=1022001&subCategoryId=1031001 HTTP/1.1\" 200 256012 133 \"121.32.181.134\" \"Mozilla/5.0 (Linux; Android 6.0.1; 1605-A01 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.96 Mobile Safari/537.36\" \"http://m.you.163.com/item/cateList?categoryId=1022001\" \"276be2cf-8331-4187-b483-73a6b9b963e9\" \"wap_out_pz_baidu_1\" \"-\"";

        String s7 = "{hostIp=192.168.201.223,fileName=main}[INFO ]2017-11-21 00:00:00,182,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=10.2, logLevel=DAILYREMOTE, username=hanlise@163.com, clientIp=120.239.72.120, deviceId=f93f909dbed04f0169edbff9b1975d8d, categroy=main, payload={\"uuid\":\"f93f909dbed04f0169edbff9b1975d8d\",\"carrier\":\"移动\",\"ch_Id\":\"from_official\",\"net_type\":\"wifi\",\"frequency\":\"10\",\"idfa\":\"49EF7FED-B17D-4090-832F-8351D1B625C4\",\"events\":[{\"timestamp_a\":1511193595798,\"page_name\":\"timelimit\",\"sequence\":9411,\"event_name\":\"click_timelimit_item\",\"event_action\":\"click\",\"topage\":\"yanxuan:\\/\\/commoditydetails?commodityid=1269012\",\"log_source\":\"h5\",\"parameters\":{\"itemId\":1269012,\"hour\":\"2017112114\"},\"frompage\":\"yanxuan:\\/\\/commoditydetails?commodityid=1251021\",\"locpage\":\"yanxuan:\\/\\/yxwebview?url=https:\\/\\/m.you.163.com\\/flashSale\\/index&use_doc_title=1\"},{\"timestamp_a\":1511193596661,\"page_name\":\"detail\",\"sequence\":9412,\"event_name\":\"view_detail\",\"event_action\":\"view\",\"is_return\":\"0\",\"log_source\":\"app\",\"parameters\":{\"type\":1,\"itemId\":1269012},\"frompage\":\"yanxuan:\\/\\/commoditydetails?commodityid=1251021\",\"locpage\":\"yanxuan:\\/\\/yxwebview?url=https:\\/\\/m.you.163.com\\/flashSale\\/index&use_doc_title=1\"}],\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.0\",\"OS_V\":\"ios10.2\",\"abtest_info\":\"[\\\"YX_CART_001-001\\\"]\",\"model_Id\":\"iPhone 6\",\"resolution\":\"375*667\",\"account\":\"hanlise@163.com\",\"timestamp_s\":1511193600051}";
        String s8 = "{hostIp=192.168.201.223,fileName=main}[INFO ]2017-11-21 00:01:17,318,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=11.1.1, logLevel=DAILYREMOTE, username=2332276434@sina.163.com, clientIp=220.175.150.24, deviceId=96e3a50ef364375a01a94ef0eb274713, categroy=main, payload={\"id\":1511193677100,\"uuid\":\"96e3a50ef364375a01a94ef0eb274713\",\"net_type\":\"wifi\",\"resolution\":\"375*667\",\"events\":[{\"page_name\":\"detail\",\"parameters\":{\"name\":\"?95><86>?93><81>\"},\"sequence\":726,\"timestamps_a\":1511193652532,\"event_action\":\"click\",\"event_name\":\"click_detail_tab_top\",\"frompage\":\"yanxuan:\\/\\/ordering?addressCount=0&from=shoppingCart\",\"locpage\":\"yanxuan:\\/\\/shoppingcart\"},{\"page_name\":\"commoditydetail\",\"parameters\":{\"type\":1,\"itemId\":1085013},\"sequence\":727,\"timestamps_a\":1511193652645,\"event_action\":\"view\",\"event_name\":\"view_commoditydetail\",\"frompage\":\"yanxuan:\\/\\/ordering?addressCount=0&from=shoppingCart\",\"locpage\":\"yanxuan:\\/\\/shoppingcart\"},{\"page_name\":\"commoditydetail\",\"parameters\":{\"type\":1,\"itemId\":1085013},\"sequence\":728,\"timestamps_a\":1511193652874,\"event_action\":\"view\",\"event_name\":\"view_commoditydetail\",\"frompage\":\"yanxuan:\\/\\/shoppingcart\",\"locpage\":\"yanxuan:\\/\\/commoditydetails?promId=0&commodityid=1085013\"},{\"page_name\":\"topicdetail\",\"parameters\":{\"url\":\"\",\"name\":\"nothing\",\"topicId\":10000003},\"sequence\":729,\"timestamps_a\":1511193653199,\"event_action\":\"view\",\"event_name\":\"view_topicdetail\",\"frompage\":\"yanxuan:\\/\\/shoppingcart\",\"locpage\":\"yanxuan:\\/\\/commoditydetails?promId=0&commodityid=1085013\"}],\"idfa\":\"\",\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.3.0\",\"OS_V\":\"ios11.1.1\",\"abtest_info\":\"[\\\"YX_CART_001-001\\\"]\",\"model_Id\":\"iPhone 6S\",\"account\":\"2332276434@sina.163.com\",\"frequency\":\"10\",\"carrier\":\"移动\"}";

        String s9 = "{hostIp=192.168.201.223,fileName=main}[INFO ]2017-11-21 00:00:40,976,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=10.3.3, logLevel=DAILYREMOTE, username=jinkun1989@163.com, clientIp=183.159.198.150, deviceId=3f43fe88aebff189c62b75a9c3246c21, categroy=main, payload={\"uuid\":\"3f43fe88aebff189c62b75a9c3246c21\",\"carrier\":\"移动\",\"ch_Id\":\"AppStore\",\"net_type\":\"wifi\",\"frequency\":\"10\",\"idfa\":\"\",\"events\":[{\"timestamp_a\":1511193631576,\"page_name\":\"catelev1\",\"sequence\":608,\"event_name\":\"view_catelev1\",\"event_action\":\"view\",\"is_return\":\"1\",\"log_source\":\"app\",\"parameters\":{\"categoryId\":1008000},\"frompage\":\"yanxuan:\\/\\/homepage_categoryl2?categoryL1=1005001\",\"locpage\":\"yanxuan:\\/\\/homepage_categoryl2?categoryL1=1008000\"},{\"timestamp_a\":1511193633446,\"page_name\":\"catelev1\",\"sequence\":609,\"event_name\":\"view_catelev1\",\"event_action\":\"view\",\"is_return\":\"1\",\"log_source\":\"app\",\"parameters\":{\"categoryId\":1010000},\"frompage\":\"yanxuan:\\/\\/homepage_categoryl2?categoryL1=1008000\",\"locpage\":\"yanxuan:\\/\\/homepage_categoryl2?categoryL1=1010000\"}],\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.5\",\"OS_V\":\"ios10.3.3\",\"abtest_info\":\"[\\\"YX_CART_001-001\\\"]\",\"model_Id\":\"iPhone 7 Plus\",\"resolution\":\"414*736\",\"account\":\"jinkun1989@163.com\",\"timestamp_s\":1511193640875}";
        String s10 = "{hostIp=192.168.201.223,fileName=main}[INFO ]2017-11-21 00:00:00,355,[yanxuan:main], appId=11, mobileOs=iOS, osVersion=10.3.3, logLevel=DAILYREMOTE, username=qlinye@163.com, clientIp=112.17.241.211, deviceId=5b1f3060e2b4a14feb146e1c21c7a19d, categroy=main, payload={\"uuid\":\"5b1f3060e2b4a14feb146e1c21c7a19d\",\"carrier\":\"移动\",\"ch_Id\":\"AppStore\",\"net_type\":\"4G\",\"frequency\":\"10\",\"idfa\":\"9CCF927A-B2D4-4B05-BEBF-78ADCB4B6CED\",\"events\":[{\"timestamp_a\":1511193597544,\"page_name\":\"catelev2\",\"sequence\":406,\"event_name\":\"view_catelev2\",\"event_action\":\"view\",\"is_return\":\"1\",\"log_source\":\"app\",\"parameters\":{\"categoryId\":1010002},\"frompage\":\"yanxuan:\\/\\/commoditydetails?promId=0&commodityid=1436035\",\"locpage\":\"yanxuan:\\/\\/categoryl2?supercategoryid=1010000&categoryid=1035001&name=xxx\"}],\"YXS_v\":\"1\",\"app_v\":\"YANXUAN3.4.5\",\"OS_V\":\"ios10.3.3\",\"abtest_info\":\"[\\\"YX_CART_001-001\\\"]\",\"model_Id\":\"iPhone 6\",\"resolution\":\"375*667\",\"account\":\"qlinye@163.com\",\"timestamp_s\":1511193600179}";
        String s11 = "{hostIp=192.168.206.129,fileName=main-2017-11-21_10.log}[INFO]2017-11-21 10:33:39,464,[yanxuan:main],appId=11,mobileOs=Android,osVersion=5.1.1,logLevel=DAILYREMOTE,username=oep2jt2ddf67a92cea2175788cc0484759216c02fd@wx.163.com,clientIp=144.123.10.178,deviceId=1f61abecad912bb27b8f5a75eeb467d,categroy=main,payload={\"YXS_v\":\"1\",\"OS_V\":\"android5.1.1\",\"app_v\":\"YANXUAN3.4.7\",\"ch_Id\":\"aos_market_chuizi\",\"model_Id\":\"smartisan SM801\",\"n et_type\":\"wifi\",\"resolution\":\"1080*1920\",\"timestamp_s\":1511231618712,\"carrier\":\"\",\"lbs\":\"121.45902014*37.45742772\",\"abtest_info\":\"[\\\"YX_CART_001-001\\\"]\",\"uuid\":\"1f61abecad912bb27b8f5a75eeb4\\n67d\",\"account\":\"oep2jt2ddf67a92cea2175788cc0484759216c02fd@wx.163.com\",\"idfa\":\"990006202383682\",\"frequency\":\"10\",\"events\":[{\"event_name\":\"special_newdevice\",\"timestamp_a\":1511231534340,\"locpage\":\"yanxuan://homepage\",\"event_action\":\"special\",\"frompage\":\"yanxuan://mainpage_inn\\ner\",\"sequence\":4,\"page_name\":\"\",\"log_source\":\"app\"}]}";

        KafkaMsgSender kms = new KafkaMsgSender();

        //            kms.sendKafkaMsg(s1, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s2, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s3, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s4, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s5, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s6, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s7, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s8, "datahub-canal-1503973606232");
        kms.sendKafkaMsg(s9, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s10, "datahub-canal-1503973606232");
        //            kms.sendKafkaMsg(s11, "datahub-canal-1503973606232");

    }

    private static void dmYxAccessUvBuMinuteAccuJob() throws InterruptedException {
        String s1 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1008001\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\"1522634161000\"},{\"field_name\":\"secondCateId\",\"field_value\":\"1008011\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000003\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-04-02 09:56:01,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-04-02\"}]}";
        String s2 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1008001\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\"1522637761000\"},{\"field_name\":\"secondCateId\",\"field_value\":\"1008011\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000004\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-04-02 10:56:01,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-04-02\"}]}";
        KafkaMsgSender kms = new KafkaMsgSender();
        kms.sendKafkaMsg(s2, "FDATA-DWD_ACCESS");
    }
    private static void dmYxAccessItemCate() throws InterruptedException {
        String s1 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118161000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000001\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        String s2 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"android\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118161000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000001\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        String s3 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"web\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118161000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000001\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        String s4 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"wap\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118161000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000001\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        String s6 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"ios\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118341000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000002\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        String s7 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"android\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118341000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000002\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        String s8 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"web\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118341000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000002\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        String s9 = "{\"table_name\":\"dwd_access\",\"fields\":[{\"field_name\":\"firstCateId\",\"field_value\":\"1001001\"},{\"field_name\":\"platform\",\"field_value\":\"wap\"},{\"field_name\":\"wzpData\"},{\"field_name\":\"ts\",\"field_value\":\""
            +
            //                System.currentTimeMillis() +
            1516118341000L
            + "\"},{\"field_name\":\"secondCateId\",\"field_value\":\"2002001\"},{\"field_name\":\"isNewUUid\"},{\"field_name\":\"uuid\",\"field_value\":\"3f43fe88aebff189c62b75a9c3246c019000002\"},{\"field_name\":\"itemId\",\"field_value\":\"800101\"},{\"field_name\":\"date\",\"field_value\":\"2018-01-03 00:00:00,976\"},{\"field_name\":\"url\"},{\"field_name\":\"ds\",\"field_value\":\"2018-01-03\"}]}";

        KafkaMsgSender kms = new KafkaMsgSender();
        kms.sendKafkaMsg(s1, "FDATA-DWD_ACCESS");
//        kms.sendKafkaMsg(s2, "FDATA-DWD_ACCESS");
//        kms.sendKafkaMsg(s3, "FDATA-DWD_ACCESS");
//        kms.sendKafkaMsg(s4, "FDATA-DWD_ACCESS");
        //
        //        Thread.sleep(1500L);
        //
//        kms.sendKafkaMsg(s6, "FDATA-DWD_ACCESS");
//        kms.sendKafkaMsg(s7, "FDATA-DWD_ACCESS");
//        kms.sendKafkaMsg(s8, "FDATA-DWD_ACCESS");
//        kms.sendKafkaMsg(s9, "FDATA-DWD_ACCESS");

        /*
         * long ts1 = System.currentTimeMillis(); long ts2 = ts1 + 60000 * 1;
         * long ts3 = ts1 + 60000 * 2; long ts4 = ts1 + 60000 * 3; String uuid =
         * "32372b0c167b26c3cfd6f185d9e5f9af"; KafkaMsgSender kms = new
         * KafkaMsgSender(); MyTimerTask task1 = new MyTimerTask(kms, 1, ts1,
         * "t1-" + uuid); MyTimerTask task2 = new MyTimerTask(kms, 1, ts2, "t2-"
         * + uuid); MyTimerTask task3 = new MyTimerTask(kms, 1, ts3, "t3-" +
         * uuid); MyTimerTask task4 = new MyTimerTask(kms, 1, ts4, "t4-" +
         * uuid); Long initalDelay = 60L; Long period = 1L;
         * ScheduledExecutorService scheduledExecutorService = new
         * ScheduledThreadPoolExecutor( 4);
         * scheduledExecutorService.scheduleAtFixedRate(task1, 0 * initalDelay,
         * period, TimeUnit.SECONDS);
         * scheduledExecutorService.scheduleAtFixedRate(task2, 0 * initalDelay,
         * period, TimeUnit.SECONDS);
         * scheduledExecutorService.scheduleAtFixedRate(task3, 0 * initalDelay,
         * period, TimeUnit.SECONDS);
         * scheduledExecutorService.scheduleAtFixedRate(task4, 0 * initalDelay,
         * period, TimeUnit.SECONDS);
         */

    }

    private static void dmGoodsCateItemSaleQtyRankJob() throws InterruptedException {
        String s1 = "{\"fields\":[{\"field_value\":\"0.0\",\"field_name\":\"giftcardprice\"},{\"field_value\":\"0\",\"field_name\":\"cancelstatus\"},{\"field_value\":\"10.0\",\"field_name\":\"exptotalprice\"},{\"field_value\":\"0\",\"field_name\":\"source\"},{\"field_value\":\"38.50\",\"field_name\":\"costprice\"},{\"field_value\":\"107188214\",\"field_name\":\"userid\"},{\"field_value\":\"5\",\"field_name\":\"platform\"},{\"field_value\":1115026,\"field_name\":\"itemid\"},{\"field_value\":\"3\",\"field_name\":\"paymethod\"},{\"field_value\":\"0\",\"field_name\":\"visiblestatus\"},{\"field_value\":[\"paytime\",\"status\"],\"field_name\":\"binlog_update_fields\"},{\"field_value\":\"30781102\",\"field_name\":\"id\"},{\"field_value\":\"264.0\",\"field_name\":\"realprice\"},{\"field_value\":\"1034000\",\"field_name\":\"category2_id\"},{\"field_value\":\"10.0\",\"field_name\":\"expsyspayprice\"},{\"field_value\":\"1520305320876\",\"field_name\":\"createtime\"},{\"field_value\":\"UPDATE\",\"field_name\":\"binlog_event_type\"},{\"field_value\":\"264.0\",\"field_name\":\"totalprice\"},{\"field_value\":\"0.0\",\"field_name\":\"redpacketprice\"},{\"field_value\":\"0.0\",\"field_name\":\"corpcouponprice\"},{\"field_value\":2,\"field_name\":\"count\"},{\"field_value\":\"1520305332525\",\"field_name\":\"paytime\"},{\"field_value\":0,\"field_name\":\"isgift\"},{\"field_value\":1520305332000,\"field_name\":\"binlog_execute_time\"},{\"field_value\":\"1010000\",\"field_name\":\"category1_id\"},{\"field_value\":\"0.0\",\"field_name\":\"activityprice\"},{\"field_value\":\"0.0\",\"field_name\":\"expuserprice\"},{\"field_value\":30,\"field_name\":\"subtotalprice\"},{\"field_value\":\"\",\"field_name\":\"corpname\"},{\"field_value\":1130210,\"field_name\":\"skuid\"},{\"field_value\":\"1\",\"field_name\":\"status\"}],\"table_name\":\"dwd_order_sku\"}";
        KafkaMsgSender kms = new KafkaMsgSender();
        kms.sendKafkaMsg(s1, "dwdordersku");

    }
}
