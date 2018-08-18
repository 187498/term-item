package com.cjg.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.cjg.bank.domain.TradeInfo;
import com.cjg.bank.persistence.TradeDAO;
import com.cjg.bank.persistence.TradeDAOImpl;


public class TradeFacadeImpl implements TradeFacade {

	private TradeDAO tradeDAO;

	public TradeFacadeImpl() {
		tradeDAO = new TradeDAOImpl();
	}

	public void fetchMoney(TradeInfo tradeInfo) throws SQLException {
		tradeDAO.fetchMoney(tradeInfo);
	}

	public void saveMoney(TradeInfo tradeInfo) throws SQLException {
		tradeDAO.saveMoney(tradeInfo);
	}

	public Integer selectBalance(String userNO) throws SQLException {
		return tradeDAO.selectBalance(userNO);
	}

	public List selectTradeInfo(String userNO) throws SQLException {
		return tradeDAO.selectTradeInfo(userNO);
	}

}
