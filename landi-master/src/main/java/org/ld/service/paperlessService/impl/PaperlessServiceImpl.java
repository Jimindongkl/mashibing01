package org.ld.service.paperlessService.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.congressDao.AgendaDao;
import org.ld.dao.congressDao.AgendaPersonDao;
import org.ld.dao.congressDao.CongressDao;
import org.ld.dao.congressDao.TopicDao;
import org.ld.dao.fileDao.CongressBulletinFileDao;
import org.ld.dao.fileDao.CongressFileDao;
import org.ld.dao.paperlessDao.PaperlessDao;
import org.ld.dao.paperlessDao.PersoncongressFileDao;
import org.ld.dao.paperlessDao.PersoncongressTextDao;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.model.congressModel.Topic;
import org.ld.model.fileModel.CongressBulletinFile;
import org.ld.model.fileModel.CongressFile;
import org.ld.model.paperlessModel.PersoncongressFile;
import org.ld.model.paperlessModel.PersoncongressText;
import org.ld.model.paperlessModel.StaffInfoSelfModel;
import org.ld.service.paperlessService.IPaperlessService;
import org.ld.utils.PropertiesUtil;
import org.ld.vo.AgendaSeatUitStaffInfoVo;
import org.ld.vo.ComboTree;
import org.ld.vo.PaperlessFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("paperlessService")
public class PaperlessServiceImpl implements IPaperlessService{

	@Autowired
	private PaperlessDao paperlessDao;
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private CongressFileDao congressFileDao;
	
	@Autowired
	private AgendaDao agendaDao;
	
	@Autowired
	private AgendaPersonDao agendaPersonDao;
	
	@Autowired
	private CongressDao congressDao;
	
	@Autowired
	private CongressBulletinFileDao congressBulletinFileDao;
	
	@Autowired
	private PersoncongressTextDao personcongressTextDao;
	
	@Autowired
	private PersoncongressFileDao personcongressFileDao;
	
	
	@Override
	public Agenda findPaperlessNowAgenda(Integer status) {
	
		return agendaDao.findPaperlessNowAgenda(status);
	}
	
	
	@Override
	public List<PaperlessFile> findPaperlessNowTopicFile(Integer status) {
		 //查询当前的议题和会议及议程的详细信息
		 List<Map> topics = topicDao.findPaperlessNowTopics(status);
		 List<PaperlessFile> paperlessFiles = new ArrayList<>();
		 //遍历议题下的文件
		 for(int i=0;i<topics.size();i++) {
			 PaperlessFile paperlessFile = new PaperlessFile();
			 //会议,议程,议题,子议题的主键id
			 Integer congressId = (Integer) topics.get(i).get("congressId");
			 Integer agendaId = (Integer) topics.get(i).get("agendaId");
			 Integer topicId = (Integer) topics.get(i).get("topicId");
			 Integer topicLower =(Integer) topics.get(i).get("topicLower");
			 //放入各个实体类中
			 paperlessFile.setCongressId(congressId);
			 paperlessFile.setCongressName((String)topics.get(i).get("congressName"));
			 paperlessFile.setAgendaId(agendaId);
			 paperlessFile.setAgendaName((String)topics.get(i).get("agendaName"));
			 paperlessFile.setTopicId((topicId));
			 paperlessFile.setTopicName((String)topics.get(i).get("topicName"));
			 paperlessFile.setTopicLower(topicLower);
			 if(congressId!=null&&agendaId!=null&&topicId!=null&&topicLower==0) {
				 //查询议题下的文件
				 CongressFile congressFile = new CongressFile();
				 congressFile.setAgendaID(agendaId);
				 congressFile.setCongressID(congressId);
				 congressFile.setTopicID(topicId);
				 List<CongressFile> congressFiles = congressFileDao.findCongressFiles(congressFile);
				 paperlessFile.setChildrenFile(congressFiles);
				 //查询子议题
				List<Topic> sunTopics = topicDao.findAllTopicLower(topicId);
				if(sunTopics.size()>0) {
					List<PaperlessFile> sunPaperlessFiles = new ArrayList<>();
					for(int j=0;j<sunTopics.size();j++) {
						 PaperlessFile sunPaperlessFile = new PaperlessFile();
						 //放入各个实体类中
						 sunPaperlessFile.setCongressId(sunTopics.get(j).getCongress().getId());
						 sunPaperlessFile.setCongressName((String)topics.get(i).get("congressName"));
						 sunPaperlessFile.setAgendaId(sunTopics.get(j).getAgenda().getId());
						 sunPaperlessFile.setAgendaName((String)topics.get(i).get("agendaName"));
						 sunPaperlessFile.setTopicId(sunTopics.get(j).getId());
						 sunPaperlessFile.setTopicName(sunTopics.get(j).getToName());
						 sunPaperlessFile.setTopicLower(sunTopics.get(j).getTopicLower());
						 //查询议题下的文件
						 CongressFile sunCongressFile = new CongressFile();
						 sunCongressFile.setAgendaID(agendaId);
						 sunCongressFile.setCongressID(congressId);
						 sunCongressFile.setTopicID(sunTopics.get(j).getId());
						 List<CongressFile> sunCongressFiles = congressFileDao.findCongressFiles(sunCongressFile);
						 sunPaperlessFile.setChildrenFile(sunCongressFiles);
						 sunPaperlessFiles.add(sunPaperlessFile);
					}
					paperlessFile.setSunPaperlessFileList(sunPaperlessFiles);
				}
			 }
			 paperlessFiles.add(paperlessFile);
		 }
		return  paperlessFiles;
	}


