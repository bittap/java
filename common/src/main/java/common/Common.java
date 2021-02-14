package common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Common {

	 public static String arrayJoin(String glue, String array[]) {
	    String result = "";

	    for (int i = 0; i < array.length; i++) {
	      result += array[i];
	      if (i < array.length - 1) result += glue;
	    }
	    
	    return result;
	}
	 
	 public static void folderMake(String dir) {
		File folder = new File(dir);
		if(!folder.exists()) 
		{
			folder.mkdir();
		}
	 }
	 
	 public static void fileCopy(File file,String nameDir) {
		 File copyFile = new File(nameDir+"\\"+file.getName());
		 try {
			// ���� ����
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			// ������ ����
			FileOutputStream fos = new FileOutputStream(copyFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int fileByte = 0;
			
			while ((fileByte = fis.read()) != -1) {
				fos.write(fileByte);
			}
			
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }
	 
	 public static boolean copyFtpFile(String dir,String ftpDir,String fileName) {
		 try {
			File file = new File(dir+fileName);
			if(!file.exists())
			{
				System.out.println("���� �������� ����");
				// ���� ������ ����
				Common.folderMake(dir);
				Ftp ftp = new Ftp();
				if(!ftp.isUploadFtpToLocal(dir+fileName, ftpDir+fileName)) return false;	
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
		 return true;
		 
	 }
	 
	 public static boolean isStringInt(String str) {
		 try {
			 Integer.parseInt(str);
			 return true;
		} catch (NumberFormatException e) {
			return false;
		}
		 
	 }
	 
	 // String �迭 Integer�迭�� ��ȯ
	 public static int[] StringArrToIntArr(String[] strArr) {
		 int[] intArr = new int[strArr.length];
		 for (int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		 
		return intArr;
	 }
	 
	 public static boolean isEmpty(Object obj) {
		 if(obj == null) return true;
		 if((obj instanceof String) && ((String)obj).trim().length() == 0) return true;
		 if(obj instanceof Map) return ((Map<?, ?>)obj).isEmpty();
		 if(obj instanceof List) return ((List<?>)obj).isEmpty();
		 if(obj instanceof Object[]) return ((Object[])obj).length == 0;
		 
		 return false;
	 }
}
