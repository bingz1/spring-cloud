package cloud.simple.docker.entiyt;

import java.util.Date;

/**
 * Created by zxb on 7/8/16.
 */
public class Visitor {
    String id;
    String ip;
    Date visitDate;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
