package com.kh.farmapp.admin.notice.controller;

<<<<<<< HEAD
=======
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

=======
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
import com.kh.farmapp.admin.model.service.AdminNoticeService;

import common.dto.Admin;
import common.dto.EveryonesFarmFile;
import common.dto.Notice;
import common.util.AdminPaging;
import common.util.upload.img.CkImageUpload;
import common.util.upload.img.model.service.CkImageUploadService;

/**
 * 공지사항 & 자주 묻는 질문 관리 페이지
 */
@Controller
public class AdminNoticeController {

	// member field
	private static final int NOTICE_BOARD_NO = 7;
	
	// log 를 남기기 위한 Logger 객체
	private static final Logger logger = LoggerFactory.getLogger(AdminNoticeController.class);

	// service 객체
	@Autowired
	private AdminNoticeService adminNoticeService;
	
	// 이미지 삭제와 관련된 service
	@Autowired
	private CkImageUploadService ckImageUploadService;
	
	// 이미지 파일 삭제와 관련된 class
	@Autowired
	private CkImageUpload ckImageUpload;
	
	// 공지사항 관리 목록 페이지
	@RequestMapping(value = "/adminnotice/list", method = RequestMethod.GET)
	public String adminNoticeList(
			Model model
			, @RequestParam(defaultValue = "0") String curPage
			, HttpSession session
			) {
		// 로그인이 안되어 있을 경우, 바로 로그인 페이지로 이동
		Admin loginAdmin = (Admin) session.getAttribute("adminInfo");
		if( loginAdmin == null) {
			
			return "redirect:/admin/login";
			
		}
		
		// 로그 찍기
		logger.info("/adminnotice/list - [GET] 요청");
		
		// 페이징 설정
		AdminPaging apaging = adminNoticeService.getPaging(curPage);
//		logger.info("AdminPaging: " + apaging.toString());
		
		// apaging 정보로 notice 목록 불러오기
		List<Map<String, Object>> pagingNList = adminNoticeService.selectNoticeByAPaging(apaging);
		//pagingNList test output
//		for(Map<String, Object> m : pagingNList) {
//			logger.info("m: " + m.toString());
//		}
		
		// model 값 넘겨주기
		// 페이징 객체 넘기기
		if( apaging != null ) {
			model.addAttribute("apaging", apaging);
		}
		// 페이징 처리된 목록 넘기기
		if( pagingNList != null ) {
			model.addAttribute("pagingNList", pagingNList);
		}
		
		return "admin/notice/admin_notice_list";
	}
	
	
	// 공지사항 관리 공지사항 상세 페이지
	@RequestMapping(value = "/adminnotice/detail", method = RequestMethod.GET)
	public String adminNoticeDetail(
				Notice noticeNo
				, HttpSession session
				, Model model
			) {
		
		// admin login 안되어 있을 시 로그인 페이지로 이동
		Admin loginAdmin = (Admin) session.getAttribute("adminInfo");
		if( loginAdmin == null) {
			
			return "redirect:/admin/login";
			
		}
		
		logger.info("/adminnotice/detail - [GET] 요청");
		
		logger.debug("noticeNo: " + noticeNo);
		
		// noticeNo 로 해당 Notice 조회하기
		Map<String, Object> noticeDetail = adminNoticeService.selectNoticeByNoticNo(noticeNo); 
		logger.debug("noticeDetail: " + noticeDetail.toString());
		
		// 조회된 결과가 null 값이 아닐 때 view 에 넘겨주기
		if(noticeDetail != null) {
			model.addAttribute("noticeDetail", noticeDetail);
		}
		
		return "admin/notice/admin_notice_detail";
	}
	
	// 공지사항 관리 공지사항 작성 폼 페이지
	@RequestMapping(value = "/adminnotice/write", method = RequestMethod.GET)
	public String adminNoticeWrite(
				HttpSession session
				, Model model
			){
		// 로그인이 안되어 있을 경우, 바로 로그인 페이지로 이동
		Admin loginAdmin = (Admin) session.getAttribute("adminInfo");
		if( loginAdmin == null) {
			
			return "redirect:/admin/login";
			
		}
		
		// 현재 작성될 글의 번호를 미리 조회한다.
		String postNo = adminNoticeService.selectPostNo();
		if( postNo != null ) { // 조회된 결과가 null 값이 아닐 경우
			logger.debug("postNo: " + postNo);
			model.addAttribute("postNo", postNo);
		}
		
		return "admin/notice/admin_notice_write";
	}
	
