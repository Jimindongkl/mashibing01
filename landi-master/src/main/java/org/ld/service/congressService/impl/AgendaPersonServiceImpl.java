package org.ld.service.congressService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.StaffInfoDao;
import org.ld.dao.congressDao.AgendaPersonDao;
import org.ld.model.StaffInfo;
import org.ld.model.congressModel.AgendaPerson;
import org.ld.service.congressService.IAgendaPersonService;
import org.ld.vo.AgendaPersonResult;
import org.ld.vo.AgendaPersonResultByModelVo;
import org.ld.vo.AgendaPersonSeatUnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("agendaPersonService")
public class AgendaPersonServiceImpl implements IAgendaPersonService {

	@Autowired
	private AgendaPersonDao agendaPersondao;

	@Autowired
	private StaffInfoDao staffInfoDao;

	@Override
	public List<AgendaPersonSeatUnitVo> getAgendaPersonList(AgendaPerson agendaPerson) {

		return agendaPersondao.getAgendaPersonList(agendaPerson);
	}

	@Override
	public void addAgendaPerson(AgendaPerson agendaPerson) {
		// 1,增加基础人员
		StaffInfo staffInfo = agendaPerson.getStaffInfo();
		staffInfo.getStaffCategory().setId(agendaPerson.getStaffCategoryID());
		staffInfo.getStaffGroup().setId(agendaPerson.getStaffGroupID());
		staffInfo.getDictionary().setId(agendaPerson.getDictionaryID());
		staffInfo.getNation().setId(agendaPerson.getNationID());
		Date t = new Date();
		// 修改时间
		staffInfo.setUpdatetime(t);
		// 创建时间
		staffInfo.setCreateTime(t);
		int i = staffInfoDao.addStaffInfoResultID(staffInfo);
		agendaPerson.setStaffInfo(staffInfo);
		// 2，基础人员绑定会议
		agendaPersondao.addAgendaPerson(agendaPerson);
	}

	@Override
	public AgendaPersonResultByModelVo findAgendaPersonByID(AgendaPerson agendaPerson) {

		return agendaPersondao.findAgendaPersonByID(agendaPerson);
	}

	@Override
	public void updateAgendaPerson(AgendaPerson agendaPerson) {
		// 1,修改基础人员
		StaffInfo staffInfo = agendaPerson.getStaffInfo();
		staffInfo.getStaffCategory().setId(agendaPerson.getStaffCategoryID());
		staffInfo.getStaffGroup().setId(agendaPerson.getStaffGroupID());
		staffInfo.getDictionary().setId(agendaPerson.getDictionaryID());
		staffInfo.getNation().setId(agendaPerson.getNationID());
		Date t = new Date();
		// 修改时间
		staffInfo.setUpdatetime(t);
		staffInfoDao.updateStaffInfo(staffInfo);
		// 2,修改agendaPerson
		agendaPersondao.updateAgendaPerson(agendaPerson);

	}

