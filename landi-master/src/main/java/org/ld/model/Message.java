package org.ld.model;
//报文
public class Message {
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
    private byte[] content;
    //校验高位
    private byte checkHigh;
    //校验低位
    private byte checkLow;

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte getCheckHigh() {
        return checkHigh;
    }

    public void setCheckHigh(byte checkHigh) {
        this.checkHigh = checkHigh;
    }

    public byte getCheckLow() {
        return checkLow;
    }

    public void setCheckLow(byte checkLow) {
        this.checkLow = checkLow;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Message{");
        sb.append("head :'").append(head).append('\'');
        sb.append(", mainInstruction :'").append(mainInstruction).append('\'');
        sb.append(", childInstruction :'").append(childInstruction).append('\'');
        sb.append(", high :'").append(high).append('\'');
        sb.append(", low :'").append(low).append('\'');
        sb.append(", content :");
        if (content == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < content.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(content[i]);
            sb.append(']');
        }
        sb.append(", checkHigh :").append(checkHigh);
        sb.append(", checkLow :").append(checkLow);
        sb.append('}');
        return sb.toString();
    }
}
