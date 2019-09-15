package learn.http.tech.qihaizhi;

public enum HttpStatusCode {

    HTTP_200(200,"200 OK","Request resource is sent successfully!"),

    ;
    private Integer code;
    private String statusCode;
    private String desc;

    HttpStatusCode(Integer code,String statusCode,String desc){
        this.code = code;
        this.statusCode = statusCode;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
