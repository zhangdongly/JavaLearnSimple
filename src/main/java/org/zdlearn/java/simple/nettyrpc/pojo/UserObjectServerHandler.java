package org.zdlearn.java.simple.nettyrpc.pojo;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by wyzhangdong on 2016/12/9.
 */
public class UserObjectServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        ChannelFuture f = ctx.writeAndFlush(new UserObject());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
