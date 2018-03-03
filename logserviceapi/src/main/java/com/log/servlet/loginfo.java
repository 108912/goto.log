package com.log.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.log.common.MonitorService;
import com.log.common.RedisManager;
import com.log.entity.LogInfoEntity;

public class loginfo extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		resp.setContentType("text/json; charset=utf-8");
		PrintWriter out = resp.getWriter();

		int status = -1;
		String s = null;
		StringBuffer contentstr = new StringBuffer();
		while ((s = br.readLine()) != null) {
			contentstr.append(s);
		}
		if (contentstr != null && contentstr.length() > 0) {
			LogInfoEntity entity = MonitorService.Getloginfo(req, contentstr.toString());
			status = RedisManager.Addloginfo(entity);
			// status= MongoManager.Addloginfo(entity);
		}
		System.out.println(status);
		out.println(status);
		out.close();
	}
}
