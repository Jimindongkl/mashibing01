package org.ld.controller;

import org.ld.model.CardDetail;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.ICardDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 证卡管理ctr
 * */
@Controller
@RequestMapping("/cardDeatilController")
public class CardDeatilController {
    @Resource(name = "cardDetailService")
    private ICardDetailService cardDetailService;
//    @RequestMapping("/openWebSocket")
//    public void openWebSocket() throws Exception{
//        new WebSocketServers(3001).start();
//    }
    /**
     * 查询全部证卡信息
     * */
    @RequestMapping("/getCardDetails")
    @ResponseBody
    public ResponseServer getCardDetails(){
        Map map = new HashMap();
        List<CardDetail> cardDetailList ;
        cardDetailList = cardDetailService.getCardDetails();
        map.put("cardDetailList",cardDetailList );
        return ResponseServer.success(map);
    }
    /**
     * 按条件查询 证卡信息
     * */
    @RequestMapping("/getCardDetailsByConditions")
    @ResponseBody
    public ResponseServer getCardDetailsByConditions(CardDetail cardDetail){
        Map map = new HashMap();
        List<CardDetail> cardDetails ;
        cardDetails = cardDetailService.getCardDetailsByConditions(cardDetail);
        map.put("cardDetails", cardDetails);
        return ResponseServer.success(map);
    }
    /**
     * 单个添加或修改 证卡信息
     * */
    @RequestMapping("/addOrUpdateCardDetail")
    @ResponseBody
    public ResponseServer addOrUpdateCardDetail(CardDetail cardDetail){
        cardDetailService.addOrUpdateCardDetail(cardDetail);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }
    /**
     * 批量增加证卡信息
     * */
    @RequestMapping("/addCardDetails")
    @ResponseBody
    public ResponseServer addCardDetails(CardDetail cardDetail,String str){
        cardDetailService.addCardDetails(cardDetail, str);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }
    /**
     * 批量删除证卡信息
     * */
    @RequestMapping("/deleteCardDetail")
    @ResponseBody
    public ResponseServer deleteCardDetail(String ids){
        cardDetailService.deleteCardDetail(ids);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }
}