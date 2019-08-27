package yt.bean.bus.service.lruService;

import org.apache.commons.collections.map.LRUMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunteng
 */
@Service
public class LruCacheService {

	@Autowired
	private LRUMap lruMap;

	public Object set (String key,String value) {
		return lruMap.put(key, value);
	}

	public String get (String key) {
		return (String)lruMap.getOrDefault(key,"defaultValue");
	}
}
