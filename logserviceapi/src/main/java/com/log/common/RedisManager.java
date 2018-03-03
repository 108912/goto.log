package com.log.common;

import com.log.entity.LogInfoEntity;
import net.sf.json.JSONObject;

public class RedisManager {
	public static int Addloginfo(LogInfoEntity info) {
		int result = 0;
		if (info != null) {
			try {
				SendRedis(info);
			} catch (Exception e) {
				result += 2;
				System.out.println(e.toString());
			}
		} else {
			result++;
		}
		return result;
	}

	public static void SendRedis(LogInfoEntity info) {
		JSONObject jsonObj = JSONObject.fromObject(info);
		Global.redisConn.QueuePush(Global.LogInfoQueName, jsonObj.toString());
	}
}