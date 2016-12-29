package org.zdlearn.java.simple.zoa.provider;

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
 * <p>项目名称：ZOA</p>
 * <p>包名称：  org.zdlearn.java.simple.zoa.domain</p>
 * <p>类名称：  ZOAServer</p>
 * <p>类描述：  //类职责详细说明</p>
 * <p>创建人：  wyzhangdong</p>
 * <p>创建日期：2016/12/28 </p>
 * <p>修改人:</p>
 * <p>修改日期</p>
 * <p>修改备注</p>
 * <p>@version V1.0 </p>
 * <p>@author wyzhangdong</p>
 * <p>@see</p>
 */
public class ZOAServer {

    private String host;
    private int port;
    private Server server;
    public ZOAServer(){}
    public ZOAServer(String host,int port,Server server){
        this.port=port;
        this.host=host;
        this.server=server;
    }

    public void run(){
        EventLoopGroup bossGroup=new NioEventLoopGroup(1);
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        ServerBootstrap bootstrap= new ServerBootstrap();
        try{
            bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ObjectEncoder(),new ObjectDecoder(ClassResolvers.cacheDisabled(null)),new ZOAServerHandler(server));
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
        new ZOAServer("localhost",9500,null).run();
    }
}
