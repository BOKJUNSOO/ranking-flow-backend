package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class IPCheckFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        log.debug("filter begin");
        HttpServletRequest req = (HttpServletRequest) request;
        String ip = request.getRemoteAddr();
        log.debug("ip : " + ip);
        chain.doFilter(req, response);
        log.debug("filter end");
    }
}
