package com.market.service;

import java.util.List;

import com.market.dto.Market;

public interface MarketService {
	public int getDataCount(String searchKey, String searchValue) throws Exception;
	
	public List<Market> getLists(String searchKey, String searchValue, int start, int end) throws Exception;

}
