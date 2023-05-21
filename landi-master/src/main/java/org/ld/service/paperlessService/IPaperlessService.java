package org.ld.service.paperlessService;

import java.util.List;
import java.util.Map;

import org.ld.model.StaffInfo;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.model.fileModel.CongressBulletinFile;
import org.ld.model.paperlessModel.PersoncongressFile;
import org.ld.model.paperlessModel.PersoncongressText;
import org.ld.model.paperlessModel.StaffInfoSelfModel;
import org.ld.vo.AgendaSeatUitStaffInfoVo;
import org.ld.vo.ComboTree;
import org.ld.vo.PaperlessFile;

public interface IPaperlessService {

	//查询当前议题和议题下的文件
	List<PaperlessFile> findPaperlessNowTopicFile(Integer status);
	
	//查询状态下召开议程的详细信息 
	Agenda findPaperlessNowAgenda(Integer status);

	//按议程的id和坐席的id查询人员的信息
	AgendaSeatUitStaffInfoVo findAgendaAndSeatQueryStaffInfo(Integer agendId, Integer suId);

	//查询当前的议题和会议及议程的详细信息
	List<Map> findPaperlessNowCongress(Integer status);

	//查询当前的会议详细信息
	Congress findPaperlessNowCongressModel(Integer status);

	//查询当前会议的日程及分组文件
	List<CongressBulletinFile> findPaperlessNowCongressScheduleFile(Integer congressId, Integer fileType);

	//按条件查询基础人员参加的会议和文件
	List<ComboTree> findOneselfHistoryMeeting(StaffInfoSelfModel staffInfoSelf);
	
	//编辑个人的文字批注
	void compileOneselfTextPiZhu(String strText);

	//删除文字批注
	void delectOneselfTextPiZhu(String ids);
	
	//查看个人的文字批注
	List<PersoncongressText> findOneselfTextPiZhu(PersoncongressText personcongressText);

	//增加个人手写批注
	void compileOneselfFilePiZhu(PersoncongressFile personcongressFile);
	
	//查看个人的手写批注
	List<PersoncongressFile> findOneselfFilePiZhu(PersoncongressFile personcongressFile);

	//删除个人的手写批注
	void delectOneselfFilePiZhu(String ids);
	
	//按照伪ID删除文字批注
	void delectOneselfTextPiZhuFaseID(String faseIDs);

	//修改手写批注
	void updateOneselfFilePiZhu(PersoncongressFile personcongressFile);

	//增加手写批注
	int addOneselfFilePiZhu(PersoncongressFile personcongressFile);
	
	

}
