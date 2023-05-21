package org.ld.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.RoomDao;
import org.ld.dao.SeatDeviceDao;
import org.ld.dao.SeatModelDao;
import org.ld.dao.SeatThemeDao;
import org.ld.dao.SeatUnitDao;
import org.ld.model.Room;
import org.ld.model.SeatModel;
import org.ld.model.SeatTheme;
import org.ld.model.SeatUnit;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.ISeatModelService;
import org.ld.utils.Util;
import org.ld.vo.SeatUnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

@Service("seatModelService")
public class SeatModelServiceImpl implements ISeatModelService{

	@Autowired
	private SeatModelDao seatModelDao;
	
	@Autowired
	private SeatUnitDao seatUnitDao;
	
	@Autowired
	private SeatThemeDao seatThemeDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private SeatDeviceDao seatDeviceDao;


	@Override
	public List<SeatModel> getSeatModels(SeatModel seatModel) {
		/*List<SeatModel> seatModels = new ArrayList<>();*/
		List<SeatModel> modelList = seatModelDao.getSeatModels(seatModel);
		/*if(modelList.size()>0) {
			for(int i=0;i<modelList.size();i++) {
				SeatUnit seatUnit = new SeatUnit();
				SeatModel seatModelNew = new SeatModel();
				seatModelNew.setId(modelList.get(i).getId());
				seatModelNew.setModelName(modelList.get(i).getModelName());
				seatModelNew.setWidth(modelList.get(i).getWidth());
				seatModelNew.setHeight(modelList.get(i).getHeight());
				seatModelNew.setRow(modelList.get(i).getRow());
				seatModelNew.setColumn(modelList.get(i).getColumn());
				seatModelNew.setBackground(modelList.get(i).getBackground());
				seatModelNew.setCreateTime(modelList.get(i).getCreateTime());
				seatModelNew.setUpdateTime(modelList.get(i).getUpdateTime());
				seatUnit.setSuSeatModelId(modelList.get(i).getId()); 
				List<SeatUnitVo> list=seatUnitDao.getSeatUnitsByModelId(seatUnit);
				if(list.size()>0) {
					String array= JSONArray.parseArray(JSON.toJSONString(list,SerializerFeature.
							WriteNullStringAsEmpty)).toString();
					seatModelNew.setFileXML(array);
				}
				seatModels.add(seatModelNew);
			}
			return seatModels;
		}*/
		return modelList;
	}

