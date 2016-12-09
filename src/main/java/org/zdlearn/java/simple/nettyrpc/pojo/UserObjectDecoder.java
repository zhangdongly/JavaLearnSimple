package org.zdlearn.java.simple.nettyrpc.pojo;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by wyzhangdong on 2016/12/9.
 */
public class UserObjectDecoder extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);
        ctx.close();
    }

}
