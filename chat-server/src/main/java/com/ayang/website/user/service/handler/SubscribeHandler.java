package com.ayang.website.user.service.handler;

import com.ayang.website.user.service.WxMsgService;
import com.ayang.website.user.service.adapter.TextBuilder;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author shy
 * @date 2023/12/5
 * @description
 */
@Component
@AllArgsConstructor
public class SubscribeHandler extends AbstractHandler {

    private final WxMsgService wxMsgService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wsxService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());
        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = wxMsgService.scan(wsxService, wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }
        return TextBuilder.build("感谢关注", wxMessage);
    }


}
