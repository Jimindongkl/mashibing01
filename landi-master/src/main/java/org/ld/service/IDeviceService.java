package org.ld.service;

import java.util.List;

import org.ld.model.Device;
import org.ld.model.Dictionary;
import org.ld.vo.ComboTree;

public interface IDeviceService {
    //全查询查询
    List<Device> getDeviceList();
    //按条件查询
    List<Device> getDeviceByConditions(Device device);
    //添加或修改
    void addOrUpdateDevice(Device device);
    //根据id 修改设备名称
    void updateDeviceName(Device device);
    //删除
    void deleteDevice(String ids);
    //设备类型下拉
	List<Dictionary> findDevicetType(String str);
	//获取 设备树
//	Map<String,Object> getDeviceTree();
	//
	List<ComboTree> getDeviceTree();
}
