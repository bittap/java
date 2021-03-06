/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package google.drive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import common.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriveManager {
    private final String APPLICATION_NAME = "Quickstart";
    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private final String TOKENS_DIRECTORY_PATH = "C:\\Temp\\";
    private final String FTP_FILE_PATH = "/html/google/";
    private final String TOKENS_FILE_NAME = "StoredCredential";
    private String nowFolderId = "root";
    public String ext = "image/jpeg";
    
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_FILE);
    private final String CREDENTIALS_FILE_NAME = "credentials.json";
    private Drive service;

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    
    public DriveManager(String[] folName) {
    	service = createService();
    	
    	for (int i = 0; i < folName.length; i++) {
    		try {
				createFolder(folName[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    	
	}
    
    
    public String getnowFolderId() {
		return nowFolderId;
	}

	private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        if(!Common.copyFtpFile(TOKENS_DIRECTORY_PATH, FTP_FILE_PATH, CREDENTIALS_FILE_NAME))
        {
        	throw new FileNotFoundException("Resource not found FTP: " + "/html/google/"+CREDENTIALS_FILE_NAME);
        }
        InputStream in = new FileInputStream(TOKENS_DIRECTORY_PATH+CREDENTIALS_FILE_NAME);
        
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        
        if(!Common.copyFtpFile(TOKENS_DIRECTORY_PATH, FTP_FILE_PATH, TOKENS_FILE_NAME))
        {
        	throw new FileNotFoundException("Resource not found FTP: " + "/html/google/"+TOKENS_FILE_NAME);
        }

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
        		.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
    
    private Drive createService() {
        NetHttpTransport HTTP_TRANSPORT;
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	        service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	                .setApplicationName(APPLICATION_NAME)
	                .build();
	        return service;
		} catch (GeneralSecurityException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return null;
    }
    
    // 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占싱듸옙
    private String getParentFolder(String name) throws IOException {
    	String sql = "mimeType = 'application/vnd.google-apps.folder' and trashed=false and name = '"+name+"' and '"
    			+ nowFolderId +"' in parents";
        FileList result = service.files().list()
                .setQ(sql)
                .setFields("files(*)")
                .execute();
        if(result.getFiles().size() != 0)
        {
        	return result.getFiles().get(0).getId();
        }
        else
        {
        	return nowFolderId;
        }
    }
    
    // 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
    private boolean getExistsFolder(String name) throws IOException {
    	String sql = "mimeType = 'application/vnd.google-apps.folder' and trashed=false and name = '"+name+"' and '"
    			+ nowFolderId +"' in parents";
        FileList result = service.files().list()
                .setQ(sql)
                .setFields("files(*)")
                .execute();
        if(result.getFiles().size() == 0)
        {
        	return false;
        }
        else
        {
        	return true;
        }
    }
    
    public String fileUplod(String fileName,java.io.File uploadFile) {
    	File fileMetadata = new File();
    	fileMetadata.setName(fileName);
    	fileMetadata.setParents(getParentsList());
    	FileContent mediaContent = new FileContent("image/jpeg", uploadFile);
    	File file = null;
		try {
			file = service.files().create(fileMetadata, mediaContent)
			    .setFields("*")
			    .execute();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	return file.getId();
    }
    
    private List<String> getParentsList(){
		List<String> parentsList = new ArrayList<String>();
		parentsList.add(nowFolderId);
    	return parentsList;
    }
    

    private void createFolder(String folderName) throws IOException {
    	//System.out.printf("1 folderName = %s, nowFolderId = %s\n",folderName,nowFolderId);
    	// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�
    	if(!getExistsFolder(folderName)) 
    	{
        	File fileMetadata = new File();
        	fileMetadata.setName(folderName);
        	fileMetadata.setMimeType("application/vnd.google-apps.folder");
    		fileMetadata.setParents(getParentsList());
    		
    		// 占쏙옙占쏙옙 占쏙옙占쏙옙
    		File file = service.files().create(fileMetadata).setFields("id").execute();
    		nowFolderId = file.getId();
    		System.out.printf("2 folderName = %s, nowFolderId = %s\n",folderName,nowFolderId);
    	}
    	else
    	{
    		nowFolderId =  getParentFolder(folderName);
    		System.out.printf("3 folderName = %s, nowFolderId = %s\n",folderName,nowFolderId);
    	}
    }
    
   

    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
    	
    	String[] folName = {"file","13579","占쏙옙占쏙옙"};
    	DriveManager driveManager = new DriveManager(folName);
    	//driveManager.fileUplod("fileUplod", new java.io.File(""));
    	

    }
}
