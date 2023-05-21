package org.ld.service.fileService.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.fileDao.CongressFileDao;
import org.ld.dao.fileDao.FileTypeDao;
import org.ld.model.fileModel.CongressFile;
import org.ld.model.fileModel.FileType;
import org.ld.service.fileService.ICongressFileService;
import org.ld.utils.PropertiesUtil;
import org.ld.vo.MoveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("congressFileService")
public class CongressFileServiceServiceImpl implements ICongressFileService {

	private static final int BUFFER_SIZE = 100 * 1024;

	@Autowired
	private CongressFileDao congressFileDao;
	
	@Autowired
	private FileTypeDao fileTypeDao;

	@Override
	public List<CongressFile> findCongressFiles(CongressFile congressFile) {

		return congressFileDao.findCongressFiles(congressFile);
	}

	@Override
	public void saveCongressFile(CongressFile congressFile, List<Map<String, Object>> result) {
		// 获取config.properties文件中realPath的值
		String basePath = new PropertiesUtil("config.properties").readProperty("realPath");
		// 拼接数据
		List<CongressFile> congressFiles = new ArrayList<CongressFile>();
		if (congressFile.getAgendaID() != null && congressFile.getCongressID() != null) {
			for (int i = 0; i < result.size(); i++) {
				CongressFile congressFileNew = new CongressFile();
				congressFileNew.setCongressID(congressFile.getCongressID());
				congressFileNew.setAgendaID(congressFile.getAgendaID());
				if (congressFile.getTopicID() != null) {
					congressFileNew.setTopicID(congressFile.getTopicID());
				}
				String CfPath = basePath + "/" + result.get(i).get("realPath");
				congressFileNew.setCfName((String) result.get(i).get("fileOldName"));
				congressFileNew.setTrueFilePath(CfPath);
				congressFileNew.setCfPath(CfPath.substring(0, CfPath.indexOf("."))+".pdf");
				double size = (double) result.get(i).get("size");
				congressFileNew.setCfSize((float) size);
				//文件类型默认为第一个
				List<FileType> fileType = fileTypeDao.findFileTypes();
				congressFileNew.setCfType(fileType.get(0).getFileTypeId());
				// 排序
				/*Integer MaxOrder = i;
				Integer max = congressFileDao.getMaxCongressFileOrder();
				if (max != null) {
					MaxOrder = max + i+1;
				}*/
				long MaxOrder = new Date().getTime();
				congressFileNew.setCfSerial(MaxOrder+i);
				try {
					String d = (String) result.get(i).get("fileUploadDate");
					congressFileNew.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				congressFileNew.setCfPicPath(CfPath.substring(0, CfPath.lastIndexOf("."))+"/00001.png");
				congressFileNew.setCfIsEnabled(0);
				congressFiles.add(congressFileNew);
			}
		}
		// 批量增加
		if (congressFiles.size() > 0) {
			congressFileDao.addBatchCongressFiles(congressFiles);
		}
	}

	@Override
	public void updateCongressFile(CongressFile congressFile) {
		congressFile.setUpdateTime(new Date());
		congressFileDao.updateCongressFile(congressFile);
	}

	@Override
	public void deleteCongresFiles(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			// 字符串转List
			List<Integer> idList = new ArrayList<>();
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				idList.add(Integer.parseInt(id));
			}
			// 1,物理地址删除
			// 查询出文件的名字
			// 获取文件绝对路径
			String basePath = new PropertiesUtil("config.properties").readProperty("basePath");
			basePath = basePath + System.getProperty("file.separator");
			// basePath: F:\phlicense\
			String realPath = new PropertiesUtil("config.properties").readProperty("realPath");
			// realPath: /upload
			List<CongressFile> congressFiles = congressFileDao.findCongressFileName(idList);
			for (int i = 0; i < congressFiles.size(); i++) {
				String DBpath = congressFiles.get(i).getCfPath();
				if (!StringUtils.isEmpty(DBpath)) {
					DBpath = DBpath.replaceAll(realPath + "/", "");
				}
				String filePath = basePath + DBpath;
				File file = new File(filePath);
				if (file.exists()) {
					// 如果文件存在就删除
					//file.delete();
				}
			}
			// 2,数据库参数
			congressFileDao.deleteCongresFiles(idList);
		}
	}

	@Override
	public void UpdateCongresFilesOrder(MoveVo moveVo) {
		// 调换序号
		CongressFile congressFileA = new CongressFile();
		CongressFile congressFileB = new CongressFile();
		List<CongressFile> congressFiles = new ArrayList<>();
		congressFileA.setId(moveVo.getPitchOnId());
		congressFileA.setCfSerial(moveVo.getBorderOrder());
		congressFileB.setId(moveVo.getBorderId());
		congressFileB.setCfSerial(moveVo.getPitchOnOrder());
		congressFiles.add(congressFileA);
		congressFiles.add(congressFileB);
		// 批量修改
		congressFileDao.updateBatchCongresFiles(congressFiles);
	}

}
