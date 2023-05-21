package org.ld.service.congressService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.StaffInfoDao;
import org.ld.dao.congressDao.CongressPersonDao;
import org.ld.model.StaffInfo;
import org.ld.model.congressModel.CongressPerson;
import org.ld.service.congressService.ICongressPersonService;
import org.ld.vo.CongressPersonSeatUnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("congressPersonService")
public class CongressPersonServiceImpl implements ICongressPersonService{

	
	@Autowired
	private CongressPersonDao congressPersondao;

	@Autowired
	private StaffInfoDao staffInfoDao;
	
	
	@Override
	public List<CongressPersonSeatUnitVo> getCongressPersonList(CongressPerson congressPerson) {
		
		return congressPersondao.getCongressPersonList(congressPerson);
	}
	
	@Override
	public void addCongressPerson(CongressPerson congressPerson) {
		//1,增加基础人员
		StaffInfo staffInfo=congressPerson.getStaffInfo();
		staffInfo.getStaffCategory().setId(congressPerson.getStaffCategoryID());
		staffInfo.getStaffGroup().setId(congressPerson.getStaffGroupID());
		staffInfo.getDictionary().setId(congressPerson.getDictionaryID());
		staffInfo.getNation().setId(congressPerson.getNationID());
		Date t = new Date();
		// 修改时间
		staffInfo.setUpdatetime(t);
		// 创建时间
		staffInfo.setCreateTime(t);
		int i = staffInfoDao.addStaffInfoResultID(staffInfo);
		congressPerson.setStaffInfo(staffInfo);
		//2，基础人员绑定会议
		congressPersondao.addCongressPerson(congressPerson);
	}

	@Override
	public Map findCongressPersonByID(CongressPerson congressPerson) {
		
		return congressPersondao.findCongressPersonByID(congressPerson);
	}

	@Override
	public void updateCongressPerson(CongressPerson congressPerson) {
		//1,先修改基础人员
		StaffInfo staffInfo=congressPerson.getStaffInfo();
		staffInfo.getStaffCategory().setId(congressPerson.getStaffCategoryID());
		staffInfo.getStaffGroup().setId(congressPerson.getStaffGroupID());
		staffInfo.getDictionary().setId(congressPerson.getDictionaryID());
		staffInfo.getNation().setId(congressPerson.getNationID());
		Date t = new Date();
		// 修改时间
		staffInfo.setUpdatetime(t);
		staffInfoDao.updateStaffInfo(staffInfo);
		//2,修改CongressPerson
		congressPersondao.updateCongressPerson(congressPerson);
	}

	@Override
	public void deleteCongressPersons(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			congressPersondao.deleteCongressPersons(idList);
		}
		
	}

	@Override
	public String addCongressPersonsList(String persons, Integer congressID,String typeId) {
		//基础人员    jcry    
		//源会议	   yhy
		String str = "会议：";
		List<CongressPerson> congressPersons = new ArrayList<>();
		if(typeId.equals("jcry")) {
			if (StringUtils.isNotEmpty(persons) && congressID != null) {
				// 1,查询跟会议的人员id集合
				List<Integer> personList = congressPersondao.findCongressPersonIDs(congressID);
				System.out.println(personList);
				// 将传过来的字符串转成List
				List<Integer> idList = new ArrayList<>();
				String[] idArr = persons.split(",");
				for (String id : idArr) {
					idList.add(Integer.parseInt(id));
				}
				// 把已经添加到会议的人员remove掉
				int errorNum = 0;
				for (int i = 0; i < personList.size(); i++) {
					for (int j = 0; j < idList.size(); j++) {
						if (idList.get(j) == personList.get(i)) {
							idList.remove(j);
							errorNum += 1 ;
						}
					}
				}
				if(errorNum>0) {
					str +="已存在未导入【"+errorNum+"】条;";
				}
				// 把会议中没又的参会人员再入到会议中去
				for (Integer id : idList) {
					CongressPerson congressPerson = new CongressPerson();
					congressPerson.setStaffID(id);
					congressPerson.setCongressID(congressID);
					// 报到权
					congressPerson.setReportPower(1);
					// 表决权
					congressPerson.setVotePower(1);
					// 发言权
					congressPerson.setSpeakPower(1);
					// 优先发言权
					congressPerson.setFirstSpeakPower(0);
					// 呼叫权
					congressPerson.setCallPower(1);
					// 查询权
					congressPerson.setSearchPower(1);
					congressPersons.add(congressPerson);
				}
			}
			if (congressPersons.size() > 0) {
				 congressPersondao.addBatchCongressPerson(congressPersons);
				 str+="成功导入【"+congressPersons.size()+"】条。";
			}else {
				str+="成功导入【"+congressPersons.size()+"】条。";
			}
		}else if(typeId.equals("yhy")) {
			// 1,查询跟会议的人员id集合
			List<Integer> personList = congressPersondao.findCongressPersonIDs(congressID);
			System.out.println(personList);
			// 将传过来的字符串转成List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = persons.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			List<CongressPerson> congressPersonList = congressPersondao.getIDSCongressPersonList(idList);
			// 把已经添加到会议的人员remove掉
			int errorNum = 0;
			for (int i = 0; i < personList.size(); i++) {
				for (int j = 0; j < congressPersonList.size(); j++) {
					if (congressPersonList.get(j).getStaffInfo().getId() == personList.get(i)) {
						congressPersonList.remove(j);
						errorNum += 1 ;
					}
				}
			}
			if(errorNum>0) {
				str +="已存在未导入【"+errorNum+"】条;";
			}
			for(int i=0;i<congressPersonList.size();i++) {
				CongressPerson congressPerson = new CongressPerson();
				congressPerson.setStaffID(congressPersonList.get(i).getStaffInfo().getId());
				congressPerson.setCongressID(congressID);
				// 报到权
				congressPerson.setReportPower(congressPersonList.get(i).getReportPower());
				// 表决权
				congressPerson.setVotePower(congressPersonList.get(i).getVotePower());
				// 发言权
				congressPerson.setSpeakPower(congressPersonList.get(i).getSpeakPower());
				// 优先发言权
				congressPerson.setFirstSpeakPower(congressPersonList.get(i).getFirstSpeakPower());
				// 呼叫权
				congressPerson.setCallPower(congressPersonList.get(i).getCallPower());
				// 查询权
				congressPerson.setSearchPower(congressPersonList.get(i).getSearchPower());
				congressPerson.setXpoint(congressPersonList.get(i).getXpoint());
				congressPerson.setYpoint(congressPersonList.get(i).getYpoint());
				congressPerson.setStatus(congressPersonList.get(i).getStatus());
				congressPerson.setSeatID(congressPersonList.get(i).getSeatID());
				congressPerson.setSeatArea(congressPersonList.get(i).getSeatArea());
				congressPerson.setRemark(congressPersonList.get(i).getRemark());
				congressPersons.add(congressPerson);
			}
			if (congressPersons.size() > 0) {
				 congressPersondao.addBatchCongressPerson(congressPersons);
				 str+="成功导入【"+congressPersons.size()+"】条。";
			}else {
				str+="成功导入【"+congressPersons.size()+"】条。";
			}
		}
		return str;
	}

}
