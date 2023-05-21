package org.ld.dao;

import org.ld.model.Device;
import org.ld.model.Dictionary;

import java.util.List;

public interface DeviceDao {
    //查询设备信息
    List<Device> getDeviceList();

    //按条件查询设备信息
    List<Device> getDeviceByConditions(Device device);

    //新增设备信息
    void addDevice(Device device);

    //修改设备信息
    void updateDevice(Device device);

    //修改设备名称
    void updateDeviceName(Device device);

    //批量删除设备信息
    void deleteDevice(List<String> idList);
    //批量删除 相关活动设备信息
    void deleteDeviceUsed(List<String> idList);

    //设备类型下拉
    List<Dictionary> getDevicetype(String str);
    //获取设备库 现有的设备类型
    List<Device> getDevTypeID();
}
