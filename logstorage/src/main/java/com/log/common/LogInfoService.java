package com.log.common;

import com.log.entity.LogInfoEntity;

public class LogInfoService {

	public static int QueueStorage() {
		int result = -1;
		LogInfoEntity loginfoentity = RedisManager.ReceiveRedis();
		if (loginfoentity != null) {
			try {
				MongoManager.SendMongodb(loginfoentity);
				result = 0;
			} catch (Exception e) {
				result = 2;
				System.out.println(e.getStackTrace());
			}
		}
		return result;
	}
}
