package org.ld.service;

import java.util.List;
import java.util.Map;

import org.ld.model.SeatDevice;
import org.ld.model.SeatUnit;
import org.ld.vo.SeatdeviceAddressCodeVo;

public interface ISeatDeviceService {

	void addSeatDevice(String json);

	SeatDevice findSeatDeviceByID(SeatDevice seatDevice);

	List<Map> getUnitDevicesList(SeatUnit seatUnit);

	List<SeatDevice> getDevicefindSeatUnitList(Integer suSeatModelId, Integer deviceUsedId);

	void updateSeatDeviceByID(SeatDevice seatDevice);

	List<SeatDevice> getSeatIdCache(Integer modelId);
	
	List<SeatDevice> updateSeatdeviceAddressCode(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo);

	List<SeatDevice> updateSeatdeviceIPAddress(SeatdeviceAddressCodeVo seatdeviceAddressCodeVo);

	List<SeatDevice> updateSeatdeviceTouchScreenSet(String ids, String strValue);

	List<SeatDevice> updateSeatdevicePassWayCode(String ids, Integer intValue);

	void deleteSeatdevices(String seatIds, Integer deviceId);
}
