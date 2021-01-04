package demo.springboot.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LiuYingJie
 * @version 1.0
 * @date 2020/11/1
 **/
@Component
@WebFilter("/*")
public class SessionFilter implements Filter {
    private final static String NO_LOGIN = "您还未登录";
    private final static String[] includeUrls = new String[]{"/","/user/login","/user/register","/user/create"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if (session != null && session.getAttribute("user") != null) {
                filterChain.doFilter(request, response);
            } else {
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write(this.NO_LOGIN);
                } else {
                    //重定向到登录页(需要在static文件夹下建立此html文件)
                    response.sendRedirect(request.getContextPath() + "/");
                }
                return;
            }
        }
    }

    public boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(uri)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void destroy() {

    }
}
