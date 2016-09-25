package com.atguigu.Test;

public class PhoneTest {

	public static void main(String[] args) {
		final Phone phone = new Phone();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int id = 1; id <= 100; id++) {
					phone.getIos(id);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int id = 1; id <= 100; id++) {
					phone.getIos1(id);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int id = 1; id <= 100; id++) {
					phone.getIos2(id);
				}
			}
		}).start();
	}
}
