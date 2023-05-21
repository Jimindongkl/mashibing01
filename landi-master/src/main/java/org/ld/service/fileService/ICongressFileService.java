package org.ld.service.fileService;

import java.util.List;
import java.util.Map;

import org.ld.model.fileModel.CongressFile;
import org.ld.vo.MoveVo;

public interface ICongressFileService {

	void saveCongressFile(CongressFile congressFile, List<Map<String, Object>> result);

	List<CongressFile> findCongressFiles(CongressFile congressFile);

	void updateCongressFile(CongressFile congressFile);

	void deleteCongresFiles(String ids);

	void UpdateCongresFilesOrder(MoveVo moveVo);

}
