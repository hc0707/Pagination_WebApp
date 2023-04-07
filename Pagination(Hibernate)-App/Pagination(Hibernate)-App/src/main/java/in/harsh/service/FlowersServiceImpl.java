package in.harsh.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import in.harsh.daofactory.FlowersDaoFactory;
import in.harsh.dto.FlowersDto;
import in.harsh.model.Flowers;
import in.harsh.persistence.IFlowersDao;

public class FlowersServiceImpl implements IFlowersService {

	private IFlowersDao bankAccountDao;

	@Override
	public List<FlowersDto> getRecord(Integer record, Integer pgNumber) {
		bankAccountDao = FlowersDaoFactory.getBankAccountDao();
		if (bankAccountDao != null) {
			List<Flowers> flowersList = bankAccountDao.getRecord(record, pgNumber);
			List<FlowersDto> flowersDtoList = new ArrayList<>();
			
			flowersList.forEach(
					element->{
						FlowersDto flower=new FlowersDto();
						flower.setName(element.getName());
						flower.setInformation(element.getInformation());
						String image= Base64.getEncoder().encodeToString(element.getImage());
						flower.setImage(image);
						flowersDtoList.add(flower);
					}
					);
			return flowersDtoList;

		} else
			return null;
	}
	@Override
	public Long getNumberOfRecords() {
		bankAccountDao = FlowersDaoFactory.getBankAccountDao();
		if (bankAccountDao != null) {
			return bankAccountDao.getNumberOfRecords();

		} else
			return null;
	}

}
