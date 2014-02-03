/**********************************************************************
 * CampaignManagementService.java, 16-oct-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.service;

import com.olsms.persistence.CampaignC2A;



// TODO: Auto-generated Javadoc
/**
 * The Interface CampaignManagementService.
 */
public interface CampaignManagementService 
{
	
	


	/**
	 * Find campaign by alias.
	 *
	 * @param alias the alias
	 * @return the campaign c2 a
	 */
	public CampaignC2A findCampaignByAlias(String alias);
	
	/**
	 * Find campaign by alias.
	 *
	 * @param alias the alias
	 * @return the campaign c2 a
	 */
	public CampaignC2A findCampaignByAlias2(String alias);

	

}
