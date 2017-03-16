package com.service.address.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import com.service.web.ResponseEntity;
import com.service.web.exception.BaseException;
import com.service.web.exception.InfoException;
import com.service.web.exception.ParameterException;
import com.service.web.util.JsonUtil;

//@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MessageSource messageSource;

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("initial filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse rep = (HttpServletResponse) response;

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            // // 杩囨护鎺変笉闇�瑕佺櫥褰曡姹傞�氳繃鐨勮矾寰�
            // boolean freeStyle = false;
            // boolean AdminUrLFlag = false;
            // boolean UserUrLFlag = false;
            // for (Pattern pattern : freeURIRegexPatternSet) {
            // Matcher matcher = pattern.matcher(req.getRequestURI());
            // if (matcher.find()) {
            // freeStyle = true;
            // }
            //
            // }
            // for (Pattern pattern : AdminURIRegexPatternSet) {
            // Matcher matcher = pattern.matcher(req.getRequestURI());
            // if (matcher.find()) {
            // AdminUrLFlag = true;
            // }
            //
            // }
            // for (Pattern pattern : UserURIRegexPatternSet) {
            // Matcher matcher = pattern.matcher(req.getRequestURI());
            // if (matcher.find()) {
            // UserUrLFlag = true;
            // }
            //
            // }
            // String accessToken = req.getHeader(ACCESS_TOKEN_HEADER);
            // if (!freeStyle) {
            //
            // String userId = "";
            // if (!StringUtils.isEmpty(accessToken)) {
            // String value = "";
            // if (AdminUrLFlag) {
            // value = c_MemberLoginRegistRemoteService.checkAdminLogin(accessToken);
            // }
            // if (UserUrLFlag && StringUtils.isEmpty(value)) {
            // value = c_MemberLoginRegistRemoteService.checkLogin(accessToken);
            // }
            // if (StringUtils.isEmpty(value)) {
            // throw new JbwException(JbwException.USER_LOST);
            // } else {
            // userId = value.split("_")[0];
            // }
            // } else {
            // throw new JbwException(JbwException.USER_LOST);
            // }
            // req.setAttribute("userId", userId);
            // }

            chain.doFilter(request, response);
        } catch (

        Exception e)

        {
            logger.error(e.getMessage(), e);
            Throwable cause = e.getCause() instanceof BaseException || e.getCause() instanceof ParameterException || e.getCause() instanceof InfoException
                    ? e.getCause() : e;
            writerError(response, ResponseEntity.getEntityError(cause, Locale.SIMPLIFIED_CHINESE, messageSource));
        }

    }

    @Override
    public void destroy() {
        logger.info(" filter destroy ......");

    }

    private void writerError(ServletResponse response, ResponseEntity entity) throws IOException {
        String result = JsonUtil.toJson(entity);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.flush();
    }
}