	@Override
	public AgendaSeatUitStaffInfoVo findAgendaAndSeatQueryStaffInfo(Integer agendId, Integer suId) {
		
		return agendaPersonDao.findAgendaAndSeatQueryStaffInfo(agendId,suId);
	}

	@Override
	public List<Map> findPaperlessNowCongress(Integer status) {
		
		return topicDao.findPaperlessNowTopics(status);
	}


	@Override
	public Congress findPaperlessNowCongressModel(Integer status) {
		
		
		return congressDao.findPaperlessNowCongressModel(status);
	}


	@Override
	public List<CongressBulletinFile> findPaperlessNowCongressScheduleFile(Integer congressId, Integer fileType) {
		
		return congressBulletinFileDao.findPaperlessNowCongressScheduleFile(congressId,fileType);
	}


	@Override
	public List<ComboTree> findOneselfHistoryMeeting(StaffInfoSelfModel staffInfoSelf) {
		//1,拿着人员的id查询都开过那些会议
		//2，查看会议下的日程及议题文件
		//成为一z——tree
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
		List<Congress> congressList=congressDao.findOneselfCongress(staffInfoSelf);
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		// 2,遍历相关联的
		for (Congress meet : congressList) {
			ComboTree combotree = new ComboTree();
			combotree.setId(meet.getId());
			combotree.setText(meet.getCongressName());
			//开始时间，结束时间
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(meet.getStartTime()!=null) {
				String start =d.format(meet.getStartTime());
				combotree.setStartDate(start);
			}
			if(meet.getEndTime()!=null) {
				String end = d.format(meet.getEndTime());
				combotree.setEndDate(end);
			}
			//报道方式
			combotree.setCheckInType(meet.getDicName());
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
					//议题下的文件
					List<CongressFile> congressFiles = new ArrayList<>();
					if(meet.getId()!=null&&agenda.getId()!=null&&topic.getId()!=null) {
						CongressFile congressFile = new CongressFile();
						congressFile.setCongressID(meet.getId());
						congressFile.setAgendaID(agenda.getId());
						congressFile.setTopicID(topic.getId());
						congressFiles = congressFileDao.findCongressFiles(congressFile);
					}
					node.setFiles(congressFiles);
					List<Topic> topicLowers = topicDao.findAllTopicLower(topic.getId());
					// 获取议程下的全部子议题
					for (Topic topicLower : topicLowers) {
						ComboTree nodeLower = new ComboTree();
						nodeLower.setId(topicLower.getId());
						nodeLower.setText(topicLower.getToName());
						nodeLower.setOrder(topicLower.getNum());
						nodeLower.setAttributes(topicLowerMap);
						List<CongressFile> congressFileList = new ArrayList<>();
						if(meet.getId()!=null&&agenda.getId()!=null&&topicLower.getId()!=null) {
							CongressFile congressFile = new CongressFile();
							congressFile.setCongressID(meet.getId());
							congressFile.setAgendaID(agenda.getId());
							congressFile.setTopicID(topicLower.getId());
							congressFiles = congressFileDao.findCongressFiles(congressFile);
						}
						nodeLower.setFiles(congressFileList);
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
	public void compileOneselfTextPiZhu(String strText) {
		JSONArray ay = JSONArray.fromObject(strText);
		//Integer PID = 0;
		//存放修改文字批注的List
		List<PersoncongressText> updatePersoncongressTextList = new ArrayList<>();
		//存放增加文字批注的List
		List<PersoncongressText> addPersoncongressTextList = new ArrayList<>();
		if(ay.size()>0) {
			for(int i=0;i<ay.size();i++) {
				JSONObject job = ay.getJSONObject(i);
				//伪ID falseID
				String falseid=job.get("falseID").toString();
				//查库，有数据这为修改，无数据则为增加
				List<PersoncongressText> personcongressTextList=personcongressTextDao.findFalseIDList(falseid);
				if(personcongressTextList.size()>0) {
					//修改
					PersoncongressText updateText = new PersoncongressText();
					//伪id
					String falseID = job.get("falseID").toString();
					updateText.setFalseID(falseID);
					//批注的内容
					String text = job.get("text").toString();
					updateText.setText(text);
					//是否展开
					boolean isOpen = Boolean.parseBoolean("true");
					String str = job.getString("isOpen");
					updateText.setOpen(isOpen);
					//x轴
					double x=Double.parseDouble(job.getString("x"));
					updateText.setX(x);
					//y轴
					double y=Double.parseDouble(job.getString("y"));
					updateText.setY(y);
					//字体大小
					Integer fontSize =Integer.valueOf(job.get("fontSize").toString()) ;
					updateText.setFontSize(fontSize);
					//页码
					Integer pageNum =Integer.valueOf(job.get("pageNum").toString()) ;
					updateText.setPageNum(pageNum);
					//字体颜色
					String fontColor =job.get("fontColor").toString();
					updateText.setFontColor(fontColor);
					//字体粗细
					String fontWeight =job.get("fontWeight").toString();
					updateText.setFontWeight(fontWeight);
					//行数
					String line=job.get("lineAmount").toString();
					if(StringUtils.isNotEmpty(line)){
					Integer lineAmount =Integer.valueOf(line);
					updateText.setLineAmount(lineAmount);
					}
					//修改时间
					updateText.setUpdateTime(new Date());
					//加入到修改的List集合中
					updatePersoncongressTextList.add(updateText);
				}else {
					//增加
					PersoncongressText addText = new PersoncongressText();
					//会议id
					Integer congressID = Integer.valueOf(job.get("congressID").toString());
					addText.setCongressID(congressID);
					//日程id
					String agendaId=job.get("agendaID").toString();
					if(!StringUtils.isEmpty(agendaId)) {
						Integer agendaID = Integer.valueOf(agendaId);
						addText.setAgendaID(agendaID);
					}
					//议题id
					String topicId=job.get("topicID").toString();
					if(!StringUtils.isEmpty(topicId)) {
						Integer topicID = Integer.valueOf(topicId);
						addText.setTopicID(topicID);
					}
					//文件id
					Integer fileID = Integer.valueOf(job.get("fileID").toString());
					addText.setFileID(fileID);
					//人员id
					Integer staffID = Integer.valueOf(job.get("staffID").toString());
					addText.setStaffID(staffID);
					//是否展开
					boolean isOpen = Boolean.parseBoolean("true");
					String str = job.getString("isOpen");
					addText.setOpen(isOpen);
					//批注的内容
					String text = job.get("text").toString();
					addText.setText(text);
					//x轴
					double x=Double.parseDouble(job.getString("x"));
					addText.setX(x);
					//y轴
					double y=Double.parseDouble(job.getString("y"));
					addText.setY(y);
					//字体大小
					Integer fontSize =Integer.valueOf(job.get("fontSize").toString()) ;
					addText.setFontSize(fontSize);
					//页码
					Integer pageNum =Integer.valueOf(job.get("pageNum").toString()) ;
					addText.setPageNum(pageNum);
					//字体颜色
					String fontColor =job.get("fontColor").toString();
					addText.setFontColor(fontColor);
					//字体粗细
					String fontWeight =job.get("fontWeight").toString();
					addText.setFontWeight(fontWeight);
					//行数
					Integer lineAmount =Integer.valueOf(job.get("lineAmount").toString());
					addText.setLineAmount(lineAmount);
					//伪ID
					String falseID =job.get("falseID").toString();
					addText.setFalseID(falseID);
					//创建时间
					addText.setCreateTime(new Date());
					addPersoncongressTextList.add(addText);
				}
			}
		}
	
		//批量修改
		if(updatePersoncongressTextList.size()>0) {
			personcongressTextDao.updatePersoncongressTextbatch(updatePersoncongressTextList);
		}
		//批量增加
		if(addPersoncongressTextList.size()>0) {
			personcongressTextDao.addPersoncongressTextbatch(addPersoncongressTextList);
		}
		
	}


	@Override
	public void delectOneselfTextPiZhu(String ids) {
		// 字符串转List
		List<Integer> idList = new ArrayList<>();
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			idList.add(Integer.parseInt(id));
		}
		if(idList.size()>0) {
			personcongressTextDao.delectOneselfTextPiZhu(idList);
		}
		
	}


	@Override
	public void compileOneselfFilePiZhu(PersoncongressFile personcongressFile) {
		if(StringUtils.isEmpty(personcongressFile.getFalseID())) {
			personcongressFileDao.updateOneselfFilePiZhu(personcongressFile);
		}else {
			personcongressFileDao.addOneselfFilePiZhu(personcongressFile);
		}
		
	}


	@Override
	public List<PersoncongressFile> findOneselfFilePiZhu(PersoncongressFile personcongressFile) {
		
		return personcongressFileDao.findOneselfFilePiZhu(personcongressFile);
	}


	@Override
	public List<PersoncongressText> findOneselfTextPiZhu(PersoncongressText personcongressText) {
		
		return personcongressTextDao.findOneselfTextPiZhu(personcongressText);
	}


	@Override
	public void delectOneselfFilePiZhu(String ids) {
		// 1，删除文件服务器的文件
		// 1.1找到批注图片的路径
		List<Integer> idList = new ArrayList<>();
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			idList.add(Integer.parseInt(id));
		}
		if (idList.size() > 0) {
			List<PersoncongressFile> personcongressFiles = personcongressFileDao.findOneselfFilePiZhuPath(idList);
			String basePath = new PropertiesUtil("config.properties").readProperty("basePath");
			basePath = basePath + System.getProperty("file.separator");
			// 1.2删除
			for (int i = 0; i < personcongressFiles.size(); i++) {
				String pic = personcongressFiles.get(i).getPicPath();
				if (StringUtils.isNotEmpty(pic)) {
					String upload = new PropertiesUtil("config.properties").readProperty("realPath");
					String Strpic = pic.replace("upload/", "");
					// 绝对路径
					String filePath = basePath + Strpic;
					// 删除
					System.out.println(filePath);
					File file = new File(filePath);
					if (file.exists()) {
						// 如果文件存在就删除
						file.delete();
					}
				}
			}
			// 2，删除数据库中的数据
			personcongressFileDao.delectOneselfFilePiZhu(idList);
		}
	}


	@Override
	public void delectOneselfTextPiZhuFaseID(String faseIDs) {
			// 字符串转List
			List<String> idList = new ArrayList<>();
			String[] idArr = faseIDs.split(",");
			for (String id : idArr) {
				idList.add(id);
			}
			if(idList.size()>0) {
				personcongressTextDao.delectOneselfTextPiZhuFaseID(idList);
			}
		
		
	}


	@Override
	public void updateOneselfFilePiZhu(PersoncongressFile personcongressFile) {
		// TODO Auto-generated method stub
		personcongressFileDao.updateOneselfFilePiZhu(personcongressFile);
	}


	@Override
	public int addOneselfFilePiZhu(PersoncongressFile personcongressFile) {
		// TODO Auto-generated method stub
		int  pFid= personcongressFileDao.addOneselfFilePiZhu(personcongressFile);
		return pFid;
	}
	
	
	
	
}
