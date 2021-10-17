package dev.patika.homework05.config;

import ch.qos.logback.core.net.server.Client;
import dev.patika.homework05.utils.ClientRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ComponentScan
public class CustomInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    ClientRequestInfo clientRequestInfo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        clientRequestInfo.setClientIpAddress(request.getRemoteAddr());
        clientRequestInfo.setClientUrl(request.getRequestURI());
        clientRequestInfo.setSessionActivityId(request.getSession().getId());
        return true;
    }
}
