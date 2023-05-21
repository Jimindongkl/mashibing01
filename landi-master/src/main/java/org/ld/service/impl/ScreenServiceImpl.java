package org.ld.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.BasicsEventDao;
import org.ld.dao.ScreenDao;
import org.ld.dao.ScreenFormDao;
import org.ld.dao.ScreenFormEventDao;
import org.ld.model.BasicsEvent;
import org.ld.model.RoomPart;
import org.ld.model.Screen;
import org.ld.model.ScreenForm;
import org.ld.model.ScreenFormEvent;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.IScreenService;
import org.ld.utils.Util;
import org.ld.vo.ScreenJsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("screenService")
public class ScreenServiceImpl implements IScreenService {

	@Autowired
	private ScreenDao screenDao;

	@Autowired
	private ScreenFormDao screenFormDao;

	@Autowired
	private BasicsEventDao basicsEventDao;

	@Autowired
	private ScreenFormEventDao screenFormEventDao;

	@Override
	public List<Screen> findScreenList() {

		return screenDao.findScreenList();
	}

	@Override
	public void addOrupdateScreen(Screen screen) {
		if (screen.getId() != null) {
			// 修改
			screen.setUpdateTime(new Date());
			screenDao.updateScreen(screen);
		} else {
			// 增加
			Date d = new Date();
			screen.setCreateTime(d);
			screen.setUpdateTime(d);
			screen.setSortID(1);
			int sid = screenDao.addScreen(screen);
			Integer e = screen.getId();
			// 绑定事件
			// 1，查事件
			List<BasicsEvent> basicsEvents = basicsEventDao.findBasicsEventList();
			List EventList = new ArrayList<>();
			for (int i = 0; i < basicsEvents.size(); i++) {
				ScreenFormEvent screenFormEvent = new ScreenFormEvent();
				screenFormEvent.setScreenId(e);
				screenFormEvent.setSfeTypeName(basicsEvents.get(i).getBasTypeName());
				screenFormEvent.setSfeName(basicsEvents.get(i).getBasName());
				screenFormEvent.setSfeDescribe(basicsEvents.get(i).getBasDescribe());
				screenFormEvent.setStopTime(0);
				Date t = new Date();
				screenFormEvent.setCreateTime(t);
				screenFormEvent.setUpdateTime(t);
				EventList.add(screenFormEvent);
			}
			if (EventList != null) {
				// 2,绑定事件
				screenFormEventDao.addBasicsEvent(EventList);
			}

		}
	}

	@Override
	public void deleteBatchScreen(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> list = new ArrayList<>();
			String[] args = ids.split(",");
			for (String temp : args) {
				list.add(Integer.parseInt(temp));
			}
			// 1，删除大屏下的事件
			screenFormEventDao.deleteBatchScreenFormEvent(list);
			// 2，在删除大屏 顺序不能错
			screenDao.deleteBatchScreen(list);
		}

	}

	@Override
	public List<ScreenForm> findScreenFormList(Screen screen) {

		return screenFormDao.findScreenFormList(screen);
	}

	@Override
	public void addOrupdateScreenForm(ScreenForm screenForm) {
		if (screenForm.getId() != null) {
			// 修改窗体
			screenForm.setUpdateTime(new Date());
			screenFormDao.updateScreenForm(screenForm);
		} else {
			// 增加窗体
			Date d = new Date();
			screenForm.setCreateTime(d);
			screenForm.setUpdateTime(d);
			screenForm.setTypeID(1);
			screenFormDao.addScreenForm(screenForm);
		}

	}

	@Override
	public ResponseServer deleteBatchScreenForm(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> list = new ArrayList<>();
			String[] args = ids.split(",");
			for (String temp : args) {
				list.add(Integer.parseInt(temp));
			}
			// 查事件是否绑到窗体上了
			List<ScreenFormEvent> screenFormEvents = screenFormEventDao.fidscreenForm(list);
			if (screenFormEvents == null || screenFormEvents.size() == 0) {
				screenFormDao.deleteBatchScreenForm(list);
				return ResponseServer.success();
			}
		}
		return ResponseServer.error(ResponseEnum.DELETE_ERROR);
	}

	@Override
	public ScreenForm findScreenFormContent(ScreenForm screenForm) {

		return screenFormDao.findScreenFormContent(screenForm);
	}

	@Override
	public void updateScreenFormContent(ScreenForm screenForm) {

		screenFormDao.updateScreenFormContent(screenForm);
	}

	@Override
	public List<ScreenFormEvent> findScreenEventList(Screen screen) {

		return screenFormEventDao.findScreenEventList(screen);
	}

	@Override
	public void updateFormEvent(ScreenFormEvent screenFormEvent) {

		screenFormEventDao.updateFormEvent(screenFormEvent);
	}

	@Override
	public List<ScreenFormEvent> findScreenExistEventList(String ids) {
		// TODO Auto-generated method stub
		List<ScreenFormEvent> screenFormEventList = new ArrayList<ScreenFormEvent>();
		if (StringUtils.isNotEmpty(ids)) {
				// 字符串转List
				List<Integer> list = new ArrayList<>();
				String[] args = ids.split(",");
				for (String temp : args) {
					list.add(Integer.parseInt(temp));
				}
			screenFormEventList = screenFormEventDao.findScreenExistEventList(list);
		}
		return screenFormEventList;
	}

	@Override
	public List<ScreenForm> findScreenformeventList(String strJson) {
		List<ScreenForm> screenFormList = new ArrayList<>();
		List<ScreenJsonVo> list = new ArrayList<>();
		//传递过来的数据转成Json数据
		if(StringUtils.isNotEmpty(strJson)) {
			JSONArray ay = JSONArray.fromObject(strJson);
			if (ay.size() > 0) {
				for (int i = 0; i < ay.size(); i++) {
					ScreenJsonVo screenJsonVo = new ScreenJsonVo();
					// 遍历 jsonarray 数组，把每一个对象转成 json 对象
					JSONObject job = ay.getJSONObject(i);
					screenJsonVo.setScreenID((Integer) job.get("screenID"));
					screenJsonVo.setSeventContent((String)job.get("seventContent"));
					list.add(screenJsonVo);
				}
			}
			//根据大屏的id和事件的内容查询窗体的具体字段信息
			if(list.size()>0) {
				for(int i = 0 ;i<list.size();i++) {
					List<ScreenForm> screenForms=screenFormDao.findScreenformeventList(list.get(i));
					if(screenForms.size()>0) {
						screenFormList.add(screenForms.get(0));
					}
				}
			}
		}
		return screenFormList;
	}

}
