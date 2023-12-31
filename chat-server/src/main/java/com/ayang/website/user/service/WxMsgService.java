package com.ayang.website.user.service;

import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * @author shy
 * @date 2023/12/8
 * @description WXMsgService
 */
public interface WxMsgService {

    /**
     * 用户扫码成功
     */
    WxMpXmlOutMessage scan(WxMpService wxMpService, WxMpXmlMessage wxMpXmlMessage);

    /**
     * 用户授权
     */
    void authorize(WxOAuth2UserInfo userInfo);
}
