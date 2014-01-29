/**********************************************************************
 * ScheduleC2ADAO.java, 16-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;





public interface ScheduleC2ADAO 
{

	
	public void insertScheduleC2A(ScheduleC2A scheduleC2A);
	
	public String findRoutingLabelByAlias(String alias);

	
}
