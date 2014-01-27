/**********************************************************************
 * ScheduleC2AManagementServiceImpl.java, 16-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.service;

import com.olsms.persistence.ScheduleC2A;
import com.olsms.persistence.ScheduleC2ADAO;



// TODO: Auto-generated Javadoc
/**
 * The Class ScheduleC2AManagementServiceImpl.
 */
public class ScheduleC2AManagementServiceImpl implements ScheduleC2AManagementService
{

	/** The schedule c2 adao. */
	private ScheduleC2ADAO scheduleC2ADAO;
	
	public ScheduleC2ADAO getScheduleC2ADAO() 
	{
		return scheduleC2ADAO;
	}

	public void setScheduleC2ADAO(ScheduleC2ADAO scheduleC2ADAO) 
	{
		this.scheduleC2ADAO = scheduleC2ADAO;
	}
	
	public void loadScheduleC2A(ScheduleC2A scheduleC2A)
	{
		
		scheduleC2ADAO.insertScheduleC2A(scheduleC2A);
	}

	
	
	
	

}
