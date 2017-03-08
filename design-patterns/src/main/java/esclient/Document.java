package esclient;

import java.io.Serializable;

/**
 * Created by yanglaichang1 on 2017/2/24.
 */
@com.jd.ql.monitor.esclient.annotations.Document()
public class Document implements Serializable{

    Document(){}

    Document(String previous_site_send_user_code,Integer waybill_flag){
        this.previous_site_send_user_code = previous_site_send_user_code;
        this.waybill_flag = waybill_flag;
    }

    private String previous_site_send_user_code;
    private Integer waybill_flag;

    public String getPrevious_site_send_user_code() {
        return previous_site_send_user_code;
    }

    public void setPrevious_site_send_user_code(String previous_site_send_user_code) {
        this.previous_site_send_user_code = previous_site_send_user_code;
    }

    public Integer getWaybill_flag() {
        return waybill_flag;
    }

    public void setWaybill_flag(Integer waybill_flag) {
        this.waybill_flag = waybill_flag;
    }
}