	@Override
	public void addOrUpdateSeatModel(SeatModel seatModel) {
		String str = seatModel.getFileXML();
		Date  date = new Date();
		if(seatModel.getId() != null){
			//修改坐席图
			seatModel.setUpdateTime(date);
			seatModel.setFileXML("");
			seatModelDao.updateSeatModel(seatModel);
		}else{
			//增加
			seatModel.setCreateTime(date);
			seatModel.setFileXML("");
			int tId =seatModelDao.addSeatModel(seatModel);
			//增加矩阵
			//增加后的modelId
			Integer modelId = seatModel.getId();
			if(!StringUtils.isEmpty(str)) {
				JSONArray jsonArray = JSON.parseArray(str);
		    	 List<SeatUnit> seatUnitList = new ArrayList<>();
		    	 int size = jsonArray.size();
		         for(int i =0;i<size;i++){
			        JSONObject jsonObject = jsonArray.getJSONObject(i);
			        SeatUnit seatUnits = new SeatUnit();
			        seatUnits.setSuSeatModelId(modelId);
			        //seatUnits.setSuId(jsonObject.getIntValue("id"));
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
	         
		}
	}

	@Override
	public ResponseServer updateSeatUnits(SeatModel seatModel) {
		Integer modelId = seatModel.getId();
		String str = seatModel.getFileXML();
		if(modelId!=null && !StringUtils.isEmpty(str)) {
			JSONArray jsonArray = JSON.parseArray(str);
			List<SeatUnit> updateList = new ArrayList<>();
			List<SeatUnit> addList = new ArrayList<>();
			int size = jsonArray.size();
			for (int i = 0; i < size; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				SeatUnit seatUnits = new SeatUnit(); 
				if ((Integer) jsonObject.getIntValue("id") != null) {
					seatUnits.setSuId(jsonObject.getIntValue("id"));
					seatUnits.setSuName(jsonObject.getString("name"));
					seatUnits.setSuAddressIP(jsonObject.getString("suAddressIP"));
					seatUnits.setSuSpareAddressIP(jsonObject.getString("suSpareAddressIP"));
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
					updateList.add(seatUnits);
				}else{
					seatUnits.setSuSeatModelId(seatModel.getId());
					seatUnits.setSuName(jsonObject.getString("name"));
					seatUnits.setSuRow(jsonObject.getInteger("rowId"));
					seatUnits.setSuColumn(jsonObject.getInteger("columnId"));
					seatUnits.setSuXpoint(Double.parseDouble(jsonObject.getString("x")));
					seatUnits.setSuYpoint(Double.parseDouble(jsonObject.getString("y")));
					seatUnits.setSuZpoint(Double.parseDouble(jsonObject.getString("z")));
					seatUnits.setUserName(jsonObject.getString("userName"));
					seatUnits.setSuWidth(jsonObject.getInteger("Width"));
					seatUnits.setSuAddressIP(jsonObject.getString("suAddressIP"));
					seatUnits.setSuSpareAddressIP(jsonObject.getString("suSpareAddressIP"));
					seatUnits.setSuHeight(jsonObject.getInteger("Height"));
					seatUnits.setAngle(Double.parseDouble(jsonObject.getString("degree")));
					seatUnits.setType(jsonObject.getString("type"));
					addList.add(seatUnits);
				}
			}
			if(addList.size()>0) {
				seatUnitDao.addSeatUnits(addList);
			}
			if(updateList.size()>0) {
				seatUnitDao.updateSeatUnits(updateList);
			}
			return ResponseServer.success();
		}
		return ResponseServer.error(ResponseEnum.ADDORUPDATE_ERROR);
	}
	
	@Override
	public void updateFilexmlById(SeatModel seatModel) {
		Date date = new Date();
		seatModel.setUpdateTime(date);
		seatModelDao.updateFilexmlById(seatModel);
	}

	@Override
	public ResponseServer  deleteSeatModel(String str) {
		List<Integer> list = new ArrayList<>();
		list = Util.StringPareListInteger(str);
		List<Room> rooms =new ArrayList<>();
		//查看会议室中有没有使用坐席模板，如果使用则提示，没有则删除
		//有会议室引用,不允许删除
		//会议室查看
		List<Integer> inlist = new ArrayList<>();
		List<Integer> bdlist = new ArrayList<>();
		for(Integer in:list) {
			 rooms = roomDao.findRoomIsSeatModelList(in);
			 if(rooms.size()==0) {
				//先去除设备跟坐席的绑定
				//1,查看坐席模板下的坐席单元
				 List<Integer> ins= seatUnitDao.getSeatUnitsIntegerByModelId(in);
				//2,删除坐席单元与设备的绑定
				 if(ins.size()>0) {
					 seatDeviceDao.deleteSeatdeviceIsSeatUnitIds(ins);
				 }
				 	inlist.add(in);
		 	}else {
		 		bdlist.add(in);
		 	}
		}
		if(inlist.size()>0) {
			seatUnitDao.deleteModelSeatUnits(inlist);
			seatModelDao.deleteSeatModel(inlist);
		}
		if(bdlist.size()>0) {
			return ResponseServer.error(ResponseEnum.ROOT_ING);
		}
		return ResponseServer.success();
	}

	@Override
	public List<SeatTheme> getSeatThemes() {
		
		return seatThemeDao.getSeatThemes();
	}

	@Override
	public void updateSeatTheme(SeatTheme seatTheme) {
		
		seatThemeDao.updateSeatTheme(seatTheme);
	}

	@Override
	public SeatModel findRoomIdToSeatModelInfo(Integer roomId) {
		
		return seatModelDao.findRoomIdToSeatModelInfo(roomId);
	}

	@Override
	public List<SeatUnitVo> getSeatUnitsByModelId(SeatModel seatModel) {
		SeatUnit seatUnit = new SeatUnit();
		seatUnit.setSuSeatModelId(seatModel.getId());
		List<SeatUnitVo> list=seatUnitDao.getSeatUnitsByModelId(seatUnit);
		return list;
	}

	
}
