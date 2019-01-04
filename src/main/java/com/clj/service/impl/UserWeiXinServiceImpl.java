package com.clj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clj.dao.UserweixinMapper;
import com.clj.domain.Userweixin;
import com.clj.service.UserWeiXinService;

@Service
public class UserWeiXinServiceImpl implements UserWeiXinService{

	@Autowired
	private UserweixinMapper  userweixinMapper;
	@Override
	public void saveUserWeixinInfo(Userweixin weixin) {
		userweixinMapper.saveUserWeixinInfo(weixin);
	}
	@Override
	public Userweixin findUserWeixinInfoByopenId(String wxOpenId) {
		// TODO Auto-generated method stub
		return userweixinMapper.findUserWeixinInfoByopenId(wxOpenId);
		
		
	}
	/**
	 * 更新手机号
	 * @param weixin
	 */
	@Override
	public void updateUserWeixinInfo(Userweixin weixin) {
		userweixinMapper.updateUserWeixinInfo(weixin);
	}

}
