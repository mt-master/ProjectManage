package com.liantong.user;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermanageApplicationTests {

	@Test
	public void contextLoads() {
			// 用户名
			String username = "user";
			// 用户密码
			String password = "123456";
			// 加密方式
			String hashAlgorithName = "MD5";
			// 加密次数
			int hashIterations = 2;
			ByteSource credentialsSalt = ByteSource.Util.bytes(username);
			Object obj = new SimpleHash(hashAlgorithName, password,
					credentialsSalt, hashIterations);
			System.out.println(obj);
	}

}
