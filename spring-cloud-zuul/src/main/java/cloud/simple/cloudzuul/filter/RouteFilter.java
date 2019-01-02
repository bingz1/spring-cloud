package cloud.simple.cloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author xiangbingzhang
 * @data 2018-11-26
 **/
@Component
public class RouteFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //记录入参日志
        ActionLogDto actionLogDto = new ActionLogDto();
        actionLogDto.setStartTime(new Date());
        actionLogDto.setMethod(request.getMethod());
        StringBuilder url = new StringBuilder();
        url.append(request.getScheme()).append("://");
        url.append(request.getHeader("Host"));
        url.append(request.getRequestURI());
        actionLogDto.setUrl(url.toString());
        ZuulConstant.ACTION_LOG_CONTEXT.set(actionLogDto);
        System.out.println("route");
        return null;
    }
}
