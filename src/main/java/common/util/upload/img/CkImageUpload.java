package common.util.upload.img;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

import common.dto.EveryonesFarmFile;
import common.util.upload.img.model.service.CkImageUploadService;

/**
 * ck editor 4 이미지 업로드 담당 클래스 
 */
@Controller
public class CkImageUpload {
	
	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(CkImageUpload.class);
	
	// 파일 업로드를 테이블에 저장해 줄 함수를 호출하는 service
	@Autowired
	private CkImageUploadService ckImageUploadService;
	
	// 이미지 업로드 공통 url
	@RequestMapping(value = "/common/imageupload", method = RequestMethod.POST)
	@ResponseBody
	public String commonImageUpload(
			HttpServletRequest req
			, HttpServletResponse resp
			, MultipartHttpServletRequest multiFile
			// 파일 테이블에 저장하기 위한 정보를 저장하는 파일 dto - EveryonesFarmFile
			, EveryonesFarmFile fileDto
			) {
		
		logger.info("/common/imageupload - [POST] 요청");
		logger.debug("fileDto: " + fileDto);
		
		
		JsonObject json = new JsonObject();
		PrintWriter pw = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		
		if( file != null ) {
			
			if( file.getSize() > 0 && StringUtils.isNotBlank(file.getName()) ) {
				
				if( file.getContentType().toLowerCase().startsWith("image/") ) {
					
					try {

						String fileName = file.getName();
						byte[] bytes = file.getBytes();
						String uploadPath = req.getServletContext().getRealPath("/resources") + "/ckimg";  // 이 업로드 path를 데이터베이스에 저장해야할 것 같음!
						File uploadFile = new File(uploadPath);
						
						// upload 폴더가 없으면 해당 폴더를 만들어준다.
						if( !uploadFile.exists() ) {
							
							uploadFile.mkdirs();
							
						}
						
						fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
						// 파일 원래 이름 파일 dto 에 저장
						fileDto.setOriginName(file.getOriginalFilename());
						
						// 파일 업로드 이름(새 이름) 파일 dto 에 저장
						fileDto.setFileRename(fileName);
						
						uploadPath = uploadPath + "/" + fileName;
						logger.debug("uploadPath: " + uploadPath); // 이녀석?
						// 파일이 업로드된 경로를 파일 dto 에 저장
						fileDto.setSavePath(uploadPath);
						
						out = new FileOutputStream(new File(uploadPath));
						out.write(bytes);
						out.flush();
						
						pw = resp.getWriter();
						resp.setContentType("text/html");
						String fileUrl = req.getContextPath() + "/resources/ckimg/" + fileName;
						logger.debug("fileUrl: " + fileUrl); // 이녀석? 둘 중에 하나 테이블에 저장해야함
						
						// json 데이터로 등록
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						
						pw.println(json);
						pw.flush();
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						
						try {
						
							if(out != null) {
								out.close();
							}
							if(pw != null) {
								pw.close();
							}
							
						} catch (IOException e) {
							e.printStackTrace();
						}
							
						
					}
					
					// fileDto에 어떤 값들이 저장되어 있는지 확인
					logger.debug("fileDto: " + fileDto);
					// fileDto 를 이용하여 테이블에 파일 정보 저장
					// 테이블에 저장하고 글을 삭제할 때는 해당 이미지들을 모두 다 지워버린다
					int insertRes = ckImageUploadService.insertFile(fileDto);
					logger.debug("insertRes: " + insertRes);
					
				}
				
			}
			
		}
		
		return null;
	}
	
	// 파일 삭제
	public void deleteFile(String path) {
		//삭제하고 싶은 파일의 경로를 생성자의 매개변수로 넣음
		File deleteFile = new File(path);
		// 해당 파일 삭제
		deleteFile.delete();
	}
	
}
