package org.ld.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.SeatDeviceDao;
import org.ld.dao.SeatUnitDao;
import org.ld.model.SeatDevice;
import org.ld.model.SeatUnit;
import org.ld.service.ISeatDeviceService;
import org.ld.vo.SeatUnitVo;
import org.ld.vo.SeatdeviceAddressCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service("seatDeviceService")
public class SeatDeviceServiceImpl implements ISeatDeviceService {

	@Autowired
	private SeatDeviceDao seatDeviceDao;

	@Autowired
	private SeatUnitDao seatUnitDao;

	@Override
	public void addSeatDevice(String Json) {
		JSONArray jsonArray = JSON.parseArray(Json);
		List<SeatDevice> seatDevices = new ArrayList<>();
		int size = jsonArray.size();
		for (int i = 0; i < size; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			SeatDevice seatDevice = new SeatDevice();
			Integer seatUnitId=jsonObject.getInteger("seatUnitId");
			Integer deviceUsedId=jsonObject.getInteger("deviceUsedId");
			List<SeatDevice> seatDeviceList = seatDeviceDao.findSeatDeviceByList(seatUnitId,deviceUsedId);
			if(seatDeviceList.size()==0) {
				seatDevice.setSeatUnitId(seatUnitId);
				seatDevice.setDeviceUsedId(deviceUsedId);
				seatDevice.setPassWayCode(0);
				seatDevice.setCCUAddressCode(0);
				/*
				 * seatDevice.setUnitCode(jsonObject.getString("UnitCode"));
				 * seatDevice.setIPAddress(jsonObject.getString("IPAddress"));
				 * seatDevice.setCCUAddressCode(jsonObject.getInteger("CCUAddressCode"));
				 * seatDevice.setOtherPassWayCode(jsonObject.getInteger("OtherPassWayCode"));
				 * seatDevice.setOtherAddressCode(jsonObject.getInteger("OtherAddressCode"));
				 * seatDevice.setCameraSet(jsonObject.getString("CameraSet"));
				 * seatDevice.setTouchScreenSet(jsonObject.getString("TouchScreenSet"));
				 * seatDevice.setIPAddress(jsonObject.getString("IPAddress"));
				 */
				seatDevices.add(seatDevice);
			}
		}
		seatDeviceDao.addSeatDevice(seatDevices);
		
	}

	@Override
	public SeatDevice findSeatDeviceByID(SeatDevice seatDevice) {

		return seatDeviceDao.findSeatDeviceByID(seatDevice);
	}

	@Override
	public List<Map> getUnitDevicesList(SeatUnit seatUnit) {
		List<SeatUnitVo> seatUnits = seatUnitDao.getSeatUnitsByModelId(seatUnit);
		List<Map> seatUnitsA = new ArrayList<>();
		for (int i = 0; i < seatUnits.size(); i++) {
			List<SeatDevice> deviceUseds = new ArrayList<>();
			Map map = new HashMap<>();
			deviceUseds = seatDeviceDao.getSeatDeviceUsedList((Integer) seatUnits.get(i).getId());
			map.put("id", seatUnits.get(i).getId());
			map.put("name", seatUnits.get(i).getName());
			map.put("rowId", seatUnits.get(i).getRowId());
			map.put("columnId", seatUnits.get(i).getColumnId());
			map.put("x", seatUnits.get(i).getX());
			map.put("y", seatUnits.get(i).getY());
			map.put("z", seatUnits.get(i).getZ());
			map.put("userName", seatUnits.get(i).getUserName());
			map.put("Width", seatUnits.get(i).getWidth());
			map.put("Height", seatUnits.get(i).getHeight());
			map.put("degree", seatUnits.get(i).getDegree());
			map.put("type", seatUnits.get(i).getType());
			map.put("deviceUseds", deviceUseds);
			seatUnitsA.add(map);
		}
		return seatUnitsA;
	}

	@Override
	public List<SeatDevice> getDevicefindSeatUnitList(Integer suSeatModelId, Integer deviceUsedId) {

		return seatDeviceDao.getDevicefindSeatUnitList(suSeatModelId, deviceUsedId);
	}

	@Override
	public void updateSeatDeviceByID(SeatDevice seatDevice) {

		seatDeviceDao.updateSeatDeviceByID(seatDevice);
	}

	@Override
	public  List<SeatDevice> getSeatIdCache(Integer modelId) {

		return seatDeviceDao.getSeatIdCache(modelId);
	}
	
