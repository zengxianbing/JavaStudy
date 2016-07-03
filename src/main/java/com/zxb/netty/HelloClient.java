package com.zxb.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2015/12/30.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class HelloClient {
    public void connect(String host, int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b=new Bootstrap();
            b.group(workerGroup);
            b.channel(NioServerSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {


                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HelloClientIntHandler());
                        }
                    });
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        HelloClient client=new HelloClient();
        client.connect("127.0.0.1",9203);
    }
}
