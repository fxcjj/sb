package com.vic.sb01.vo;

import java.util.Arrays;

/**
 * 消息返回码
 *
 * <pre>
 * 枚举命名以小模块名打头（如：核心-APP模块使用：CORE_APP_XXXXX）放在一起
 * 编码（6位）：
 *     a、第一位是S【成功】、F【失败】、E【异常】，
 *     b、第二位是大模块标志0-5（
 *               0：系统公共
 *              1：基础模块【XAPP-BASE】
 *              2：共通模块【XAPP-COMN】
 *              3：核心模块【XAPP-CORE】
 *              4：网关模块【XAPP-GATE】
 *              5：借贷模块【XAPP-LOAN】
 *              6：商城模块【XAPP-MALL】
 *       ）
 *     c、第三位是大模块下的小模块标志,按大模块下小模块的排序定，16进制
 *     d、后三位有1000个码，供自己的小模块定义
 *
 * 当前业务子模块编码定义：
 *    31   core-app
 *    32   core-call
 *    33   core-org
 *    34   core-pay
 *    35   core-sms
 *    36   core-sys
 *    37   core-user
 *    39   core-credit
 *
 *    41   gate-application
 *    42   gate-merchant
 *    43   gate-system
 *
 *    51   loan-after
 *    52   loan-audit
 *    53   loan-canal
 *    54   loan-credit
 *    55   loan-data
 *    56   loan-debt
 *    57   loan-pay
 *    58   loan-settle
 *    59   loan-telesale
 *    60   loan-channel
 *
 *
 * 【示例】:
 *      F31000：核心APP的某个错误码
 *  <pre/>
 *
 * @author: 兰祥建
 * date: 2020/1/3 10:55
 */
public enum RestMsg implements CodeEnum {

    // 公共消息X0开头
    SUCCESS("S00000", "成功"),
    ERROR("E00000", "异常"),
    FAIL("F00000", "失败"),
    NOT_LOGIN("F00001", "未登录"),
    LOGIN_FAIL("F00002", "登录失败"),
    NOT_AUTH("F00003", "访问受限"),
    PARAM_ERROR("F00004", "参数错误"),
    PARAM_NULL("F00005", "参数为空"),
    DATA_IS_EXIST("F00007", "数据已存在"),
    DATA_NOT_FOUND("F00008", "没有找到记录"),
    SAVE_FAIL("F00009", "保存失败"),
    MODIFY_FAIL("F00010", "修改失败"),
    CREATE_FAIL("F00011", "创建失败"),
    DELETE_FAIL("F00012", "删除失败"),
    INVALID_DATA("F00013", "无效数据"),
    ALREADY_EXPIRATION("F00014", "已经过期"),
    NOT_PARAM("F00015", "缺少参数"),
    CHECK_CONFIG("F00016", "请检查配置"),
    TOO_MANY_REQUESTS("F00017", "请求太多"),
    FOREIGN_KEY_EXISTS("F00018", "数据存在外键关联，禁止执行当前操作"),
    FUNCTION_NOT_REALIZE("F00019", "功能未实现"),
    INVOKING_INTERFACE_ERROR("F00020", "系统模块间调用接口异常"),
    VALIDATE_ERROR("F00021", "数据验证失败"),
    NONE_SERVICE("F00022", "service不存在"),
    MULTI_SERVICE("F00023", "查找到多个service"),
    AUTH_INFO_ERROR("F00024", "鉴权中心返回失败"),
    PART_FAIL("F00025", "部分操作失败"),
    EXPORT_CONDITION_MUST_LEAST_ONE("F00026", "请输入导出条件"),
    TOO_MANY_ATTEMPTS("F00027", "请求次数过多"),
    TOO_MANY_ATTEMPTS_24H("F00028", "请求次数过多，请等待24小时"),
    DATE_RANGE_INVALID_45D("F00029", "请求时间范围无效，开始结束日期最多间隔45日"),


    // 基础模块消息X1开头
    BASE_EXAMPLE_SYSTEM_IMAGE_FORMAT_ERROR("F10011", "图片格式错误，仅支持jpg/png"),
    BASE_EXAMPLE_SYSTEM_SYSTEM_IMAGE_SIZE_5M("F10012", "图片大小不能超过5M"),
    BASE_EXAMPLE_SYSTEM_IMAGE_UPLOAD_FAIL("F10013", "图片上传失败"),
    BASE_EXAMPLE_SYSTEM_SUPPLIER_NOT_FAIL("F10014", "该账号不是供应商账号，不能添加"),
    BASE_EXAMPLE_SYSTEM_SYSTEM_IMAGE_SIZE_10M("F10015", "图片大小不能超过10M"),
    BASE_EXAMPLE_SYSTEM_EXCEL_FORMAT_ERROR("F10016", "文件格式错误，仅支持xlsx/xls"),
    BASE_EXAMPLE_SYSTEM_MERCHANT_CODE_EXIST("F10017", "商户编码已存在"),
    BASE_EXAMPLE_SYSTEM_CONTRACT_SIZE_10M("F10018", "合同模板大小不能超过10M"),
    BASE_EXAMPLE_SYSTEM_CONTRACT_UPLOAD_FAIL("F10019", "合同模板文件上传失败"),
    BASE_EXAMPLE_SYSTEM_CONTRACT_FORMAT_ERROR("F10020", "合同模板格式错误，仅支持ftl/pdf"),

    // 共通模块消息X2开头
    SUCCESS_WITH_DONOTHING("S20001", "成功(无需处理)"),

    // 核心模块消息X31开头
    CORE_EXAMPLE_FAIL("F31000", "核心支付模块调用失败"),
    CORE_APP_COUNTRY_NOT_EXIST("F31001", "国家信息不存在"),

