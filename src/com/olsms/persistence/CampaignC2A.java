/**********************************************************************
 * CampaignC2A.java, 16-oct-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
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

	/** The planning date. */
	private Timestamp planningDate;

	/** The init date. */
	private Timestamp initDate;

	/** The end date. */
	private Timestamp endDate;

	/** The routing label. */
	@Column(length = 10)
	private String routingLabel;


	/** The routing. */
	@OneToMany(mappedBy = "campaign", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RoutingC2A> routing;

	/**
	 * Instantiates a new campaign c2 a.
	 */
	public CampaignC2A()
	{
		super();
	}

	/**
	 * Instantiates a new campaign c2 a.
	 * 
	 * @param id
	 *            the id
	 * @param alias
	 *            the alias
	 * @param name
	 *            the name
	 * @param planningDate
	 *            the planning date
	 * @param initDate
	 *            the init date
	 * @param endDate
	 *            the end date
	 * @param emailsCallmelater
	 *            the emails callmelater
	 */
	public CampaignC2A(Long id, String alias, String name, Timestamp planningDate, Timestamp initDate, Timestamp endDate, String emailsCallmelater)
	{

		super();

		this.setId(id);
		this.setAlias(alias);
		this.setPlanningDate(planningDate);
		this.setInitDate(initDate);
		this.setEndDate(endDate);

	}

	/**
	 * Instantiates a new campaign c2 a.
	 * 
	 * @param alias
	 *            the alias
	 * @param name
	 *            the name
	 * @param planningDate
	 *            the planning date
	 * @param initDate
	 *            the init date
	 * @param endDate
	 *            the end date
	 * @param validationType
	 *            the validation type
	 * @param routingType
	 *            the routing type
	 * @param emailsCallmelater
	 *            the emails callmelater
	 * @param type
	 *            the type
	 */
	public CampaignC2A(String alias, String name, Timestamp planningDate, Timestamp initDate, Timestamp endDate, String emailsCallmelater, String type)
	{

		super();
		this.setAlias(alias);
		this.setName(name);
		this.setPlanningDate(planningDate);
		this.setInitDate(initDate);
		this.setEndDate(endDate);

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
	 * Gets the planning date.
	 * 
	 * @return the planning date
	 */
	public Timestamp getPlanningDate()
	{
		return planningDate;
	}

	/**
	 * Gets the planning date string.
	 * 
	 * @return the planning date string
	 */
	public String getPlanningDateString()
	{
		if (this.planningDate != null)
		{
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(this.planningDate);
		}
		return "";
	}

	/**
	 * Sets the planning date.
	 * 
	 * @param planningDate
	 *            the new planning date
	 */
	public void setPlanningDate(Timestamp planningDate)
	{
		this.planningDate = planningDate;
	}

	/**
	 * Gets the inits the date.
	 * 
	 * @return the inits the date
	 */
	public Timestamp getInitDate()
	{
		return initDate;
	}

	/**
	 * Gets the inits the date string.
	 * 
	 * @return the inits the date string
	 */
	public String getInitDateString()
	{
		if (this.initDate != null)
		{
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(this.initDate);
		}
		return "";

	}

	/**
	 * Sets the inits the date.
	 * 
	 * @param initDate
	 *            the new inits the date
	 */
	public void setInitDate(Timestamp initDate)
	{
		this.initDate = initDate;
	}

	/**
	 * Gets the end date.
	 * 
	 * @return the end date
	 */
	public Timestamp getEndDate()
	{
		return endDate;
	}

	/**
	 * Gets the end date string.
	 * 
	 * @return the end date string
	 */
	public String getEndDateString()
	{
		if (this.endDate != null)
		{
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(this.endDate);
		}
		return "";
	}

	/**
	 * Sets the end date.
	 * 
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(Timestamp endDate)
	{
		this.endDate = endDate;
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

	/**
	 * Sets the routing label.
	 * 
	 * @param routingLabel
	 *            the new routing label
	 */
	public void setRoutingLabel(String routingLabel)
	{
		this.routingLabel = routingLabel;
	}

	/**
	 * Gets the routing.
	 * 
	 * @return the routing
	 */
	public Set<RoutingC2A> getRouting()
	{
		return routing;
	}

	/**
	 * Sets the routing.
	 * 
	 * @param routing
	 *            the new routing
	 */
	public void setRouting(Set<RoutingC2A> routing)
	{
		this.routing = routing;
	}

}
