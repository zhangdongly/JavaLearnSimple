package org.zdlearn.java.simple.nettyrpc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.zdlearn.java.simple.nettyrpc.pojo.UserObjectDecoder;

/**
 * Created by wyzhangdong on 2016/12/8.
 */
public class Server {

    private int port;

    public Server(int port){
        this.port=port;
    }

    public Server(){
        this.port=9500;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).
                    handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new UserObjectDecoder());
                }
            }).option(ChannelOption.SO_BACKLOG, 128).
                    childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
            ChannelFuture f = bootstrap.bind(port).sync(); // (7)
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String [] args) throws  Exception{
         Server server=new Server(9500);
         server.run();
    }
}
