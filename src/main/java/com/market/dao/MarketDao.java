package com.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.market.dto.Market;

	@Mapper
	public interface MarketDao {
		public int getDataCount(String searchKey, String searchValue) throws Exception;

		public List<Market> getLists(String searchKey, String searchValue, int start, int end) throws Exception;
		
	}
	
	
