package yt.bean.bus.dao;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import yt.bean.bus.model.UserInfoDO;

import java.util.List;

/**
 * @author yunteng
 * 模拟数据库
 */
@Service
public class UserInfoMapper {

	public List<UserInfoDO> getAllUserInfo(int id) {
		List<UserInfoDO> userInfoDOS = Lists.newArrayList();

		if (id != 2) {
			UserInfoDO userInfoDO = new UserInfoDO();
			userInfoDO.setUserId(1);
			userInfoDO.setAge(20);
			userInfoDO.setPhone("13712342123");
			userInfoDO.setUserName("张三");
			userInfoDOS.add(userInfoDO);
		}
		if (id != 1) {
			UserInfoDO userInfoDO2 = new UserInfoDO();
			userInfoDO2.setUserId(2);
			userInfoDO2.setAge(25);
			userInfoDO2.setPhone("13643532345");
			userInfoDO2.setUserName("李四");
			userInfoDOS.add(userInfoDO2);
		}

		return userInfoDOS;
	}
}
