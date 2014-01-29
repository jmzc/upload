/**********************************************************************
 * ScheduleC2ADAOImplJpa.java, 16-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

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

}