    // 审核模块消息X32开头
    AUDIT_RELATION_COUNT_FAIL("F32000", "删除审核规则时，存在产品关联数据，请先删除关联数据"),
    AUDIT_DEBT_DATA_NULL("F32001", "审核模块，获取工单数据为空"),
    AUDIT_CREDIT_INFO_DATA_NULL("F32002", "审核模块，获取工单获取授信单无数据"),
    AUDIT_REJECT_DATA_FAIL("F32003", "保存或者更新授信被拒记录失败"),
    AUDIT_DEBT_STATUS_FAIL("F32004", "前置审核，工单状态不正确"),
    AUDIT_USER_STATUS_FAIL("F32005", "前置审核，获取用户信息为空"),
    AUDIT_CREDIT_DATA_NULL("F32006", "授信单不存在"),
    AUDIT_USER_DATA_NULL("F32007", "借款人不存在"),
    AUDIT_BJSH_CALLBACK_ERROR("F32008", "北京审核回调接口异常"),
    AUDIT_AUTH_CREDIT_DATA_NULL("F32009", "审核模块授信授权数据查询，入参为空"),
    AUDIT_AUTH_CREDIT_PUSH_DATA_NULL("F32010", "审核模块授信授权数据查询，获取推送数据不存在"),
    AUDIT_AUTH_RECORD_DATA_NULL("F32011", "审核模块授信授权数据查询，获取认证记录数据异常"),
    AUDIT_EXIST_PROCESS_CREDIT("F32012", "用户存在正在进行中的授信单信息"),
    AUDIT_CREDIT_STATUS_EXISTS_0_8_DATA("F32013", "用户存在草稿或者撤回授信单"),
    AUDIT_EXIST_REJECT_BLACKLIST("F32014", "存在被拒授信单或在黑名单中"),
    AUDIT_ERROR("F32015", "审核模块系统异常"),
    AUDIT_CLOUD_ERROR("F32016", "审核模块，审核前置异常"),
    AUDIT_AUTH_RECORD_DATA_NOT_EXIST("F32017", "获取认证记录数据不存在"),
    AUDIT_PRODUCT_LINK_DATA_EXIST("F32018", "审核规则关联产品信息，维护规则已存在"),
    AUDIT_CREDIT_DEBT_LINK_NOT_EXIST("F32019", "工单关联授信单信息不存在"),
    AUDIT_CREDIT_MANPOWER_ALLOT_SAVE_ERROR("F32020", "授信单保存人工审核分配人员信息失败"),
    AUDIT_ERROR_FAIL("F32021", "审核异常"),
    AUDIT_USER_INTERFACE_ERROR("F32022", "审核模块调用接口人接口异常"),
    AUDIT_SAVE_CREDIT_DATA_ERROR("F32023", "审核模块保存授信单数据异常"),
    AUDIT_CREDIT_CRAWLER_DATA_ERROR("F32024", "借款人爬虫数据已存在"),
    AUDIT_CREDIT_CREDIT_AMOUNT_ERROR("F32025", "授信额度小于产品设定最小值或大于产品设定最大值"),
    AUDIT_CRAWLWE_PATH_NULL("F32026", "爬取数据上传路径为空"),

    //org  F33开头
    CORE_ORG_MERANT_LOGIN_FAIL("F33001", "商户不存在或被冻结"),

    //支付模块  F34开头---------------
    //校验异常  F340开头
    CORE_PAY_REQ_CHECK_USER_ID("F34000", "用户id不能为空"),
    CORE_PAY_REQ_CHECK_USER_ID_CARD("F34002", "用户身份证号不能为空"),
    CORE_PAY_REQ_CHECK_USER_CARD_NAME("F34003", "持卡人姓名不能为空"),
    CORE_PAY_REQ_CHECK_CARD_ID("F34004", "银行卡id不能为空"),
    CORE_PAY_REQ_CHECK_USER_CARD_PHONE("F34005", "银行卡绑定手机号不能为空"),
    CORE_PAY_REQ_CHECK_USER_CARD_NO("F34006", "银行卡号不能为空"),
    CORE_PAY_REQ_CHECK_CARD_VALID_DATE("F34007", "信用卡有效期不能为空"),
    CORE_PAY_REQ_CHECK_CARD_VALID_NO("F34008", "信用卡安全码不能为空"),
    CORE_PAY_REQ_CHECK_ORDER_NO("F34009", "订单号不能为空"),
    CORE_PAY_REQ_CHECK_AMOUNT("F34010", "支付金额不能为空"),
    CORE_PAY_REQ_CHECK_AMOUNT2("F34011", "支付金额需大于0"),
    CORE_PAY_REQ_CHECK_PRE_UNIQUE_CODE("F34012", "预签约唯一码不能为空"),
    CORE_PAY_REQ_CHECK_SMS_CODE("F34013", "短信验证码不能为空"),
    CORE_PAY_REQ_CHECK_PRE_TRADE_UNIQUE_CODE("F34014", "预支付唯一码不能为空"),
    CORE_PAY_REQ_CHECK_BANK_CODE("F34015", "银行代码不能为空"),
    CORE_PAY_REQ_CHECK_USER("F34016", "用户不存在"),
    CORE_PAY_REQ_CHECK_USER_EMAIL("F34017", "邮箱不能为空"),
    CORE_PAY_REQ_CHECK_USER_ADDRESS("F34018", "地址不能为空"),
    CORE_PAY_NONE_CONFIG("F34019", "不支持的应用或交易类型"),
    CORE_PAY_ENCRYPT("F34020", "加密失败"),
    CORE_PAY_DECRYPT("F34021", "解密失败"),
    CORE_PAY_REPEAT("F34022", "交易已存在"),
    CORE_PAY_REQ_CHECK_BVN("F34023", "BVN不能为空"),
    CORE_PAY_REQ_CHECK_BVN_LENGTH("F34024", "BVN必须为11位"),
    CORE_PAY_REQ_CHECK_BENE_ID("F34025", "受益人id不能位空"),
    CORE_PAY_REQ_CHECK_FIRST_NAME("F34026", "名字不能为空"),
    CORE_PAY_REQ_CHECK_LAST_NAME("F34027", "姓氏不能为空"),
    CORE_PAY_REFUND_REPEAT("F34028", "退款交易已存在"),


