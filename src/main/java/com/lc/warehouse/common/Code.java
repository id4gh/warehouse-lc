package com.lc.warehouse.common;

/**
 * ClassName: Code
 *
 * @author mayanchao
 * @Description: 共用参数
 */
public class Code {
    /**
     * 成功
     */
    public static final int SUCCESS = 200;

    /**
     * 参数错误
     */
    public static final int PARAMATER = 400;

    /**
     * 系统异常
     */
    public static final int FAIL = 500;

    /**
     * 退款可重试
     */
    public static final int REFUND_TRY = 600;

    /**
     * 回退账单退款失败
     */
    public static final int WITHDRAW_REFUND = 700;

    /**
     * 业务异常 不正常的订单数据提交
     */
    public static final int SERVICE_EXCEPTION = 800;

    /**
     * 参数错误
     */
    public static final int ERROR_PARAMATER = 801;

    /**
     * 前后端交易价格不匹配
     */
    public static final int PRICE_DISMATCH = 802;

    /**
     * 非法参数
     */
    public static final int ILLEAGEL_PARAM = 803;

    /**
     * 子订单状态转换异常
     */
    public static final int ORDER_STATUS_EXCEPTION = 805;

    /**
     * 查询List<tradeDto>异常
     */
    public static final int SEARCH_TRADEDTO_EXCEPTION = 806;

    /**
     * 插入excel文件记录表失败
     */
    public static final int CREATE_EXCELFILE_EXCEPTION = 807;

    /**
     * 保存excel文件失败
     */
    public static final int SAVE_IMPORTEXCEL_EXCEPTION = 808;

    /**
     * 删除购物车记录失败
     */
    public static final int DELETE_CART_EXCEPTION = 809;

    /**
     * 根据cartIds查询购物车记录失败
     */
    public static final int SERACH_CARTSBYIDS_EXCEPTION = 810;

    /**
     * 更新子订单价格失败
     */
    public static final int UPDATE_ORDER_PRICE_ERROR = 811;

    /**
     * 读取已经上传到服务器的excel文件失败
     */
    public static final int READ_IMPORTEDEXCEL_EXCEPTION = 812;

    /**
     * 更新交易的物流费失败
     */
    public static final int UPDATE_TRADE_LOGISTICE_EXCEPTION = 813;

    /**
     * 修改子订单价格失败
     */
    public static final int ILLEAGEL_ORDER_PRICE_UPDATE = 815;

    /**
     * 修改子订单价格失败
     */
    public static final int DELAY_ORDER_CONFIRM_EXCEPTION = 816;

    /**
     * 查询子订单历史状态失败
     */
    public static final int SELECT_ORDER_ORDERPROGRESS_EXCEPTION = 817;

    /**
     * 更新购物车的产品数量失败
     */
    public static final int UPDATE_CART_PRODUCT_NUM_EXCEPTION = 818;

    /**
     * 通过trade_number查询其子订单详情失败
     */
    public static final int SELECT_ORDERDTOS_BY_TRADE_NUMBER_EXCEPTION = 819;

    /**
     * 通过用户点击展示订单列表失败
     */
    public static final int SELECT_TRADE_LIST_BY_MPUSER_EXCEPTION = 820;

    /**
     * 查询购物车失败
     */
    public static final int SELECT_IS_COLLECTION_ERROR = 821;

    /**
     * 添加购物车失败
     */
    public static final int INSERT_CART_ERROR = 822;

    /**
     * 根据tradeNumber查询出orderNumbers的列表失败
     */
    public static final int SELECT_ORDERNUMBERS_BY_TRADENUMBER_ERROR = 823;

    /**
     * 查询出7天之内每一天的子订单数量列表失败
     */
    public static final int SELECT_TRADE_PAYAMOUNT_SUM_BY7DAYS_ERROR = 824;

    /**
     * 查询一天内
     */
    public static final int SELECT_MP_TRADE_INFO_BY_MPALIAS = 825;

    /**
     * 删除搜藏记录失败
     */
    public static final int DELETE_COLLECTION_BY_ID_FAILED = 826;

    /**
     * 添加搜藏记录失败
     */
    public static final int INSERT_COLLECTION_FAILED = 827;

    /**
     * 删除购物车记录失败
     */
    public static final int DELETE_CART_BY_ID_FAILED = 828;

    /**
     * 查询收货地址失败
     */
    public static final int SELECT_SADDRESS_DTOBY_TRADE_NUMBER = 829;

    /**
     * 导出记录查询失败
     */
    public static final int SELECT_ALL_EXPORT_LIST_EXCEPTION = 830;

    /**
     * 更新order的物流信息失败
     */
    public static final int UPDATE_ORDER_LOGISTICS_INFO = 831;

    /**
     * 查询导入记录失败
     */
    public static final int SELECT_ALL_IMPORTLIST_BY_MPALIAS = 832;

    /**
     * 读取excel表格失败
     */
    public static final int UPDATE_READ_EXCEL_TO_SEND_ORDER_ERROR = 833;

    /**
     * 导出tradeExcel文件文件返回false
     */
    public static final int EXPORT_TRADE_EXCEL_FAILED = 834;

    /**
     * 导出tradeExcel文件文件异常
     */
    public static final int EXPORT_TRADE_EXCEL_EXCEPTION = 835;

