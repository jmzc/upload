/**********************************************************************
 * CampaignC2A.java, 16-oct-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class CampaignC2A.
 */
@Entity
public class CampaignC2A
{

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;

	/** The alias. */
	@Column(nullable = false, length = 100)
	private String alias;

	/** The name. */
	private String name;

	/** The routing label. */
	@Column(length = 10)
	private String routingLabel;

	/**
	 * Instantiates a new campaign c2 a.
	 */
	public CampaignC2A()
	{
		super();
	}

	public CampaignC2A(Long id, String alias, String name, String routingLabel)
	{
		super();
		this.id = id;
		this.alias = alias;
		this.name = name;
		this.routingLabel = routingLabel;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * Gets the alias.
	 * 
	 * @return the alias
	 */
	public String getAlias()
	{
		return alias;
	}

	/**
	 * Sets the alias.
	 * 
	 * @param alias
	 *            the new alias
	 */
	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Gets the routing label.
	 * 
	 * @return the routing label
	 */
	public String getRoutingLabel()
	{
		return routingLabel;
	}

}
