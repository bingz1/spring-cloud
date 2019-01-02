package cloud.simple.cloudzuul.filter;

/**
 * @author qian
 */
public class ZuulConstant {

    public static ThreadLocal<ActionLogDto> ACTION_LOG_CONTEXT = new ThreadLocal<ActionLogDto>();

    public static final String UNKNOWN = "unknown";
    public static final String GET = "GET";
    public static final String POST = "POST";
}
