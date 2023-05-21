package org.ld.dao;

import org.ld.model.DeviceUsed;

import java.util.List;

public interface DeviceUsedDao {
    //查询所有活动设备
    List<DeviceUsed> getAllDeviceUsed();
    //按条件查询活动设备
    List<DeviceUsed> getDeviceUsedByConditions(DeviceUsed deviceUsed);
    //修改
    void updateDeviceUsed(DeviceUsed deviceUsed);
    //添加
    void addDeviceUsed(DeviceUsed deviceUsed);
    //删除
    void deleteDeviceUsed(List<Integer> idList);
}
