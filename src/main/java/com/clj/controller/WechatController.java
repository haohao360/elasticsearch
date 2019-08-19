package com.clj.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clj.domain.Userweixin;
import com.clj.service.UserWeiXinService;
import com.clj.webchart.config.WechatAccountConfig;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {
	private static Logger log = LoggerFactory.getLogger(WechatController.class);
	@Autowired
	private WxMpService wxMpService;

	@Autowired
	private WechatAccountConfig wechatAccountConfig;

	@Autowired
	private UserWeiXinService userWeiXinService;

	@RequestMapping("/authorize")
	public String authorize() {
		/*
		 * String url =
		 * wechatAccountConfig.getWechatOpenAuthorize()+"/wechat/userInfo";
		 * String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url,
		 *  WxConsts.OAuth2Scope.SNSAPI_USERINFO, "1125");
		 * log.info("【微信网页授权】获取code,redirectURL={}", redirectURL);
		 */
		// return "redirect:" + redirectURL;
		int state = (int) ((Math.random() * 9 + 1) * 1000);// 随机四位数
		String returnUrl = "http://m.123.com/get-weixin-code.htm?appid=wx22185f3fa7824bbf6&scope=snsapi_userinfo&state="
		+ state
		+ "&redirect_uri=http://www.123.com/wechat/userInfo";
		//m.123.com    f.123.com
/*String returnUrl = "http://m.123.com/get-weixin-code.htm?appid=wx5285f2fa7824bbf7&scope=snsapi_userinfo&state="
		+ state
		+ "&redirect_uri=http://f.123.com/wechat/userInfo";*/
		return "redirect:" + returnUrl;
	}

	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request,
			@RequestParam("code") String code,
			@RequestParam("state") String returnUrl) throws Exception {
		log.info("【微信网页授权】code={}", code);
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
		
		try {
			wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
		} catch (WxErrorException e) {
			log.info("【微信网页授权】{}", e);
			throw new Exception(e.getError().getErrorMsg());
		}
		String openId = wxMpOAuth2AccessToken.getOpenId();
		log.info("【微信网页授权】openId={}", openId);
		
		// return "redirect:" + returnUrl + "?openid=" + openId;
		Userweixin weixin = null;
		weixin = userWeiXinService.findUserWeixinInfoByopenId(openId);
		if (weixin != null) {
			request.getSession().setAttribute("Userweixin", weixin);
			return "index";
		}
		log.info("【微信网页授权】Token={}", wxMpOAuth2AccessToken);
		WxMpUser mpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken,"zh_CN");
		weixin = new Userweixin();
		weixin.setWxOpenId(openId);
		String nickName = filterEmoji(mpUser.getNickname());
		weixin.setWxNickname(nickName);
		weixin.setWxSex(mpUser.getSex());
		weixin.setWxProvince(mpUser.getProvince());
		weixin.setWxCity(mpUser.getCity());
		weixin.setWxCountry(mpUser.getCountry());
		weixin.setWxHeadimgurl(mpUser.getHeadImgUrl());
		userWeiXinService.saveUserWeixinInfo(weixin);
		request.getSession().setAttribute("Userweixin", weixin);
		return "index";
	}
	
	public String filterEmoji(String source) {

		if (!containsEmoji(source)) {
			return source;// 如果不包含，直接返回
		}
		// 到这里铁定包含
		StringBuilder buf = null;

		int len = source.length();

		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);

			if (isEmojiCharacter(codePoint)) {
				if (buf == null) {
					buf = new StringBuilder(source.length());
				}

				buf.append(codePoint);
			} else {
			}
		}

		if (buf == null) {
			return source;// 如果没有找到 emoji表情，则返回源字符串
		} else {
			if (buf.length() == len) {// 这里的意义在于尽可能少的toString，因为会重新生成字符串
				buf = null;
				return source;
			} else {
				return buf.toString();
			}
		}

	}

	public boolean containsEmoji(String source) {
		if (source == null) {
			return false;
		}

		int len = source.length();

		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);

			if (isEmojiCharacter(codePoint)) {
				// do nothing，判断到了这里表明，确认有表情字符
				return true;
			}
		}

		return false;
	}

	private boolean isEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
				|| (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
				|| ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}

}