	@Override
	public List<SeatDevice> updateSeatdeviceAddressCode(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo) {
		List<SeatDevice> seatdevices = new ArrayList<>();
		List<SeatDevice> seatdeviceResult = new ArrayList<>();
		List<Integer> idList = new ArrayList<>();
		String[] idArr = seatdeviceAddressCodeVo.getIds().split(",");
		// 赋值
		List<Integer> valueList = new ArrayList<>();
		if ("RtoL".equals(seatdeviceAddressCodeVo.getDirection())) {
			// 把传过来的id倒放
			for (int i = idArr.length - 1; i >= 0; i--) {
				idList.add(Integer.parseInt(idArr[i]));
			}
			// 开始的值
			Integer startValue = 0;
			startValue = seatdeviceAddressCodeVo.getStartValue();
			// 步长
			Integer stepSize = seatdeviceAddressCodeVo.getStepSize();
			for (int i = 0; i < idList.size(); i++) {
				// 第一个值
				if (i == 0) {
					valueList.add(startValue);
				} else {
					// 剩余的值
					startValue += seatdeviceAddressCodeVo.getStepSize();
					valueList.add(startValue);
				}
			}
		} else if ("LtoR".equals(seatdeviceAddressCodeVo.getDirection())) {
			// 把传过来的id正放
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			// 开始的值
			Integer startValue = 0;
			startValue = seatdeviceAddressCodeVo.getStartValue();
			// 步长
			Integer stepSize = seatdeviceAddressCodeVo.getStepSize();
			for (int i = 0; i < idList.size(); i++) {
				// 第一个值
				if (i == 0) {
					valueList.add(startValue);
				} else {
					// 剩余的值
					startValue += seatdeviceAddressCodeVo.getStepSize();
					valueList.add(startValue);
				}
			}
		}
		if (idList.size() > 0 || valueList.size() > 0) {
			for (int i = 0; i < idList.size(); i++) {
				SeatDevice seatDevice = new SeatDevice();
				seatDevice.setId(idList.get(i));
				seatDevice.setCCUAddressCode(valueList.get(i));
				seatdeviceResult.add(seatDevice);
				seatdevices.add(seatDevice);
			}
			seatDeviceDao.updateSeatdeviceAddressCode(seatdevices);
			return seatdeviceResult;
		}
		return seatdeviceResult;
	}

	@Override
	public List<SeatDevice> updateSeatdeviceIPAddress(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo) {
		List<SeatDevice> seatdevices = new ArrayList<>();
		List<SeatDevice> seatdeviceResult = new ArrayList<>();
		List<Integer> idList = new ArrayList<>();
		String[] idArr = seatdeviceAddressCodeVo.getIds().split(",");
		String ipHead = seatdeviceAddressCodeVo.getIpHead();
		// 赋值
		List<String> valueList = new ArrayList<>();
		if ("RtoL".equals(seatdeviceAddressCodeVo.getDirection())) {
			// 把传过来的id倒放
			for (int i = idArr.length - 1; i >= 0; i--) {
				idList.add(Integer.parseInt(idArr[i]));
			}
			// 开始的值
			Integer startValue = 0;
			startValue = seatdeviceAddressCodeVo.getStartValue();
			// 步长
			Integer stepSize = seatdeviceAddressCodeVo.getStepSize();
			for (int i = 0; i < idList.size(); i++) {
				// 第一个值
				if (i == 0) {
					valueList.add(ipHead+startValue);
				} else {
					// 剩余的值
					startValue += seatdeviceAddressCodeVo.getStepSize();
					valueList.add(ipHead+startValue);
				}
			}
		} else if ("LtoR".equals(seatdeviceAddressCodeVo.getDirection())) {
			// 把传过来的id正放
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			// 开始的值
			Integer startValue = 0;
			startValue = seatdeviceAddressCodeVo.getStartValue();
			// 步长
			Integer stepSize = seatdeviceAddressCodeVo.getStepSize();
			for (int i = 0; i < idList.size(); i++) {
				// 第一个值
				if (i == 0) {
					valueList.add(ipHead+startValue);
				} else {
					// 剩余的值
					startValue += seatdeviceAddressCodeVo.getStepSize();
					valueList.add(ipHead+startValue);
				}
			}
		}
		if (idList.size() > 0 || valueList.size() > 0) {
			for (int i = 0; i < idList.size(); i++) {
				SeatDevice seatDevice = new SeatDevice();
				seatDevice.setId(idList.get(i));
				seatDevice.setIPAddress(valueList.get(i));
				seatdeviceResult.add(seatDevice);
				seatdevices.add(seatDevice);
			}
			seatDeviceDao.updateSeatdeviceIPAddress(seatdevices);
			return seatdeviceResult;
		}
		return seatdeviceResult;
	}

	@Override
	public List<SeatDevice> updateSeatdeviceTouchScreenSet(String ids, String strValue) {
		List<SeatDevice> seatdevices = new ArrayList<>();
		List<SeatDevice> seatdeviceResult = new ArrayList<>();
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			SeatDevice seatDevice = new SeatDevice();
			seatDevice.setId(Integer.parseInt(id));
			seatDevice.setTouchScreenSet(strValue);
			seatdeviceResult.add(seatDevice);
			seatdevices.add(seatDevice);
		}
		if(seatdevices.size()>0) {
			seatDeviceDao.updateSeatdeviceTouchScreenSet(seatdevices);
			return seatdeviceResult;
		}
		return seatdeviceResult;
	}

	@Override
	public List<SeatDevice> updateSeatdevicePassWayCode(String ids, Integer intValue) {
		List<SeatDevice> seatdevices = new ArrayList<>();
		List<SeatDevice> seatdeviceResult = new ArrayList<>();
		String[] idArr = ids.split(",");
		for (String id : idArr) {
			SeatDevice seatDevice = new SeatDevice();
			seatDevice.setId(Integer.parseInt(id));
			seatDevice.setPassWayCode(intValue);
			seatdeviceResult.add(seatDevice);
			seatdevices.add(seatDevice);
		}
		if(seatdevices.size()>0) {
			seatDeviceDao.updateSeatdevicePassWayCode(seatdevices);
			return seatdevices;
		}
		return seatdevices;
	}

	@Override
	public void deleteSeatdevices(String seatIds, Integer deviceId) {
		if (StringUtils.isNotEmpty(seatIds)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = seatIds.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			seatDeviceDao.deleteSeatdevices(idList,deviceId);
		}
		
	}

}
