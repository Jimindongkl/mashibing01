package org.ld.service;

import java.util.List;

import org.ld.model.Screen;
import org.ld.model.ScreenForm;
import org.ld.model.ScreenFormEvent;
import org.ld.response.ResponseServer;
import org.ld.vo.ScreenJsonVo;

public interface IScreenService {

	List<Screen> findScreenList();

	void addOrupdateScreen(Screen screen);

	void deleteBatchScreen(String ids);

	List<ScreenForm> findScreenFormList(Screen screen);

	void addOrupdateScreenForm(ScreenForm screenForm);

	ResponseServer deleteBatchScreenForm(String ids);

	List<ScreenFormEvent> findScreenEventList(Screen screen);

	void updateFormEvent(ScreenFormEvent screenFormEvent);

	ScreenForm findScreenFormContent(ScreenForm screenForm);

	void updateScreenFormContent(ScreenForm screenForm);

	List<ScreenFormEvent> findScreenExistEventList(String ids);

	List<ScreenForm> findScreenformeventList(String strJson);

}
