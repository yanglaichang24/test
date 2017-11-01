package com.ylch.test.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * Created by yanglaichang1 on 2017/7/18.
 */
public class TimeClient {

    public void connect(int port,String host) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new LineBasedFrameDecoder(1024))
                                    .addLast(new StringDecoder())
                                    .addLast(new ChannelHandlerAdapter(){

                                private final ByteBuf firstMessag;
                                {
                                    byte[] req = "PING".getBytes();
                                    ByteBuf buffer = Unpooled.buffer(req.length);
                                    firstMessag = buffer.writeBytes(req);
                                }

                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    //super.channelActive(ctx);
                                    for(int i = 0;i <=1000;i++){
                                        byte[] req = ("PING" + System.getProperty("line.separator")).getBytes();
                                        ByteBuf buffer = Unpooled.buffer(req.length);
                                        ctx.writeAndFlush(buffer.writeBytes(req));
                                    }
                                }


                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    //super.channelRead(ctx, msg);
                                    ByteBuf buf = (ByteBuf) msg;

                                    byte[] bytes = new byte[buf.readableBytes()];

                                    buf.readBytes(bytes);
                                    String s = new String(bytes, "UTF-8");
                                    System.out.println("client resp : "+ s);

                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                    //super.exceptionCaught(ctx, cause);
                                    System.out.println("错误:"+cause.getMessage());
                                     ctx.close();
                                }
                            });
                        }
                    });

            ChannelFuture sync = b.connect(host, port).sync();
            sync.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //new TimeClient().connect(911,"test01");
        new TimeClient().connect(911,"localhost");
    }

}
