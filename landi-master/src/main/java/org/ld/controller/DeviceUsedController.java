package org.ld.controller;

import org.ld.model.DeviceUsed;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IDeviceUsedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动设备信息表
 * 被启用的设备记录在此表中
 * */
@Controller
@RequestMapping("deviceUsedController")
public class DeviceUsedController {

    @Resource(name = "deviceUsedService")
    private IDeviceUsedService deviceUsedService;

    /**
     * 活动设备列表
     * */
    @RequestMapping("/getAllDeviceUsed")
    @ResponseBody
    public ResponseServer getAllDeviceUsed(){
        Map map = new HashMap();
        List<DeviceUsed> deviceUsedList = deviceUsedService.getAllDeviceUsed();
        map.put("deviceUsedList", deviceUsedList);
        return ResponseServer.success(map);
    }
    /**
     * 按条件查询活动设备
     * */
    @RequestMapping("/getDeviceUsedByConditions")
    @ResponseBody
    public ResponseServer getDeviceUsedByConditions(DeviceUsed deviceUsed){
        Map map = new HashMap();
        List<DeviceUsed> deviceUseds = deviceUsedService.getDeviceUsedByConditions(deviceUsed);
        map.put("deviceUseds", deviceUseds);
        return  ResponseServer.success(map);
    }
    /**
     * 添加或修改活动设备
     * */
    @RequestMapping("/addOrUpdateDeviceUsed")
    @ResponseBody
    public ResponseServer addOrUpdateDeviceUsed(DeviceUsed deviceUsed){

        deviceUsedService.addOrUpdateDeviceUsed(deviceUsed);

        return  ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }
    /**
     * 新增活动设备
     * */
    @RequestMapping("/addDeviceUsed")
    @ResponseBody
    public ResponseServer addDeviceUsed(DeviceUsed deviceUsed){

        deviceUsedService.addDeviceUsed(deviceUsed);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }

    /**
     * 修改活动设备
     * */
    @RequestMapping("/updateDeviceUsed")
    @ResponseBody
    public ResponseServer updateDeviceUsed(DeviceUsed deviceUsed){
        deviceUsedService.updateDeviceUsed(deviceUsed);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }
    /**
     * 删除活动设备
     * */
    @RequestMapping("/deleteDeviceUsed")
    @ResponseBody
    public ResponseServer deleteDeviceUsed(String Ids){
        //根据Ids删除活动设备数据
    	ResponseServer s=deviceUsedService.deleteDeviceUsed(Ids);
        return s;
    }
}
