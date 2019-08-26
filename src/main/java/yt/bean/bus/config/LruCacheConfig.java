package yt.bean.bus.config;

import org.apache.commons.collections.map.LRUMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yunteng
 */
@Configuration
public class LruCacheConfig {

	@Bean
	public LRUMap lruMapService(){
		return new LRUMap();
	}
}
