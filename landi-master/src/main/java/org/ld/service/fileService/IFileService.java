package org.ld.service.fileService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IFileService {

	void addFile(Map<String, Object> map);

	List<Map<String, Object>> upload(HttpServletRequest request, String fileDirName);

}
