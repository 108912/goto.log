package com.log.main;

import com.log.common.LogInfoService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isrun = true;
		while (isrun) {
			try {

				int r = LogInfoService.QueueStorage();
				System.out.println(r);
				if (r != 0) {
					Thread.sleep(5000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(123);
	}

}
