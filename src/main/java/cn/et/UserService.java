/**
 * 
 */
package cn.et;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Qixiaohao
 * @version 1.0
 * 
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserService {
	public static void main(String[] args) {
		SpringApplication.run(UserService.class, args);
	}
}
