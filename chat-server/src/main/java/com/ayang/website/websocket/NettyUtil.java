package com.ayang.website.websocket;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

/**
 * @description: Netty工具类
 * @author: <a href="https://github.com/shy0002“>ayang</a>
 * @date: 2023/12/18
 **/

public class NettyUtil {
    public static AttributeKey<String> TOKEN = AttributeKey.valueOf("token");

    public static <T> void setAttr(Channel channel, AttributeKey<T> key, T value) {
        Attribute<T> attr = channel.attr(key);
        attr.set(value);
    }

    public static <T> T getAttr(Channel channel, AttributeKey<T> key) {
        Attribute<T> attr = channel.attr(key);
        return attr.get();
    }
}