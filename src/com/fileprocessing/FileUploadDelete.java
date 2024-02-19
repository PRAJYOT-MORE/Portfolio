package com.fileprocessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.dao.GetConnection;

public class FileUploadDelete {
	
	@SuppressWarnings("finally")
	public boolean uploadFile(HttpServletRequest request, String uniquefilename) {
		
		boolean res = false;
		try {
			InputStream fis = request.getPart("filename").getInputStream();
			byte b[] = new byte[fis.available()];
			fis.read(b);
			
			String path = request.getServletContext().getRealPath("images/project") + File.separator + uniquefilename;
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			
			fis.close();
			fos.close();
			
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			return res;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean deleteFile(HttpServletRequest request, String uniquefilename) {
		boolean res = false;
		try {
			String path = request.getServletContext().getRealPath("images/project") + File.separator + uniquefilename;
			File f = new File(path);
			f.delete();
			
			res = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return res;
		}
	}
}
