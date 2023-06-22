package com.market.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.Market;
import com.market.service.MarketService;
import com.market.util.MyUtil;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;


@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:/Temp/img")

@Controller
public class MarketController {
	//의존성 주입
	@Autowired
	private MarketService marketService;
	
	@Autowired
	MyUtil myUtil;
	
	@RequestMapping(value="/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Market market, HttpServletRequest request, Model model) {
		
		
		try {
			
			String pageNum = request.getParameter("pageNum");
			int currentPage = 1;
			
			if(pageNum != null) currentPage = Integer.parseInt(pageNum);
			String searchKey = request.getParameter("searchKey"); //검색키워드
			String searchValue = request.getParameter("searchValue"); //검색어
			
			if(searchValue == null) {
				searchKey = "name";
				searchValue = "";
			} else {
				if(request.getMethod().equalsIgnoreCase("GET")) {
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				}
			}
			
			//전체 게시물 갯수(페이징처리에 필요)
			int dataCount = marketService.getDataCount(searchKey, searchValue);
		
			//페이징처리(준비단계)
			int numPerPage = 4;
			int totalPage =myUtil.getPageCount(numPerPage, dataCount);
			
			if(currentPage > totalPage) {
				currentPage = totalPage;
			}
			
			int start = (currentPage - 1) * numPerPage + 1;
			int end = currentPage * numPerPage;
			
			//전체 게시물 리스트 가져옴
			List<Market> lists = marketService.getLists(searchKey, searchValue, start, end);
			
			//페이징 처리
			String param = "";
			
			if(searchValue != null && !searchValue.equals("")) {
				param = "searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			}
			
			String listUrl = "/list";
			
			if(!param.equals("")) listUrl += "?" + param;
			
			String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, listUrl);
			
			String articleUrl = "/article?pageNum=" + currentPage;
			
			if(!param.equals("")) {
				articleUrl += "&" + param;
			}
			


			
			model.addAttribute("lists", lists);
			model.addAttribute("articleUrl", articleUrl);
			model.addAttribute("pageIndexList", pageIndexList);
			model.addAttribute("dataCount", dataCount);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
		
		
		return "bbs/list";
	}
	
	
	
	
	
	
	
}
