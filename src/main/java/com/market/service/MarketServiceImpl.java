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


	@Override
	public Market getReadData(int num) throws Exception {
		return marketMapper.getReadData(num);
	}


	@Override
	public int maxNum() throws Exception {
		return marketMapper.maxNum();
	}


	@Override
	public void insertData(Market market) throws Exception {
		marketMapper.insertData(market);
		
	}


	@Override
	public void updateData(Market market) throws Exception {
		marketMapper.updateData(market);
	}


	@Override
	public void deleteData(int num) throws Exception {
		marketMapper.deleteData(num);
		
	}


	@Override
	public int updateGood() throws Exception {
		return marketMapper.updateGood();
	}

	
	

}
