package org.ld.service.fileService.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.ld.dao.fileDao.CongressBulletinFileDao;
import org.ld.dao.fileDao.CongressFileDao;
import org.ld.model.fileModel.CongressBulletinFile;
import org.ld.model.fileModel.CongressFile;
import org.ld.service.fileService.ICongressBulletinFileService;
import org.ld.utils.PropertiesUtil;
import org.ld.vo.MoveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("congressBulletinFileService")
public class CongressBulletinFileServiceImpl implements ICongressBulletinFileService{
	
	@Autowired
	private CongressBulletinFileDao congressBulletinFileDao;
	
	@Autowired
	private CongressFileDao congressFileDao;

	@Override
	public List<CongressBulletinFile> findCongressIDToCongressBulletinFiles(CongressBulletinFile congressBulletinFile) {
		Integer  congressID = congressBulletinFile.getCongressID();
		List<CongressBulletinFile> congressBulletinFiles = congressBulletinFileDao.findCongressIDToCongressBulletinFiles(congressBulletinFile);
		//查会议中的会议文件
		List<CongressFile> congressFlies= congressFileDao.getCongressIdFindCongressFile(congressID);
		for(int i=0;i<congressFlies.size();i++) {
			CongressBulletinFile congressBulletinFileNew = new CongressBulletinFile();
			congressBulletinFileNew.setCbID(congressFlies.get(i).getId());
			congressBulletinFileNew.setCongressID(congressID);
			congressBulletinFileNew.setCbType(1);
			congressBulletinFileNew.setCbName(congressFlies.get(i).getCfName());
			congressBulletinFileNew.setCbPath(congressFlies.get(i).getCfPath());
			congressBulletinFileNew.setCbPicPath(congressFlies.get(i).getCfPicPath());
			congressBulletinFileNew.setCbSize(congressFlies.get(i).getCfSize());
			congressBulletinFileNew.setCbSerial(congressFlies.get(i).getCfSerial());
			congressBulletinFileNew.setCbCreateTime(congressFlies.get(i).getCreateTime());
			congressBulletinFileNew.setCbIsEnabled(congressFlies.get(i).getCfIsEnabled());
			congressBulletinFileNew.setCbRemark(congressFlies.get(i).getRemark());
			congressBulletinFileNew.setTypeName(congressFlies.get(i).getTypeName());
			congressBulletinFiles.add(congressBulletinFileNew);
		}
		return congressBulletinFiles;
	}

	@Override
	public void saveCongressBulletinFile(CongressBulletinFile congressBulletinFile, List<Map<String, Object>> result) {
			// 获取config.properties文件中realPath的值
			String basePath = new PropertiesUtil("config.properties").readProperty("realPath");
			// 拼接数据
			List<CongressBulletinFile> congressBulletinFiles = new ArrayList<CongressBulletinFile>();
			if (congressBulletinFile.getCongressID() != null) {
				for (int i = 0; i < result.size(); i++) {
					CongressBulletinFile CongressBulletinFileNew = new CongressBulletinFile();
					CongressBulletinFileNew.setCongressID(congressBulletinFile.getCongressID());
					CongressBulletinFileNew.setCbName((String) result.get(i).get("fileOldName"));
					String path =basePath + "/" + result.get(i).get("realPath");
					CongressBulletinFileNew.setCbPath(path.substring(0, path.indexOf("."))+".pdf");
					CongressBulletinFileNew.setTrueFilePath(path);
					double size = (double) result.get(i).get("size");
					CongressBulletinFileNew.setCbSize((float) size);
					//文件类型
					CongressBulletinFileNew.setCbType(congressBulletinFile.getCbType());
					// 排序
					// 1，先查出标准文件表中最大的序号，2，在此基础上加一
					/*Integer MaxOrder = 0;
					Integer max = congressBulletinFileDao.getMaxCongressBulletinFileOrder();
					if (max != null) {
						MaxOrder = max + 1;
					}*/
					Integer MaxOrder =(int) new Date().getTime();
					CongressBulletinFileNew.setCbSerial(MaxOrder+i);
					try {
						String d = (String) result.get(i).get("fileUploadDate");
						CongressBulletinFileNew.setCbCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String CfPath = basePath + "/" + result.get(i).get("realPath");
					CongressBulletinFileNew.setCbPicPath(CfPath.substring(0, CfPath.lastIndexOf("."))+"/00001.png");
					CongressBulletinFileNew.setCbIsEnabled(1);
					congressBulletinFiles.add(CongressBulletinFileNew);
					congressBulletinFileDao.addCongressBulleFile(CongressBulletinFileNew);
				}
			}
			// 批量增加
			/*if (congressBulletinFiles.size() > 0) {
				congressBulletinFileDao.addBatchCongressBulleFiles(congressBulletinFiles);
			}*/
	}
	@Override
	public void deleteCongresBulletinFiles(String ids) {
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
			List<CongressBulletinFile> congressBulletinFiles = congressBulletinFileDao.findCongressBulletinFileName(idList);
			for (int i = 0; i < congressBulletinFiles.size(); i++) {
				String DBpath = congressBulletinFiles.get(i).getCbPath();
				if (!StringUtils.isEmpty(DBpath)) {
					DBpath = DBpath.replaceAll(realPath + "/", "");
				}
				String filePath = basePath + DBpath;
				File file = new File(filePath);
				if (file.exists()) {
					// 如果文件存在就删除
					file.delete();
				}
			}
			// 2,数据库参数
			congressBulletinFileDao.deleteCongresBulletinFiles(idList);
		}
	}

	@Override
	public void UpdateCongresBulletinFilesOrder(MoveVo moveVo) {
		// 调换序号
		CongressBulletinFile congressFileA = new CongressBulletinFile();
		CongressBulletinFile congressFileB = new CongressBulletinFile();
		List<CongressBulletinFile> congressBulletinFiles = new ArrayList<>();
		congressFileA.setCbID(moveVo.getPitchOnId());
		congressFileA.setCbSerial(moveVo.getBorderOrder());
		congressFileB.setCbID(moveVo.getBorderId());
		congressFileB.setCbSerial(moveVo.getPitchOnOrder());
		congressBulletinFiles.add(congressFileA);
		congressBulletinFiles.add(congressFileB);
		// 批量修改
		congressBulletinFileDao.updateBatchCongresBulletinFiles(congressBulletinFiles);
		
	}

}
