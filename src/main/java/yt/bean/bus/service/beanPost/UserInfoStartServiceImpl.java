package yt.bean.bus.service.beanPost;

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
public class UserInfoStartServiceImpl implements UserInfoListService{
	@Autowired
	private IUserInfoService userInfoService;
	@Override
	public int getId() {
		return 1;
	}

	@Override
	public List<UserInfoVO> list(UserInfoAO userInfoAO) {
		userInfoAO.setId(this.getId());
		return userInfoService.getAllUserInfo(userInfoAO);
	}
}
