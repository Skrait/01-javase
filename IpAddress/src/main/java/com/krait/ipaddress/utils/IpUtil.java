package com.krait.ipaddress.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Peekaboo
 * Date 2022/6/27 20:40
 * X-Forwarded-For：一个 HTTP 扩展头部，主要是为了让 Web 服务器获取访问用户的真实 IP 地址。每个 IP 地址，每个值通过逗号+空格分开，最左边是最原始客户端的 IP 地址，
 *  中间如果有多层代理，每⼀层代理会将连接它的客户端 IP 追加在 X-Forwarded-For 右边。
 * X-Real-IP：一般只记录真实发出请求的客户端IP
 * Proxy-Client-IP：这个一般是经过 Apache http 服务器的请求才会有，用 Apache http 做代理时一般会加上 Proxy-Client-IP 请求头
 * WL-Proxy-Client-IP：也是通过 Apache http 服务器，在 weblogic 插件加上的头。
 */
@Slf4j
public class IpUtil {

    public static String getIpAddr(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        String ipAddress = headers.getFirst("X-Forwarded-For");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = headers.getFirst("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = headers.getFirst("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddress().getAddress().getHostAddress();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                try {
                    InetAddress inet = InetAddress.getLocalHost();
                    ipAddress = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    log.error("根据网卡获取本机配置的IP异常", e);
                }

            }
        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP，多个IP按照','分割
        if (ipAddress != null && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.split(",")[0];
        }

        return ipAddress;
    }



}
