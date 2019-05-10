package com.lucq.utils;

public enum CommonMsgEnum {
    // 默认返回
    SUCCESS("ERR_0000", "success"),//成功
    FAIL("ERR_0001", "fail"),//失败
    PARAMETERS_INVALID("ERR_0002", "request parameters is invalid"),//请求参数是无效的（不合法）
    EXCEPTION("ERR_0003", "an exception occurs in the code"),//代码中发生了异常
    PARAMETERS_MANDATORY("ERR_0004", "request parameters is mandatory"),//请求参数是强制性的
    SERVICE_UNAVAILABLE("ERR_0005", "service unavailable"),
    PARAM_INVALID("ERR_0002", "请求参数不合法"),// 参数不合法
    NO_FOUND_DATA("ERR_0006", "未发现数据"),
    OPERATE_FAIL("ERR_0007", "操作失败"),
    PINYIN_RESOLVE_FAIL("ERR_0008", "拼音解析失败"),
    PASSWORD_LENGTH_IS_NOT_ENOIGH("ERR_0009", "password length is not enough"),//密码长度不够
    USERNAME_OR_PASSWORD_ERROR("ERR_0010", "username or password is error"),//用户名或密码错误
    ACCOUNT_FORBIDDEN("ERR_0011", "账号已禁用，如有疑问请联系管理员"),
    SYNC_REPEAT_ERROR("ERR_0012", "防止重复同步"),
    ALREADY_SYNCHRONIZED_ERROR("ERR_0013", "任务已同步，请确认后重试"),
    SYNC_STUDENT_PACKAGE_ERROR("ERR_0014", "班级中有学生未同步课包关系，请确认同步后重试"),
    STUDENT_PACKAGE_ERROR("ERR_0015", "新增学生未同步课包关系，请确认同步后重试"),
    CLASS_TIME_OFF_ERROR("ERR_0016", "下课时间请排在下一节课上课时间之前"),
    CLASS_TIME_ON_ERROR("ERR_0017", "上课时间请排在上一节课的下课时间之后"),
    SYSTEM_BUSINESS_ERROR("ERR_0018", "系统繁忙，请稍后再试"),
    USERNAME_OR_PASSWORD_INVALID("ERR_0019", "username or password invalid"),//用户名或密码无效
    ACCOUNT_LOCKED("ERR_0020", "account already locked"),
    ACCOUNT_INVALID("ERR_0021", "account invalid"),
    ACCOUNT_EXISTS("ERR_0022", "account exists"),
    ACCOUNT_NO_EXISTS("ERR_0023", "account no exists"),
    ORIGINAL_PASSWORD_ERROR("ERR_0024", "original password error"),
    ORIGINAL_AND_NEW_PASSWORD_CANNOT_SAME("ERR_0025", "new password cannot be the same as the original password"),
    UNSUPPORTED_UPLOAD_TYPE("ERR_0026", "unsupported file upload type, invalid file content"),
    CLASS_NOT_EXITS("ERR_0027", "The class is not exists"),
    CLASS_FULL("ERR_0028", "The class is full"),
    EBLOCKS_CODE_EXISTS("ERR_0029", "The EBlocks code is exists"),
    ROLES_KEY_EXISTS("ERR_0030", "The roles key is exists"),
    ROLES_NAME_EXISTS("ERR_0031", "The roles name is exists"),
    STUDENTS_NUM_FULL_ERROR("ERR_0032", "The number of students is full"),
    REMEDIAL_NUM_ERROR("ERR_0033", "The times of remedial course is error"),
    CLASS_TIME_ERROR("ERR_0034", "Please for half an hour in advance reservation"),
    PARAMS_NULL("40000000", "参数不能为空"),
    PHONE_NUMBER_FORMAT_ERROR("40000001", "手机格式不正确"),
    MAIL_FORMAT_ERROR("40000002", "邮箱格式不正确"),
    PHONE_NUMBER_NULL("40000003", "手机号码不能为空"),
    ACCOUNT_DISPLAY_NAME_NULL("40000004", "用户名不能为空"),
    ACCOUNT_PASSWORD_NULL("40000005", "密码不能为空"),
    MAIL_NULL("40000006", "邮箱不能为空"),
    ORGANIZATION_NULL("40000007", "机构编号不能为空"),
    ORGANIZATION_DISPLAY_NAME_NULL("40000008", "机构名称不能为空"),
    ORGANIZATION_ADDRESS_NULL("40000009", "机构地址不能为空"),
    LATITUDE_NULL("40000010", "纬度不能为空"),
    LONGITUDE_NULL("40000011", "经度不能为空"),
    CODE_NULL("40000012", "中心编码不能为空"),
    CITY_ID_NULL("40000013", "城市编号不能为空"),
    PHONE_NUMBER_EXISTS("40000014", "此手机号码已注册"),
    ORGANIZATION_EXISTS("40000015", "该机构已注册"),
    ORGANIZATION_NOT_EXISTS("40000016", "该机构不存在"),
    ACCOUNT_ID_NULL("40000017", "账号编码不能为空"),
    ACCOUNT_NOT_EXISTS("40000018", "账号不存在，请确认后重试"),
    STUDENT_NAME_NULL("40000019", "学生昵称不能为空"),
    STUDENT_BIRTHDAY_NULL("40000020", "学生生日日期不能为空"),
    STUDENT_REALNAME_NULL("40000021", "学生真实名称不能为空"),
    STUDENT_IDCARD_NULL("40000022", "身份证号不能为空"),
    IDCARD_FORMAT_ERROR("40000023", "身份证校验无效"),
    ADD_STUDENT_ERROR("40000024", "添加学生信息失败"),
    ADD_PARENT_STUDENT_ERROR("40000025", "添加家长信息失败"),
    ADD_PARENT_STUDENT_RELATION_ERROR("40000026", "添加学生家长关联信息失败"),
    STUDENT_RELATION_NULL("40000027", "关系称谓不能为空"),
    ORGANIZATION_STUDENT_EXISTS("40000028", "家长在本机构下有同名的学员，是否继续创建？"),
    STUDENT_ID_NULL("40000029", "学生编号不能为空"),
    PARENT_STUDENT_ID_NULL("40000030", "家长编号不能为空"),
    COURSE_PLAN_ID_NULL("40000031", "排课编号不能为空"),
    COURSE_RELATION_ID_NULL("40000032", "学生课程关系编号不能为空"),
    ORG_CODE_EXISTS("40000033", "中心编码已存在，请重新输入"),
    STU_CLASS_ATTENDANCE_NULL("40000034", "学生班级出席编号不能为空"),
    PASSWORD_FORMAT_ERROR("40000035", "必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间"),
    READ_EXCEL_ERROR("40000036", "读取excel文件流异常"),
    ORG_TYPE_NULL("40000037", "机构类型不能为空"),
    ORG_AREA_NULL("40000038", "所属区域不能为空"),
    ACCOUNT_TYPE_NULL("40000039", "账号类型不能为空"),
    ACCOUNT_STATE_NULL("40000040", "账号状态不能为空"),
    COURSE_PACKAGE_ID_NULL("40000041", "课程包编号不能为空"),
    DISPLAY_ORDER_NULL("40000042", "课程包顺序不能为空"),
    CLASS_HOUR_TOTAL_NULL("40000043", "总课时数不能为空"),
    COURSE_PACKAGE_EXISTS("40000044", "课程包已存在"),
    OLD_PASSWORD_ERROR("40000045", "密码错误"),
    COURSE_NAME_ALREADY_EXIST("40000046", "The course name can not be the same "),//课程名称不能相同
    COURSE_PACKAGE_NAME_ALREADY_EXIST("40000047", "The course name can not be the same "),//课程名称不能相同
    COURSE_PLAN_NOT_EXISTS("40000048", "排课计划不存在"),
    COURSE_CAN_NOT_BE_DELETED_AFTER_BEING_USED("40000049", "courses can not be deleted after being used."),
    COURSE_PACKAGE_CAN_NOT_BE_DELETED_AFTER_BEING_USED("40000050", "courses package can not be deleted after being used."),
    CLASS_NO_OPEN("40000051", "班级处于未开班状态，不能进行排课"),
    CLASS_NO_ENABLE("40000052", "班级未启用，不能进行排课"),
    WECHAT_WEB_AUTHORIZATION_FAILED("40000053", "weChat web authorization failed"),
    VERITY_THAT_AUTHORIZATION_DOCUMENT_TOKEN_IS_INVALID("40000053", "校验授权凭证access_token无效"),
    PLEASE_BIND_CELL_PHONE_NUMBER("40000054", "Please bind cell phone number."),
    ACCOUNT_OR_PASSWORD_ERROR("40000055", "用户名或者密码错误"),
    ACCOUNT_LOCKED_ERROR("40000056", "账号已锁定"),
    TOO_MANY_TIMES_TO_GET_SMS_CAPTCHA("40000057", "获取短信验证码次数太多"),
    SEND_SMS_MSG_FAIL("40000058", "发送短信失败"),
    CHECK_VERIFICATION_CODE_FAILED("40000059", "匹配验证码失败"),
    VERIFICATION_CODE_ERROR("40000060", "验证码错误"),
    VERIFICATION_CODE_BE_OVERDUE("40000061", "验证码过期"),
    SEND_PLAN_MSG_ERROR("40000062", "推送排课通知失败"),
    STUDENT_CLASS_RELATION_EXISTS("40000063", "学生已经关联班级，不能停用"),
    OPEN_ID_STUDENT_NOT_RELATION("40000064", "未找到关联信息，如有疑问，请联系客服"),
    CANCEL_PLAN_TIME_ERROR("40000065", "取消排课日期有误，请确认后再试"),
    ACCOUNT_NAME_EXISTS("40000066", "用户名已使用"),
    COURSE_CAN_NOT_BE_UPDATE_AFTER_BEING_USED("40000067", "courses can not be update after being used."),
    COURSE_PACKAGE_CAN_NOT_BE_UPDATE_AFTER_BEING_USED("40000068", "courses package can not be update after being used."),
    PLEASE_ADD_STUDENTS("40000069", "please add students ,class size can not be 0"),
    SCHOOL_CLASS_WEEKLY_PLAN_IS_MANDATORY("40000070", "school class weekly plan request parameters is mandatory "),
    COURSE_PACKAGE_AFTER_BEING_USED("40000071", "courses package after being used."),
    DATA_OPTION_VALUE_NO_EXIST("40000072","data option value no exist"),
    SYSTEM_PARAMETER_NAME_ALREADY_EXIST("40000074","系统参数名称已经存在"),
    PREREGISTRATION_ALREADY_EXIST("40000075","预报名机构名单已经存在"),
    CARD_COUPON_NO_EXISTENCE("40000076","卡券号不存在"),
    CARD_COUPON_EXPIRED("40000077","卡券已经过期"),
    CARD_COUPON_ALREADY_USED("40000077","卡券已经使用"),
    CARD_COUPON_INVALID("40000078","卡券无效"),
    CARD_COUPON_TOTAL_NUMBER_NOT_ENOUGH("40000079","卡券总数量不足,请重新设置数量"),
    ORGANIZATION_CARD_COUPON_NUMBER_NOT_ENOUGH("40000080","该机构下的卡券数量不足"),
    USER_NEED_FOLLOW_WE_CHAT("40000080","用户需要去关注公众号"),
    INFORMATION_MISMATCH("40000081","机构信息不匹配"),
    WE_CHAT_OPEN_ID_NO_EXIST("40000082","微信openid不存在"),
    PHONE_NUMBER_UNLIKENESS("40000083","手机号码不一致"),
    QUESTIONNAIRE_FEED_BACK_IS_EXIST("40000084","调查问卷已经存在"),
    STUDENT_CAN_NOT_DELETE("40000085","不能够删除学员"),
    COURSE_EVALUATION_IS_EXIST("40000086","课程评价已经存在"),;

    private String returnCode;
    private String returnMsg;

    private CommonMsgEnum(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public String getReturnMsg() {
        return this.returnMsg;
    }

    public static CommonMsgEnum getEnum(String returnCode) {
        CommonMsgEnum[] arr = values();
        for (CommonMsgEnum tmp : arr) {
            if (returnCode == tmp.getReturnCode()) {
                return tmp;
            }
        }
        return SUCCESS;
    }
}