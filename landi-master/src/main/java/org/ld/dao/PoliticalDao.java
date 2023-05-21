package org.ld.dao;

import java.util.List;

import org.ld.model.Dictionary;

public interface PoliticalDao {

	List<Dictionary> politicalList();

	Dictionary findDictionaryId(Dictionary dictionary);
	
	

}
