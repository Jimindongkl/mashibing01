package org.ld.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.DeviceUsedDao;
import org.ld.dao.SeatDeviceDao;
import org.ld.model.DeviceUsed;
import org.ld.model.SeatDevice;
import org.ld.response.ResponseServer;
import org.ld.service.IDeviceUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("deviceUsedService")
public class DeviceUsedServiceImpl implements IDeviceUsedService {

    @Autowired
    private DeviceUsedDao deviceUsedDao;
    
    @Autowired
	private SeatDeviceDao seatDeviceDao;
    
    /** 查询所有活动设备信息*/
    @Override
    public List<DeviceUsed> getAllDeviceUsed() {
        List<DeviceUsed>deviceUsedList = deviceUsedDao.getAllDeviceUsed();
        return deviceUsedList;
    }
    /** 按条件查询活动设备信息*/
    @Override
    public List<DeviceUsed> getDeviceUsedByConditions(DeviceUsed deviceUsed) {
        List<DeviceUsed> deviceUseds = deviceUsedDao.getDeviceUsedByConditions(deviceUsed);
        return deviceUseds;
    }
    /**
     * 添加或修改 活动设备
     * */
    @Override
    public void addOrUpdateDeviceUsed(DeviceUsed deviceUsed) {
        //通过id判断增加还是修改
        Date date = new Date();
        if(deviceUsed.getDuId() != null){
            deviceUsedDao.updateDeviceUsed(deviceUsed);
        }else{
            /*UUID uuid = UUID.randomUUID();
            deviceUsed.setDuIduuid.toString());*/
            deviceUsedDao.addDeviceUsed(deviceUsed);
        }
    }

    /** 添加活动设备信息*/
    @Override
    public void addDeviceUsed(DeviceUsed deviceUsed) {

            deviceUsedDao.addDeviceUsed(deviceUsed);

    }
    /** 修改活动设备信息*/
    @Override
    public void updateDeviceUsed(DeviceUsed deviceUsed) {
        deviceUsedDao.updateDeviceUsed(deviceUsed);
    }

    @Override
    public ResponseServer deleteDeviceUsed(String ids) {
    	Integer error = 0;
    	Integer end = 0;
    	if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			List<Integer> delIds = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
				delIds.add(Integer.parseInt(id));
			}
			int start = idList.size();
			//遍历idList
			for(int i=0;i<idList.size();i++) {
				//查有没有活动设备绑定的坐席;如果有就从idList中去除掉,不能删除。
				List<SeatDevice> seatDevices =seatDeviceDao.findIsNotseatDevice(idList.get(i));
				if(seatDevices.size()>0) {
					for(int j= 0;j<delIds.size();j++) {
						if(delIds.get(j)==idList.get(i)) {
							delIds.remove(j);
								break;
						}
					}
				}
			}
			if(delIds.size()>0) {
				 end = delIds.size();
				 error = start - end;
				 deviceUsedDao.deleteDeviceUsed(delIds);
			}
			
		}
            return ResponseServer.success("成功删除【"+end+"】个设备;有关联设备【"+error+"】个删除失败");
    }
}
