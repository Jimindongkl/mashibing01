package org.ld.dao.paperlessDao;

import java.util.List;

import org.ld.model.paperlessModel.PersoncongressFile;
import org.ld.model.paperlessModel.PersoncongressText;

public interface PersoncongressTextDao {

	//批量修改文字批注
	void updatePersoncongressTextbatch(List<PersoncongressText> updatePersoncongressTextList);

	//批量增加文字批注
	void addPersoncongressTextbatch(List<PersoncongressText> updatePersoncongressTextList);

	//批量删除文字批注
	void delectOneselfTextPiZhu(List<Integer> idList);
	
	//查看个人的文字批注
	List<PersoncongressText> findOneselfTextPiZhu(PersoncongressText personcongressText);

	//单个修改文字批注
	void updateTextPiZhu(PersoncongressText updateText);

	//单个增加文字批注
	Integer addTextPiZhu(PersoncongressText addText);

	//按伪id批量删除文字批注
	void delectOneselfTextPiZhuFaseID(List<String> idList);

	//按照伪id查询数据
	List<PersoncongressText> findFalseIDList(String falseid);

	
}
