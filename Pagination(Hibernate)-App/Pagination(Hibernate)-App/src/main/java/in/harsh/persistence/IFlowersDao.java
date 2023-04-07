package in.harsh.persistence;

import java.util.List;

import in.harsh.model.Flowers;

public interface IFlowersDao {
	
	public  List<Flowers> getRecord(Integer record, Integer pgNumber);
	public Long getNumberOfRecords();
}

