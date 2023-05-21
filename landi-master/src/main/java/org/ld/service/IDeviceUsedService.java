package org.ld.service;

import org.ld.model.DeviceUsed;
import org.ld.response.ResponseServer;

import java.util.List;

public interface IDeviceUsedService {
    //查询所有
    List<DeviceUsed> getAllDeviceUsed();

    //按条件查询
    List<DeviceUsed> getDeviceUsedByConditions(DeviceUsed deviceUsed);

    //添加 或 修改
    void addOrUpdateDeviceUsed(DeviceUsed deviceUsed);

    //添加
    void addDeviceUsed(DeviceUsed deviceUsed );
    //修改
    void updateDeviceUsed(DeviceUsed deviceUsed);

    //删除
    ResponseServer deleteDeviceUsed(String ids);

}
