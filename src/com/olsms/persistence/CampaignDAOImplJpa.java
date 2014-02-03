/**********************************************************************
 * CampaignDAOImplJpa.java, 16-oct-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;




import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 * The Class CampaignDAOImplJpa.
 */

@Transactional(propagation=Propagation.MANDATORY)
public class CampaignDAOImplJpa extends JpaDaoSupport implements CampaignDAO
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.prosodie.c2a.campaign.persistence.CampaignDAO#findCampaignByAlias(
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public CampaignC2A findCampaignByAlias(String alias)
	{
		List<CampaignC2A> results = new ArrayList<CampaignC2A>();
		CampaignC2A result = null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("alias", alias);
		results = getJpaTemplate().findByNamedParams("SELECT c " + "FROM CampaignC2A c WHERE lower(c.alias) LIKE lower(:alias) ORDER BY c.alias", params);

		if (!results.isEmpty())
		{
			result = results.get(0);
			

		}

		return result;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.prosodie.c2a.campaign.persistence.CampaignDAO#findCampaignByAlias(
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public CampaignC2A findCampaignByAlias2(String alias)
	{
		CampaignC2A campaignC2A = null;
	
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("alias", alias);
		
		List<CampaignC2A> l = getJpaTemplate().findByNamedParams("SELECT c " + "FROM CampaignC2A c WHERE lower(c.alias) LIKE lower(:alias) ORDER BY c.alias", params);

		if (!l.isEmpty())
		{
			campaignC2A = l.get(0);
			if (campaignC2A != null)
			{
				Set<RoutingC2A> s = campaignC2A.getRouting();

	        	for (RoutingC2A routingC2A: s)
	        	{
	        		if (routingC2A != null && routingC2A.getWorkPlace() != null)
	        			routingC2A.getWorkPlace().getName();
	        			        			        	

	        	}

			}

		}
		

		return campaignC2A;
	}
	
	
	

}