    //通用错误 F341，F342开头
    CORE_TRADE_NONE("F34100", "交易不存在"),
    CORE_TRADE_FINISHED("F34101", "交易完成"),
    CORE_TRADE_IN_PROCESS("F34102", "交易处理中"),
    CORE_TRADE_FAILED("F34103", "交易失败"),
    CORE_TRADE_CANCEL("F34104", "交易取消"),
    CORE_SETTLE_NOT_FINISHED("F34105", "清结算未完成"),
    CORE_REFUND_FAILED("F34106", "退款失败"),
    CORE_REFUND_CANCEL("F34107", "退款取消"),
    CORE_REFUND_FINISHED("F34108", "退款完成"),
    CORE_REFUND_IN_PROCESS("F34109", "退款处理中"),
    CORE_TRADE_NON_SUPPORT("F34110", "不支持的交易类型"),
    CORE_REFUND_ORIGIN_NOT_FINISH("F34111", "原交易未完成,无法退款"),
    CORE_REFUND_AMOUNT_EXCEED_LIMIT("F34112", "累计退款金额大于交易金额"),
    CORE_CARD_NONE_PRE_BOUND("F34113", "请先进行预绑定"),
    CORE_CARD_IS_BOUND("F34114", "银行卡已经绑定"),
    CORE_CARD_NOT_BOUND("F34115", "银行卡没有绑定"),
    CORE_CARD_NOT_EXIST("F34116", "此银行卡不存在"),
    CORE_CARD_NOT_EXIST_OR_BOUND("F34117", "银行卡不存在或没有绑定"),
    CORE_CARD_USER_NONE_CARD("F34118", "用户无可用的银行卡"),
    CORE_CLIENT_NONE_INIT("F34119", "未初始化第三方支付配置"),
    CORE_MERCHANT_NONE_EXIST("F34120", "渠道支付配置不存在"),
    CORE_PAY_BANK_VERIFYING("F34121", "银行账户认证中,请稍后"),
    CORE_PAY_BANK_VALIDATE("F34122", "银行信息校验失败"),
    CORE_PAY_BANK_VALIDATE_NAME_MATCH_FAIL("F34123", "用户姓名与银行账户对应姓名不一致"),
    CORE_PAY_CLIENT_INIT_ERROR("F34124", "初始化第三方配置失败"),
    CORE_REFUND_FREQUENT("F34125", "退款过于频繁，请稍后再试"),
    CORE_PAY_GET_PREPAY_INFO_ERROR("F34126", "获取预支付信息失败,请稍后重试"),
    CORE_PAY_PREPAY_INFO_EXPIRED("F34127", "预支付信息已过期,请稍后重试"),

    //渠道错误 F343开头
    //微信支付宝支付 F34300-F34349
    CORE_NOT_SUPPORT_PAY_TYPE("F34300", "不支持的支付类型"),
    CORE_AUTH_ACCESS_TOKEN_INVOKE_FAIL("F34301", "获取accessToken失败"),
    CORE_AUTH_ACCESS_TOKEN_NULL("F34302", "获取accessToken结果为null"),
    CORE_AUTH_ACCESS_TOKEN_FAIL("F34303", "获取accessToken失败"),

    //cashfree错误信息 F34350-F34399
    CASH_FREE_PAYOUT_AUTHORIZE("F34350", "获取token失败"),
    CASH_FREE_PAYOUT_ADD_BENE_ERROR("F34352", "新增受益人信息失败"),
    CORE_PAY_CASH_FREE_CREATE_PLAN_ERROR("F34353", "创建还款计划失败"),
    CORE_PAY_WITHHOLD_AUTH_NOT_EXIST("F34354", "代扣未授权"),
    CORE_PAY_PAYMENT_GET_TOKEN_ERROR("F34355", "获取token失败"),
    CASH_FREE_PAYOUT_NONE_BENE("F34356", "未查询到受益人信息"),
    CASH_FREE_SUB_NONE_WITHHOLD_AUTH("F34357", "未查询到代扣授权信息"),
    CORE_PAY_CASH_FREE_CREATE_SUB_ERROR("F34358", "创建订阅失败"),

    //razorpay错误信息 F34400-F34449
    RAZOR_PAY_CREATE_CONTACT("F34400", "创建用户失败!"),

    //支付模块  F34开头  结束---------------

    //核心->短信 模块消息X35开头
    CORE_SMS_SECRET_ERROR("F35101", "参数密钥验证错误"),
    CORE_SMS_CHANNEL_INVALID("F35103", "短信通道拒绝"),
    CORE_SMS_ACCOUNT_INVALID("F35104", "短信通道鉴权已过期"),
    CORE_SMS_MSGTYPE_INVALID("F35105", "渠道短信下发方式未开通"),
    CORE_SMS_SIGN_INVALID("F35106", "短信签名已过期"),
    CORE_SMS_TEMPLATE_ERROR("F35107", "短信模板信息加载失败"),
    CORE_SMS_SERVICE_NOTEXISTS("F35108", "短信业务服务不存在"),
    CORE_SMS_EXTPARAM_NOTJSON("F35109", "账户扩展参数JSON格式不正确"),

    //系统模块x36
    CORE_SYS_CODEMAKER_ERROR("F36001", "验证码不正确"),
    CORE_SYS_OLDPASSWORD_ERROR("F36002", "原密码错误"),
    CORE_SYS_NOWLOGIN_NO_ROLE("F36003", "当前用户没有关联角色"),
    CORE_SYS_NOWLOGIN_NO_MENU("F36004", "当前用户没有菜单，检查是否分配角色"),
    CORE_SYS_CODEMAKER_CREATE_FAIL("F36005", "图片验证码生成失败"),
    CORE_SYS_USER_USERNAMEORPHONE_EXIST("F36006", "用户名或手机号已存在"),
    CORE_SYS_USER_PHONE_EXIST("F36007", "手机号已存在"),
    CORE_SYS_CODE_EXIST("F36008", "编码已存在"),
    CORE_SYS_DATA_NOEXIST("F36009", "没有找到需要修改的数据"),
    CORE_SYS_BALANCE_CX("F36010", "先撤销下级机构"),
    CORE_SYS_STS_NULL("F36011", "获取STS临时授权，无数据返回"),

