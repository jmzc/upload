/**********************************************************************
 * RoutingC2A.java, 31-oct-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class RoutingC2A.
 */
@Entity
public class RoutingC2A
{

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;

	/** The campaign. */
	@ManyToOne(fetch = FetchType.LAZY)
	private CampaignC2A campaign;

	/** The percent. */
	private Long percent;

	/** The is check. */
	private Boolean isCheck;

	/** The workplace order. */
	@Column(columnDefinition = "INTEGER DEFAULT '0'")
	private int workplaceOrder;


	/** The work place. */
	@ManyToOne(fetch = FetchType.LAZY)
	private WorkPlaceC2A workPlace;

	/**
	 * Instantiates a new routing c2 a.
	 */
	public RoutingC2A()
	{
		super();
	}

	/**
	 * Instantiates a new routing c2 a.
	 * 
	 * @param id
	 *            the id
	 * @param percent
	 *            the percent
	 * @param isCheck
	 *            the is check
	 */
	public RoutingC2A(Long id, Long percent, Boolean isCheck)
	{

		super();
		this.setId(id);
		this.setPercent(percent);
		this.setIsCheck(isCheck);

	}

	/**
	 * Instantiates a new routing c2 a.
	 * 
	 * @param isCheck
	 *            the is check
	 * @param percent
	 *            the percent
	 * @param campaign
	 *            the campaign
	 * @param workPlace
	 *            the work place
	 * @param web
	 *            the web
	 * @param routingType
	 *            the routing type
	 */
	public RoutingC2A(Boolean isCheck, Long percent, CampaignC2A campaign, WorkPlaceC2A workPlace)
	{
		super();
		this.setIsCheck(isCheck);
		this.setPercent(percent);
		this.setCampaign(campaign);
		this.setWorkPlace(workPlace);

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
	 * Gets the campaign.
	 * 
	 * @return the campaign
	 */
	public CampaignC2A getCampaign()
	{
		return campaign;
	}

	/**
	 * Sets the campaign.
	 * 
	 * @param campaign
	 *            the new campaign
	 */
	public void setCampaign(CampaignC2A campaign)
	{
		this.campaign = campaign;
	}

	/**
	 * Gets the percent.
	 * 
	 * @return the percent
	 */
	public Long getPercent()
	{
		return percent;
	}

	/**
	 * Sets the percent.
	 * 
	 * @param percent
	 *            the new percent
	 */
	public void setPercent(Long percent)
	{
		this.percent = percent;
	}

	/**
	 * Gets the checks if is check.
	 * 
	 * @return the checks if is check
	 */
	public Boolean getIsCheck()
	{
		return isCheck;
	}

	/**
	 * Sets the checks if is check.
	 * 
	 * @param isCheck
	 *            the new checks if is check
	 */
	public void setIsCheck(Boolean isCheck)
	{
		this.isCheck = isCheck;
	}

	/**
	 * Gets the workplace order.
	 * 
	 * @return the workplace order
	 */
	public int getWorkplaceOrder()
	{
		return workplaceOrder;
	}

	/**
	 * Sets the workplace order.
	 * 
	 * @param workplaceOrder
	 *            the new workplace order
	 */
	public void setWorkplaceOrder(int workplaceOrder)
	{
		this.workplaceOrder = workplaceOrder;
	}

	/**
	 * Gets the work place.
	 * 
	 * @return the work place
	 */
	public WorkPlaceC2A getWorkPlace()
	{
		return workPlace;
	}

	/**
	 * Sets the work place.
	 * 
	 * @param workPlace
	 *            the new work place
	 */
	public void setWorkPlace(WorkPlaceC2A workPlace)
	{
		this.workPlace = workPlace;
	}

}