	@Override
	public void deleteAgendaPersons(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			agendaPersondao.deleteAgendaPersons(idList);
		}

	}

	@Override
	public String addAgendaPersonsList(String persons, Integer agendaID, String typeId) {
		//基础人员    jcry    
		//源会议		yhy
		String str = "";
		List<AgendaPerson> agendaPersons = new ArrayList<>();
		if(typeId.equals("jcry")) {
			if (StringUtils.isNotEmpty(persons) && agendaID != null) {
				// 1,查询跟会议的人员id集合
				List<Integer> personList = agendaPersondao.findAgendaPersonIDs(agendaID);
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
							errorNum += 1;
						}
					}
				}
				if (errorNum > 0) {
					str += "已存在未导入【" + errorNum + "】条;";
				}
				// 把议程中没又的参会人员再入到议程中去
				for (Integer id : idList) {
					AgendaPerson agendaPerson = new AgendaPerson();
					agendaPerson.setStaffID(id);
					agendaPerson.setAgendaID(agendaID);
					// 报到权
					agendaPerson.setReportPower(1);
					// 表决权
					agendaPerson.setVotePower(1);
					// 发言权
					agendaPerson.setSpeakPower(1);
					// 优先发言权
					agendaPerson.setFirstSpeakPower(0);
					// 呼叫权
					agendaPerson.setCallPower(1);
					// 查询权
					agendaPerson.setSearchPower(1);
					agendaPersons.add(agendaPerson);
				}
				if (agendaPersons.size() > 0) {
					agendaPersondao.addBatchAgendaPerson(agendaPersons);
					str += "成功导入【" + agendaPersons.size() + "】条。";
				} else {
					str += "成功导入【" + agendaPersons.size() + "】条。";
				}
			}
		}else if(typeId.equals("yhy")) {
			if (StringUtils.isNotEmpty(persons) && agendaID != null) {
				// 查询跟会议的人员id集合
				List<Integer> personList = agendaPersondao.findAgendaPersonIDs(agendaID);
				// 将传过来的字符串转成List
				List<Integer> idList = new ArrayList<>();
				String[] idArr = persons.split(",");
				for (String id : idArr) {
					idList.add(Integer.parseInt(id));
				}
				List<AgendaPerson> agendaPersonList = agendaPersondao.getIDSAgendaPersonList(idList);
				// 把已经添加到会议的人员remove掉
				int errorNum = 0;
				for (int i = 0; i < personList.size(); i++) {
					for (int j = 0; j < agendaPersonList.size(); j++) {
						if (agendaPersonList.get(j).getStaffInfo().getId() == personList.get(i)) {
							agendaPersonList.remove(j);
							errorNum += 1;
						}
					}
				}
				if (errorNum > 0) {
					str += "已存在未导入【" + errorNum + "】条;";
				}
				for(int i=0;i<agendaPersonList.size();i++) {
					AgendaPerson agendaPerson = new AgendaPerson();
					agendaPerson.setAgendaID(agendaID);
					agendaPerson.setStaffID(agendaPersonList.get(i).getStaffInfo().getId());
					// 报到权
					agendaPerson.setReportPower(agendaPersonList.get(i).getReportPower());
					// 表决权
					agendaPerson.setVotePower(agendaPersonList.get(i).getVotePower());
					// 发言权
					agendaPerson.setSpeakPower(agendaPersonList.get(i).getSpeakPower());
					// 优先发言权
					agendaPerson.setFirstSpeakPower(agendaPersonList.get(i).getFirstSpeakPower());
					// 呼叫权
					agendaPerson.setCallPower(agendaPersonList.get(i).getCallPower());
					// 查询权
					agendaPerson.setSearchPower(agendaPersonList.get(i).getSearchPower());
					agendaPerson.setXpoint(agendaPersonList.get(i).getXpoint());
					agendaPerson.setYpoint(agendaPersonList.get(i).getYpoint());
					agendaPerson.setStatus(agendaPersonList.get(i).getStatus());
					agendaPerson.setSeatID(agendaPersonList.get(i).getSeatID());
					agendaPerson.setSeatArea(agendaPersonList.get(i).getSeatArea());
					agendaPerson.setRemark(agendaPersonList.get(i).getRemark());
					agendaPersons.add(agendaPerson);
				}
				// 把议程中没又的参会人员再入到议程中去
				if (agendaPersonList.size() > 0) {
					agendaPersondao.addBatchAgendaPerson(agendaPersons);
					str += "成功导入【" + agendaPersonList.size() + "】条。";
				} else {
					str += "成功导入【" + agendaPersonList.size() + "】条。";
				}
			}
		}
		return str;
	}

	@Override
	public void updateAgendaPersonBondSeatUnit(AgendaPersonSeatUnitVo agendaPersonSeatUnitVo) {
		//坐席id，人员绑定日程的id
		//1,按照agendaPersonId查询agendaId
		//2,按照agendaId和传过来的坐席id(seatUnitId)查询
		//3,结论如果2查出来的是0条则能绑定，否则不能
		AgendaPerson agendaPerson=agendaPersondao.findagendaPersonIdSelectAgendaId(agendaPersonSeatUnitVo.getAgendaPersonId());
		Integer ag = agendaPerson.getAgendaID();
		List<AgendaPerson> agendaPersons=agendaPersondao.findSumSeatID(ag,agendaPersonSeatUnitVo.getSeatUnitId());
		if(agendaPersons.size()==0) {
			agendaPersondao.updateAgendaPersonBondSeatUnit(agendaPersonSeatUnitVo);
		}
		
	}

	@Override
	public List<AgendaPersonResult> getAgendaPersonListInt(AgendaPersonResult aendaPersonResult) {

		return agendaPersondao.getAgendaPersonListInt(aendaPersonResult);
	}

	@Override
	public void updateAgendaPersonRemoveSeatUnit(AgendaPersonSeatUnitVo agendaPersonSeatUnitVo) {
		// 绑定时是将AgendaPerson中的参数修改为指定参数
		// 解绑时是将AgendaPerson中的参数修改为空，所以用同一个方法
		agendaPersondao.updateAgendaPersonBondSeatUnit(agendaPersonSeatUnitVo);
	}

	@Override
	public void updateSwopSeatUnit(String swopSeatUnit) {
		List<AgendaPerson> updateAgendaPersons = new ArrayList<>();
		List<AgendaPerson> addAgendaPersons = new ArrayList<>();
		List<Integer> deleteAgendaPersons = new ArrayList<>();
		JSONArray ay = JSONArray.fromObject(swopSeatUnit);
		//议程的id,用于查询权限
		String Id = (String) ay.getJSONObject(0).get("agendaId");
		Integer AgendaId = null;
		if(!StringUtils.isEmpty(Id)) {
			AgendaId = Integer.valueOf(Id);
		}
		for (int i = 0; i < ay.size(); i++) {
			AgendaPerson agendaPerson = new AgendaPerson();
			JSONObject job = ay.getJSONObject(i);
			String agendaPersonId=(String) job.get("agendaPersonId");
			String staffinfoId=(String) job.get("staffinfoId");
			String seatUnitId=(String) job.get("seatUnitId");
			//情况1:agendaPersonId,staffinfoId,seatUnitId 走交换
			if(!StringUtils.isEmpty(agendaPersonId)&&!StringUtils.isEmpty(staffinfoId)&&!StringUtils.isEmpty(seatUnitId)) {
				//查权限staffinfoId,agendaId
				AgendaPerson agendaPersonPower = agendaPersondao.findStaffinfoBondSeatUnitIsPower(staffinfoId,AgendaId);
				// 报到权
				agendaPerson.setReportPower(agendaPersonPower.getReportPower());
				// 表决权
				agendaPerson.setVotePower(agendaPersonPower.getVotePower());
				// 发言权
				agendaPerson.setSpeakPower(agendaPersonPower.getSpeakPower());
				// 优先发言权
				agendaPerson.setFirstSpeakPower(agendaPersonPower.getFirstSpeakPower());
				// 呼叫权
				agendaPerson.setCallPower(agendaPersonPower.getCallPower());
				// 查询权
				agendaPerson.setSearchPower(agendaPersonPower.getSearchPower());
				agendaPerson.setId(Integer.valueOf(agendaPersonId));
				agendaPerson.setStaffID(Integer.valueOf(staffinfoId));
				updateAgendaPersons.add(agendaPerson);
			}
			//情况2:没有agendaPersonId;有staffinfoId,seatUnitId  走绑定
			if(StringUtils.isEmpty(agendaPersonId)&&!StringUtils.isEmpty(staffinfoId)&&!StringUtils.isEmpty(seatUnitId)) {
				agendaPerson.setStaffID(Integer.valueOf(staffinfoId));
				agendaPerson.setAgendaID(Integer.valueOf(AgendaId));
				agendaPerson.setSeatID(Integer.valueOf(seatUnitId));
				//查权限staffinfoId,agendaId
				AgendaPerson agendaPersonPower = agendaPersondao.findStaffinfoBondSeatUnitIsPower(staffinfoId,AgendaId);
				// 报到权
				agendaPerson.setReportPower(agendaPersonPower.getReportPower());
				// 表决权
				agendaPerson.setVotePower(agendaPersonPower.getVotePower());
				// 发言权
				agendaPerson.setSpeakPower(agendaPersonPower.getSpeakPower());
				// 优先发言权
				agendaPerson.setFirstSpeakPower(agendaPersonPower.getFirstSpeakPower());
				// 呼叫权
				agendaPerson.setCallPower(agendaPersonPower.getCallPower());
				// 查询权
				agendaPerson.setSearchPower(agendaPersonPower.getSearchPower());
				addAgendaPersons.add(agendaPerson);
			}
			//情况3:没有staffinfoId;有agendaPersonId,seatUnitId 走删除
			if(StringUtils.isEmpty(staffinfoId)&&!StringUtils.isEmpty(agendaPersonId)&&!StringUtils.isEmpty(seatUnitId)) {
					deleteAgendaPersons.add(Integer.valueOf(agendaPersonId));
				}
		}
		
		if(addAgendaPersons.size()>0) {
			//批量绑定
			agendaPersondao.addBatchAgendaPerson(addAgendaPersons);
		}
		
		if(updateAgendaPersons.size()>0) {
			// 批量修改
			agendaPersondao.updateBatchSwopSeatUnits(updateAgendaPersons);
		}
		if(deleteAgendaPersons.size()>0) {
			//批量删除
			agendaPersondao.deleteAgendaPersons(deleteAgendaPersons);
		}
		
	}

}
