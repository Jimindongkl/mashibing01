package org.ld.service.congressControlService;

import java.util.List;
import java.util.Map;

import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.AgendaPerson;
import org.ld.model.congressModel.Congress;
import org.ld.model.congressModel.Topic;
import org.ld.vo.AgendaSeatUitStaffInfoVo;
import org.ld.vo.ComboTree;
import org.ld.vo.ComboTreeController;
import org.ld.vo.StaffInfoAndNumVo;

public interface ICongressControlService {

	List<ComboTree> findUnpublishedCongressList(Congress congress);

	void uploadStatusCongress(Integer congressId, Integer congressStatus);

	void uploadStatusAgenda(Integer agendaId, Integer agendaStatus);

	List<Agenda> findAgendaList(Integer congressId);

	List<Agenda> findAgendaIdfindAgendas(Integer agendaId);

	Congress findAgendaIdfindcongressBy(Integer agendaId);

	List<Map> findSeatUnitAndPersonAndDeviceUsedList(Integer seatModelId, Integer agendaId);

	List<Agenda> findNotCurrentAgendaStatus(Integer agendaId, Integer status);

	List<ComboTreeController> findAgendaQueryTopics(Topic topic);
	//按日程id查询签到人员
	List<AgendaSeatUitStaffInfoVo> findUnderwayMeetingPersonList(Integer agendaId);
	//按坐席id修改签到人员的时间和状态
	void updateUnderwayMeetingPersonCheckInTimeAndCheckState(Integer seatID);
	void updateUnderwayMeetingPersonCheckInTimeAndCheckStateOut(Integer seatID);
	//修改正在开会的（分配坐席的）所有人员的状态
	void updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(Integer status);
	//按id查询日程的详细信息
	Agenda findAgendaModel(Integer agendaId);
	//查询绑定的人员信息
	List<StaffInfoAndNumVo> findControlPersonCheckInCount(AgendaPerson agendaPerson);
	//正在进行中的日程
	Agenda findLoadingAgendaInfo();

}
