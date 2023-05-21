package org.ld.utils;

import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;

public class WordToPDFConverter {

	private static final int wdFormatPDF = 17;// word保存为pdf格式宏，值为17
	
	
	/**
	 * 
	 * @Title: convert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Administrator
	 * @date 2015-10-26 下午01:23:31
	 * @param srcFile
	 * @param destFile
	 */
	public boolean convert(String srcFile, String destFile) {
		boolean result = false;

		// 检查文件是否存在
		result = checkFileExist(srcFile);

		// 存在则转换
		if (result) {
			result = word2PDF(srcFile, destFile);
		}

		// 检查文件是否存在
		if (result) {
			result &= checkFileExist(destFile);
		}

		return result;
	}

	public boolean checkFileExist(String path) {
		File aim = new File(path);
		return aim.exists();
	}

	/**
	 * 
	 * @Title: word2PDF
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Administrator
	 * @date 2015-10-26 下午01:41:43
	 * @param inputFile
	 * @param pdfFile
	 * @return
	 */
	public synchronized boolean word2PDF(String inputFile, String pdfFile) {
		try {
			// 打开word应用程序
			ActiveXComponent app = new ActiveXComponent("Word.Application");
			// 设置word不可见
			app.setProperty("Visible", false);
			// 获得word中所有打开的文档,返回Documents对象
			Dispatch docs = app.getProperty("Documents").toDispatch();
			// 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
			Dispatch doc = Dispatch.call(docs, "Open", inputFile, false, true)
					.toDispatch();
			// 调用Document对象的SaveAs方法，将文档保存为pdf格式
			/*
			 * Dispatch.call(doc, "SaveAs", pdfFile, wdFormatPDF );
			 */
			Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF);
			// 关闭文档
			Dispatch.call(doc, "Close", false);
			// 关闭word应用程序
			app.invoke("Quit", 0);
			// 释放资源标识
			app = null;
			ComThread.Release();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author Administrator
	 * @date 2015-10-26 下午01:05:05
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("java.library.path");
		System.out.println(System.getProperty("java.library.path"));
		System.out.println("java.library.path");
		WordToPDFConverter converter = new WordToPDFConverter();
		String srcFile = "D:/java/apache-tomcat-7.0.57/webapps/tvcms_gab/pictureFile/images/p1a746bbmg1h86tcjcucag1o5e1.doc";
		String destFile = "D:/java/apache-tomcat-7.0.57/webapps/tvcms_gab/pictureFile/images/conv.pdf";

		converter.convert(srcFile, destFile);
	}
}