	// 공지사항 관리 공지사항 작성
	@RequestMapping(value = "/adminnotice/write", method = RequestMethod.POST)
	public String adminNoticeWriteProc(
				@ModelAttribute Notice notice
				, HttpSession session
				, Model model
			) {
		// 로그인이 안되어 있을 경우, 바로 로그인 페이지로 이동
		Admin writer = (Admin) session.getAttribute("adminInfo");
		if( writer == null) {
			
			return "redirect:/admin/login";
			
		}
		
		// logger 찍기 - 현재 어디 method 인지
		logger.info("/adminnotice/write - [POST] 요청");
		
		// RequestParam notice 객체 테스트 출력
		logger.debug("notice: " + notice.toString());
		
		// notice 객체의 adminNo set 하기
		notice.setAdminNo(writer.getAdminNo());
		
		int res = adminNoticeService.writeNotice(notice);
		
		if(res > 0) {
			logger.info("공지사항 작성 성공~");
			
			// 관리자 메인 화면으로 이동
			model.addAttribute("alertMsg", "공지사항이 성공적으로 작성됐습니다.");
			// 나중에 상세조회 페이지 만들면 그 페이지로 넘어가게끔 하기! 그렇다면 noticeNo 를 조회해서 보여줘야할 것 같네요!
			// 아예 noticeNo 는 select notice_seq.nextval from dual 로 조회하는 query를 사용해서 notice 에 저장해서 그 notice로 상세페이지를 조회하는 게 좋은 생각인거 같다.
			model.addAttribute("url", "list");
		} else {
			logger.info("공지사항 작성 실패...");
			model.addAttribute("alertMsg", "공지사항 작성이 실패했습니다...");
			model.addAttribute("url", "write");
		}
		
		return "common/result";
	}
	
	// 공지사항 이미지 업로드
	@RequestMapping(value = "/adminnotice/fileupload", method = RequestMethod.POST)
	@ResponseBody
	public String adminNoticeImgUpload(
			HttpServletRequest req
			, HttpServletResponse resp
			, MultipartHttpServletRequest multiFile
			){
		
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
						String uploadPath = req.getServletContext().getRealPath("/resources") + "/ckimg";
//						logger.debug(uploadPath);
						File uploadFile = new File(uploadPath);
						
						if(!uploadFile.exists()) {
							
							uploadFile.mkdirs();
							
						}
						
						fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
						uploadPath = uploadPath + "/" + fileName;
//						logger.debug(uploadPath);
						out = new FileOutputStream(new File(uploadPath));
						out.write(bytes);
						out.flush();
						
						pw = resp.getWriter();
						resp.setContentType("text/html");
						String fileUrl = req.getContextPath() + "/resources/ckimg/" + fileName;
//						logger.debug(fileUrl);
						
						//json 데이터로 등록
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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					
				}
				
			}
			
		}
		
		return null;
	}
	
	// 공지사항 관리 공지사항 삭제
<<<<<<< HEAD
	@RequestMapping(value = "/adminnotice/deletenotice", method = RequestMethod.POST)
	public String deleteNotice(Notice notice) {
		return "";
=======
	@RequestMapping(value = "/adminnotice/delete", method = RequestMethod.POST)
	@ResponseBody
	public int deleteNotice(
			// 삭제할 번호들
			@RequestParam Map<String, Object> deleteNums
			) {
		
		// 현재 어떤 url 이 실행되고 있는지
		logger.info("/adminnotice/delete [POST] 요청");

		// ajax 반환 값
		int result = 1;
		
		// noticeNo -> ArrayList 로 변환
		String[] nums = deleteNums.get("noticeNo").toString().split(",");
		List<Object> noticeNoList =  new ArrayList<>(Arrays.asList(nums));
		logger.info("noticeNoList: " + noticeNoList.toString());
//		logger.info("noticeNoList: " + noticeNoList.getClass().getName());
		
		// file dto 먼저 삭제
		// file 테이블에서 delete 할 정보를 갖는 Map
		Map<String, Object> deleteConfig = new HashMap<>();
		deleteConfig.put("boardNo", NOTICE_BOARD_NO);
		deleteConfig.put("postNo", noticeNoList);
		logger.debug("deleteNums: " + deleteConfig.get("postNo"));
		logger.debug("deleteConfig: " + deleteConfig.toString());
		
		// 서버에서 먼저 삭제
		// delete 할 파일들을 모두 조회
		List<EveryonesFarmFile> deleteFiles = ckImageUploadService.selectFilesByBoardNoAndPostNo(deleteConfig);
		// deleteFiles test 출력
		int fileDelRes = 0;
		if(deleteFiles.size() > 0) {
			for( EveryonesFarmFile e : deleteFiles ) {
				logger.debug("삭제할 file 정보: " + e.toString());
				// deleteFile 함수 호출
				ckImageUpload.deleteFile(e.getSavePath());
			}
			
			// 테이블에서 삭제
			fileDelRes = ckImageUploadService.deleteFile(deleteConfig);
			logger.debug("fileDelRes: " + fileDelRes);
		}
		
		
		// 삭제 처리
		int delRes = adminNoticeService.deleteNoticeByNoticeNo(noticeNoList);
//		int delRes = 0;
		
		if(delRes >= 1) { // 삭제 결과 성공
			
			logger.info("삭제 성공~");
			return result;
			
		} else { // 삭제 결과 실패
			
			logger.info("삭제 실패~");
			result = 0;
			return result;
			
		}
		
>>>>>>> 4f609ed6ae2026061686ed652541ba063ad3fa05
	}
	
}
