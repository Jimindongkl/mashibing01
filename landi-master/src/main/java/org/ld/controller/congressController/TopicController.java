package org.ld.controller.congressController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.model.congressModel.Topic;
import org.ld.model.fileModel.CongressFile;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.commonService.ICommonService;
import org.ld.service.congressService.ITopicService;
import org.ld.service.fileService.ICongressFileService;
import org.ld.vo.ComboTree;
import org.ld.vo.MoveVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("topicCtroller")
public class TopicController {

	@Resource(name = "topicService")
	private ITopicService topicService;

	@Resource(name = "congressFileService")
	private ICongressFileService congressFileService;
	
	@Resource(name = "commonService")
	private ICommonService commonService;
	
	/**
	 * <pre>
	 * findCongressTree(展示议题树)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月4日 下午4:45:43    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月4日 下午4:45:43    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/findTopicTree")
	@ResponseBody
	public ResponseServer findTopicTree() {
		List<ComboTree> comboTrees = topicService.findCongressTree();
		return ResponseServer.success(comboTrees);
	}
	
	/**
	 * <pre>findtopicModel(查询关于议题的投屏,参数设置,文件的查看或议程的文件查看)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月8日 下午4:49:03    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月8日 下午4:49:03    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/findTopicOrAgenda")
	@ResponseBody
	public ResponseServer findTopicOrAgenda(CongressFile congressFile, String treeType) {
		Map map = new HashMap<>();	
		Topic topicModel = new Topic();
		List<CongressFile> congressFiles = new ArrayList<CongressFile>();
		//议题
		if (treeType.equals("topic") || treeType.equals("topicLower")) {
				//查询投屏和参数设置
				if(congressFile.getTopicID()!=null) {
					topicModel=topicService.getTopicId(congressFile.getTopicID());
				}
				//文件
				if(congressFile.getCongressID()!=null&&congressFile.getAgendaID()!=null&&congressFile.getTopicID()!=null) {
					congressFiles = congressFileService.findCongressFiles(congressFile);
				}
			//议程	
			}else if (treeType.equals("agenda")) {
				//文件
				if (congressFile.getCongressID() != null && congressFile.getAgendaID() != null) {
					congressFiles = congressFileService.findCongressFiles(congressFile);
				}
			}
		map.put("topicModel", topicModel);
		map.put("congressFiles", congressFiles);
		return ResponseServer.success(map);
	}
	
	/**
	 * <pre>findTopicNumSetting(查询议题参数设置)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年11月19日 下午2:44:30    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年11月19日 下午2:44:30    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/findTopicNumSetting")
	@ResponseBody
	public ResponseServer findTopicNumSetting() {
		List s=commonService.findTopicNumSetting();
		return ResponseServer.success(s);
	}

	/**
	 * <pre>
	 * addTopic(增加议题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午4:15:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午4:15:37    
	 * 修改备注： 
	 * &#64;param topic
	 * &#64;param treeType  tree树的类型 ，meet,agenda,topic,topicLower
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/addTopic")
	@ResponseBody
	public ResponseServer addTopic(Topic topic, String treeType) {
		if (treeType.equals("topic") || treeType.equals("agenda")) {
			topicService.addTopic(topic, treeType);
			return ResponseServer.success();
		} else {
			return ResponseServer.error(ResponseEnum.ADDORUPDATE_ERROR);
		}
	}

	/**
	 * <pre>
	 * delectTopics(删除议题)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午5:34:47    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午5:34:47    
	 * 修改备注： 
	 * &#64;param ids
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/delectTopics")
	@ResponseBody
	public ResponseServer delectTopics(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			topicService.delectTopics(ids);
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.DELETE_ERROR);
	}

	/**
	 * <pre>
	 * saveTopicTree(议题Tree的移动)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月5日 下午2:57:06    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月5日 下午2:57:06    
	 * 修改备注： 
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/MoveTopicTreeOrder")
	@ResponseBody
	public ResponseServer MoveTopicTreeOrder(MoveVo moveVo) {
		topicService.UpdateTopicTreeOrder(moveVo);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * updateTopic(修改议题的投屏)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月18日 下午2:53:16    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月18日 下午2:53:16    
	 * 修改备注： 
	 * &#64;param topic
	 * &#64;param treeType
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateTopicMiracast")
	@ResponseBody
	public ResponseServer updateTopicMiracast(Topic topic) {
		// 要保存的字段 toContent toName agendaHtml num
		topicService.updateTopicMiracast(topic);
		return ResponseServer.success();
	}

	/**
	 * <pre>
	 * updateTopicParam(修改议题参数设置)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月26日 下午3:59:28    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月26日 下午3:59:28    
	 * 修改备注： 
	 * &#64;param topic
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/updateTopicParam")
	@ResponseBody
	public ResponseServer updateTopicParam(Topic topic) {
		// 要保存的字段
		topicService.updateTopicParam(topic);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>queryTopictoContent(按议题的id查询议题的投屏内容)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年12月21日 上午10:04:45    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年12月21日 上午10:04:45    
	 * 修改备注： 
	 * @param topicId
	 * @return</pre>
	 */
	@RequestMapping("/queryTopictoContent")
	@ResponseBody
	public ResponseServer queryTopictoContent(Integer topicId) {
		if(topicId!=null&&topicId>0) {
			Topic topic = topicService.queryTopictoContent(topicId);
			return ResponseServer.success(topic);
		}else {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		
		
	}
	
	/**
	 * <pre>updateTopicToStatus(修改议题的状态)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2021年1月25日 上午11:04:17    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2021年1月25日 上午11:04:17    
	 * 修改备注： 
	 * @param topicId
	 * @return</pre>
	 */
	@RequestMapping("/updateTopicToStatus")
	@ResponseBody
	public ResponseServer updateTopicToStatus(Integer topicId) {
		if(topicId==null) {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		//以查询出的结果来进行判断是否为子议题
		Topic topic=topicService.getTopicId(topicId);
		//子议题
		if(topic.getTopicLower()>0) {
			//1,修改当前议题下的所有子议题的状态为0
			topicService.updateTopicCongressAgendaTopicLower(topic);
			//2,修改当前议题状态为1
			topicService.updateTopicStatus(topicId);
		//议题
		}else {
			//1,修改当前议程下所有的议题的状态为0
			topicService.updateTopicCongressAgenda(topic);
			//2,修改当前议题状态为1
			topicService.updateTopicStatus(topicId);
		}
			return ResponseServer.success();
	}
	
	@RequestMapping("/updateTopicToPreStart")
	@ResponseBody
	public ResponseServer updateTopicToPreStart(Integer topicId) {
		if(topicId==null) {
			return ResponseServer.error(ResponseEnum.INFO_NULL);
		}
		//以查询出的结果来进行判断是否为子议题
		Topic topic=topicService.getTopicId(topicId);
		//子议题
		if(topic.getTopicLower()>0) {
			//1,修改当前议题下的所有子议题的状态为0
			topicService.updateTopicCongressAgendaTopicLower(topic);
			//2,修改当前议题状态为-1, 即将开始，但没开始
			topicService.updateTopicToPreStart(topicId);
		//议题
		}else {
			//1,修改当前议程下所有的议题的状态为0
			topicService.updateTopicCongressAgenda(topic);
			//2,修改当前议题状态为-1
			topicService.updateTopicToPreStart(topicId);
		}
			return ResponseServer.success();
	}

}
