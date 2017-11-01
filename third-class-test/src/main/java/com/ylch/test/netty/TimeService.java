package com.ylch.test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yanglaichang1 on 2017/7/17.
 */
public class TimeService {

    public void bind(int port){
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());
            ChannelFuture f =
                    b.bind(port).sync();

            f.channel().closeFuture().sync();
        } catch (Exception e){

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

   class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

       AtomicInteger length = new AtomicInteger();

       @Override
       protected void initChannel(SocketChannel socketChannel) throws Exception {
           System.out.println(socketChannel);
           socketChannel.pipeline()
                   .addLast(new LineBasedFrameDecoder(1024))
                   .addLast(new StringDecoder())
                   .addLast(new ChannelHandlerAdapter(){
               @Override
               public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

                  /* ByteBuf buf = (ByteBuf) msg;
                   byte[] req = new byte[buf.readableBytes()];
                   buf.readBytes(req);
                   String body = new String(req, "UTF-8");*/

                   String body = (String) msg;

                   System.out.println(" service receive order :" + body + length.getAndIncrement());

                   String resp = "PING".equalsIgnoreCase(body.trim())?"PONG":"OTHER ORDER";

                   System.out.println("返回消息:"+ resp);

                   ByteBuf buf1 = Unpooled.copiedBuffer(resp.getBytes());

                   ctx.write(buf1);
               }

               @Override
               public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
                   //super.channelReadComplete(ctx);
                   ctx.flush();
               }

               @Override
               public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                   System.out.println("server 错误" + cause.getMessage());
                   ctx.close();
               }
           });
       }
   }

    public static void main(String[] args) {
        new TimeService().bind(911);
    }

}
