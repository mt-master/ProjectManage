package com.liantong.gatewayclient.sys.util;

import io.netty.buffer.UnpooledByteBufAllocator;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
import java.io.UnsupportedEncodingException;
 
/**
 * Created by wanghongqi on 2019/5/11
 * ServerHttpResponse辅助类
 */
public class ServerHttpResponseUtil {
    /**
     * html输出
     * @param response
     * @param html
     * @return
     */
    public static Mono<Void> writeHtml(ServerHttpResponse response,String html){
        return response.writeWith(Flux.create(sink -> {
 
            NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(new UnpooledByteBufAllocator(false));
            try {
                DataBuffer dataBuffer= nettyDataBufferFactory.wrap(html.getBytes("utf8"));
                sink.next(dataBuffer);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sink.complete();
        }));
    }
}
