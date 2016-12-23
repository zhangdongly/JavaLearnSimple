package org.zdlearn.java.simple;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.zdlearn.java.simple.nettyrpc.pojo.UserObject;

/**
 * Created by wyzhangdong on 2016/12/23.
 */
public class ObjectServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        System.out.println("server receive msg:"+msg);

       UserObject user = new UserObject();
        user.setName("ZD");
        user.setAge(110);
        System.out.println("server write msg:"+user);
        ctx.writeAndFlush(user);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
