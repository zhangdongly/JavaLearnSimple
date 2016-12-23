package org.zdlearn.java.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by wyzhangdong on 2016/12/23.
 */
public class ObjectClient {
    private String host;
    private int port;
    public ObjectClient(){}
    public ObjectClient(String host,int port){
        this.host=host;
        this.port=port;
    }
    public void run(){
        EventLoopGroup workGroup=new NioEventLoopGroup();
        Bootstrap clientBootstrap=new Bootstrap();
        try{
            clientBootstrap.group(workGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ObjectEncoder(),new ObjectDecoder(ClassResolvers.cacheDisabled(null)),new ObjectClientHandler());
                }
            });
            clientBootstrap.connect(host,port).sync().channel().closeFuture().sync();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String [] args){
        new ObjectClient("localhost",9500).run();;
    }
}
