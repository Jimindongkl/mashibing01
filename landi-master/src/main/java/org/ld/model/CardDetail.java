package org.ld.model;
/**
 * 证卡人员关联关系表
 * */
public class CardDetail {

    private Integer Id;
    //人员ID
    private String StaffID;
    //证卡类型
    private String TypeID;
    //证卡编码
    private String CardCode;
    //证卡状态
    private Integer IsEnabled;
    //序号
    private Integer cd_Num;
    //备注
    private String Remark;
    //会议ID
    private String CongressID;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        this.StaffID = staffID;
    }

    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String typeID) {
        TypeID = typeID;
    }

    public String getCardCode() {
        return CardCode;
    }

    public void setCardCode(String cardCode) {
        CardCode = cardCode;
    }

    public Integer getIsEnabled() {
        return IsEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.IsEnabled = isEnabled;
    }

    public Integer getCd_Num() {
        return cd_Num;
    }

    public void setCd_Num(Integer cd_Num) {
        this.cd_Num = cd_Num;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getCongressID() {
        return CongressID;
    }

    public void setCongressID(String congressID) {
        CongressID = congressID;
    }
}
