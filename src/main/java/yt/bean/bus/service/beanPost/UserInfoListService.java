package yt.bean.bus.service.beanPost;

import yt.bean.bus.model.UserInfoAO;
import yt.bean.bus.model.UserInfoVO;

import java.util.List;

/**
 * @author yunteng
 */
public interface UserInfoListService {

	int getId();

	List<UserInfoVO> list(UserInfoAO userInfoAO);
}
