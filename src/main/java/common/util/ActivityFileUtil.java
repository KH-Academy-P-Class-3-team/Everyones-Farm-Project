package common.util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import common.dto.FarmActivityFile;

public class ActivityFileUtil {
	
	public List<FarmActivityFile> fileUpload(
				List<MultipartFile> files, String root
			){
		
		int idx = 0;
//		List<Map<String,String>> filedata 
//				= new ArrayList<Map<String,String>>();
		List<FarmActivityFile> filedata	= new ArrayList<FarmActivityFile>();
		
		if(files.size() > 1) {
			
			for(MultipartFile mf: files) {
				FarmActivityFile aFile = new FarmActivityFile();
				
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
				
				//파일에 대한 정보를 map에 저장
//				HashMap<String,String> map = new HashMap<>();
//				map.put("originName", originName);
//				map.put("fileRename", fileRename);
//				map.put("savePath", savePath);
				
				
				//완성된 map을 list에 담음
//				filedata.add(map);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