    //用户模块F37开头
    CORE_USER_NOT_EXIST("F37001", "用户不存在"),
    CORE_USER_VERIFY_CODE_EMPTY("F37002", "验证码不能为空"),
    CORE_USER_VERIFY_CODE_ERROR("F37002", "验证码不正确"),
    CORE_USER_VERIFY_CODE_EXPIRED("F37003", "验证码已过期"),
    CORE_USER_PASSWORD_ERROR("F37004", "密码不正确"),
    CORE_USER_SERIAL_NO_BIND("F37005", "手机设备号已绑定"),
    CORE_USER_MOBILE_REGISTERED("F37006", "该手机号已注册"),
    CORE_USER_WECHAT_NO_BIND("F37007", "微信号已绑定"),
    CORE_USER_NEW_AND_OLD_PWD_CANT_MATCH("F37008", "新旧密码不能一致"),
    CORE_USER_APP_INFO_NOT_FOUND("F37009", "app信息不存在"),
    CORE_USER_VEST_INFO_NOT_FOUND("F37010", "vest信息不存在"),
    CORE_USER_CHANNEL_INFO_NOT_FOUND("F37011", "渠道信息不存在"),
    CORE_USER_COUNTRY_CODE_NOT_FOUND("F37012", "国家地区编码不存在"),
    CORE_USER_COUNTRY_INFO_NOT_FOUND("F37013", "国家地区信息不存在"),
    CORE_USER_COUNTRY_PHONE_CODE_NOT_FOUND("F37014", "国家区号不存在"),
    CORE_USER_CITY_LENGTH_OVER_MAX("F37015", "城市信息过长"),
    CORE_USER_ADDRESS_LENGTH_OVER_MAX("F37016", "地址信息过长"),
    CORE_USER_EMAIL_LENGTH_OVER_MAX("F37017", "邮箱信息过长"),
    CORE_USER_EMAIL_FORMAT_ERROR("F37018", "邮箱格式错误"),
    CORE_USER_EXCEED_BIND_CARD_ERROR("F37019", "超过当月绑卡限制"),
    CORE_USER_DISABLED("F37020", "账号已禁用"),

    // 应用模块 F38
    CORE_APP_UPLOAD_FILE_NULL("F38001", "安装包文件上传，原始文件名为空"),
    CORE_APP_UPLOAD_FORMAT_ERROR("F38002", "安装包文件格式错误，仅支持apk/ipa"),
    CORE_APP_UPLOAD_SIZE_200M("F38003", "安装包大小不能超过200M"),
    CORE_APP_VESION_ERROR("F38004", "新增版本失败，请检查版本号相关问题"),

    // 核心认证模块 F39开关
    CORE_CREDIT_PARAM_SOURCE_NULL("F39001", "调用者标识为空"),
    CORE_CREDIT_PARAM_SIGN_NULL("F39003", "签名为空"),
    CORE_CREDIT_PARAM_SIGN_ERROR("F39005", "签名错误"),
    CORE_CREDIT_PARAM_CARD_TYPE_ERROR("F39021", "不支持的卡类型"),
    CORE_CREDIT_PARAM_CARD_SIDE_ERROR("F39022", "卡面仅支持front/back"),
    CORE_CREDIT_PARAM_IMAGE_URL_ERROR("F39023", "图片地址错误"),
    CORE_CREDIT_MASK_CARD_ERROR("F39026", "打码图片失败"),
    CORE_CREDIT_THIRD_RESULT_NULL("F39036", "三方结果为空"),
    CORE_CREDIT_THIRD_RESULT_ERROR("F39037", "三方结果异常"),

    // 腾讯云[200,250]
    CORE_CREDIT_GET_TENCENT_TICKET_ERROR("F39206", "获取腾讯云ticket异常"),
    CORE_CREDIT_GET_H5_FACEID_ERROR("F39207", "腾讯云上送身份信息异常"),
    CORE_CREDIT_CALLBACK_TIMEOUT("F39209", "腾讯云回调超时请重新认证"),
    CORE_CREDIT_AUTH_FAIL("F39210", "腾讯云处理失败请重新认证"),
    CORE_CREDIT_SIGN_ERROR("F39211", "腾讯云签名错误"),

    // 中台配置三方相关
    CORE_CREDIT_ACCOUNT_THIRD_CODE_EXIST("F39900", "账户下三方渠道编码已存在"),
    CORE_CREDIT_THIRD_EXIST("F39901", "认证渠道已存在"),
    CORE_CREDIT_WAY_EXIST("F39904", "认证方式已存在"),
    CORE_CREDIT_THIRD_NOT_CONFIG("F39905", "认证渠道未配置"),
    CORE_CREDIT_WAY_NOT_CONFIG("F39906", "认证方式未配置"),

    // 网关模块消息X4开头


    //贷后模块X51开头
    LOAN_AFTER_AMOUNT_FORMAT_ERROR("F51200", "金额格式错误"),
    LOAN_AFTER_AMOUNT_CAN_NOT_LESS_THAN_ZERO("F51201", "金额不能小于0"),
    LOAN_AFTER_EXIST_APPLY_WITH_AUDITING("F51202", "存在审核中的申请，请稍后再试"),
    LOAN_AFTER_USER_WORK_INFO_NOT_EXIST("F51203", "用户工作信息不存在"),
    LOAN_AFTER_USER_CONTACT_INFO_NOT_EXIST("F51204", "用户联系人信息不存在"),
    LOAN_AFTER_USER_BASE_INFO_NOT_EXIST("F51205", "用户基本信息不存在"),
    LOAN_AFTER_APPLY_REDUCE_AMOUNT_OVER_MAX("F51206", "申请减免金额过大"),
    LOAN_AFTER_NOT_FOUND_REPAY_PLAN("F51207", "未查询到还款计划"),
    LOAN_AFTER_DEBT_HAS_REPAY("F51208", "该工单已还款"),
    LOAN_AFTER_DEBT_CANCEL_DEBT("F51209", "该工单状态不允许取消操作"),
    LOAN_AFTER_DEBT_SEARCH_CREDIT("F51210", "查询授信信息出错"),
    LOAN_AFTER_DEBT_CREDIT_NOT_FOUND("F51211", "授信信息未查到"),
    LOAN_AFTER_DEBT_FILE_SUFFIX_ERROR("F51212", "文件格式错误，仅支持excel"),
    LOAN_AFTER_DEPT_REPAY_TIMES_OVER_LIMIT("F51213", "扣款次数超过部门次数限制"),
    LOAN_AFTER_SYS_USER_DEPT_NOT_EXIST("F51214", "当前系统用户无所属部门"),

