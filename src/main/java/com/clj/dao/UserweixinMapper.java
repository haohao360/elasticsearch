package com.clj.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.clj.domain.Userweixin;


@Mapper
public interface UserweixinMapper {

	@Options(useGeneratedKeys = true, keyProperty = "wxId")
	@Insert("INSERT INTO userweixin (wxOpenId,wxNickname,wxSex,wxProvince,wxCountry,wxHeadimgurl) VALUES (#{wxOpenId},#{wxNickname},#{wxSex},#{wxProvince},#{wxCountry},#{wxHeadimgurl})")
	void saveUserWeixinInfo(Userweixin weixin);

	@Select("SELECT * FROM userweixin WHERE wxOpenId=#{wxOpenId}")
	Userweixin findUserWeixinInfoByopenId(String wxOpenId);
	/**
	 * 更新手机号
	 * @param weixin
	 */
	@Update("UPDATE SET wxMobile=#{wxMobile} WHERE wxOpenId = #{wxOpenId}")
	void updateUserWeixinInfo(Userweixin weixin);
}
