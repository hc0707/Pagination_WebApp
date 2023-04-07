package in.harsh.persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.harsh.model.Flowers;
import in.harsh.util.HibernateUtil;

public class FlowersDaoImpl implements IFlowersDao {

	Session session=HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Flowers> getRecord(Integer record, Integer pgNumber) {
		try {
			
			Query<Flowers> query = session.createQuery("from in.harsh.model.Flowers");
			query.setFirstResult((pgNumber-1)*record);
			query.setMaxResults(record);
			List<Flowers> flower = query.list();
			return flower;

		} catch (HibernateException he) {
			he.printStackTrace();
			return null;
		}
	}
	@SuppressWarnings("rawtypes")
	@Override
	public Long getNumberOfRecords() {
			Query query = session.createQuery("SELECT COUNT(*) FROM in.harsh.model.Flowers");
			List list = query.list();
			return (Long) list.get(0);
	}

}
