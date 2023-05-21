package org.ld.controller.fileController;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.ld.common.BizException;
import org.ld.utils.MiaoUitl;
import org.ld.utils.WordToPDFConverter;
import org.springframework.beans.factory.annotation.Autowired;


public class PDFToImageConverter implements Runnable{

	
	private String srcPath = null;
	private String destPath = null;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description: 私有成员变量
	 * </p>
	 * 
	 * @throws BizException
	 */
	private PDFToImageConverter() throws BizException {
		throw new BizException(
				"try create a PDFToImageConverter without src and dest.");
	}
	
	/**
	 * 
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param src
	 * @param dest
	 * @param commonDao
	 * @param sessionFactory
	 */
	public PDFToImageConverter(String src, String dest,
			SqlSessionFactory sessionFactory) {
		this.srcPath = src;
		this.destPath = dest;
		this.sessionFactory = sessionFactory;
	}
	
	
	/**
	 * 
	 * @Title: convert
	 * @Description: 转换pdf到png图片
	 * @author Administrator
	 * @date 2015-10-9 上午08:33:37
	 * @param src
	 * @param dest
	 * @throws Exception
	 */
	public boolean convert(String src, String dest) {
		boolean result = false;
		CheckedOutputStream cos = null;
		ZipOutputStream zos = null;
		RandomAccessFile raf = null;
		PDDocument document = null;
		try {
			// 检查文件是否为pdf文件
			src = checkAndPreparePdf(src);

			document = PDDocument.load(new File(src));
			PDFRenderer renderer = new PDFRenderer(document);
			int pageCount = document.getNumberOfPages();

			// 压缩文件
			String zipFilePath = dest + ".zip";
			File zipFile = new File(zipFilePath);
			if (zipFile.exists()) {
				// // 检测文件是否允许删除，如果不允许删除，将会抛出SecurityException
				// SecurityManager securityManager = new SecurityManager();
				// securityManager.checkDelete(zipFilePath);
				// 删除已存在的目标文件
				zipFile.delete();
			}
			cos = new CheckedOutputStream(new FileOutputStream(zipFile),
					new CRC32());
			zos = new ZipOutputStream(cos);

			// 取得总页数、循环出图
			//int resolution = 96;
			for (int i = 0; i < pageCount; i++) {
				BufferedImage image = renderer.renderImageWithDPI(i, 145);//第二个参数为dpi分辨率单位
				System.out.println("宽：" + image.getWidth() + ",高：" + image.getHeight());
				 //切白边
				//7:10
				//BufferedImage newImage = image.getSubimage(26, 100, image.getWidth() - 32, image.getHeight() - 220);
				BufferedImage newImage = image.getSubimage(30, 45, image.getWidth() - 60, image.getHeight() - 100);
//				BufferedImage image = renderer.renderImage(i, 2.5f);
				// 取得图像二进制内容
				// 输出指定文件
				File destDir = new File(dest);
				if (destDir.exists()) {
					if (destDir.isFile()) {
						destDir.mkdir();
					}
				} else {
					destDir.mkdir();
				}
				File asd = new File(destDir, StringUtils.leftPad((i + 1) + "",
						5, "0")
						+ ".png");
				if (asd.exists()) {
					asd.delete();
				}

				ImageIO.write(newImage, "png", asd);
				zip(asd.getParent(), asd, zos);
			}
			result = true;
			// 压缩zip成功后，继续上传到linux服务器
			//uploadToLinuxServer(zipFile);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//log.error("切图失败", e);
		} catch (IOException e) {
			e.printStackTrace();
			//log.error("切图失败", e);
		} catch (Exception e) {
			e.printStackTrace();
			//log.error("压缩失败", e);
		} finally {
			try {
				if (zos != null) {
					zos.close();
				}
				if (raf != null) {
					raf.close();
				}
				if (document != null) {
					document.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				//log.error("关闭失败", e);
			}
		}
		//log.info("end of convert");
		return result;
	}
	
	
	
	@Override
	public void run() {
		// 切图操作
		boolean result = convert(srcPath, destPath);
		boolean containedFactory = true;
		/*// 保存数据
		if (result) {
			if(TransactionSynchronizationManager.hasResource(sessionFactory)){
				containedFactory = false;
			} else {
				Session session = sessionFactory.openSession();  
				session.setFlushMode(FlushMode.MANUAL);  
				SessionHolder sessionHolder = new SessionHolder(session);  
				TransactionSynchronizationManager.bindResource(sessionFactory, sessionHolder);
			}
			File src = new File(srcPath);
			commonDao.executeSql("update file set is_exported='1' where file_new_name='"+src.getName()+"'");
//			List list = commonDao.querySQL("select * from file where file_new_name='"+src.getName()+"'");
//			for (Object logisticsFile : list) {
//				log.debug(logisticsFile);
//			}
			if(containedFactory){
				SessionHolder sessionHolder = (SessionHolder)TransactionSynchronizationManager.unbindResource(sessionFactory);  
				SessionFactoryUtils.closeSession(sessionHolder.getSession());
			}
		}*/
		
	}
	

	
	
	private synchronized String checkAndPreparePdf(String src) {
		// 检查是否为pdf文件
		if (src.endsWith("pdf")) {
			// do nothing
		} else {
			// word转换成pdf文件
			String dest = src.substring(0, src.lastIndexOf(".")) + ".pdf";
			WordToPDFConverter converter = new WordToPDFConverter();
			if (converter.convert(src, dest)) {
				src = dest;
			}
			converter = null;
			System.gc();
		}
		return src;
	}
	
	
	/**
	 * 递归压缩文件夹
	 * 
	 * @param srcRootDir
	 *            压缩文件夹根目录的子路径
	 * @param file
	 *            当前递归压缩的文件或目录对象
	 * @param zos
	 *            压缩文件存储对象
	 * @throws Exception
	 */
	private void zip(String srcRootDir, File file, ZipOutputStream zos)
			throws Exception {
		//log.debug(String.format("srcRootDir is %s", srcRootDir));
		//log.debug(String.format("file is %s", file.getName()));
		if (file == null) {
			return;
		}

		// 如果是文件，则直接压缩该文件
		if (file.isFile()) {
			int count, bufferLen = 1024;
			byte data[] = new byte[bufferLen];

			// 获取文件相对于压缩文件夹根目录的子路径
			String subPath = file.getAbsolutePath();
			int index = subPath.indexOf(srcRootDir);
			if (index != -1) {
				subPath = subPath.substring(srcRootDir.length()
						+ File.separator.length());
			}
			ZipEntry entry = new ZipEntry(subPath);
			zos.putNextEntry(entry);
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));
			while ((count = bis.read(data, 0, bufferLen)) != -1) {
				zos.write(data, 0, count);
			}
			bis.close();
			zos.closeEntry();
		}
		// 如果是目录，则压缩整个目录
		else {
			// 压缩目录中的文件或子目录
			File[] childFileList = file.listFiles();
			for (int n = 0; n < childFileList.length; n++) {
				childFileList[n].getAbsolutePath().indexOf(
						file.getAbsolutePath());
				zip(srcRootDir, childFileList[n], zos);
			}
		}
	}
	
	/**
	 * @Title: uploadToLinuxServer
	 * @Description: 继续上传到Linux服务器
	 * @author Administrator
	 * @date 2016-5-5 下午2:56:12
	 * @param zipFile
	 * @throws IOException 
	 */
	private void uploadToLinuxServer(File zipFile) throws Exception {
		// 压缩文件是否存在
		if(!zipFile.exists()){
			throw new Exception("需要上传到linux的压缩文件不存在");
		}
		// 要上传的服务器路径
		String linuxPath = MiaoUitl.getKeyValue("linux");
		if(StringUtils.isEmpty(linuxPath)){
			throw new Exception("linux服务器的地址不存在");
		}
		String[] pathArray = linuxPath.split(";");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		for(String path : pathArray){
			File linuxDir = new File(path);
			// 存在并且是目录
			if(linuxDir.exists() && linuxDir.isDirectory()){
				try{
					bis = new BufferedInputStream(new FileInputStream(zipFile));
					bos = new BufferedOutputStream(new FileOutputStream(new File(linuxDir, zipFile.getName())));
					int readLength = 0;
					byte[] byteArray = new byte[2048];
					while(-1 != (readLength = bis.read(byteArray))){
						bos.write(byteArray, 0, readLength);
					}
				}catch(Exception e){
					e.printStackTrace();
					//log.error(linuxDir + ": " + zipFile.getName(), e);
				}finally{
					if(null != bos){
						bos.flush();
						bos.close();
					}
					if(null != bis){
						bis.close();
					}
					//log.info(linuxDir + ": " + zipFile.getName() + " 上传成功 ");
				}
			}
		}
	}

}