    /**
     * 按照分页获得该店铺的优惠券列表失败
     */
    public static final int SELECT_ALL_COUNT_COUPONS_EXCEPTION = 836;

    /**
     * 查询今天的成交信息失败
     */
    public static final int SELECT_MPTODAY_TRADEINFO_BYMAPALIAS_EXCEPTION = 837;

    /**
     * 添加优惠券模板失败
     */
    public static final int INSERT_COUPON_EXCEPTION = 838;

    /**
     * 返回优惠券详情失败
     */
    public static final int SELECT_COUPON_DETAIL_BY_HASH_EXCEPTION = 839;

    /**
     * 更新草稿状态下的优惠券信息失败
     */
    public static final int UPDATE_COUPON_INFO_EXCEPTION = 840;

    /**
     * 查询出用户的优惠券列表
     */
    public static final int SELECT_COUPON_BYMPUSER_EXCEPTION = 841;
    /**
     * 用户领取优惠券失败
     */
    public static final int INSERT_USERCOUPON_EXCEPTION = 842;

    /**
     * 用户领取优惠券情况
     */
    public static final int SELECT_COUPONGET_SITUATION_EXCEPTION = 843;

    /**
     * 判断用户是否重复领取
     */
    public static final int IS_USER_REPEAT_GET_EXCEPTION = 844;

    /**
     * 通过用户领券编码查询详情失败
     */
    public static final int SELECT_USERCOUPON_BY_USERHASH_EXCEPTION = 845;

    /**
     * 查询优惠券使用情况失败
     */
    public static final int SELECT_COUPONUSE_SITUATION_EXCEPTION = 846;

    /**
     * 查询订单优惠券列表失败
     */
    public static final int SELECT_TRADECOUPON_BY_TRADENUMBER_EXCEPTION = 847;

    /**
     * 查询订单的统计数据发生了异常
     */
    public static final int SELECT_TRADE_SATICSC_INFO_EXCEPTION = 858;

    /**
     * 查询买家是否重复购买异常
     */
    public static final int GET_PRODUCT_IS_REPEATE_BUY_EXCEPTION = 859;

    /**
     * 查询用户的消费金额和实际消费金额异常
     */
    public static final int SELECT_USERS_CONSUME_INFO_EXCEPTION = 860;

    /**
     * 查询交易扩展记录失败
     */
    public static final int SELECT_TRADE_SUPPORT_DETAIL_EXCEPTION = 861;

    /**
     * 增加新的交易末班信息失败
     */
    public static final int INSERT_NEW_TRADE_SUPPORT_EXCEPTION = 862;

    /**
     * 更新交易扩展信息失败
     */
    public static final int UPDATE_TRADE_SUPPORT_EXCEPTION = 863;

    /**
     * 获取用户是否退签或者退货
     */
    public static final int GET_TRADE_IS_RETURN_BACK_EXCEPTION = 864;

    /**
     * 查询产品的销售列表记录失败
     */
    public static final int SELECT_HOT_SALED_PRODUCT_LIST_BY_MPALIAS = 865;

    /**
     * 查询店铺的退货列表失败
     */
    public static final int SELECT_SAFEGUARD_REASON_LIST_BY_MPALIAS_EXCEPTION = 866;

    /**
     * 文件批量导入失败
     */
    public static final int UPDATE_READ_EXCELTO_UPDATE_ORDER_REMARK_EXCEPTION = 867;

    /**
     * 更新退换货原因结束
     */
    public static final int UPDATE_SAFEGUARDREASON_ERROR = 868;

    public static final int INSERT_SAFEGUARDREASONDIC_ERROR = 869;

    /**
     * 删除
     */
    public static final int DELETE_SAFEGUARD_REASON_DIC_ERROR = 870;

    /**
     * CRM查询订单列表失败
     */
    public static final int SELECT_CRM_TRADE_ERROR = 871;

    /**
     * 查询用户订单列表数量
     */
    public static final int SELECT_CRM_TRADE_COUNT_ERROR = 872;

    /**
     * 当支付完成的时候修改订单的状态
     */
    public static final int UPDATE_TRADE_AND_ORDER_AFTER_PAYFINISH_ERROR = 873;

    /**
     * 查询产品快照失败
     */
    public static final int SELECT_SPRODUCT_BY_ORDER_EXCEPTION = 874;

    /**
     * 查询产品快照参数错误
     */
    public static final int SELECT_SPRODUCT_BY_ORDER_ERR_PARAM = 875;

    public static final int SELECT_ORDER_STATIC_INFO_ERROR = 876;

    /**
     * PSP发货orderSourceId错误
     */
    public static final int ERROR_SOURCE_ID_PSP_SEND = 877;

    /**
     * 用户已经帮砍过
     */
    public static final int BARGAIN_HELPER_EXISTS_ERROR = 878;

    /**
     * 订单导入操作失败
     */
    public static final int ERROR_UPDATE_ORDER_EXCEL_IMPORT = 879;

    /**
     * 解析物流回调信息失败
     */
    public static final int ERROR_PARSE_LOGISTICS_CALL_BACK_INFO = 880;

    /**
     * 前端展示错误信息
     */
    public static final int SHOW_ERROR_MESSAGE = 881;
}
