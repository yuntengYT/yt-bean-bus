package yt.bean.bus.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yt.bean.bus.dao.UserInfoMapper;
import yt.bean.bus.model.UserInfoAO;
import yt.bean.bus.model.UserInfoDO;
import yt.bean.bus.model.UserInfoVO;
import yt.bean.bus.service.IUserInfoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunteng
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public List<UserInfoVO> getAllUserInfo(UserInfoAO userInfoAO) {

		List<UserInfoDO> list = userInfoMapper.getAllUserInfo(userInfoAO.getId());
		if(CollectionUtils.isEmpty(list)) {
			return new ArrayList<>();
		}
		List<UserInfoVO> retList = new ArrayList<>();
		list.forEach(userInfoDO -> {
			UserInfoVO userInfoVO = new UserInfoVO();
			BeanUtils.copyProperties(userInfoDO,userInfoVO);
			retList.add(userInfoVO);
		});
		return retList;
	}
}
