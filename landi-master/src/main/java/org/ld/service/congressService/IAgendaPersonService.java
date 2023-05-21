package org.ld.service.congressService;

import java.util.List;
import java.util.Map;

import org.ld.model.congressModel.AgendaPerson;
import org.ld.model.congressModel.CongressPerson;
import org.ld.vo.AgendaPersonResult;
import org.ld.vo.AgendaPersonResultByModelVo;
import org.ld.vo.AgendaPersonSeatUnitVo;
import org.ld.vo.SwopSeatUnitVo;

public interface IAgendaPersonService {

	void addAgendaPerson(AgendaPerson agendaPerson);

	List<AgendaPersonSeatUnitVo> getAgendaPersonList(AgendaPerson agendaPerson);

	AgendaPersonResultByModelVo findAgendaPersonByID(AgendaPerson agendaPerson);

	void updateAgendaPerson(AgendaPerson agendaPerson);

	void deleteAgendaPersons(String ids);

	String addAgendaPersonsList(String persons, Integer agendaID, String typeId);

	void updateAgendaPersonBondSeatUnit(AgendaPersonSeatUnitVo agendaPersonSeatUnitVo);

	List<AgendaPersonResult> getAgendaPersonListInt(AgendaPersonResult aendaPersonResult);

	void updateAgendaPersonRemoveSeatUnit(AgendaPersonSeatUnitVo agendaPersonSeatUnitVo);

	void updateSwopSeatUnit(String swopSeatUnit);

}
