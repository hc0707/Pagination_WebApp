package in.harsh.service;

import java.util.List;

import in.harsh.dto.FlowersDto;

public interface IFlowersService {
	

	public  List<FlowersDto> getRecord(Integer record,Integer pgNumber);
	public Long getNumberOfRecords();
	
}
