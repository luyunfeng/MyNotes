package cn.lucode.java.$01_杂货;

/**
 * Created by lucode on 2017/7/21.
 */
public class 枚举 {
    public static void main(String[] args) {
        System.out.println(ReturnCodeModel.FAIL);
        System.out.println(ReturnCodeModel.getByCode("0009"));

    }

}
enum ReturnCodeModel {


    SUCCESS("9999", "成功"),
    FAIL("0000", "系统异常"),
    SYSTEM_IS_BUSY("0001", "系统忙"),
    PARAMETER_IS_MISSING("0002", "参数缺失！"),
    JSON_XML_PARSE_ERROR("0003", "格式解析错误"),
    SERVER_ERROR("0004", "服务错误,请联系我们"),
    NO_DATE("0005", "服务端没有数据"),
    PARAMETER_IS_WRONG("0006", "无效入参！"),
    UNAUTHORIZED("0007", "无效的认证"),
    RECORD_EXISTS("0008", "记录存在"),
    RECORD_OUT("0009", "记录超过限制");

    private String code;
    private String msg;
    // 构造方法
    private ReturnCodeModel(String code, String msg) {
        this.code=code;
        this.msg=msg;

    }
    private ReturnCodeModel() {}

    public static ReturnCodeModel getByCode(String code) {
        for (ReturnCodeModel param: ReturnCodeModel.values()) {
            if (param.getCode().equals(code)) {
                return param;
            }
        }
        return null;
    }
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
