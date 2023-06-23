package com.market.service;

import java.util.List;

import com.market.dto.Market;

public interface MarketService {
	public int getDataCount(String searchKey, String searchValue) throws Exception;
	
	public List<Market> getLists(String searchKey, String searchValue, int start, int end) throws Exception;

	public Market getReadData(int num) throws Exception;

	public int maxNum() throws Exception;
	
	public void insertData(Market market) throws Exception;
	
	public void updateData(Market market) throws Exception;
	
	public void deleteData(int num) throws Exception;
	
	public int updateGood() throws Exception;

}
