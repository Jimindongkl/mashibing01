package org.ld.service.fileService;

import java.util.List;
import java.util.Map;

import org.ld.model.fileModel.CongressBulletinFile;
import org.ld.vo.MoveVo;

public interface ICongressBulletinFileService {

	List<CongressBulletinFile> findCongressIDToCongressBulletinFiles(CongressBulletinFile congressBulletinFile);

	void saveCongressBulletinFile(CongressBulletinFile congressBulletinFile, List<Map<String, Object>> result);

	void deleteCongresBulletinFiles(String ids);

	void UpdateCongresBulletinFilesOrder(MoveVo moveVo);

}
