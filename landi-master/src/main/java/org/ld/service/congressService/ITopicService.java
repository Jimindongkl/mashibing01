package org.ld.service.congressService;

import java.util.List;

import org.ld.model.congressModel.Topic;
import org.ld.vo.ComboTree;
import org.ld.vo.MoveVo;

public interface ITopicService {

	List<ComboTree> findCongressTree();

	Topic getTopicId(Integer poticId);

	void addTopic(Topic topic, String treeType);

	void delectTopics(String ids);

	void updateTopicMiracast(Topic topic);

	void updateTopicParam(Topic topic);

	void UpdateTopicTreeOrder(MoveVo moveVo);

	Topic queryTopictoContent(Integer topicId);
	
	void updateTopicCongressAgenda(Topic topic);

	void updateTopicStatus(Integer topicId);
	
    void updateTopicToPreStart(Integer topicId);
    
	void updateTopicCongressAgendaTopicLower(Topic topic);

}
