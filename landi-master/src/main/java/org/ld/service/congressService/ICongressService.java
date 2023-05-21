package org.ld.service.congressService;

import java.util.List;

import org.ld.model.Dictionary;
import org.ld.model.Room;
import org.ld.model.congressModel.Agenda;
import org.ld.model.congressModel.Congress;
import org.ld.vo.ComboTree;

public interface ICongressService {

	List<Congress> findCongressList();

	List<Dictionary> findCheckInType(String str);

	List<Dictionary> findSeatMode(String str);

	List<Dictionary> findCongressType(String str);
	
	List<Dictionary> findPersonStatus(String str);

	void addorupdateCongress(Congress congress);

	void deleteCongress(String ids);

	void addorupdateAgenda(Agenda agenda);

	void deleteAgenda(String ids);

	List<Agenda> findCongresAgendasList(Congress congress);

	List<ComboTree> findAgendaTree(Congress congress);

}
