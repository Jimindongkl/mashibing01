package org.ld.service.congressService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.commonDao.SysAddDao;
import org.ld.dao.commonDao.SysSetDao;
import org.ld.dao.congressDao.AgendaDao;
import org.ld.dao.congressDao.CongressDao;
import org.ld.dao.congressDao.TopicDao;
import org.ld.model.commonModel.SysAdd;
import org.ld.model.commonModel.SysSet;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.model.congressModel.Topic;
import org.ld.service.commonService.ICommonService;
import org.ld.service.congressService.ITopicService;
import org.ld.utils.LowcaseToUppercase;
import org.ld.vo.ComboTree;
import org.ld.vo.MoveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.oscache.util.StringUtil;

@Service("topicService")
public class TopicServiceImpl implements ITopicService {

	@Autowired
	private TopicDao topicDao;

	@Autowired
	private CongressDao congressDao;

	@Autowired
	private AgendaDao agendaDao;

	@Autowired
	private SysAddDao sysAddDao;
	
	@Resource(name = "commonService")
	private ICommonService commonService;

	@Override
	public List<ComboTree> findCongressTree() {
		// 类型
		Map<String, Object> meetMap = new HashMap<String, Object>();
		meetMap.put("type", "meet");
		Map<String, Object> agendaMap = new HashMap<String, Object>();
		agendaMap.put("type", "agenda");
		Map<String, Object> topicMap = new HashMap<String, Object>();
		topicMap.put("type", "topic");
		Map<String, Object> topicLowerMap = new HashMap<String, Object>();
		topicLowerMap.put("type", "topicLower");
		Congress congress = new Congress();
		List<Congress> congressList = congressDao.findAllCongress(congress);
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		// 2,遍历相关联的
		for (Congress meet : congressList) {
			ComboTree combotree = new ComboTree();
			combotree.setId(meet.getId());
			combotree.setText(meet.getCongressName());
			combotree.setOrder(meet.getSerial());
			combotree.setAttributes(meetMap);
			combotree.setChildren(new ArrayList<ComboTree>());
			List<Agenda> agendas = agendaDao.findAllAgenda(meet.getId());
			// 获取全部议程
			for (Agenda agenda : agendas) {
				ComboTree comboNode = new ComboTree();
				comboNode.setId(agenda.getId());
				comboNode.setText(agenda.getAgName());
				comboNode.setOrder(agenda.getSerial());
				comboNode.setAttributes(agendaMap);
				comboNode.setChildren(new ArrayList<ComboTree>());
				List<Topic> topics = topicDao.findAllTopic(agenda.getId());
				// 获取议程下的全部议题
				for (Topic topic : topics) {
					ComboTree node = new ComboTree();
					node.setId(topic.getId());
					node.setText(topic.getToName());
					node.setOrder(topic.getNum());
					node.setAttributes(topicMap);
					node.setChildren(new ArrayList<ComboTree>());
					List<Topic> topicLowers = topicDao.findAllTopicLower(topic.getId());
					// 获取议程下的全部子议题
					for (Topic topicLower : topicLowers) {
						ComboTree nodeLower = new ComboTree();
						nodeLower.setId(topicLower.getId());
						nodeLower.setText(topicLower.getToName());
						nodeLower.setOrder(topicLower.getNum());
						nodeLower.setAttributes(topicLowerMap);
						node.getChildren().add(nodeLower);
					}
					comboNode.getChildren().add(node);
				}
				combotree.getChildren().add(comboNode);
			}
			comboTrees.add(combotree);
		}
		return comboTrees;
	}

	@Override
	public Topic getTopicId(Integer poticId) {

		return topicDao.getTopicId(poticId);
	}

