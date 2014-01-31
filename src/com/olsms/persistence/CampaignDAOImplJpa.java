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

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 * The Class CampaignDAOImplJpa.
 */

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

}
