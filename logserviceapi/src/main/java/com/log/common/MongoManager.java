package com.log.common;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;
import com.log.entity.LogInfoEntity;

import net.sf.json.JSONObject;

public class MongoManager {
	public static int Addloginfo(LogInfoEntity info) {
		int result = 0;
		if (info != null) {
			try {
				SendMongodb(info);
			} catch (Exception e) {
				result += 2;
				System.out.println(e.toString());
			}
		} else {
			result++;
		}
		return result;
	}

	public static void SendMongodb(LogInfoEntity info) {
		if (info != null) {
			MongoDatabase db = Global.mongodbConn.getDatabase(Global.MongodbdbName_LogInfo);
			Document doc = new Document();
			doc.append("name", "name1");
			JSONObject jsonobj = JSONObject.fromObject(info);
			Document doc2 = Document.parse(jsonobj.toString());
			System.out.println(jsonobj.toString());
			db.getCollection(Global.MongodbdbTable_LogInfo).insertOne(doc2);
		}
	}
}
