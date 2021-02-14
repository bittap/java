package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.SocketException;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class Ftp {
	FTPClient ftp = null;
	String host = "brnsss.dothome.co.kr";
	String user = "brnsss";
	String pwd = "q1w2e3r4!";
	
	public Ftp() throws Exception {
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host);
		reply = ftp.getReplyCode();
		
		if(!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		
		ftp.login(user, pwd);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
	}
	
	public void uploadFile(File file, String hostDir) {
		try {
			InputStream ism = new FileInputStream(file);
			this.ftp.storeFile(hostDir+file.getName(), ism);
			System.out.println(hostDir+file.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void makeFolder(String name, String hostDir) {
		isFolder(name,hostDir);
	}
	
	public boolean isUploadFtpToLocal(String filePath,String ftpFilePath) {
		FileOutputStream outputStream = null;
		try {
			File getFile = new File(filePath);
			outputStream = new FileOutputStream(getFile);
			
			if(ftp.retrieveFile(ftpFilePath, outputStream)) return true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				outputStream.close();
				disConn();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void isFolder(String name, String hostDir) {
		try {
			FTPFile[] ftpFiles = ftp.listDirectories();
			if(ftpFiles != null) {
				for (FTPFile ftpFile : ftpFiles) {
					System.out.println(ftpFile.getName());
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void disConn() {
		if(this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	
}
