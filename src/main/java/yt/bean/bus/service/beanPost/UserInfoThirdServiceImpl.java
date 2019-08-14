package yt.bean.bus.service.beanPost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yt.bean.bus.model.UserInfoAO;
import yt.bean.bus.model.UserInfoVO;
import yt.bean.bus.service.IUserInfoService;

import java.util.List;

/**
 * @author yunteng
 */
@Service
@Slf4j
public class UserInfoThirdServiceImpl implements UserInfoListService{
	@Autowired
	private IUserInfoService userInfoService;
	@Override
	public int getId() {
		return 3;
	}

	@Override
	public List<UserInfoVO> list(UserInfoAO userInfoAO) {
		log.info("userInfoList=====userId:{}",userInfoAO.getId());
		userInfoAO.setId(this.getId());
		return userInfoService.getAllUserInfo(userInfoAO);
	}
}
