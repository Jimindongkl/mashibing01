package org.ld.service.congressService;

import java.util.List;
import java.util.Map;

import org.ld.model.congressModel.CongressPerson;
import org.ld.vo.CongressPersonSeatUnitVo;

public interface ICongressPersonService {

	List<CongressPersonSeatUnitVo> getCongressPersonList(CongressPerson congressPerson);
	
	void addCongressPerson(CongressPerson congressPerson);

	Map findCongressPersonByID(CongressPerson congressPerson);

	void updateCongressPerson(CongressPerson congressPerson);

	void deleteCongressPersons(String ids);

	String addCongressPersonsList(String persons, Integer congressID,String typeId);

}
