package org.ld.vo;

import org.ld.model.Message;

import java.io.UnsupportedEncodingException;

//报文 vo 处理纯字符串时用到
public class MessageByStr{
    //报文头
    private String  head;
    //主指令
    private String mainInstruction;
    //子指令
    private String childInstruction;
    //长度高位
    private String high;
    //长度地位
    private String low;
    //文本内容
    private String content;
    //校验高位
    private String checkHigh;
    //校验低位
    private String checkLow;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMainInstruction() {
        return mainInstruction;
    }

    public void setMainInstruction(String mainInstruction) {
        this.mainInstruction = mainInstruction;
    }

    public String getChildInstruction() {
        return childInstruction;
    }

    public void setChildInstruction(String childInstruction) {
        this.childInstruction = childInstruction;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(content.equals("")){
            this.content = content;
        }else{
            try {
                StringBuffer sb = new StringBuffer();
                byte[] temp = content.getBytes("UTF-8");
                sb.append('[');
                for (int i = 0; i < temp.length; ++i)
                    sb.append(i == 0 ? "" : ", ").append(temp[i]);
                sb.append(']');
                this.content = sb.toString();
            } catch (UnsupportedEncodingException e) {
                System.out.println("内容转BYTE数组出错！！！！");
                e.printStackTrace();
            }
        }

    }

    public String getCheckHigh() {
        return checkHigh;
    }

    public void setCheckHigh(String checkHigh) {
        this.checkHigh = checkHigh;
    }

    public String getCheckLow() {
        return checkLow;
    }

    public void setCheckLow(String checkLow) {
        this.checkLow = checkLow;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MessageByStr{");
        sb.append("head='").append(head).append('\'');
        sb.append(", mainInstruction='").append(mainInstruction).append('\'');
        sb.append(", childInstruction='").append(childInstruction).append('\'');
        sb.append(", high='").append(high).append('\'');
        sb.append(", low='").append(low).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", checkHigh='").append(checkHigh).append('\'');
        sb.append(", checkLow='").append(checkLow).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
