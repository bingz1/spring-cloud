package cloud.simple.springsecurity.security;

import cloud.simple.springsecurity.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author xiangbingzhang
 * @date 2019-01-13
 **/
public class DemoRememberMeService extends TokenBasedRememberMeServices {

    protected final String HEADER_SECURITY_TOKEN = "HEADER_SECURITY_TOKEN";

    public DemoRememberMeService(String key, UserDetailsService userDetailsService) {
        super(key, userDetailsService);
    }

    @Override
    protected String extractRememberMeCookie(HttpServletRequest request) {
        return StringUtils.isEmpty(request.getHeader(HEADER_SECURITY_TOKEN))
                ? request.getParameter(HEADER_SECURITY_TOKEN)
                : request.getHeader(HEADER_SECURITY_TOKEN);
    }

    @Override
    protected boolean isTokenExpired(long tokenExpiryTime) {
        return super.isTokenExpired(tokenExpiryTime);
    }

    @Override
    protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = encodeCookie(tokens);
        response.setHeader(HEADER_SECURITY_TOKEN, cookieValue);
    }

    @Override
    public void onLoginSuccess(HttpServletRequest request, HttpServletResponse response,
                               Authentication successfulAuthentication) {
        User user = (User) successfulAuthentication.getPrincipal();

        String username = user.getUsername();
        String password = user.getPassword();

        if (!org.springframework.util.StringUtils.hasLength(username)) {
            logger.debug("Unable to retrieve username");
            return;
        }

        int tokenLifetime = calculateLoginLifetime(request, successfulAuthentication);
        long expiryTime = System.currentTimeMillis();
        expiryTime += 1000L * (tokenLifetime < 0 ? TWO_WEEKS_S : tokenLifetime);

        String signatureValue = makeTokenSignature(expiryTime, username, password);

        setCookie(new String[]{username, Long.toString(expiryTime), signatureValue}, tokenLifetime, request, response);

        if (logger.isDebugEnabled()) {
            logger.debug("Added remember-me cookie for user '" + username + "', expiry: '"
                    + new Date(expiryTime) + "'");
        }
    }
}
