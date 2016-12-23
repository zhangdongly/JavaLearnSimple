package org.zdlearn.java.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by wyzhangdong on 2016/12/23.
 */
public class ObjectServer {
    private String host;
    private int port;
    public ObjectServer(){}
    public ObjectServer(String host,int port){
        this.port=port;
        this.host=host;
    }

    public void run(){
        EventLoopGroup bossGroup=new NioEventLoopGroup(1);
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        ServerBootstrap bootstrap= new ServerBootstrap();
        try{
            bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                       socketChannel.pipeline().addLast(new ObjectEncoder(),new ObjectDecoder(ClassResolvers.cacheDisabled(null)),new ObjectServerHandler());
                }
            });
            bootstrap.bind(port).sync().channel().closeFuture().sync() ;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String [] args){
        new ObjectServer("localhost",9500).run();
    }



}
