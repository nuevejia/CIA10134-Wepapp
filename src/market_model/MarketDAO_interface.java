package market_model;

import java.util.*;

public interface MarketDAO_interface {
	public void insert(MarketVO MarketVO);
	public void update(MarketVO MarketVO);
	public void remove(Integer market_id);
	public MarketVO FindByPrimaryKey(Integer market_id);
	public List<MarketVO> getAll();

}