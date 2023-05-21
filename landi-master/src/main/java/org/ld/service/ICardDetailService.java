package org.ld.service;

import org.ld.model.CardDetail;
import java.util.List;
public interface ICardDetailService {
    /**
     * 查询证卡信息
     * */
    List<CardDetail> getCardDetails();
    /**
     * 按条件查询证卡信息
     * */
    List<CardDetail> getCardDetailsByConditions(CardDetail cardDetail);
    /**
     * 增加或修改证卡信息
     * */
    void addOrUpdateCardDetail(CardDetail cardDetail);
    /**
     * 批量增加证卡信息
     * TODO 等前端传后端的数据格式确定后，处理数据后做批量新增
     * */
    void addCardDetails(CardDetail cardDetails,String str);
    /**
     * 删除证卡信息
     * */
    void deleteCardDetail(String ids);
}
