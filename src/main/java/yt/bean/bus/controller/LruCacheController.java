package yt.bean.bus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yt.bean.bus.service.lruService.LruCacheService;

import javax.annotation.Resource;

/**
 * @author yunteng
 */
@RestController
@Slf4j
public class LruCacheController {
	@Autowired
	private LruCacheService lruCacheService;
	@Resource
	private ApplicationContext applicationContext;

	@GetMapping("get-lru-cache")
	public String getLruCache(String key) {

		log.info("getLruCache====key:{}", key);
		return lruCacheService.get(key);
	}

	@GetMapping("set-lru-cache")
	public Object setLruCache(String key, String value) {

		log.info("setLruCache====key:{},value:{}", key, value);
		return lruCacheService.set(key, value);
	}


	@GetMapping("get-lru-cache11")
	public String getLruCache1(String key) {
		LruCacheService aa = applicationContext.getBean(LruCacheService.class);
		log.info("getLruCache1====key:{}", key);
		return aa.get(key);
	}
}
