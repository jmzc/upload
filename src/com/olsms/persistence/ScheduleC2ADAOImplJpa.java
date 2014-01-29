/**********************************************************************
 * ScheduleC2ADAOImplJpa.java, 16-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class ScheduleC2ADAOImplJpa extends JpaDaoSupport implements ScheduleC2ADAO
{

	

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertScheduleC2A(ScheduleC2A scheduleC2A) 
	{

		getJpaTemplate().persist(scheduleC2A);
	
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String findRoutingLabelByAlias(String alias) 
	{

		Map<String, String> param = new HashMap<String, String>();
		param.put("alias", alias);
		
		//JPQL mostly is case-insensitive. One of the things that is case-sensitive is Java entity names. 
		String query = "SELECT t.routingLabel FROM CampaignC2A t WHERE lower(t.alias) = lower(:alias)";
				
		List<String> l = getJpaTemplate().findByNamedParams(query , param);
		

		
		if(l!= null && !l.isEmpty())
		{
			return  l.get(0);
		}
		else
		{
			return null;
		}	
		
	}

}
