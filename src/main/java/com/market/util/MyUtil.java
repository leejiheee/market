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
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">◀이전</a>&nbsp");
		}
		
		//그냥 버튼
		page = currentPageSetup + 1;
		
		while(page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
			
			if(page == currentPage) {
				sb.append("<font color=\"hotpink\">" + page + "</font>&nbsp;");
			} else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp");
				
			}
			
			page++;
		}
		
		//다음버튼
		if(totalPage - currentPageSetup > numPerBlock) {
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">다음▶</a>&nbsp");
		}
		
		//문자열로 리턴
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
}
