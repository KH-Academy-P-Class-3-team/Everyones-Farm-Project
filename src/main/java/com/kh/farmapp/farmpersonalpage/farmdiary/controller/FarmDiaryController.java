package com.kh.farmapp.farmpersonalpage.farmdiary.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.kh.farmapp.farmpersonalpage.farmdiary.model.service.FarmDiaryService;
import com.kh.farmapp.farmpersonalpage.personalproduce.model.service.PersonalProduceService;

import common.dto.Farmer;



@Controller
public class FarmDiaryController {

	@Autowired
	private FarmDiaryService farmdiaryService;
	
	@Autowired
	private PersonalProduceService personalproduceService; 

	//농장 일기 작성 화면
	@RequestMapping(value = "/farmdiary/farmdiarywrite.do", method = RequestMethod.GET)
	public void farmdiaryWrite() {
//		System.out.println("wrtie 페이지 접속 완료");

	}

	//농장 일기 작성
	@RequestMapping(value = "/diary/diarywrite.do", method = RequestMethod.POST)
	public String diaryWrite(@RequestParam Map<String, Object> commandMap, String farmerNo) {

		//		Farmer res = farmdiaryService.writeFarmDiary(commandMap);

		//		session.setAttribute("farmerInfo", res);

		farmdiaryService.writeFarmDiary(commandMap);

//		System.out.println(commandMap);


		return "redirect:/farmdiary/farmdiarylist.do?farmerNo="+farmerNo;
	}

	//농장일기 리스트 화면
	@RequestMapping(value = "/farmdiary/farmdiarylist.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryList(@RequestParam(required = false, defaultValue = "1") int cPage, String farmerNo ) {

		System.out.println("FarmDiaryController farmerNo: " + farmerNo);
		
		// 파라미터용 farmNo 조회  * 수정이가 수정 *
		int farmNo = personalproduceService.selectFarmNoByFarmerNo(farmerNo);
		
//		int farmNo = farmdiaryService.selectFarmNoByFarmerNo(farmerNo);
		System.out.println("FarmDiaryController farmNo: " + farmNo);
		
		ModelAndView mav = new ModelAndView();

		int cntPerPage = 10;
		
//		System.out.println("FarmDairyContorller - farmerNo: " + farmerNo);
		
		Map<String,Object> res = farmdiaryService.selectFarmDiaryList(cPage, cntPerPage, farmerNo);
		
		mav.addObject("farmerNo", farmerNo);
		mav.addObject("paging", res.get("paging"));
		mav.addObject("list", res.get("fdlist"));
		mav.setViewName("farmdiary/farmdiarylist");
		
//		System.out.println("컨트롤러값"+res);
//		System.out.println(mav);
		//		System.out.println(res);

		// 원래는 이런 식으로 적는게 안좋은거 같긴 한데 일단 해볼게요
		if( farmNo != 0) {
			mav.addObject("farmNo", farmNo);
		}
		if( farmerNo != null ) {
			mav.addObject("farmerNo", farmerNo);
		}
		
		return mav;
	}

	//상세조회 화면
	@RequestMapping(value = "/farmdiary/farmdiarydetail.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryDetail(int farmDiaryNo) {

		ModelAndView mav = new ModelAndView();
		
		farmdiaryService.updateFarmDiaryHits(farmDiaryNo);
		
		Map<String, Object> res = farmdiaryService.selectFarmDiaryDetail(farmDiaryNo);
		mav.addObject("detail", res);
		mav.setViewName("farmdiary/farmdiarydetail");

		return mav;

	}

	//게시글 수정 화면
	@RequestMapping(value = "/farmdiary/farmdiarymodify.do", method = RequestMethod.GET)
	public ModelAndView farmdiaryModify(int farmDiaryNo) {
//		System.out.println("수정 페이지 접속 완료");

		ModelAndView mav = new ModelAndView();

		Map<String, Object> res = farmdiaryService.selectFarmDiaryDetail(farmDiaryNo);
		mav.addObject("detail", res);	
		
		return mav;
	}
	//게시글 수정
	@RequestMapping(value = "/diary/diarymodify.do", method = RequestMethod.POST)
	public ModelAndView diarymodify(@RequestParam Map<String, Object> commandMap, int farmDiaryNo) {

		ModelAndView mav = new ModelAndView();

		farmdiaryService.modifyFarmDiary(commandMap);

		mav.setViewName("redirect:/farmdiary/farmdiarydetail.do?farmDiaryNo="+farmDiaryNo);
		
//		System.out.println(mav);
		
		

		return mav;
	}

	//게시글 삭제
	@RequestMapping(value = "/farmdiary/farmdiarydelete.do", method = RequestMethod.GET )
	public String deleteFarmdiary(@RequestParam(value="farmDiaryNo") int farmDiaryNo, String farmerNo){
		
		
		farmdiaryService.deleteFarmDiary(farmDiaryNo);		
		
		return "redirect:/farmdiary/farmdiarylist.do?farmDiaryNo="+farmDiaryNo+"&farmerNo="+farmerNo;
	}

	//농장일기 이미지 업로드
	@RequestMapping(value = "/farmdiary/fileupload", method = RequestMethod.POST)
	@ResponseBody
	public String farmDiaryImgUpload(
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
						//							logger.debug(uploadPath);
						File uploadFile = new File(uploadPath);

						if(!uploadFile.exists()) {

							uploadFile.mkdirs();

						}

						fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
						uploadPath = uploadPath + "/" + fileName;
						//							logger.debug(uploadPath);
						out = new FileOutputStream(new File(uploadPath));
						out.write(bytes);
						out.flush();

						pw = resp.getWriter();
						resp.setContentType("text/html");
						String fileUrl = req.getContextPath() + "/resources/ckimg/" + fileName;
						//							logger.debug(fileUrl);

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


	//파일 업로드
	//	@RequestMapping(value = "/diary/diarywrite.do", method = RequestMethod.POST)
	//	public ModelAndView farmdiaryUpload(
	//			  FarmDiary farmdiary
	//			, @RequestParam List<MultipartFile> files
	//			, HttpSession session
	//			) throws Exception {
	//		
	//		ModelAndView mav = new ModelAndView();
	//		
	//		System.out.println(mav);
	//		
	//		String root = session.getServletContext().getRealPath("/");
	//		Member sessionMember = (Member)session.getAttribute("logInInfo");

	//		if(sessionMember != null) {
	//			notice.setUserId(sessionMember.getUserId());
	//		}else {
	//			notice.setUserId("비회원");
	//		}

	//		farmdiaryService.insertFarmdiaryFile(farmdiary, files, root);
	//		mav.setViewName("farmdiary/farmdiarylist");
	//		return mav;
	//	}	


}
