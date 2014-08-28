package cn.gyyx.hzh.memcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.yanf4j.util.ResourcesUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class memcached {
	private static MemcachedClient client;

	private static Object sysncObject = new Object();

	private static MemcachedClient getClient() {
		if (client == null) {
			synchronized (sysncObject) {
				if (client == null) {
					try {
						client = new XMemcachedClientBuilder(
								AddrUtil.getAddresses("192.168.6.224:11211"))
								.build();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return client;
	}

	public static <T> void setValue(String key, T info)
			throws TimeoutException, InterruptedException, MemcachedException {
		getClient().set(key, 0, info);
	}

	public static <T> T getValue(String key) throws TimeoutException,
			InterruptedException, MemcachedException {
		return getClient().get(key);
	}

}
