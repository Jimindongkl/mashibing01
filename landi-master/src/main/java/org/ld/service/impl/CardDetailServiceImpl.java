package org.ld.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.ld.dao.CardDetailDao;
import org.ld.model.CardDetail;
import org.ld.service.ICardDetailService;
import org.ld.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service("cardDetailService")
public class CardDetailServiceImpl implements ICardDetailService {
    @Autowired
    private CardDetailDao cardDetailDao;

    @Override
    public List<CardDetail> getCardDetails() {
        List<CardDetail> cardDetails ;
        cardDetails = cardDetailDao.getCardDetails();
        return cardDetails;
    }

    @Override
    public List<CardDetail> getCardDetailsByConditions(CardDetail cardDetail) {
        List<CardDetail>cardDetails;
        cardDetails = cardDetailDao.getCardDetailsByConditions(cardDetail);
        return cardDetails;
    }

    @Override
    public void addOrUpdateCardDetail(CardDetail cardDetail) {
        if(cardDetail.getId() != null){
            cardDetailDao.modifyCardDetail(cardDetail);
        }else{
            cardDetailDao.addCardDetail(cardDetail);
        }
    }

    @Override
    public void addCardDetails(CardDetail cardDetails,String str) {
        JSONArray jsonArray = JSON.parseArray(str);
        List<CardDetail> cardDetailList = new ArrayList<>();
        int size = jsonArray.size();
        for(int i = 0; i < size; i++){//根据前端传入的json 拼接list后 插入数据库
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            CardDetail seatUnits = new CardDetail();
//            seatUnits.setId(1);//自动增加id 还是插入指定id 看前端要求
            seatUnits.setCardCode(jsonObject.getString("cardcode"));
            seatUnits.setCd_Num(jsonObject.getIntValue("Num"));
            seatUnits.setTypeID(jsonObject.getString("typeID"));
            seatUnits.setIsEnabled(jsonObject.getIntValue("isEnabled"));
            seatUnits.setRemark(jsonObject.getString("remark"));
            seatUnits.setStaffID(jsonObject.getString("staffID"));
            cardDetailList.add(seatUnits);
        }
        cardDetailDao.addCardDetails(cardDetailList);
    }
    @Override
    public void deleteCardDetail(String ids) {
        List idList;
        idList =  Util.StringPareList(ids);
        cardDetailDao.deleteCardDetail(idList);
    }
}