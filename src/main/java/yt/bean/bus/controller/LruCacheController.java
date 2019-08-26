package yt.bean.bus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yt.bean.bus.service.lruService.LruCacheService;

/**
 * @author yunteng
 */
@RestController
@Slf4j
public class LruCacheController {
	@Autowired
	private LruCacheService lruCacheService;

	@GetMapping("get-lru-cache")
	public String getLruCache(String key) {

		log.info("getLruCache====key:{}", key);
		return lruCacheService.get(key);
	}

	@GetMapping("set-lru-cache")
	public void setLruCache(String key, String value) {

		log.info("setLruCache====key:{},value:{}", key, value);
		lruCacheService.set(key, value);
	}
}
