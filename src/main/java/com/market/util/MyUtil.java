package com.market.util;

import org.springframework.stereotype.Service;

@Service
public class MyUtil {
	//전체 페이지의 갯수
	public int getPageCount(int numPerPage, int dataCount) {
		int pageCount = 0;
		pageCount = dataCount / numPerPage;
		
		if(dataCount % numPerPage != 0) {
			pageCount++;
		}
		return pageCount;
	}
	
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
		
		StringBuffer sb = new StringBuffer();
		int numPerBlock = 5;
		int currentPageSetup;
		int page;
		
		if(currentPage == 0 || totalPage == 0) return "";
		
		if(listUrl.indexOf("?") != -1) {
			listUrl += "&";
		} else {
			listUrl += "?";
		}
		//이전버튼
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
		
		if(currentPage % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			sb.append("<li class=\"page-item \"><a class=\"page-link\" href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">&laquo;</a></li>");
		}
		
		//그냥 버튼
		page = currentPageSetup + 1;
		System.out.println("page=" + page);
		
		while(page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
			
			if(page == currentPage) {
				sb.append("<font class=\"page-link\"  style=\"background-color: #0d6efd; color: white;\">" + page + "</font>");
			} else {
				sb.append("<a class=\"page-link\" href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>");
				
			}
			
			page++;
		}
		
		//다음버튼
		if(totalPage - currentPageSetup > numPerBlock) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + listUrl + "pageNum=" + page + "\">&raquo;</a></li>");
		}
		
		//문자열로 리턴
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
}
