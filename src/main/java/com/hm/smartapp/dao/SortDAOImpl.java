package com.hm.smartapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hm.smartapp.model.Sortinfo;
import com.hm.smartapp.model.Sortnumber;
import com.hm.smartapp.service.numbergenerator.NumberPickerService;


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
		
		List<Sortnumber> numberList = session.getNamedQuery("Sortnumber.findBySortId").setParameter("id",sortId).list();
		
		if (logger.isDebugEnabled()){
			numberList.stream().forEach(System.out::println);
		}
		return numberList;
	}
	

}
