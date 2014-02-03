/**********************************************************************
 * CampaignManagementServiceImpl.java, 16-oct-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.service;

import com.olsms.persistence.CampaignC2A;
import com.olsms.persistence.CampaignDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class CampaignManagementServiceImpl.
 */
public class CampaignManagementServiceImpl implements CampaignManagementService
{

	/** The campaign dao. */
	private CampaignDAO campaignDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.prosodie.c2a.campaign.service.CampaignManagementService#
	 * findCampaignByAlias(java.lang.String)
	 */
	public CampaignC2A findCampaignByAlias(String alias)
	{

		return campaignDAO.findCampaignByAlias(alias);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see es.prosodie.c2a.campaign.service.CampaignManagementService#
	 * findCampaignByAlias(java.lang.String)
	 */
	public CampaignC2A findCampaignByAlias2(String alias)
	{

		return campaignDAO.findCampaignByAlias2(alias);
	}
	

	/**
	 * Gets the campaign dao.
	 * 
	 * @return the campaign dao
	 */
	public CampaignDAO getCampaignDAO()
	{
		return campaignDAO;
	}

	/**
	 * Sets the campaign dao.
	 * 
	 * @param campaignDAO
	 *            the new campaign dao
	 */
	public void setCampaignDAO(CampaignDAO campaignDAO)
	{
		this.campaignDAO = campaignDAO;
	}

}