	@Override
	public void addTopic(Topic topic, String treeType) {
		// 添加议题的时候增加议题参数设置
		//SysAdd sysAdds = sysAddDao.findSysAddModel();
		List<Map<String, Object>> s = commonService.findTopicNumSetting();
		Map<String,Integer> mapPut = new HashMap<>();
		for(int i=0;i<s.size();i++) {
			Map<String, Object> p = s.get(i);
			mapPut.put((String) p.get("title"), Integer.valueOf(p.get("value").toString()));
		}
		//议题类型1
		if(mapPut.get("议题类型")>0) {
				topic.setType(mapPut.get("议题类型"));
		}
		//发言模式2
		if(mapPut.get("发言模式")>0) {
			topic.setSpeakMode(mapPut.get("发言模式"));
		}
		//表决种类3
		if(mapPut.get("表决种类")>0) {
			topic.setVoteSpecies(mapPut.get("表决种类"));
		}
		//表决方式4
		if(mapPut.get("表决方式")>0) {
			topic.setVoteMethod(mapPut.get("表决方式"));
		}
		//表决基数5
		if(mapPut.get("表决基数")>0) {
			topic.setVoteBaseNum(mapPut.get("表决基数"));
		}
		//通过比例6
		if(mapPut.get("通过比例")>0) {
			topic.setPassRate(mapPut.get("通过比例"));
		}
		//显示方式7
		if(mapPut.get("显示方式")>0) {
			topic.setShowMode(mapPut.get("显示方式"));
		}
		//按键种类8
		if(mapPut.get("按键种类")>0) {
			topic.setButtonType(mapPut.get("按键种类"));
			List<SysSet> sysSetList=commonService.queryKeyNameList(mapPut.get("按键种类").toString());
			//5键
			if(sysSetList.size()==5) {
				topic.setButtonOneName(sysSetList.get(0).getsYSMemo());
				topic.setButtonTwoName(sysSetList.get(1).getsYSMemo());
				topic.setButtonThreeName(sysSetList.get(2).getsYSMemo());
				topic.setButtonFourName(sysSetList.get(3).getsYSMemo());
				topic.setButtonFiveName(sysSetList.get(4).getsYSMemo());
			} 
			//3键
			if(sysSetList.size()==3) {
				topic.setButtonOneName(sysSetList.get(0).getsYSMemo());
				topic.setButtonTwoName(sysSetList.get(1).getsYSMemo());
				topic.setButtonThreeName(sysSetList.get(2).getsYSMemo());
			}
		}
		Date d = new Date();
		// 增加议题
		if ("agenda".equals(treeType)) {
			Integer value = 1;
			// 查询议程下排序最大的议程
			if (topic.getAgenda().getId() != null) {
				Integer max = topicDao.findAgendaMaxorder(topic.getAgenda().getId());
				if (max != null) {
					value = max; 
					value = value + 1;
				}
			}
			// 拼接议题的名称
			//String toName = "议题" + value;
			//topic.setToName(toName);
			topic.setNum(value);
			topic.setCreateTime(d);
			topic.setUpdateTime(d);
			topic.setParentGUID(topic.getAgenda().getId());
			topic.setTopicLower(0);
			// 增加子议题
		} else if ("topic".equals(treeType)) {
			topic.setTopicId(topic.getId());	
			Integer valueL = 1;
			// 查询议程下排序最大的议程
			if (topic.getTopicId() != null) {
				Integer maxTopic = topicDao.findTopicMaxorder(topic.getTopicId());
				if (maxTopic != null) {
					valueL = maxTopic + 1;
				}
			}
			// 拼接议题的名称
			//String toName = "子议题" + valueL;
			//topic.setToName(toName);
			topic.setCreateTime(d);
			topic.setUpdateTime(d);
			topic.setNum(valueL);
			topic.setParentGUID(topic.getAgenda().getId());
			topic.setTopicLower(topic.getId());
		}
		topicDao.addTopic(topic);
	}

	@Override
	public void delectTopics(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			topicDao.delectTopics(idList);
		}
	}

	@Override
	public void updateTopicMiracast(Topic topic) {
		topic.setUpdateTime(new Date());
		topicDao.updateTopicMiracast(topic);
	}

	@Override
	public void updateTopicParam(Topic topic) {
		topic.setUpdateTime(new Date());
		topicDao.updateTopicParam(topic);
	}

	@Override
	public void UpdateTopicTreeOrder(MoveVo moveVo) {
		// 调换序号
		Topic topicA = new Topic();
		Topic topicB = new Topic();
		List<Topic> topics = new ArrayList<>();
		topicA.setId(moveVo.getPitchOnId());
		topicA.setNum((int)moveVo.getBorderOrder());
		topicB.setId(moveVo.getBorderId());
		topicB.setNum((int)moveVo.getPitchOnOrder());
		topics.add(topicA);
		topics.add(topicB);
		// 批量修改
		topicDao.updateBatchTopicTrees(topics);

	}

	@Override
	public Topic queryTopictoContent(Integer topicId) {
		// TODO Auto-generated method stub
		return topicDao.queryTopictoContent(topicId);
	}

	@Override
	public void updateTopicCongressAgenda(Topic topic) {
		// TODO Auto-generated method stub
		topicDao.updateTopicCongressAgenda(topic);
	}

	@Override
	public void updateTopicStatus(Integer topicId) {
		// TODO Auto-generated method stub
		topicDao.updateTopicStatus(topicId);
	}

	@Override 
	public void updateTopicToPreStart(Integer topicId) {
		// TODO Auto-generated method stub
		topicDao.updateTopicToPreStart(topicId);
	}

	
	@Override
	public void updateTopicCongressAgendaTopicLower(Topic topic) {
		// TODO Auto-generated method stub
		topicDao.updateTopicCongressAgendaTopicLower(topic);
	}
}