    // 工单模块合同相关
    LOAN_CONTRACT_COUNT_FAIL("F52000", "删除合同模板时，存在产品关联数据，请先删除关联数据"),
    LOAN_CONTRACT_FILENAME_FAIL("F52001", "合同模板文件上传，原始文件名为空"),
    LOAN_CONTRACT_LINK_DATA_EXIST("F52003", "合同模板关联产品信息，维护规则已存在"),
    LOAN_CONTRACT_NOT_CONFIG("F52004", "合同生成，没有找到相关合同模板配置"),

    // 认证模块公共码，闭区间为[F54000,F54099]
    LOAN_CREDIT_IDCARD_NOT_YOURSELF("F54000", "请上传本人身份证件照"),
    LOAN_CREDIT_IDCARD_CONFLICT("F54001", "该身份证已绑定其他账号"),
    LOAN_CREDIT_IDCARD_NOT_FOUND("F54002", "未获取到身份证信息"),
    LOAN_CREDIT_IDCARD_FRONT_NOT_FOUND("F54003", "未查询到身份证正面照片"),
    LOAN_CREDIT_IDCARD_BACK_NOT_FOUND("F54004", "未查询到身份证反面照片"),
    LOAN_CREDIT_UPLOAD_IDCARD_ERROR("F54005", "上传身份证失败"),
    LOAN_CREDIT_CARD_TYPE_ERROR("F54006", "请重新上传正确卡类型"),
    LOAN_CREDIT_CHECK_AADHAAR_ERROR("F54007", "校验Aadhaar卡失败"),
    LOAN_CREDIT_CHECK_PAN_ERROR("F54008", "校验Pan卡失败"),
    LOAN_CREDIT_AADHAAR_PAN_NOT_MATCH("F54009", "信息不一致"),
    LOAN_CREDIT_FACE_NOT_FOUNT("F54010", "请上传人脸照"),
    LOAN_CREDIT_LIVENSS_NOT_FOUNT("F54011", "请上传活体数据"),
    LOAN_CREDIT_ACCOUNT_ABNORMAL("F54012", "账户信息异常"),
    LOAN_CREDIT_UN_CREDIT_ITEMS_EXIST("F54013", "请完成未认证项"),
    LOAN_CREDIT_CHECK_BVN_ERROR("F54015", "校验BVN失败"),
    LOAN_CREDIT_REPEAT_SUBMIT_ERROR("F54016", "请勿重复提交"),
    LOAN_CREDIT_SAME_PHONE_ERROR("F54018", "手机号不能相同"),
    LOAN_CREDIT_COMMIT_OCR_ERROR("F54019", "上传信息次数过多，如有疑问请联系客服"),
    LOAN_CREDIT_SFRZ_AADHAAR_NAME_ERROR("F54025", "Aadhaar姓名不一致"),
    LOAN_CREDIT_SFRZ_PAN_NAME_ERROR("F54026", "PAN姓名不一致"),
    LOAN_CREDIT_SFRZ_AADHAAR_PAN_NAME_ERROR("F54030", "Aadhaar姓名和PAN姓名不一致"),
    LOAN_CREDIT_SFRZ_ADVANCE_START_VIDEO_GATHER_TIME_ERROR("F54031", "发起视频次数过多，如有疑问请联系客服"),
    LOAN_CREDIT_USERNAME_AND_BANK_NAME_ERROR("F54032", "用户名与银行卡姓名不一致"),
    LOAN_CREDIT_COUNTRIES_NOT_SUPPORTED("F54033", "不支持的国别"),
    LOAN_CREDIT_PAN_NO_LENGTH_OVER_MAX("F54036", "Pan卡号过长"),
    LOAN_CREDIT_AADHAAR_NO_LENGTH_OVER_MAX("F54037", "Aadhaar卡号过长"),
    LOAN_CREDIT_AADHAAR_NAME_LENGTH_OVER_MAX("F54038", "Aadhaar姓名过长"),
    LOAN_CREDIT_PAN_FIRST_NAME_LENGTH_OVER_MAX("F54039", "首名字过长"),
    LOAN_CREDIT_PAN_MIDDLE_NAME_LENGTH_OVER_MAX("F54040", "中间名字过长"),
    LOAN_CREDIT_PAN_LAST_NAME_LENGTH_OVER_MAX("F54041", "姓过长"),
    LOAN_CREDIT_LAST_NAME_FORMAT_ERROR("F54045", "姓格式错误"),
    LOAN_CREDIT_MIDDLE_NAME_FORMAT_ERROR("F54046", "中间名字格式错误"),
    LOAN_CREDIT_FIRST_NAME_FORMAT_ERROR("F54047", "名格式错误"),
    LOAN_CREDIT_NAME_FORMAT_ERROR("F54048", "姓名格式错误"),
    LOAN_CREDIT_PAN_NO_FORMAT_ERROR("F54049", "PAN卡号格式错误"),
    LOAN_CREDIT_AADHAAR_NO_FORMAT_ERROR("F54050", "AADHAAR卡号格式错误"),

    // 商汤[F54100,F54149]
    LOAN_CREDIT_UPLOAD_IDCARD_FRONT_BASE64_ERROR("F54100", "上传正面身份证base64串失败"),
    LOAN_CREDIT_UPLOAD_IDCARD_BACK_BASE64_ERROR("F54101", "上传反面身份证base64串失败"),
    LOAN_CREDIT_UPLOAD_IDCARD_HAND_BASE64_ERROR("F54102", "上传手持身份证base64串失败"),
    LOAN_CREDIT_UPLOAD_IDCARD_NOT_CLEAR("F54103", "身份证照片不清晰,请重新上传"),
    LOAN_CREDIT_UPLOAD_IDCARD_NAME_ERROR("F54104", "姓名识别有误，请重新上传身份证正面照"),
    LOAN_CREDIT_UPLOAD_IDCARD_GENDER_ERROR("F54105", "性别识别有误，请重新上传身份证正面照"),
    LOAN_CREDIT_UPLOAD_IDCARD_BIRTHDAY_ERROR("F54106", "出生日期识别有误，请重新上传身份证正面照"),
    LOAN_CREDIT_UPLOAD_IDCARD_TIMELIMIT_ERROR("F54107", "身份证有效期识别有误，请重新上传身份证正面照"),
    LOAN_CREDIT_UPLOAD_IDCARD_AUTHORITY_ERROR("F54108", "签发机构识别有误，请重新上传身份证正面照"),
    LOAN_CREDIT_UPLOAD_IDCARD_NUMBER_ERROR("F54109", "身份证号识别有误，请重新上传身份证正面照"),
    LOAN_CREDIT_UPLOAD_IDCARD_FRONT_ERROR("F54110", "请上传本人身份证正面照片"),
    LOAN_CREDIT_UPLOAD_IDCARD_BACK_ERROR("F54111", "请上传本人身份证反面照片"),
    LOAN_CREDIT_UPLOAD_BANK_CARD_FRONT_BASE64_ERROR("F54112", "上传银行卡正面base64串失败"),
    LOAN_CREDIT_UPLOAD_BANK_CARD_BACK_BASE64_ERROR("F54113", "上传银行卡反面base64串失败"),
    LOAN_CREDIT_SENSETIME_OCR_IDCARD_RESULT_EMPTY("F54114", "商汤OCR识别身份证接口返回结果为空"),
    LOAN_CREDIT_SENSETIME_OCR_IDCARD_RESULT_ERROR("F54115", "商汤识别身份证接口返回结果异常"),

