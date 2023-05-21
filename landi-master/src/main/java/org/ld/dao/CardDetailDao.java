package org.ld.dao;

import org.ld.model.CardDetail;

import java.util.List;

public interface CardDetailDao {
    /**
     * 查询证卡信息
     * */
    List<CardDetail> getCardDetails();
    /**
     * 按条件查询证卡信息
     * */
    List<CardDetail> getCardDetailsByConditions(CardDetail cardDetail);
    /**
     * 单个增加证卡信息
     * */
    void addCardDetail(CardDetail cardDetail);
    /**
     * 增加证卡信息
     * */
    void modifyCardDetail(CardDetail cardDetail);
    /**
     * 批量增加证卡信息
     * */
    void addCardDetails(List list);
    /**
     * 删除证卡信息
     * */
    void deleteCardDetail(List<String> idList);
}
