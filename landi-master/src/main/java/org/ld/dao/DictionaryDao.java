package org.ld.dao;

import org.ld.model.Dictionary;

import java.util.List;

public interface DictionaryDao {

    //通用下拉
    List<Dictionary> getDictionaryByStr(String str);
}