    // Advance[F54150,F54199]
    LOAN_CREDIT_ADVANCE_OCR_IDCARD_RESULT_EMPTY("F54150", "Advance识别身份证接口返回结果为空"),
    LOAN_CREDIT_ADVANCE_OCR_IDCARD_RESULT_ERROR("F54151", "Advance识别身份证接口返回结果异常"),
    LOAN_CREDIT_ADVANCE_FACE_COMPARE_RESULT_EMPTY("F54152", "Advance比对照片接口返回结果为空"),
    LOAN_CREDIT_ADVANCE_FACE_COMPARE_RESULT_ERROR("F54153", "Advance比对照片接口返回结果异常"),
    LOAN_CREDIT_ADVANCE_LIVENESS_DETECTION_RESULT_EMPTY("F54154", "Advance活体检测接口返回结果为空"),
    LOAN_CREDIT_ADVANCE_LIVENESS_DETECTION_RESULT_ERROR("F54155", "Advance活体检测接口返回结果异常"),

    // Accuauth[F54200,F54249]
    LOAN_CREDIT_ACCUAUTH_OCR_IDCARD_RESULT_EMPTY("F54200", "Accuauth识别身份证接口返回结果为空"),
    LOAN_CREDIT_ACCUAUTH_OCR_IDCARD_RESULT_ERROR("F54201", "Accuauth识别身份证接口返回结果异常"),
    LOAN_CREDIT_ACCUAUTH_FACE_COMPARE_RESULT_EMPTY("F54202", "Accuauth比对照片接口返回结果为空"),
    LOAN_CREDIT_ACCUAUTH_FACE_COMPARE_RESULT_ERROR("F54203", "Accuauth比对照片接口返回结果异常"),
    LOAN_CREDIT_ACCUAUTH_LIVENESS_DETECTION_RESULT_EMPTY("F54204", "Accuauth活体检测接口返回结果为空"),
    LOAN_CREDIT_ACCUAUTH_LIVENESS_DETECTION_RESULT_ERROR("F54205", "Accuauth活体检测接口返回结果异常"),

    // 腾讯云[F54250,F54299]
    LOAN_CREDIT_TENCENT_OCR_IDCARD_RESULT_EMPTY("F54250", "腾讯云OCR识别身份证接口返回结果为空"),

    // ai-check[F54300,F54349]
    LOAN_CREDIT_AI_CHECK_OCR_IDCARD_RESULT_ERROR("F54300", "智能识别身份证接口返回结果异常"),
    LOAN_CREDIT_AI_CHECK_OCR_IDCARD_FRONT_RESULT_EMPTY("F54301", "智能OCR识别身份证正面接口返回结果为空"),
    LOAN_CREDIT_AI_CHECK_OCR_IDCARD_BACK_RESULT_EMPTY("F54302", "智能OCR识别身份证反面接口返回结果为空"),
    LOAN_CREDIT_AI_CHECK_OCR_IDCARD_NOT_MATCH("F54303", "正面照与人脸照不匹配"),

    // 后台系统管理[F54900,F54999]
    LOAN_CREDIT_CAN_NOT_DELETE("F54900", "正在使用中，不可删除!"),
    LOAN_CREDIT_CAN_NOT_DISABLED("F54901", "正在使用中，不可禁用!"),
    LOAN_CREDIT_WAY_PRODUCT_LINK_EXIST("F54902", "产品已配置此认证方式!"),
    LOAN_CREDIT_WAY_ENABLED_EXIST("F54903", "认证方式不可同时启用多个!"),
    LOAN_CREDIT_CODE_EXIST("F54904", "编码已存在!"),
    LOAN_CREDIT_WAY_THIRD_NOT_CONFIG("F54905", "认证方式与认证三方未配置!"),
    LOAN_CREDIT_WAY_THIRD_DISABLED("F54906", "认证方式与认证三方已禁用!"),
    LOAN_CREDIT_THIRD_NOT_FOUND("F54907", "认证三方未找到!"),
    LOAN_CREDIT_THIRD_DISABLED("F54908", "认证三方已禁用!"),
    LOAN_CREDIT_WAY_NOT_FOUND("F54909", "认证方式未找到!"),
    LOAN_CREDIT_WAY_DISABLED("F54910", "认证方式已禁用!"),
    LOAN_CREDIT_THIRD_ACCOUNT_EXISTS("F54915", "三方账户已存在"),
    LOAN_CREDIT_THIRD_ACCOUNT_API_ID_EXISTS("F54916", "三方API-ID已存在"),
    LOAN_CREDIT_THIRD_ACCOUNT_API_SECRET_EXISTS("F54917", "三方API-SECRET已存在"),

