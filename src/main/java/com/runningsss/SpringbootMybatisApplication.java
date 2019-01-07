package com.runningsss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author liqings
 * @date 2018-10-3
 */
@EnableCaching
@SpringBootApplication
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisApplication.class, args);
	}
}
