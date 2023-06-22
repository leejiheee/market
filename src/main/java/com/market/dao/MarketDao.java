package com.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.Market;

	@Mapper
	public interface MarketDao {
		public int getDataCount(String searchKey, String searchValue) throws Exception;

		public List<Market> getLists(String searchKey, String searchValue, int start, int end) throws Exception;
		
		public Market getReadData(int num) throws Exception;
	
		public int maxNum() throws Exception;
		
		public void insertData(Market market) throws Exception;
		
		public void updateData(Market market) throws Exception;
	}
	
	
