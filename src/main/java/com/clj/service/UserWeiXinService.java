package com.clj.service;

import com.clj.domain.Userweixin;


public interface UserWeiXinService {

	void saveUserWeixinInfo(Userweixin weixin);

	Userweixin findUserWeixinInfoByopenId(String openId);
	/**
	 * 更新手机号
	 * @param weixin
	 */
	void updateUserWeixinInfo(Userweixin weixin);
}
