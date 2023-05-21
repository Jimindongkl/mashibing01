package org.ld.controller;

import org.ld.dao.DictionaryDao;
import org.ld.model.Dictionary;
import org.ld.response.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/** 通用字典
 * 传入字典类型 返回对应字典值
 * */
@Controller
@RequestMapping("/generalDictionaryClr")
public class GeneralDictionaryClr {

    @Autowired
    private DictionaryDao dictionaryDao;

    @RequestMapping("/getDictionaryByStr")
    @ResponseBody
    public ResponseServer getDictionaryByStr(String str){
        List<Dictionary> dictionaryList = new ArrayList<>();

        dictionaryList =dictionaryDao.getDictionaryByStr(str);

        return ResponseServer.success(dictionaryList);
    }
}
