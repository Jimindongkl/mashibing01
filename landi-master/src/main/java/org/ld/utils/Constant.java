package org.ld.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 会议状态
 * */
public  enum  Constant {

    StartSession(0,"开始会议"),
    StartReport(1,"开始报到"),
    Reporting(2,"正在报到"),
    StopReport(3,"结束报到"),
    StartTopic(4,"开始议题"),
    StartSpeak(5,"开始发言"),
    Speaking(6,"正在发言"),
    StopSpeak(7,"结束发言"),
    StartVote(8,"开始表决"),
    Voting(9,"正在表决"),
    StopVote(10,"结束表决"),
    StartAppraise(11,"开始评测"),
    Appraising(12,"正在评测"),
    StopAppraise(13,"结束评测"),
    StartMuchVote(14,"开始定制表决"),
    MuchVoting(15,"正在定制表决"),
    StopMuchVote(16,"结束定制表决"),
    StartMuchAppraise(17,"开始多项评测"),
    MuchAppraising(18,"正在多项评测"),
    StopMuchAppraise(19,"结束多项评测"),
    StartAsk(20,"开始专题询问"),
    AskOneing(21,"询问"),
    AskTwoing(22,"回答"),
    AskThreeing(23,"追问"),
    AskFouring(24,"总结"),
    StopAsking(25,"结束专题询问"),
    StopTopic(26,"结束议题"),
    StopSession(27,"结束会议"),
    StartPledge(28,"开始宣誓"),
    StartSing(29,"国歌"),
    StartScoring(30,"开始打分"),
    Scoring(31,"正在打分"),
    EndScoring(32,"结束打分"),
    StartMuchScoring(33,"开始多项打分"),
    MuchScoring(34,"正在多项打分"),
    EndMuchScoring(35,"结束多项打分"),
    BeforPledge(36,"宪法宣誓仪式"),
    TypeOne(37,"模式1"),
    TypeTwo(38,"模式2"),
    TypeThree(39,"模式3"),
    TypeFore(40,"模式4"),
    TypeFive(41,"模式5"),
    UnStart(-1,"会议尚未开始")
    ;
    private static final Logger LOGGER = LoggerFactory.getLogger(Constant.class);

    private static Constant getConstantEnumByKey(int key){
        for(Constant constantEnum : Constant.values()){
                if(key == constantEnum.getCode()){
                    return constantEnum;
                }
        }
        return null;

    }
    /**
     *
     * @param status 前端正在进行的会序
     * 会序反馈处理*/
    public static int CongressOrderConversion(int status){
        int ControlReport = 1;// 1. 报道控制 对应 -1,0,1,2
        int DiscussionTopics = 2;//  2.议题讨论 对应 3,4,6,7,25,26,27,28
        int ControlSpeech = 3;// 3.发言控制 对应 5,20,21,22,23,24
        int ControlledVoting = 4;// 4.表决控制 对应 8-19 29-35
        int result = 0;
        switch (Constant.getConstantEnumByKey(status)){
            //1. 报道控制 对应 -1,0,1,2
            case UnStart: result = ControlReport;
                break;
            case StartSession : result = ControlReport ;
                break;
            case StartReport: result = ControlReport ;
                break;
            case Reporting: result = ControlReport ;
                break;
            //  2.议题讨论 对应 3,4,6,7,25,26,27,28
            case StopReport: result = DiscussionTopics ;
                break;
            case StartTopic: result = DiscussionTopics ;
                break;
            case Speaking: result = DiscussionTopics;
                break;
            case StopSpeak:result = DiscussionTopics;
                break;
            case StopAsking: result = DiscussionTopics ;
                break;
            case StopTopic: result = DiscussionTopics ;
                break;
            case StopSession: result = DiscussionTopics ;
                break;
            case StartPledge : result = DiscussionTopics;
                break;
            //  3.发言控制 对应 5,20,21,22,23,24
            case StartSpeak: result = ControlSpeech ;
                break;
            case StartAsk: result = ControlSpeech ;
                break;
            case AskOneing: result = ControlSpeech ;
                break;
            case AskTwoing: result = ControlSpeech ;
                break;
            case AskThreeing: result = ControlSpeech ;
                break;
            case AskFouring: result = ControlSpeech;
                break;
            //  4.表决控制 对应 8-19 29-35
            case StartVote: result = ControlledVoting ;
                break;
            case Voting: result = ControlledVoting ;
                break;
            case StopVote: result = ControlledVoting ;
                break;
            case StartAppraise: result = ControlledVoting ;
                break;
            case Appraising: result = ControlledVoting ;
                break;
            case StopAppraise: result = ControlledVoting ;
                break;
            case StartMuchVote: result = ControlledVoting ;
                break;
            case MuchVoting: result = ControlledVoting ;
                break;
            case StopMuchVote: result = ControlledVoting ;
                break;
            case StartMuchAppraise: result = ControlledVoting ;
                break;
            case MuchAppraising: result = ControlledVoting ;
                break;
            case StopMuchAppraise: result = ControlledVoting ;
                break;
            case StartSing: result = ControlledVoting;
                break;
            case StartScoring: result = ControlledVoting;
                break;
            case Scoring: result = ControlledVoting;
                break;
            case EndScoring: result = ControlledVoting;
                break;
            case StartMuchScoring: result = ControlledVoting;
                break;
            case MuchScoring: result = ControlledVoting;
                break;
            case EndMuchScoring: result = ControlledVoting;
                break;

        }
        LOGGER.info("-------------/ 会议目前状态 ：" + Constant.getConstantEnumByKey(status).getType()+" /--------------------------");
        return result;
    }
    /**会序编码*/
    private int	code;
    /**目前会议状态*/
    private String	type;

    Constant(int code,String type){
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
