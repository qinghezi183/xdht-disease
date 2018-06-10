package com.xdht.disease.sys.constant;

/**
 * Created by L on 2018/6/10.
 */
public class SysEnum {

    public enum StatusEnum {

        STATUS_NORMAL("0", "正常"),
        STATUS_DELETE("1", "删除"),
        STATUS_DISCONTINNATION("2", "停用");

        private String code;
        private String msg;

        public String getCode() {
            return code;
        }
        public String getMsg() {
            return msg;
        }

        StatusEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static SysEnum.StatusEnum getInsuranceTypeByCode(String status) {
            status = status.trim();
            for (SysEnum.StatusEnum statusEnum : SysEnum.StatusEnum.values()) {
                if (status.equals(statusEnum.getCode())) {
                    return statusEnum;
                }
            }
            return null;
        }
    }
}
