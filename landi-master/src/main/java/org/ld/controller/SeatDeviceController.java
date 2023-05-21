package org.ld.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.ld.model.DeviceUsed;
import org.ld.model.SeatDevice;
import org.ld.model.SeatModel;
import org.ld.model.SeatUnit;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.ISeatDeviceService;
import org.ld.service.ISeatModelService;
import org.ld.utils.CacheManager;
import org.ld.vo.SeatdeviceAddressCodeVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * <pre>项目名称：landi-master    
 * 类名称：SeatDeviceController    
 * 类描述：    坐席单元跟设备
 * 创建人：姬民东 15539277254@163.com    
 * 创建时间：2020年3月13日 下午3:38:36    
 * 修改人：姬民东 15539277254@163.com    
 * 修改时间：2020年3月13日 下午3:38:36    
 * 修改备注：       
 * @version </pre>
 */
@Controller
@RequestMapping("seatDeviceController")
public class SeatDeviceController {
	
	@Resource(name = "seatDeviceService")
	private ISeatDeviceService seatDeviceService;
	public static Map<String, Object> contextMap=new HashMap<String,Object>();
	
	@Resource(name = "seatModelService")
	private ISeatModelService seatModelService;
	
	/**
	 * <pre>addSeatDevice(坐席与设备绑定)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年3月13日 下午4:19:24    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年3月13日 下午4:19:24    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("addSeatDevice")
	@ResponseBody
	public ResponseServer addSeatDevice(String Json,Integer suSeatModelId, Integer deviceUsedId) {
		if(!StringUtils.isEmpty(Json)) {
			seatDeviceService.addSeatDevice(Json);
			List<SeatDevice> seatDevices = seatDeviceService.getDevicefindSeatUnitList(suSeatModelId, deviceUsedId);
			return ResponseServer.success(seatDevices);
		}else {
			return ResponseServer.error(ResponseEnum.NAME_NULL);
		}
		
	}
	
	/**
	 * <pre>
	 * findSeatDeviceByID(按设备号和坐席号查询设备的详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月2日 下午6:20:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月2日 下午6:20:38    
	 * 修改备注： 
	 * &#64;param seatDevice
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("findSeatDeviceByID")
	@ResponseBody
	public ResponseServer findSeatDeviceByID(SeatDevice seatDevice) {
		seatDevice = seatDeviceService.findSeatDeviceByID(seatDevice);
		return ResponseServer.success(seatDevice);
	}

	/**
	 * <pre>
	 * updateSeatDeviceByID(修改坐席的设备的信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月8日 下午2:55:07    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月8日 下午2:55:07    
	 * 修改备注： 
	 * &#64;param seatDevice
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("updateSeatDeviceByID")
	@ResponseBody
	public ResponseServer updateSeatDeviceByID(SeatDevice seatDevice) {
		seatDeviceService.updateSeatDeviceByID(seatDevice);
		return ResponseServer.success();
	}

	////////////////////////////////////////// 设备的关联//////////////////////////////////////
	/**
	 * <pre>
	 * getUnitDevicesList(查询坐席跟设备的关联)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月7日 上午9:23:13    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月7日 上午9:23:13    
	 * 修改备注： 
	 * &#64;param seatUnit
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/getUnitDevicesList")
	@ResponseBody
	public ResponseServer getUnitDevicesList(SeatUnit seatUnit) {
		List<Map> seatDevices = seatDeviceService.getUnitDevicesList(seatUnit);
		return ResponseServer.success(seatDevices);
	}

	/**
	 * <pre>
	 * getDevicefindSeatUnitList(按设备的id,和坐席图的id查询坐席)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月8日 上午11:21:40    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月8日 上午11:21:40    
	 * 修改备注： 
	 * &#64;param seatDevice
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/getDevicefindSeatUnitList")
	@ResponseBody
	public ResponseServer getDevicefindSeatUnitList(Integer suSeatModelId, Integer deviceUsedId) {
		List<SeatDevice> seatDevices = seatDeviceService.getDevicefindSeatUnitList(suSeatModelId, deviceUsedId);
		return ResponseServer.success(seatDevices);
	}

	/**
	 * 获取坐席id缓存
	 * @param symbol 传false时为刷新缓存
	 * */
	@RequestMapping("/getSeatIdCache")
	@ResponseBody
	public ResponseServer getSeatIdCache(boolean symbol,Integer roomId){
		List<SeatDevice> SeatIdCache = new ArrayList();
		//获取里面的数据
		CacheManager instance = CacheManager.getInstance();
		if(symbol == false){
			instance.removeAll();
		}
		Object obj = instance.getObj("seatid");
		if(obj != null){
			contextMap = (Map<String, Object>) obj;
		}else{
			//会议室对应的坐席模板
			SeatModel seatModel = seatModelService.findRoomIdToSeatModelInfo(roomId);
			SeatIdCache = seatDeviceService.getSeatIdCache(seatModel.getId());
			for(int i=0;i<SeatIdCache.size();i++){
				StringBuffer key = new StringBuffer();
				key.append(SeatIdCache.get(i).getDeviceUsedId()).append('|')
						.append(SeatIdCache.get(i).getPassWayCode()).append('|')
						.append(SeatIdCache.get(i).getCCUAddressCode());
				String value = SeatIdCache.get(i).getSeatUnitId().toString();//获取加载出来的数据（类型视情况而定）
				//将数据放到定义好的contextMap中
				contextMap.put(key.toString(), value);
			}
			instance.putObj("seatid", contextMap);
		}
		return ResponseServer.success(contextMap);
	}
	

