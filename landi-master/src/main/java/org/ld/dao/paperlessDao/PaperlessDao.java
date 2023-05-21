package org.ld.dao.paperlessDao;

import java.util.List;
import java.util.Map;

public interface PaperlessDao {

	List<Map> findPaperlessNowTopicFile(Integer status);

}
