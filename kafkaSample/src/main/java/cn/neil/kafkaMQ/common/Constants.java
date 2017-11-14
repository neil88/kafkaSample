package cn.neil.kafkaMQ.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Constants implements Serializable  {

	public static String hostList = "10.246.18.13";
	public static String zookeeperPort = "2183";
	public static String brokerPort = "9094";
//	public static String topic = "FDATA-DWD_ACCESS";
	public static String topic = "FDATA-DWD_ACCESS";
	public static String partitionerClass = "SimplePartitioner";
	public static String groupId = "test_group_20160418";
	public static long producerCount = 100;
	public static int poolSize = 5;
}