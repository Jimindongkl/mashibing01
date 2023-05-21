package org.ld.controller.paperlessController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.ld.model.SeatUnit;
import org.ld.model.StaffInfo;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.model.fileModel.CongressBulletinFile;
import org.ld.model.paperlessModel.NoteModel;
import org.ld.model.paperlessModel.PersoncongressFile;
import org.ld.model.paperlessModel.PersoncongressText;
import org.ld.model.paperlessModel.StaffInfoSelfModel;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.ISeatUnitService;
import org.ld.service.paperlessService.INoteService;
import org.ld.service.paperlessService.IPaperlessService;
import org.ld.vo.AgendaSeatUitStaffInfoVo;
import org.ld.vo.ComboTree;
import org.ld.vo.PaperlessFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("paperlessController")
public class PaperlessController {

	@Resource(name = "paperlessService")
	private IPaperlessService paperlessService;
	
	 @Resource(name = "seatUnitService")
	 private ISeatUnitService seatUnitService;
	 
	 @Resource(name = "noteService")
	 private INoteService noteService;
	 
	/***************************************无纸化*****************************************************/
	//首页
	/**
	 * <pre>toIndexAndStaffInfo(首页获取用户信息和会议名称)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月27日 下午3:03:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月27日 下午3:03:12    
	 * 修改备注： 
	 * @param paperlessDeviceused
	 * @return</pre>
	 */
	@RequestMapping("/toIndexAndStaffInfo")
    @ResponseBody
    public ResponseServer toIndexAndStaffInfo(String paperlessDeviceusedIP) {
		if(!StringUtils.isEmpty(paperlessDeviceusedIP)) {
			//第一步 按无纸化ip找到坐席
			SeatUnit seatUnit =  seatUnitService.findPaperlessDeviceusedIP(paperlessDeviceusedIP);
			//第二步  找到正在开会的议程
			Integer status = 1;
		    Agenda agenda = paperlessService.findPaperlessNowAgenda(status);
		    List<Map> topics = paperlessService.findPaperlessNowCongress(status);
		    //会议标题
		    String congressName = (String) topics.get(0).get("congressName");
		    String agendaName = (String) topics.get(0).get("agendaName");
			//第二步 按正在开会的议程和坐席id找到相关的人员
		    StaffInfo staffInfo = new StaffInfo();
		    Map map= new HashMap<>();
		    map.put("userName", "");
		    map.put("userJob", "");
		    if(seatUnit!=null&&agenda!=null) {
		    	AgendaSeatUitStaffInfoVo agendaSeatUitStaffInfoVo = paperlessService.findAgendaAndSeatQueryStaffInfo(agenda.getId(),seatUnit.getSuId());
		      if(staffInfo!=null) {
		    	  map.put("userName", agendaSeatUitStaffInfoVo.getName());
			      map.put("userJob", agendaSeatUitStaffInfoVo.getJob());
		      }
		    }
		    map.put("congressName",congressName);
		    map.put("agendaName",agendaName);
		    return ResponseServer.success(map);
		}else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
	}
	
	
	//会议文件
	/**
	 * <pre>findPaperlessNowTopicFile(查询当前议题和议题下的文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月17日 下午3:30:31    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月17日 下午3:30:31    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/findPaperlessNowTopicFile")
    @ResponseBody
    public ResponseServer findPaperlessNowTopicFile(Integer status) {
		//根据当前议程,查询下面的所属议题和议题下的文件
		//agenda(名称) ->topic->file
		List<PaperlessFile> maps = paperlessService.findPaperlessNowTopicFile(status);
    	return ResponseServer.success(maps);
    }
	
	//日程及分组,审议简报,会议其他文件
	/**
	 * <pre>findPaperlessNowCongressScheduleFile(查询当前会议下的的日程及分组文件)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月30日 上午9:14:39    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月30日 上午9:14:39    
	 * 修改备注： 
	 * @param status
	 * @param fileType
	 * @return</pre>
	 */
	@RequestMapping("/findPaperlessNowCongressScheduleFile")
    @ResponseBody
    public ResponseServer findPaperlessNowCongressScheduleFile(Integer status,Integer fileType) {
		  //查询当前的会议信息  当前会议的状态status  文件的类型fileType
		 Congress congress= paperlessService.findPaperlessNowCongressModel(status);
		 //查询会议的日程及分组文件
		 List<CongressBulletinFile> paperlessFiles= new ArrayList<>();
		 if(congress!=null) {
			Integer congressId=congress.getId();
			paperlessFiles= paperlessService.findPaperlessNowCongressScheduleFile(congressId,fileType);
		 }
    	return ResponseServer.success(paperlessFiles);
    }
	
	
	/**
	 * <pre>findOneselfHistoryMeeting(个人的参加的历史会议)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年8月28日 下午2:53:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年8月28日 下午2:53:56    
	 * 修改备注： 
	 * @param staffInfo
	 * @return</pre>
	 */
	@RequestMapping("/findOneselfHistoryMeeting")
    @ResponseBody
    public ResponseServer findOneselfHistoryMeeting(StaffInfoSelfModel staffInfoSelf) {
		if(staffInfoSelf.getStaffInfoId()!=null) {
			List<ComboTree>  comboTrees= paperlessService.findOneselfHistoryMeeting(staffInfoSelf);
			return ResponseServer.success(comboTrees);
		}else{
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		
		
	}
	
	/********************************************批注*****************************************/
	//文字批注
	/**
	 * <pre>addOneselfTextPiZhu(编辑个人的文字批注)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月1日 下午2:35:17    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月1日 下午2:35:17    
	 * 修改备注：
	 * @return</pre>
	 */
	@RequestMapping("/compileOneselfTextPiZhu")
    @ResponseBody
    public ResponseServer compileOneselfTextPiZhu(String StrText) {
		if(StringUtils.isNotEmpty(StrText)) {
		paperlessService.compileOneselfTextPiZhu(StrText);
			/*Map map = new HashMap<>();
			map.put("pPID", pPID);
			System.out.println(map);*/
			return ResponseServer.success();
		}else {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		
	}
	
	/**
	 * <pre>delectOneselfTextPiZhu(批量删除文字批注)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月2日 上午9:30:41    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月2日 上午9:30:41    
	 * 修改备注： 
	 * @param ids
	 * @return</pre>
	 */
	@RequestMapping("/delectOneselfTextPiZhu")
    @ResponseBody
    public ResponseServer delectOneselfTextPiZhu(String faseIDs) {
		 if(StringUtils.isNotEmpty(faseIDs)) {
			paperlessService.delectOneselfTextPiZhuFaseID(faseIDs);
			return ResponseServer.success();
		}else {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		
	}
	
	/**
	 * <pre>findOneselfTextPiZhu(查看个人的文字批注)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月3日 上午9:14:04    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月3日 上午9:14:04    
	 * 修改备注： 
	 * @param personcongressFile
	 * @return</pre>
	 */
	@RequestMapping("/findOneselfTextPiZhu")
	@ResponseBody
	public ResponseServer findOneselfTextPiZhu(PersoncongressText personcongressText) {
		if(personcongressText.getCongressID()!=null&&personcongressText.getStaffID()!=null&&personcongressText.getFileID()!=null) {
			List<PersoncongressText> personcongressTexts = paperlessService.findOneselfTextPiZhu(personcongressText);
			return ResponseServer.success(personcongressTexts);
		}else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
	}
	
	
	//手写批注
	/**
	 * <pre>compileOneselfFilePiZhu(手写批注)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月2日 下午3:34:07    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月2日 下午3:34:07    
	 * 修改备注： 
	 * @param personcongressFile
	 * @param request
	 * @return</pre>
	 */
	@RequestMapping("/compileOneselfFilePiZhu")
	@ResponseBody
	public ResponseServer compileOneselfFilePiZhu(PersoncongressFile personcongressFile,HttpServletRequest request){
		if(personcongressFile.getCongressID()!=null&&personcongressFile.getAgendaID()!=null&&personcongressFile.getPageNum()!=null&&personcongressFile.getStaffID()!=null&&personcongressFile.getFileID()!=null) {
			//查询是否有批注 有为修改，无为增加
			List<PersoncongressFile> personcongressFiles = paperlessService.findOneselfFilePiZhu(personcongressFile);
			Map map = new HashMap<>();
			Integer id = 0;
			if(personcongressFiles.size()>0) {
				Integer pFID=personcongressFiles.get(0).getpFID();
				personcongressFile.setpFID(pFID);
				//修改	
				paperlessService.updateOneselfFilePiZhu(personcongressFile);
				id = personcongressFile.getpFID();
			}else {
				//增加
				 int pFid = paperlessService.addOneselfFilePiZhu(personcongressFile);
				 id = personcongressFile.getpFID();
			}
			map.put("pFID", id);
			return ResponseServer.success(map);
		}else {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		
		
		/*List<Map<String, Object>> result=new ArrayList<>();
		try {
			//获取会议文件目录
			String fileDirName = "pizhu" + "/meet_" + personcongressFile.getCongressID() + "/user_"
					+ personcongressFile.getStaffID() + "/file_" + personcongressFile.getFileID();
		    //上传文件
		     result=FileUploadUtil.upload(request, fileDirName);
		    if(result.size()>0){
		    	//获取上传后的图片路径
		    	String basePath = new PropertiesUtil("config.properties").readProperty("realPath");
				personcongressFile.setPicPath(basePath+"/" + result.get(0).get("realPath"));
				//增加到数据库
				paperlessService.compileOneselfFilePiZhu(personcongressFile);
			}else {
				return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
			return ResponseServer.error(ResponseEnum.UPLOAD_ERROR);
		}*/
		//return ResponseServer.success(ResponseEnum.SUCCESS_UPLOAD,result);
		
	}	
	
	/**
	 * <pre>findOneselfFilePiZhu(查询个人的手写批注)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月2日 下午4:24:02    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月2日 下午4:24:02    
	 * 修改备注： 
	 * @param personcongressFile
	 * @return</pre>
	 */
	@RequestMapping("/findOneselfFilePiZhu")
	@ResponseBody
	public ResponseServer findOneselfFilePiZhu(PersoncongressFile personcongressFile) {
		if(personcongressFile.getCongressID()!=null&&personcongressFile.getAgendaID()!=null&&personcongressFile.getTopicID()!=null&&personcongressFile.getStaffID()!=null&&personcongressFile.getFileID()!=null) {
			List<PersoncongressFile> personcongressFiles = paperlessService.findOneselfFilePiZhu(personcongressFile);
			return ResponseServer.success(personcongressFiles);
		}else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
	}
	
	/**
	 * <pre>delectOneselfFilePiZhu(删除个人的手写批注)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月3日 上午11:14:22    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月3日 上午11:14:22    
	 * 修改备注： 
	 * @param ids
	 * @return</pre>
	 */
	@RequestMapping("/delectOneselfFilePiZhu")
    @ResponseBody
    public ResponseServer delectOneselfFilePiZhu(String ids) {
		if(StringUtils.isNotEmpty(ids)) {
			paperlessService.delectOneselfFilePiZhu(ids);
			return ResponseServer.success();
		}else {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
	}
	
	/***********************************************************************************/
	//个人中心
	//我的笔记本，增加，删除，修改。查。
	/**
	 * <pre>findStaffInfoNoteModel(查笔记)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年9月3日 下午3:38:16    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年9月3日 下午3:38:16    
	 * 修改备注： 
	 * @param note
	 * @return</pre>
	 */
	@RequestMapping("/findStaffInfoNoteModel")
    @ResponseBody
    public ResponseServer findStaffInfoNoteModel(NoteModel note) {
		if(note.getStaffID()!=null) {
			List<NoteModel>  notes=noteService.findStaffInfoNoteModel(note);
			return ResponseServer.success(notes);
		}else{
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
	}
	
	/**
	 * <pre>addOrUpdateNoteModel(增加或修改笔记)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年6月8日 下午4:27:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年6月8日 下午4:27:37    
	 * 修改备注： 
	 * @param note
	 * @return</pre>
	 */
	@RequestMapping("/addOrUpdateNoteModel")
    @ResponseBody
    public ResponseServer addOrUpdateNoteModel(NoteModel note) {
		noteService.addOrUpdateNoteModel(note);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>deleteNoteModel(删除笔记)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年7月2日 下午4:14:44    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年7月2日 下午4:14:44    
	 * 修改备注： 
	 * @param ids
	 * @return</pre>
	 */
	@RequestMapping("/deleteNoteModel")
    @ResponseBody
    public ResponseServer deleteNoteModel(String ids) {
		noteService.deleteNoteModel(ids);
		return ResponseServer.success();
	}
	
	/**********************************消息***************************************************/
	@RequestMapping("/getCurrentAgendaPersonAndSeatUnit")
    @ResponseBody
    public ResponseServer getCurrentAgendaPersonAndSeatUnit() {
		//第一步获取当前的日程
		Integer status = 1;
	    Agenda agenda = paperlessService.findPaperlessNowAgenda(status);
		if(agenda.getId()!=null&&agenda.getRoom()!=null) {
			 Integer roomId = agenda.getRoom().getId();
			 Integer agendaID = agenda.getId();
			// 1,查询议程对应的坐席单元
			List<Map> seatUnits = seatUnitService.findRoomSeatmodelUnit(roomId,agendaID);
			Map map = new HashMap<>();
			map.put("seatUnits", seatUnits);
			 return ResponseServer.success(map);
		}else {
			return ResponseServer.success("当前没有正在开的会议");
		}
	}
	
	/******************************************************************/

}
