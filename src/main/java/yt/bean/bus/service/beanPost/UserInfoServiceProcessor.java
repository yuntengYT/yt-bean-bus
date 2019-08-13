package yt.bean.bus.service.beanPost;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yunteng
 */
@Configuration
public class UserInfoServiceProcessor extends BaseBeanPostProcessor<UserInfoListService> {

	public static final Map<Integer, UserInfoListService> USER_INFO_LIST_SERVICE_MAP = new ConcurrentHashMap<>();

	@Override
	protected void after(UserInfoListService userInfoListService, String beanName) throws BeansException {
		USER_INFO_LIST_SERVICE_MAP.put(userInfoListService.getId(),userInfoListService);
	}

}