	/**
	 * <pre>updateSeatdeviceAddressCodeOrIpCode(批量增加设备绑定坐席的地址号和批量增加设备绑定坐席的ip地址)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月8日 上午11:37:53    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月8日 上午11:37:53    
	 * 修改备注： 
	 * @param seatdeviceAddressCodeVo
	 * @return</pre>
	 */
	@RequestMapping("/updateSeatdeviceAddressCodeOrIpCode")
	@ResponseBody
	public ResponseServer updateSeatdeviceAddressCodeOrIpCode(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo) {
		if("AddressCode".equals(seatdeviceAddressCodeVo.getType())) {
			//批量增加设备绑定坐席的地址号
			List<SeatDevice> seatDevices=seatDeviceService.updateSeatdeviceAddressCode(seatdeviceAddressCodeVo);
			return ResponseServer.success(seatDevices);
		}else if ("IpCode".equals(seatdeviceAddressCodeVo.getType())) {
			//批量增加设备绑定坐席的ip地址
			List<SeatDevice> seatDevices=seatDeviceService.updateSeatdeviceIPAddress(seatdeviceAddressCodeVo);
			return ResponseServer.success(seatDevices);
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}
	
	/**
	 * <pre>updateSeatdevicePassWayCode(批量增加设备绑定坐席的通道号)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月9日 上午11:15:38    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月9日 上午11:15:38    
	 * 修改备注： 
	 * @param ids
	 * @param intValue
	 * @return</pre>
	 */
	@RequestMapping("/updateSeatdevicePassWayCode")
	@ResponseBody
	public ResponseServer updateSeatdevicePassWayCode(String ids,Integer intValue) {
		//坐席绑定设备的id集合ids,通道号strValue
		if(!StringUtils.isEmpty(ids)&&intValue!=null) {
			List<SeatDevice> seatDevices=seatDeviceService.updateSeatdevicePassWayCode(ids,intValue);
			return ResponseServer.success(seatDevices);
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}
	
	/**
	 * <pre>updateSeatdeviceTouchScreenSet(批量增加设备绑定坐席的触摸屏配置)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月9日 上午11:04:56    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月9日 上午11:04:56    
	 * 修改备注： 
	 * @param ids
	 * @param strValue
	 * @return</pre>
	 */
	@RequestMapping("/updateSeatdeviceTouchScreenSet")
	@ResponseBody
	public ResponseServer updateSeatdeviceTouchScreenSet(String ids,String strValue) {
		//坐席绑定设备的id集合ids,触摸屏配置的值strValue  
		if(!StringUtils.isEmpty(ids)&&!StringUtils.isEmpty(strValue)) {
			List<SeatDevice> seatDevices=seatDeviceService.updateSeatdeviceTouchScreenSet(ids,strValue);
			return ResponseServer.success(seatDevices);
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}
	
	/**
	 * <pre>deleteSeatdevices(批量解绑坐席设备)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月25日 上午11:01:42    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月25日 上午11:01:42    
	 * 修改备注： 
	 * @param seatIds
	 * @param deviceId
	 * @return</pre>
	 */
	@RequestMapping("/deleteSeatdevices")
	@ResponseBody
	public ResponseServer deleteSeatdevices(String seatIds,Integer deviceId,Integer suSeatModelId) {
		//seatIds坐席id的集合;deviceId设备id
		if(!StringUtils.isEmpty(seatIds)&&deviceId!=null) {
			seatDeviceService.deleteSeatdevices(seatIds,deviceId);
			List<SeatDevice> seatDevices = seatDeviceService.getDevicefindSeatUnitList(suSeatModelId, deviceId);
			return ResponseServer.success(seatDevices);
		}
		return ResponseServer.error(ResponseEnum.INFO_NULL);
	}

}
