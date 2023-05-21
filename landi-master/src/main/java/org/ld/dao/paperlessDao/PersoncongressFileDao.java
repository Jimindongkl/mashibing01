package org.ld.dao.paperlessDao;

import java.util.List;

import org.ld.model.paperlessModel.PersoncongressFile;

public interface PersoncongressFileDao {

	//增加手写批注
	int addOneselfFilePiZhu(PersoncongressFile personcongressFile);
	
	//查看个人的手写批注
	List<PersoncongressFile> findOneselfFilePiZhu(PersoncongressFile personcongressFile);

	//查看个人的手写批注文件的路径
	List<PersoncongressFile> findOneselfFilePiZhuPath(List<Integer> idList);

	//删除个人的手写批注(数据库)
	void delectOneselfFilePiZhu(List<Integer> idList);

	//编辑个人手写批注
	void updateOneselfFilePiZhu(PersoncongressFile personcongressFile);

}
