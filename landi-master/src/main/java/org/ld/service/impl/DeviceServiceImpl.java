package org.ld.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ld.dao.DeviceDao;
import org.ld.dao.DictionaryDao;
import org.ld.model.Device;
import org.ld.model.Dictionary;
import org.ld.service.IDeviceService;
import org.ld.utils.Util;
import org.ld.vo.ComboTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

@Service("deviceService")
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    private DeviceDao deviceDao;
    
    @Autowired
    private DictionaryDao dictionaryDao;
    @Override
    public List<Device> getDeviceList() {
        //查询所有设备信息
        List<Device> deviceList = deviceDao.getDeviceList();
        return deviceList;
    }


    @Override
    public List<Device> getDeviceByConditions(Device device) {
        //按条件查询设备信息
        List<Device> deviceList = deviceDao.getDeviceByConditions(device);
        return deviceList;
    }

    @Override
    public void addOrUpdateDevice(Device device) {
        //通过id判断增加还是修改
        Date  date = new Date();
        if(device.getDevID() != null){
            device.setDevUpdateTime(date);
            deviceDao.updateDevice(device);
        }else{
            /*UUID uuid = UUID.randomUUID();
            device.setDevID(uuid.toString());*/
            //设备创建时间
            device.setDevCreateTime(date);
            device.setDevUpdateTime(date);
            deviceDao.addDevice(device);
        }
    }

    /**
     * 根据id 修改设备名称
     * */
    public void updateDeviceName(Device device ){
        Date  date = new Date();
        device.setDevUpdateTime(date);
        deviceDao.updateDeviceName(device);
    }

    @Override
    public void deleteDevice(String ids) {
        // 字符串转List
        List<String> idList = new ArrayList<>();
        idList = Util.StringPareList(ids);
        deviceDao.deleteDeviceUsed(idList);//如果有相关联的 活动设备 会一并删除
        deviceDao.deleteDevice(idList);
    }

    @Override
	public List<Dictionary> findDevicetType(String str) {
		
		return dictionaryDao.getDictionaryByStr(str);
	}

    //设备库 树结构处理
	@Override
	public List<ComboTree> getDeviceTree() {
				Map<String, Object> typeMap = new HashMap<String, Object>();
				typeMap.put("type", "typeMap");
				Map<String, Object> deviceMap = new HashMap<String, Object>();
				deviceMap.put("type", "device");
				Device deviceCondition = new Device();
				List<Device> deviceList=deviceDao.getDevTypeID();
				List<ComboTree> comboTrees = new ArrayList<ComboTree>();
						// 2,遍历相关联的
						for (Device device : deviceList) {
							ComboTree combotree = new ComboTree();
							combotree.setChildren(new ArrayList<ComboTree>());
							//根据设备类型查询对应设备列表
							deviceCondition.setDevTypeID(device.getDevTypeID());
							List<Device> agendas=deviceDao.getDeviceByConditions(deviceCondition);
							// 获取全部议程
							for (Device agenda : agendas) {
								//遍历数据
								Device comboNode = new Device();
								comboNode.setId(agenda.getDevID());
								comboNode.setText(agenda.getDevName());
								comboNode.setDevID(agenda.getDevID());
								comboNode.setDevName(agenda.getDevName());
								comboNode.setDevTypeID(agenda.getDevTypeID());
								comboNode.setDevTypeName(agenda.getDevTypeName());
								comboNode.setDevConnType(agenda.getDevConnType());
								comboNode.setDevNetIPAddress(agenda.getDevNetIPAddress());
								comboNode.setDevNetRecvPort(agenda.getDevNetRecvPort());
								comboNode.setDevNetSendPort(agenda.getDevNetSendPort());
								comboNode.setDevSerialPortCode(agenda.getDevSerialPortCode());
								comboNode.setDevPassWayStartNum(agenda.getDevPassWayStartNum());
								comboNode.setDevPassWayCount(agenda.getDevPassWayCount());
								comboNode.setDevPassWayUnit(agenda.getDevPassWayUnit());
								comboNode.setDevRate(agenda.getDevRate());
								comboNode.setDevBite(agenda.getDevBite());
								comboNode.setDevParitycheck(agenda.getDevParitycheck());
								comboNode.setDevStopBit(agenda.getDevStopBit());
								comboNode.setDevSerial(agenda.getDevSerial());
								comboNode.setDevRemark(agenda.getDevRemark());
								comboNode.setDevCreateTime(agenda.getDevCreateTime());
								comboNode.setDevUpdateTime(agenda.getDevUpdateTime());
//								comboNode.setDevClassFileName(agenda.getDevClassFileName());
//								comboNode.setDevClassName(agenda.getDevClassName());
//								comboNode.setDevClassFile(agenda.getDevClassFile());
//								comboNode.setAttributes(deviceMap);
								comboNode.setChildren(new ArrayList<ComboTree>());
								combotree.getChildren().add(comboNode);
							}
							combotree.setId(StringUtils.stringToInteger(device.getDevTypeID()));
							combotree.setText(device.getDevTypeName());
							combotree.setAttributes(typeMap);
							comboTrees.add(combotree);
						}
						return comboTrees;
	}
	
}