    // 借贷模块消息X56开头
    LOAN_PRODUCT_IS_NOT_EXIST("F56001", "产品不存在"),
    LOAN_EXIST_REJECT_BLACKLIST("F56002", "存在被拒工单或在黑名单中"),
    LOAN_EXIST_PROCESS_DEBT("F56003", "存在进行中工单"),
    LOAN_DEBT_NOT_EXIST("F56004", "工单不存在"),
    LOAN_STATUS_ERROR("F56005", "工单状态错误"),
    LOAN_BANK_CARD_NOT_BIND("F56006", "未绑定银行卡"),
    LOAN_DEBT_GET_CREDIT_AMOUNT_FAIL("F56007", "获取授信额度失败"),
    LOAN_CHANNEL_EXCEPTION("F56008", "获取渠道信息异常"),
    LOAN_CHANNEL_DISABLE("F56009", "渠道已禁用"),
    LOAN_AMOUNT_LOWER_THAN_PRODUCT_MIN("F56010", "低于借款允许下限"),
    LOAN_AMOUNT_HIGHER_THAN_PRODUCT_MAX("F56011", "高于借款允许上限"),
    LOAN_DEBT_MERCHANT_WITHOUT_PRODUCT("F56012", "商户未关联产品"),
    LOAN_DEBT_PRODUCT_LOAN_NUMBER_ERROR("F56013", "借款期数错误"),
    LOAN_DEBT_PRODUCT_AUDIT_CLOSE("F56014", "请稍后再试，或者选择其他产品"),
    LOAN_DEBT_NOTICE_UPDATE_CREDIT_FAIL("F56015", "通知修改授信单状态失败"),
    LOAN_PRE_STATUS_ERROR("F56016", "工单前置状态错误"),
    LOAN_DEBT_PROCESS_NOT_FOUND("F56017", "产品扭转过程不存在"),
    LOAN_DEBT_PROCESS_TYPE_NOT_FOUND("F56018", "产品扭转类型不存在"),
    LOAN_AMOUNT_OVER_PER_DAY_LIMIT("F56019", "额度已满，请明日再试"),
    LOAN_DEBT_MAKE_LOANS_IN_PROGRESS("F56020", "工单正在放款中"),
    LOAN_DEBT_EXTENSION_APPLY_FAILED("F56021", "展期申请失败，请稍后重试"),
    LOAN_BANK_CARD_ACCOUNT_NAME_DIFF("F56022", "用户姓名与银行卡姓名不一致"),
    LOAN_DEBT_DEFER_HAS_AUTH("F56023", "已授权延期"),
    LOAN_DEBT_DEFER_NOT_AUTH("F56024", "未授权延期"),
    LOAN_DEBT_DEFER_APPLY_FAILED("F56025", "延期申请失败，请稍后重试"),
    LOAN_DEBT_DEVICE_ID_EXIST_ON_LOAN("F56026", "该设备id号已存在在贷工单"),
    LOAN_PRODUCT_PRE_SERVICE_RATE_ERROR("F56027", "产品前置收取的费率总和应小于1"),


    //借贷-支付模块以57开头
    //还款计划相关
    LOAN_PAY_REPAYMENT_GET_DEBT_FAIL("F57101", "工单数据获取失败"),
    LOAN_PAY_REPAYMENT_GET_PRODUCT_FAIL("F57102", "产品数据获取失败"),
    LOAN_PAY_REPAYMENT_GET_PRODUCT_TERM_FAIL("F57103", "产品分期数据获取失败"),
    LOAN_PAY_REPAYMENT_UPDATE_DEBTSTATUS_FAIL("F57104", "修改工单状态失败"),
    LOAN_PAY_REPAYMENT_DEBT_STATUS_WRONG("F57106", "工单状态不正确"),
    LOAN_PAY_REPAYMENT_BATCH_STATUS_WRONG("F57107", "还款批次状态不正确"),
    LOAN_PAY_REPAYMENT_TRADE_STATUS_WRONG("F57108", "支付记录状态不正确"),
    LOAN_PAY_REPAYMENT_PLAN_NOT_FOUND("F57109", "还款计划未找到"),
    LOAN_PAY_REPAYMENT_REPAY_PROCESSING("F57110", "工单正在处理还款业务"),
    LOAN_PAY_REPAYMENT_PLAN_OVERDUE_NOT_FOUND("F57111", "还款计划逾期记录未找到"),
    LOAN_PAY_REPAYMENT_DEBT_NONE_REPAYING("F57112", "工单不在还款中,请重试"),
    LOAN_PAY_PAYOUT("F57113", "工单放款中或放款已完成"),
    LOAN_PAY_REPAYMENT_DEBT_AUTOREPAY_DISABLE("F57114", "工单代扣流程已关闭,不允许执行代扣"),
    LOAN_PAY_REPAYMENT_DEBT_AUTOREPAY_CTRL_FAIL("F57115", "工单代扣开关未获取到，请重试"),
    LOAN_PAY_REPAYMENT_ROLLOVER_EXIST_DATA("F57116", "还款计划已经存在正常的展期数据，不能重复操作"),
    LOAN_PAY_REPAYMENT_ROLLOVER_NOT_MATCH_PLAN("F57117", "未找到可供展期的还款计划数据"),
    LOAN_PAY_REPAYMENT_DEFER_NOACCESS("F57118", "工单当前不支持延期"),
    LOAN_PAY_REPAYMENT_AMOUNT_OVER_LIMIT("F57119", "本次还款金额超出剩余应还金额,请稍后再试"),
    LOAN_PAY_ORIGINAL_NOT_SUCESS("F57120", "原单未支付完成,无法退款"),
    LOAN_PAY_LOAN_REVERSED("F57121", "放款已撤销,无需还款"),

    //loan pay相关 X57开始-------------------------------
    LOAN_PAY_CARD_NOT_EXIST("F57000", "银行卡不存在"),
    LOAN_PAY_DEBT_NOT_EXIST("F57001", "工单不存在"),
    LOAN_PAY_DEBT_PROCESSING("F57002", "工单支付中"),
    LOAN_PAY_TRADE_NOT_EXIST("F57003", "交易不存在"),
    LOAN_PAY_REPAY_PLAN_NOT_EXIST("F57004", "还款计划不存在"),
    LOAN_PAY_REQ_CHECK_DEBT_NO("F57005", "工单号不能为空"),
    LOAN_PAY_REQ_CHECK_NUM("F57006", "还款期数不能为空"),
    LOAN_PAY_CARD_ALREADY_USE("F57007", "银行卡已被使用,请更换其他银行卡"),
    LOAN_PAY_CARD_NAME_NOT_SAME("F57008", "用户姓名与银行预留姓名不一致"),
    LOAN_PAY_REFUND_AMOUNT_EXCEED_LIMIT("F57009", "累计退款金额大于原交易金额"),
    LOAN_PAY_REFUND_FREQUENT("F57010", "退款频繁，请稍后再试"),
    LOAN_PAY_REVERSED_NOT_EXISTS("F57011", "撤销单不存在"),
    LOAN_PAY_CAN_NOT_REFUND("F57012", "撤销单无法退款"),
    LOAN_PAY_HANDLE_OVERFLOW_AMOUNT("F57013", "请先处理溢出金额"),
    LOAN_PAY_HANDLE_REFUND_FIRST("F57014", "请先处理退款"),
    LOAN_PAY_ALREADY_REVERSED("F57015", "撤销单已处理"),
    LOAN_PAY_REVERSE_DONT_NEED_REFUND("F57016", "用户未还款,无需退款"),
    LOAN_PAY_BANK_CODE_ERROR("F57026", "银行代码只能为字母和数字"),
    LOAN_PAY_BANK_CODE_RULE_ERROR("F57027", "银行代码为11位字符且第5位必须为0"),


