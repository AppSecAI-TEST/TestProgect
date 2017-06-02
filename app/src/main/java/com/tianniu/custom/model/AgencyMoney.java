package com.tianniu.custom.model;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class AgencyMoney {
    private long id;//	Long	订单表ID
    private String goodsOrderNo;//	String	运单号
    private String carOwnerTelephone;//	String	车主联系电话
    private int payAgencyMoney;//	Integer	已付信息费金额（分）
    private long payEndTime;//	long	车主支付成功的时间(毫秒)
    private int payChannel;//	Integer	1支付宝 2易宝/银行卡 3微信
    private long goodsOwnerAgreeTime;//	long	货主同意装货时间（毫秒）
    private long carOwnerLoadfinishedTime;//	long	车主装货完成时间（毫秒）

    /**
     * 接单状态0待接单 1接单成功  2货主拒绝 3系统拒绝  4同意装货 5车主装货完成
     * 6系统装货完成 7异常上报 8货主撤销货源退款 9系统撤销货源退款
     * 10车主取销装货
     * 11接单失败（用户同意别人装货，对没有支付成功的支付信息的操作状态）
     * @return
     */
    public String getRobStatus() {
        return robStatus;
    }

    public void setRobStatus(String robStatus) {
        this.robStatus = robStatus;
    }

    /**
     * 接单状态0待接单 1接单成功  2货主拒绝 3系统拒绝  4同意装货 5车主装货完成  6系统装货完成 7异常上报 8货主撤销货源退款 9系统撤销货源退款 10车主取销装货 11接单失败（用户同意别人装货，对没有支付成功的支付信息的操作状态）
     */
    private String robStatus;
    public long getCarOwnerUserId() {
        return carOwnerUserId;
    }

    public void setCarOwnerUserId(long carOwnerUserId) {
        this.carOwnerUserId = carOwnerUserId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoodsOrderNo() {
        return goodsOrderNo;
    }

    public void setGoodsOrderNo(String goodsOrderNo) {
        this.goodsOrderNo = goodsOrderNo;
    }

    public String getCarOwnerTelephone() {
        return carOwnerTelephone;
    }

    public void setCarOwnerTelephone(String carOwnerTelephone) {
        this.carOwnerTelephone = carOwnerTelephone;
    }

    /**
     * 已付信息费金额（分）
     */
    public int getPayAgencyMoney() {
        return payAgencyMoney;
    }

    public void setPayAgencyMoney(int payAgencyMoney) {
        this.payAgencyMoney = payAgencyMoney;
    }

    /**
     * 车主支付成功的时间(毫秒)
     * @return
     */
    public long getPayEndTime() {
        return payEndTime;
    }


    public void setPayEndTime(long payEndTime) {
        this.payEndTime = payEndTime;
    }

    /**
     * 1支付宝 2易宝/银行卡 3微信
     * @return
     */
    public String getPayChannelString() {

        String result="其它";
        if(1==payChannel){
            result="支付宝支付";
        }else if(2==payChannel){
            result="银行卡支付";
        }else if(3==payChannel){
            result="微信支付";
        }else{

        }
        return result;
    }

    /**
     * 1支付宝 2易宝/银行卡 3微信
     * @return
     */
    public int getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(int payChannel) {
        this.payChannel = payChannel;
    }

    public long getGoodsOwnerAgreeTime() {
        return goodsOwnerAgreeTime;
    }

    public void setGoodsOwnerAgreeTime(long goodsOwnerAgreeTime) {
        this.goodsOwnerAgreeTime = goodsOwnerAgreeTime;
    }



    public long getCarOwnerLoadfinishedTime() {
        return carOwnerLoadfinishedTime;
    }

    public void setCarOwnerLoadfinishedTime(long carOwnerLoadfinishedTime) {
        this.carOwnerLoadfinishedTime = carOwnerLoadfinishedTime;
    }

    private long carOwnerUserId;//	Long	车主用户ID

}
