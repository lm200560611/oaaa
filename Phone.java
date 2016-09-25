package com.atguigu.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Phone {

	int number = 1;
	Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();

	public void getIos(int id) {
		lock.lock();

		try {

			while (number == 1) {
				for (int i = 1; i <= 5; i++) {

					System.out.println(Thread.currentThread().getName()
							+ " ----ios" + "---" + i + "当前第" + id + "轮");
				}
				number = 2;
				condition1.await();
				condition2.signal();
			}



		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void getIos1(int id) {
		lock.lock();

		try {

			while (number == 2) {
				for (int i = 1; i <= 10; i++) {

					System.out.println(Thread.currentThread().getName()
							+ " ----ios" + "---" + i + "当前第" + id + "轮");
				}

				number = 3;
				condition2.await();
				condition3.signal();
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void getIos2(int id) {
		lock.lock();

		try {

			while (number == 3) {
				for (int i = 1; i <= 15; i++) {

					System.out.println(Thread.currentThread().getName()
							+ " ----ios" + "---" + i + "当前第" + id + "轮");

				}
				number = 1;
				condition3.await();
				condition1.signal();
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
