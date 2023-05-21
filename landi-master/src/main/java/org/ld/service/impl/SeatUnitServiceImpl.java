package org.ld.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.SeatUnitDao;
import org.ld.model.SeatDevice;
import org.ld.model.SeatModel;
import org.ld.model.SeatUnit;
import org.ld.service.ISeatUnitService;
import org.ld.vo.AgendaPersonResult;
import org.ld.vo.SeatUnitVo;
import org.ld.vo.SeatdeviceAddressCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service("seatUnitService")
public class SeatUnitServiceImpl implements ISeatUnitService {

	@Autowired
	private SeatUnitDao seatUnitDao;

	@Override
	public List<SeatUnitVo> getSeatUnitsByModelId(SeatUnit seatUnit) {
		List<SeatUnitVo> seatUnitList = new ArrayList<>();
		seatUnitList = seatUnitDao.getSeatUnitsByModelId(seatUnit);
		return seatUnitList;
	}

	@Override
	public void addSeatUnits(SeatUnit seatUnit, String str) {
		Integer modelId = seatUnit.getSuSeatModelId();
		JSONArray jsonArray = JSON.parseArray(str);
		List<SeatUnit> seatUnitList = new ArrayList<>();
		int size = jsonArray.size();
		for (int i = 0; i < size; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			SeatUnit seatUnits = new SeatUnit();
			seatUnits.setSuSeatModelId(modelId);
			seatUnits.setSuId(jsonObject.getIntValue("id"));
			seatUnits.setSuName(jsonObject.getString("name"));
			seatUnits.setSuRow(jsonObject.getInteger("rowId"));
			seatUnits.setSuColumn(jsonObject.getInteger("columnId"));
			seatUnits.setSuXpoint(Double.parseDouble(jsonObject.getString("x")));
			seatUnits.setSuYpoint(Double.parseDouble(jsonObject.getString("y")));
			seatUnits.setSuZpoint(Double.parseDouble(jsonObject.getString("z")));
			seatUnits.setUserName(jsonObject.getString("userName"));
			seatUnits.setSuWidth(jsonObject.getInteger("Width"));
			seatUnits.setSuHeight(jsonObject.getInteger("Height"));
			seatUnits.setAngle(Double.parseDouble(jsonObject.getString("degree")));
			seatUnits.setType(jsonObject.getString("type"));
			seatUnitList.add(seatUnits);
		}
		seatUnitDao.addSeatUnits(seatUnitList);
	}

	@Override
	public void modifyUnits(SeatUnit seatUnit) {
		seatUnitDao.modifySeatUnits(seatUnit);
	}

	@Override
	public void deleteSeatUnits(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			seatUnitDao.deleteSeatUnits(idList);
		}

	}

	@Override
	public SeatUnit addSeatUnit(SeatModel seatModel) {
		String str = seatModel.getFileXML();
		SeatUnit seatUnit = new SeatUnit();
		if (!StringUtils.isEmpty(str)) {
			JSONObject jSONObject = JSON.parseObject(str);
			seatUnit.setSuSeatModelId(seatModel.getId());
			seatUnit.setSuName(jSONObject.getString("name"));
			seatUnit.setSuRow(jSONObject.getInteger("rowId"));
			seatUnit.setSuColumn(jSONObject.getInteger("columnId"));
			seatUnit.setSuXpoint(Double.parseDouble(jSONObject.getString("x")));
			seatUnit.setSuYpoint(Double.parseDouble(jSONObject.getString("y")));
			seatUnit.setSuZpoint(Double.parseDouble(jSONObject.getString("z")));
			seatUnit.setUserName(jSONObject.getString("userName"));
			seatUnit.setSuWidth(jSONObject.getInteger("Width"));
			seatUnit.setSuHeight(jSONObject.getInteger("Height"));
			seatUnit.setAngle(Double.parseDouble(jSONObject.getString("degree")));
			seatUnit.setType(jSONObject.getString("type"));
		}
		int i = seatUnitDao.addSeatUnit(seatUnit);
		return seatUnit;
	}

	@Override
	public SeatUnitVo findSeatUnitId(SeatUnit seatUnit) {

		return seatUnitDao.findSeatUnitId(seatUnit);
	}

	@Override
	public void updateSeatUnitId(SeatUnitVo seatUnitVo) {

		seatUnitDao.updateSeatUnitId(seatUnitVo);
	}

	@Override
	public List<Map> findRoomSeatmodelUnit(Integer roomId,Integer agendaID) {
		//查所有关于日程的所有坐席单位
		List<Map>  seatUnits= seatUnitDao.findRoomSeatUnitList(roomId);	
		//查日程下的人员
		List<Map> seatUnitsA = new ArrayList<>();
		for (int i = 0; i < seatUnits.size(); i++) {
			Map map = new HashMap<>();
			Integer si = i;
			Integer s = (Integer) seatUnits.get(i).get("id");
			AgendaPersonResult staffinfo = seatUnitDao.getAgendaPersonSeatUnitList(s,agendaID);
			map.put("id", seatUnits.get(i).get("id"));
			map.put("name", seatUnits.get(i).get("name"));
			map.put("rowId", seatUnits.get(i).get("rowId"));
			map.put("columnId", seatUnits.get(i).get("columnId"));
			map.put("x", seatUnits.get(i).get("x"));
			map.put("y", seatUnits.get(i).get("y"));
			map.put("z", seatUnits.get(i).get("z"));
			map.put("userName", seatUnits.get(i).get("userName"));
			map.put("Width", seatUnits.get(i).get("Width"));
			map.put("Height", seatUnits.get(i).get("Height"));
			map.put("degree", seatUnits.get(i).get("degree"));
			map.put("type", seatUnits.get(i).get("type"));
			map.put("uuit",new Date().getTime());
			if(staffinfo!=null) {
			map.put("agendaPersonId", staffinfo.getAgendaPersonId());
			}else {
				map.put("agendaPersonId", null);
			}
			map.put("staffinfo", staffinfo);
			seatUnitsA.add(map);
		}
		return seatUnitsA;
	}

	@Override
	public SeatUnit findPaperlessDeviceusedIP(String paperlessDeviceusedIP) {
		
		return seatUnitDao.findPaperlessDeviceusedIP(paperlessDeviceusedIP);
	}

	@Override
	public List<SeatUnit> updateSeatAddressIpsOrSpareAddressIP(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo) {
		List<SeatUnit> seatUnits = new ArrayList<>();
		List<SeatUnit> seatUnitResult = new ArrayList<>();
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
				SeatUnit seatUnit = new SeatUnit();
				seatUnit.setSuId(idList.get(i));
				seatUnit.setSuAddressIP(valueList.get(i));
				seatUnitResult.add(seatUnit);
				seatUnits.add(seatUnit);
			}
			//无纸化ip
			if("IpCode".equals(seatdeviceAddressCodeVo.getType())) {
				seatUnitDao.updateSeatAddressIps(seatUnits);
			//主持人ip
			}else if("AddressCode".equals(seatdeviceAddressCodeVo.getType())) {
				seatUnitDao.updateSeatSpareAddressIPs(seatUnits);
			}
			return seatUnitResult;
		}
		return seatUnitResult;
	}

}
