package cloud.simple.springsecurity.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xiangbingzhang
 * @date 2019-02-13
 **/
class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        AntPathMatcher pathMatcher = new AntPathMatcher();

        if (pathMatcher.match("/ss/**",((HttpServletRequest)request).getRequestURI())){
            Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest)request);

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);
        }

        filterChain.doFilter(request,response);
    }
}