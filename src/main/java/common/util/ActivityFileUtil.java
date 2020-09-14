package common.util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import common.dto.EveryonesFarmFile;
import common.dto.UserProfile;

public class ActivityFileUtil {
	
	public List<EveryonesFarmFile> fileUpload(
				List<MultipartFile> files, String root
			){
		
		int idx = 0;
		List<EveryonesFarmFile> filedata	= new ArrayList<EveryonesFarmFile>();
		
		if(files.size() > 0) {
			
			for(MultipartFile mf: files) {
				EveryonesFarmFile aFile = new EveryonesFarmFile();
				
				aFile.setBoardNo(1);
				
				//빈 파일을 생성할 경로
				String savePath = root + "resources/upload";
				
				//tb_file 에 넣을 데이터 추출
				String originName = mf.getOriginalFilename();
				aFile.setOriginName(originName);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				//저장할 파일 이름 생성
				String fileRename = sdf.format(
						new Date(System.currentTimeMillis())) + idx + "."
						+ originName.substring(originName.lastIndexOf(".")+1);
				aFile.setFileRename(fileRename);
				
				if(idx == 0) {
					aFile.setIsThumbnail(1);
				}  else {
					aFile.setIsThumbnail(0);
				}
				
				idx++;
				
				//파일 저장 위치 
				savePath += "/" + fileRename;

				aFile.setSavePath(savePath);
				
				filedata.add(aFile);
				
				//사용자가 등록한 파일의 이름으로 빈 파일을 생성
				File fileData = new File(savePath);
				try {
					
					//생성된 빈파일을 사용해 사용자가 업로드한 파일을 저장
					mf.transferTo(fileData);
					
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return filedata;
	}

	public void deleteFile(String path) {
		//삭제하고 싶은 파일의 경로를 생성자의 매개변수로 넣음
		File file = new File(path);
		//해당 파일 삭제
		file.delete();
	}

	public UserProfile fileUpload(MultipartFile file, String root) {
		
			
				UserProfile aFile = new UserProfile();
				
				
				//빈 파일을 생성할 경로
				String savePath = root + "resources/image/mypage";
				
				//tb_file 에 넣을 데이터 추출
				String originName = file.getOriginalFilename();
				aFile.setOriginName(originName);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				//저장할 파일 이름 생성
				String fileRename = sdf.format(
						new Date(System.currentTimeMillis())) + "."
						+ originName.substring(originName.lastIndexOf(".")+1);
				aFile.setFileRename(fileRename);
				
				
				//파일 저장 위치 
				savePath += "/" + fileRename;

				aFile.setSavePath(savePath);
				
				//사용자가 등록한 파일의 이름으로 빈 파일을 생성
				File fileData = new File(savePath);
				try {
					
					//생성된 빈파일을 사용해 사용자가 업로드한 파일을 저장
					file.transferTo(fileData);
					
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
		
		return aFile;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
