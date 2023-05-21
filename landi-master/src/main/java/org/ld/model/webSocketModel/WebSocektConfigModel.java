package org.ld.model.webSocketModel;

/**
 * @program: landi-master
 * @description: WebSocket发送消息的配置信息
 * @author: 魏中元
 * @create: 2021-01-19 15:25
 **/
public class WebSocektConfigModel {
    /**是否有浏览权 默认为ture*/
    private String EnabledBrowseAll;
    /**是否有呼叫权*/
    private String EnabledCallAll;
    /**是否有发言权*/
    private String EnabledSpeakAll;
    /**是否有报道权*/
    private String EnabledCheckedInAll;
    /**是否有表决权*/
    private String EnabledVoteAll;
    /**是否显示报到结果*/
    private String ShowCheckInResult;
    /**卡模式*/
    private String ICOutType;
    /**最大发言容量 默认6*/
    private String MaxSpeakSumTogether;
    /**优先发言键按下时是否关闭其他发言设备 默认为true*/
    private String SpeakFirstCloseClient;
    /**表决结果显示模式*/
    private String VoteShowType;
    /**发言模式*/
    private String CSpeakMothod;
    /**表决模式*/
    private String ToVoteMethod;

    public String getEnabledBrowseAll() {
        return EnabledBrowseAll;
    }

    public void setEnabledBrowseAll(String enabledBrowseAll) {
        EnabledBrowseAll = enabledBrowseAll;
    }

    public String getEnabledCallAll() {
        return EnabledCallAll;
    }

    public void setEnabledCallAll(String enabledCallAll) {
        EnabledCallAll = enabledCallAll;
    }

    public String getEnabledSpeakAll() {
        return EnabledSpeakAll;
    }

    public void setEnabledSpeakAll(String enabledSpeakAll) {
        EnabledSpeakAll = enabledSpeakAll;
    }

    public String getEnabledCheckedInAll() {
        return EnabledCheckedInAll;
    }

    public void setEnabledCheckedInAll(String enabledCheckedInAll) {
        EnabledCheckedInAll = enabledCheckedInAll;
    }

    public String getEnabledVoteAll() {
        return EnabledVoteAll;
    }

    public void setEnabledVoteAll(String enabledVoteAll) {
        EnabledVoteAll = enabledVoteAll;
    }

    public String getShowCheckInResult() {
        return ShowCheckInResult;
    }

    public void setShowCheckInResult(String showCheckInResult) {
        ShowCheckInResult = showCheckInResult;
    }

    public String getICOutType() {
        return ICOutType;
    }

    public void setICOutType(String ICOutType) {
        this.ICOutType = ICOutType;
    }

    public String getMaxSpeakSumTogether() {
        return MaxSpeakSumTogether;
    }

    public void setMaxSpeakSumTogether(String maxSpeakSumTogether) {
        MaxSpeakSumTogether = maxSpeakSumTogether;
    }

    public String getSpeakFirstCloseClient() {
        return SpeakFirstCloseClient;
    }

    public void setSpeakFirstCloseClient(String speakFirstCloseClient) {
        SpeakFirstCloseClient = speakFirstCloseClient;
    }

    public String getVoteShowType() {
        return VoteShowType;
    }

    public void setVoteShowType(String voteShowType) {
        VoteShowType = voteShowType;
    }

    public String getCSpeakMothod() {
        return CSpeakMothod;
    }

    public void setCSpeakMothod(String CSpeakMothod) {
        this.CSpeakMothod = CSpeakMothod;
    }

    public String getToVoteMethod() {
        return ToVoteMethod;
    }

    public void setToVoteMethod(String toVoteMethod) {
        ToVoteMethod = toVoteMethod;
    }
}
