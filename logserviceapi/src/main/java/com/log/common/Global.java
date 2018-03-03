package com.log.common;

import com.common.MongodbHelper;
import com.common.RedisHelper;
import com.mongodb.MongoClient;

public class Global {

	public static RedisHelper redisConn=new RedisHelper("127.0.0.1",6379,"pwd123456");
	public static  MongoClient mongodbConn= new MongodbHelper("172.0.0.1", 27017).LoadMongodbService();

	public static String LogInfoQueName = "log_info";

	public static String MongodbdbName_LogInfo = "testlu";
	public static String MongodbdbTable_LogInfo = "testlu";
}
