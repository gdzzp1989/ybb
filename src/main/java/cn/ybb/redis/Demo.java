package cn.ybb.redis;

import redis.clients.jedis.Jedis;

public class Demo {

	private static final String lockKey = "Lock.TecentIm_Interface_Counter";

	public static void main(String[] args) {

		Jedis jedis = new Jedis("127.0.0.1", 6379);

		DistributedLockHandler distributedLockHandler = new DistributedLockHandler().setJedis(jedis);
		try {
			boolean getLock = distributedLockHandler.tryLock(lockKey, Long.valueOf(5));

			if (getLock) {
				// Do your job
				System.out.println("Do your job........");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			distributedLockHandler.realseLock(lockKey);
		}

	}
}
