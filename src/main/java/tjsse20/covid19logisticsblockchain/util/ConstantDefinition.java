package tjsse20.covid19logisticsblockchain.util;

public class ConstantDefinition {
    public static int REQUEST_OK = 200;
    public static int USER_NOT_EXIST = 202;
    public static int WRONG_PASSWD = 203;
    public static int USER_EXIST = 204;
    public static int USER_STATUS_AVAILABLE = 211;
    public static int USER_STATUS_UNDER_AUDIT = 212;
    public static int USER_STATUS_NOT_AVAILABLE = 213;
    public static int SYSTEM_EXCEPTION = 500;

    public static int RISK_SUBMIT_PENDING = 0;
    public static int RISK_SUBMIT_AUDITED = 1;
    public static int RISK_SUBMIT_REJECTED = -1;

    public static int RISK_TYPE_NO = 0;
    public static int RISK_TYPE_LOW = 1;
    public static int RISK_TYPE_HIGH = 2;

    public static int LOGISTICS_ONGOING = 1;
    public static int LOGISTICS_FINISHED = 2;

    public static int DEFAULT_AUDITOR = 8;

    public static int TRANS_TYPE_STATION = 0;
    public static int TRANS_TYPE_AIRPLANE = 1;
    public static int TRANS_TYPE_TRAIN = 2;
    public static int TRANS_TYPE_SHIP = 3;
    public static int TRANS_TYPE_TRUCK = 4;

    public static int RELATED_PERSON_TYPE_PERSON = 0;
    public static int RELATED_PERSON_TYPE_SHOP = 1;

}
