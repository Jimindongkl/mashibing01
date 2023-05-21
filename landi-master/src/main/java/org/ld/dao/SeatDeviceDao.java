package org.ld.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.ibatis.annotations.Param;
import org.ld.model.DeviceUsed;
import org.ld.model.SeatDevice;
import org.ld.model.SeatUnit;

public interface SeatDeviceDao {

	/**
	 * <pre>
	 * addSeatDevice(坐席与设备绑定)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月2日 下午6:21:55    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月2日 下午6:21:55    
	 * 修改备注： 
	 * &#64;param seatDevices
	 * </pre>
	 */
	void addSeatDevice(List<SeatDevice> seatDevices);

	/**
	 * <pre>
	 * findSeatDeviceByID(按id查询单个坐席的详细信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月2日 下午6:21:59    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月2日 下午6:21:59    
	 * 修改备注： 
	 * &#64;param seatDevice
	 * &#64;return
	 * </pre>
	 */
	SeatDevice findSeatDeviceByID(SeatDevice seatDevice);

	/**
	 * <pre>
	 * getUnitDevicesList(查询坐席跟设备的关联)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月7日 上午9:22:37    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月7日 上午9:22:37    
	 * 修改备注： 
	 * &#64;param seatUnit
	 * &#64;return
	 * </pre>
	 */
	List<Map> getUnitDevicesList(SeatUnit seatUnit);

	/**
	 * <pre>
	 * getSeatDeviceUsedList(按坐席id查询绑定的活动设备)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月7日 下午5:01:09    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月7日 下午5:01:09    
	 * 修改备注： 
	 * &#64;param integer
	 * &#64;return
	 * </pre>
	 */
	List<SeatDevice> getSeatDeviceUsedList(Integer seatID);

	/**
	 * <pre>
	 * getDevicefindSeatUnitList(按设备id查询坐席)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月8日 上午11:22:51    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月8日 上午11:22:51    
	 * 修改备注： 
	 * &#64;param seatDevice
	 * &#64;return
	 * </pre>
	 */
	List<SeatDevice> getDevicefindSeatUnitList(@Param("suSeatModelId") Integer suSeatModelId,
			@Param("deviceUsedId") Integer deviceUsedId);

	/**
	 * <pre>
	 * updateSeatDeviceByID(修改坐席的设备的信息)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月8日 下午2:57:10    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月8日 下午2:57:10    
	 * 修改备注： 
	 * &#64;param seatDevice
	 * </pre>
	 */
	void updateSeatDeviceByID(SeatDevice seatDevice);

	/**
	 * <pre>findIsNotseatDevice(用活动设备查询绑定坐席的情况)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年4月17日 下午4:12:15    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年4月17日 下午4:12:15    
	 * 修改备注： 
	 * @param integer
	 * @return</pre>
	 */
	List<SeatDevice> findIsNotseatDevice(Integer deviceUsedId);

	

	//查询坐席id缓存
	List<SeatDevice> getSeatIdCache(Integer modelId);
	
	/**
	 * <pre>updateSeatdeviceAddressCode(批量修改地址号)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月8日 下午6:11:52    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月8日 下午6:11:52    
	 * 修改备注： 
	 * @param seatdevices</pre>
	 */
	void updateSeatdeviceAddressCode(List<SeatDevice> seatdevices);

	/**
	 * <pre>updateSeatdeviceIPAddress(批量修改ip地址)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月9日 上午10:34:18    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月9日 上午10:34:18    
	 * 修改备注： 
	 * @param seatdevices</pre>
	 */
	void updateSeatdeviceIPAddress(List<SeatDevice> seatdevices);

	/**
	 * <pre>updateSeatdeviceTouchScreenSet(批量修改触摸屏)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月9日 上午11:02:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月9日 上午11:02:54    
	 * 修改备注： 
	 * @param seatdevices</pre>
	 */
	void updateSeatdeviceTouchScreenSet(List<SeatDevice> seatdevices);

	/**
	 * <pre>updateSeatdevicePassWayCode(批量修改通道号)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月9日 上午11:17:30    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月9日 上午11:17:30    
	 * 修改备注： 
	 * @param seatdevices</pre>
	 */
	void updateSeatdevicePassWayCode(List<SeatDevice> seatdevices);

	/**
	 * <pre>deleteSeatdevices(批量解绑坐席设备)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月25日 上午11:14:54    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月25日 上午11:14:54    
	 * 修改备注： 
	 * @param ids</pre>
	 */
	void deleteSeatdevices(@Param("idList")List<Integer> idList,@Param("deviceId")Integer deviceId);

	/**
	 * <pre>findSeatDeviceByList(一个坐席只能绑定一个一样的设备)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年5月26日 下午2:37:19    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年5月26日 下午2:37:19    
	 * 修改备注： 
	 * @param seatUnitId
	 * @param deviceUsedId
	 * @return</pre>
	 */
	List<SeatDevice> findSeatDeviceByList(@Param("seatUnitId")Integer seatUnitId, @Param("deviceUsedId")Integer deviceUsedId);

	/**
	 * <pre>deleteSeatdeviceIsSeatUnitIds(按坐席id删除绑定的设备)   
	 * 创建人：姬民东 15539277254@163.com      
	 * 创建时间：2020年7月8日 下午2:54:40    
	 * 修改人：姬民东 15539277254@163.com      
	 * 修改时间：2020年7月8日 下午2:54:40    
	 * 修改备注： 
	 * @param ins</pre>
	 */
	void deleteSeatdeviceIsSeatUnitIds(List<Integer> ins);
	
}
