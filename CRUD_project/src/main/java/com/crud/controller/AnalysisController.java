package com.crud.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.entity.Analysis;
import com.crud.repository.AnalysisRepository;
import com.crud.service.AnalysisService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AnalysisController {

	public final AnalysisRepository analysisRepository;

	@Autowired
	private AnalysisService analysisService;

	@GetMapping("imgUpload")
	public String imgUploadForm() {
		return "analysis/imgUpload";
	}

	// 이미지 자체를 DB에 저장하는 controller
	@PostMapping("img/img_upload")
	public String img_upload(@RequestParam("file") MultipartFile file, RedirectAttributes rttr) {
		try {
			if (!file.isEmpty()) {

				byte[] product_img = file.getBytes();
				Analysis analysis = new Analysis();
				analysis.setProductImg(product_img);
				analysisService.imgSave(analysis);

				rttr.addFlashAttribute("message", "업로드 성공");

				return "redirect:/imgUpload";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rttr.addFlashAttribute("message", "업로드 실패");
		return "redirect:/displayImage";
	}

	// 이미지를 인코딩해서 출력하는 controller
	@GetMapping("/displayImage")
	public String displayImage(@RequestParam("productIdx") Long productIdx, Model model) {
		
		// DB에서 이미지 읽어오기
		
		// 문제점 : 현재는 모든 list를 가져오는데 인코딩을 해줘야 함.
		// 각각 인코딩을 끝낸 list를 어떻게 타임리프에 보내줄 것인가?
		List<Analysis> analysis = analysisService.analysisList();
		Analysis analysisImg = analysisRepository.findById(productIdx).orElse(null);
		if (analysisImg != null) {
			
			// Base64 이미지 인코딩
			String base64Image = Base64.getEncoder().encodeToString(analysisImg.getProductImg());

			model.addAttribute("base64Image", base64Image);
			model.addAttribute("msg", "true");
		}

		return "analysis/displayImage";
	}

}
