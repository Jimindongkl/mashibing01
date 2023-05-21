package org.ld.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ld.model.SeatModel;
import org.ld.model.SeatUnit;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.ISeatUnitService;
import org.ld.vo.SeatUnitVo;
import org.ld.vo.SeatdeviceAddressCodeVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 席位单元 controller
 * */
@Controller
@RequestMapping("seatUnitController")
public class SeatUnitController {

    @Resource(name = "seatUnitService")
    private ISeatUnitService seatUnitService;

    /**
     * 根据坐席图id 查询坐席单元
     * @param seatUnit
     * */
    @RequestMapping("/getSeatUnitsByModelId")
    @ResponseBody
    public ResponseServer getSeatUnitsByModelId(SeatUnit seatUnit ){
        Map map = new HashMap();
        List<SeatUnitVo> seatUnitList = new ArrayList<>();
        seatUnitList = seatUnitService.getSeatUnitsByModelId(seatUnit);
        map.put("seatUnitList", seatUnitList);
        return ResponseServer.success(map);
    }

    /**
     * 增加坐席单元
     *
     * */
    @RequestMapping("/addSeatUnits")
    @ResponseBody
    public ResponseServer addSeatUnits(SeatUnit seatUnit,String  str ){
    	if(seatUnit.getSuSeatModelId()!=null) {
    		seatUnitService.addSeatUnits(seatUnit,str);
    		 return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    	}
        return ResponseServer.error(ResponseEnum.ADDORUPDATE_ERROR);
    }

    /**
     * 修改坐席单元
     * @param seatUnit
     * */
    @RequestMapping("/modifySeatUnits")
    @ResponseBody
    public ResponseServer modifySeatUnits(SeatUnit seatUnit ){
        seatUnitService.modifyUnits(seatUnit);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }
    
    
   /**
    * <pre>deleteSeatUnits(批量删除坐席单元)   
    * 创建人：姬民东 15539277254@163.com      
    * 创建时间：2020年3月9日 下午6:18:02    
    * 修改人：姬民东 15539277254@163.com      
    * 修改时间：2020年3月9日 下午6:18:02    
    * 修改备注： 
    * @param ids
    * @return</pre>
    */
    @RequestMapping("/deleteSeatUnits")
    @ResponseBody
    public ResponseServer deleteSeatUnits(String ids ){
        seatUnitService.deleteSeatUnits(ids);
        return ResponseServer.success(ResponseEnum.SUCCESS_ALL);
    }
    
    /**
     * <pre>addSeatUnit(单个增加坐席单元)   
     * 创建人：姬民东 15539277254@163.com      
     * 创建时间：2020年3月10日 上午9:00:54    
     * 修改人：姬民东 15539277254@163.com      
     * 修改时间：2020年3月10日 上午9:00:54    
     * 修改备注： 
     * @param seatModel
     * @return</pre>
     */
    @RequestMapping("/addSeatUnit")
    @ResponseBody
    public ResponseServer addSeatUnit(SeatModel seatModel){
    	Map<String,String> map = new HashMap<>();
        SeatUnit seatUnit=seatUnitService.addSeatUnit(seatModel);
        map.put("id", seatUnit.getSuId().toString());
        return ResponseServer.success(map);
    }
    
  /**
   * <pre>findSeatUnitId(按照id查询坐席单元)   
   * 创建人：姬民东 15539277254@163.com      
   * 创建时间：2020年3月13日 上午11:53:05    
   * 修改人：姬民东 15539277254@163.com      
   * 修改时间：2020年3月13日 上午11:53:05    
   * 修改备注： 
   * @param seatUnit
   * @return</pre>
   */
    @RequestMapping("/findSeatUnitId")
    @ResponseBody
    public ResponseServer findSeatUnitId(SeatUnit seatUnit){
    	SeatUnitVo seatUnitVo = seatUnitService.findSeatUnitId(seatUnit);
        return ResponseServer.success(seatUnitVo);
    }
    
    /**
     * <pre>updateSeatUnitId(按id修改坐席单元)   
     * 创建人：姬民东 15539277254@163.com      
     * 创建时间：2020年3月13日 下午2:06:28    
     * 修改人：姬民东 15539277254@163.com      
     * 修改时间：2020年3月13日 下午2:06:28    
     * 修改备注： 
     * @param seatUnitVo
     * @return</pre>
     */
    @RequestMapping("/updateSeatUnitId")
    @ResponseBody
    public ResponseServer updateSeatUnitId(SeatUnitVo seatUnitVo){
    	 seatUnitService.updateSeatUnitId(seatUnitVo);
        return ResponseServer.success();
    }
    
    /**
     * <pre>updateSeatAddressIpsOrSpareAddressIP(批量修改无纸化的ip和主持人ip)   
     * 创建人：姬民东 15539277254@163.com      
     * 创建时间：2020年5月28日 下午4:01:53    
     * 修改人：姬民东 15539277254@163.com      
     * 修改时间：2020年5月28日 下午4:01:53    
     * 修改备注： 
     * @param seatdeviceAddressCodeVo
     * @return</pre>
     */
    @RequestMapping("/updateSeatAddressIpsOrSpareAddressIP")
    @ResponseBody				
    public ResponseServer updateSeatAddressIpsOrSpareAddressIP(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo){
    	//批量增加设备绑定坐席的ip地址
		List<SeatUnit> seatUnits=seatUnitService.updateSeatAddressIpsOrSpareAddressIP(seatdeviceAddressCodeVo);
        return ResponseServer.success(seatUnits);
    }
    
    
    
}
