package org.ld.controller;

import org.ld.model.Device;
import org.ld.model.Dictionary;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IDeviceService;
import org.ld.vo.ComboTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备库操作
 * */
@Controller
@RequestMapping("deviceController")
public class DeviceController {

    @Resource(name = "deviceService")
    private IDeviceService deviceService;

    /**
     * 获取设备 树
     * */
    @RequestMapping("/findDeviceTree")
    @ResponseBody
    public ResponseServer findDeviceTree() {
//    	Map<String,Object> comboTrees = deviceService.getDeviceTree();
    	List<ComboTree> comboTrees = deviceService.getDeviceTree();
    	return ResponseServer.success(comboTrees);
    }
    /**
     * 获取设备列表
     * */
    @RequestMapping("/getDeviceList")
    @ResponseBody
    public ResponseServer getDeviceList(){
        //查询所有设备库信息
        Map map = new HashMap<>();
        List<Device> deviceList = deviceService.getDeviceList();
        map.put("deviceList", deviceList);
        return ResponseServer.success(map);
    }
    /** 
     * 按条件查询 设备信息
     * */
    @RequestMapping("/getDeviceByConditions")
    @ResponseBody
    public ResponseServer getDeviceByConditions(Device device){
        //按条件查询设备库信息
        Map map = new HashMap();
        List<Device> deviceList = new ArrayList<>();
        deviceList = deviceService.getDeviceByConditions(device);
        map.put("deviceList", deviceList);
        return ResponseServer.success(map);
    }
    /**
     * 添加或修改 设备信息
     * */
    @RequestMapping("/addOrUpdateDevice")
    @ResponseBody
    public ResponseServer addOrUpdateDevice(Device device){
        //添加或修改设备信息
        deviceService.addOrUpdateDevice(device);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }

    /**
     * 修改设备名称及通讯类型（供前段 实现同步修改设备库名称）
     * */
    @RequestMapping("/updateDeviceName")
    @ResponseBody
    public ResponseServer updateDeviceName(Device device ){
        //根据id修改设备名称
        deviceService.updateDeviceName(device);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }

    /**
     * 批量删除设备信息
     * @param Ids
     * */
    @RequestMapping("/deleteDevice")
    @ResponseBody
    public ResponseServer deleteDevice(String Ids){
        //根据ids删除设备信息
        deviceService.deleteDevice(Ids);
        return ResponseServer.success();
    }

    /**
     * 获取设备类型下拉列表
     * form t_dictionary where dic_sort = '设备类型'
     * */
    @RequestMapping("/getDevicetype")
    @ResponseBody
    public ResponseServer getDevicetype(){
        //设备类型下拉
    	String str = "设备类型";
        List<Dictionary> dictionaryList = new ArrayList<>();
        dictionaryList = deviceService.findDevicetType(str);
        return ResponseServer.success(dictionaryList);
    }
	
}
