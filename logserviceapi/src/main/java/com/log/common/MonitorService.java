package com.log.common;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.common.CommonHelper;
import com.log.entity.LogInfoEntity;
import com.log.entity.LogInfoRequest;

import net.sf.json.JSONObject;

public class MonitorService {
	public static LogInfoEntity Getloginfo(HttpServletRequest req, String str) {
		LogInfoEntity result = null;
		if (str != null && str != "" && str.trim().length() > 0) {
			try {
				JSONObject jsonobj = JSONObject.fromObject(str);
				LogInfoRequest loginforequest = (LogInfoRequest) JSONObject.toBean(jsonobj, LogInfoRequest.class);
				result = new LogInfoEntity();
				result.setId(CommonHelper.GetGuid());
				result.setHost(CommonHelper.getIP(req));
				result.setType(loginforequest.getType());
				result.setName(loginforequest.getName());
				result.setMessage(loginforequest.getMessage());
				result.setCtime(loginforequest.getCtime());
				result.utime = new Date().getTime();
			} catch (Exception e) {
			}
		}
		return result;
	}
}
