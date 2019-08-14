package yt.bean.bus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yt.bean.bus.model.UserInfoAO;
import yt.bean.bus.model.UserInfoVO;
import yt.bean.bus.service.beanPost.UserInfoListService;
import yt.bean.bus.service.beanPost.UserInfoServiceProcessor;

import java.util.List;

/**
 * @author yunteng
 */
@RestController
@Slf4j
public class UserInfoController {

	@GetMapping("get-all-user-info")
	public List<UserInfoVO> getAllUserInfo(UserInfoAO userInfoAO){

		log.info("getAllUserInfo====userId:{}",userInfoAO.getId());
		UserInfoListService userInfoListService = UserInfoServiceProcessor.USER_INFO_LIST_SERVICE_MAP.get(userInfoAO.getId());
		return userInfoListService.list(userInfoAO);
	}
}
