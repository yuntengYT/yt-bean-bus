package yt.bean.bus.service;

import yt.bean.bus.model.UserInfoAO;
import yt.bean.bus.model.UserInfoVO;

import java.util.List;

/**
 * @author yunteng
 */
public interface IUserInfoService {

	List<UserInfoVO> getAllUserInfo(UserInfoAO userInfoAO);
}
