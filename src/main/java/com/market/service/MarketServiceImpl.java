package com.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.MarketDao;
import com.market.dto.Market;

@Service
public class MarketServiceImpl implements MarketService{
	@Autowired
	private MarketDao marketMapper;


	@Override
	public List<Market> getLists(String searchKey, String searchValue, int start, int end) throws Exception {
		return marketMapper.getLists(searchKey, searchValue, start, end);
	}


	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		return marketMapper.getDataCount(searchKey, searchValue);
	}
	

}