    //loan pay相关 X51结束----------------------------------

    //清结算F58开头
    LOAN_SETTLE_NOT_REPAYMENT_STATUS("F58001", "工单不在还款状态"),

    //电销模块
    XAPP_LOAN_TELESALE_CUSTOMER_RECORD_NOT_FOUND("F59000", "客户记录未找到"),
    XAPP_LOAN_TELESALE_STATISTICS_RECORD_ALREADY_EXIST("F59001", "统计记录已存在"),
    XAPP_LOAN_TELESALE_PARAM_IS_WRONG("F59002", "参数不正确"),


    //渠道模块----------------------------------------
    LOAN_CHANNEL_INTERVAL_ERROR("F60000", "interval error"),
    LOAN_CHANNEL_DECRYPTION_ABNORMAL("F60001", "Decryption abnormal"),
    LOAN_CHANNEL_VERIFY_SIGN_ABNORMAL("F60002", "Sign verification abnormal"),
    LOAN_CHANNEL_CHANNEL_CONFIG_ERROR("F60003", "This channel is not configured"),
    LOAN_CHANNEL_VERIFY_SIGN_NOT_PASS("F60004", "Sign verification fail"),
    LOAN_CHANNEL_FUNCTION_NOT_SUPPORT("F60005", "Unsupported business"),
    LOAN_CHANNEL_BUSINESS_PROCESSING("F60006", "Business processing,please try again later"),
    LOAN_CHANNEL_UNKNOWN_TASK_TYPE("F60007", "Unknown task type"),

    LOAN_CHANNEL_ORDER_NOT_EXISTS("F60010", "order not exists"),
    LOAN_CHANNEL_GET_ORDER_ERROR("F60011", "Failed to query the debt"),
    LOAN_CHANNEL_BIND_CARD_ERROR("F60012", "Failed to bind card"),
    LOAN_CHANNEL_PRODUCT_NOT_EXIST("F60013", "Product not exist"),
    LOAN_CHANNEL_GET_REPAYMENT_PLAN_ERROR("F60014", "Failed to get repayment plan"),
    LOAN_CHANNEL_GET_SPECIFIED_REPAYMENT_PLAN_ERROR("F60015", "Failed to get specified repayment plan"),
    LOAN_CHANNEL_GET_APPROVAL_ERROR("F60016", "Under review,please wait"),
    LOAN_CHANNEL_GET_SIGNATURE_URL("F60017", "Failed to get e-signature"),
    LOAN_CHANNEL_LOAN_ERROR("F60018", "Loan failure"),
    LOAN_CHANNEL_GET_CONTRACT_ERROR("F60019", "Failed to get contract"),
    LOAN_CHANNEL_USER_HAVE_DEBT_ON_LOAN("F60020", "The user has a debt on loan"),
    LOAN_CHANNEL_GET_PAYMENT_AMOUNT_FAIL("F60021", "Failure to obtain repayment amount"),
    LOAN_CHANNEL_LOAN_PAID_OFF("F60022", "Loan paid off"),
    LOAN_CHANNEL_PAYMENT_FAIL("F60023", "Payment failed,please try again later"),
    LOAN_CHANNEL_GET_PRODUCT_ERROR("F60024", "Failed to get product"),
    LOAN_CHANNEL_TRIAL_FAILURE("F60025", "Trial failure"),
    LOAN_CHANNEL_ORDER_CANCELLED("F60026", "Order cancelled"),
    LOAN_CHANNEL_REFUSE_CHANGE_CARD("F60027", "The order has been submitted for loan,the bank card is not allowed to be changed"),


    // 商城F6开头
    MALL_ACTIVE_NOTFOUND("F61001", "未找到对应活动"),
    MALL_ACTIVE_SECKILL_NOT_STARTTIME("F61002", "秒杀活动必须有开始结束时间"),
    MALL_ACTIVE_SECKILL_NOT_ENDTIME("F61003", "秒杀活动必须有结束结束时间"),
    MALL_ACTIVE_SECKILL_NOT_TAGINFO("F61004", "专场活动必须带有标签信息"),
    MALL_ORDER_NOTFOUND("F64001", "未找到对应订单信息"),
    MALL_ORDER_AFTER_CHECKING("F64002", "售后审核中不能重复申请"),
    MALL_ORDER_AFTER_NOTFOUND("F64003", "未找到对应售后记录"),
    MALL_ORDER_NOTALLOW_CANCEL("F64004", "订单当前状态不允许取消"),
    MALL_ORDER_SHOPPING_CARD_NULL("F64005", "购物车为空"),
    MALL_ORDER_SHOPPING_CARD_LIMIT("F64006", "购物车只能增加100种商品"),
    MALL_ORDER_NOTFOUND_GOODS("F64007", "未查询到对应商品信息"),
    MALL_ORDER_RECHARGE_ACCOUNT_NULL("F64008", "充值账号不能为空"),
    MALL_ORDER_GOODS_INFO_ERROR("F64009", "商品信息错误"),


    ;

    private String code;
    private String text;

    RestMsg(String code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getText() {
        return text;
    }

    public String getText(Object... texts) {
        return String.format(text, texts);
    }

    public static RestMsg getByCode(String code) {
        return Arrays.stream(RestMsg.values()).filter(a -> a.getCode().equals(code)).findFirst().orElse(null);
    }
}
