package cloud.simple.cloudzuul.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author qian
 */
@Setter
@Getter
public class ActionLogDto {

    private Date startTime;

    private Date endTime;

    private long costTime;

    /**
     * 请求的host
     */
    private String requestHost;

    /**
     * 请求的port
     */
    private String requestPort;

    private String url;

    private String params;

    private String method;

    private String responseMsg;

    private String statusCode;

    private String exception;

    private String uri;

    private String anchor;

    private String decodeMsg;


    public static String getInfo(String responseBody) {
        ActionLogDto actionLogDto = ZuulConstant.ACTION_LOG_CONTEXT.get();
        actionLogDto.setEndTime(new Date());
        actionLogDto.setCostTime(actionLogDto.getEndTime().getTime() - actionLogDto.getStartTime().getTime());
        actionLogDto.setResponseMsg(responseBody);
        String logInfo = "URL=" + actionLogDto.getUrl()
                + " METHOD=" + actionLogDto.getMethod() + " DECODEMSG=" + actionLogDto.getDecodeMsg() + " RESPONSE=" + actionLogDto.getResponseMsg()
                + " COST=" + actionLogDto.getCostTime();
        return logInfo;
    }

}
