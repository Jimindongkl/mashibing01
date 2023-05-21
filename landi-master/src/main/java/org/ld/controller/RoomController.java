package org.ld.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ld.model.Room;
import org.ld.model.RoomPart;
import org.ld.model.SeatModel;
import org.ld.model.StaffInfo;
import org.ld.response.ResponseServer;
import org.ld.service.IRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("roomController")
public class RoomController {
	
	@Resource(name = "roomService")
	private IRoomService roomService;
	
	/**
	 * <pre>findRoomList(查询会议室)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月21日 下午5:03:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月21日 下午5:03:38    
	 * 修改备注： 
	 * @param room
	 * @return</pre>
	 */
	@RequestMapping("/findRoomList")
	@ResponseBody 
	public ResponseServer findRoomList(Room room) {
		Map map = new HashMap<>();
		Long count =roomService.getCount(room);
		//总条数
		room.setTotalCount(count);
		//计算开始下标
		room.calculatePage();
		//查询数据
		List<Room> rooms=roomService.findRoomList(room);
		map.put("page", room);
		map.put("rooms", rooms);
		return ResponseServer.success(map);
	}
	
	/**
	 * <pre>addRoom(增加接口)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月21日 上午10:35:36    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月21日 上午10:35:36    
	 * 修改备注： 
	 * @param room
	 * @return</pre>
	 */
	@RequestMapping("/addRoom")
	@ResponseBody 
	public ResponseServer addRoom(Room room,String Json) {
		roomService.addRoom(room,Json);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>(修改接口)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月21日 上午10:35:36    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月21日 上午10:35:36    
	 * 修改备注： 
	 * @param room
	 * @return</pre>
	 */
	@RequestMapping("/updateRoom")
	@ResponseBody 
	public ResponseServer updateRoom(Room room,String Json) {
		roomService.updateRoom(room,Json);
		return ResponseServer.success();
	}
	
	/**
	 * <pre>deleteRoom(删除会议室)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月21日 下午4:52:05    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月21日 下午4:52:05    
	 * 修改备注： 
	 * @param ids
	 * @return</pre>
	 */
	@RequestMapping("/deleteRooms")
	@ResponseBody 
	public ResponseServer deleteRooms(String ids) {
		ResponseServer message=roomService.deleteRooms(ids);
		return message;
	}
	
	/**
	 * <pre>findSeatModel(下拉坐席图)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月21日 下午5:04:09    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月21日 下午5:04:09    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("/findSeatModel")
	@ResponseBody 
	public ResponseServer findSeatModel() {
		List<SeatModel> list=roomService.findSeatModel();
		return ResponseServer.success(list);
	}
	
	/**
	 * <pre>finRoomtoRoomParts(用会议室的id查询会议室分区)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年2月24日 下午2:41:12    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年2月24日 下午2:41:12    
	 * 修改备注： 
	 * @param room
	 * @return</pre>
	 */
	@RequestMapping("/finRoomtoRoomParts")
	@ResponseBody 
	public ResponseServer finRoomtoRoomParts(Room room) {
		List<RoomPart> list=roomService.finRoomtoRoomParts(room);
		return ResponseServer.success(list);
	}
	
	/**
	 * <pre>finRoomtoRoomParts(按主键id查询会议室的详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月14日 上午10:22:58    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月14日 上午10:22:58    
	 * 修改备注： 
	 * @param room
	 * @return</pre>
	 */
	@RequestMapping("/finRoomInfo")
	@ResponseBody 
	public ResponseServer finRoomInfo(Integer roomId) {
		Room room = roomService.finRoomInfo(roomId);
		return ResponseServer.success(room);
	}
	
}
