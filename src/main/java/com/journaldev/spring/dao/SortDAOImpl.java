package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Sortinfo;
import com.journaldev.spring.model.Sortnumber;
import com.journaldev.spring.randomnumber.service.DigitPickerService;


@Repository
public class SortDAOImpl implements SortDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SortDAOImpl.class);

	private SessionFactory sessionFactory;
	
	
	
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean addSortingInfo(Sortinfo sortDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(sortDetails);
		logger.info("Sort details saved successfully, Sort Details="+sortDetails );
		return true;
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@SuppressWarnings("unchecked")
	@Override
	public List<Sortinfo> listSorts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Sortinfo> sortList = session.getNamedQuery("Sortinfo.findAll").list();
		if (logger.isDebugEnabled()){
			sortList.stream().forEach(System.out::println);
		}
		return sortList;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public List<Sortnumber> listNumbers(int sortId) {
		Session session = this.sessionFactory.getCurrentSession();
		Sortinfo sortInfo = (Sortinfo )session.load(Sortinfo.class,sortId);
		if (logger.isDebugEnabled() && sortInfo.getSortnumbers()!=null){
			sortInfo.getSortnumbers().stream().forEach(System.out::println);
		}
		return sortInfo.getSortnumbers();
	}
	

}
