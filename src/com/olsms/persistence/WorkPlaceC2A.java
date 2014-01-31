/**********************************************************************
 * WorkPlaceC2A.java, 16-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

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
 * The Class WorkPlaceC2A.
 */
@Entity
public class WorkPlaceC2A
{

	/**
	 * The Enum WorkPlaceC2ADialingType.
	 */
	public enum WorkPlaceC2ADialingType
	{

		/** The manual. */
		MANUAL,

		/** The autodialing. */
		AUTODIALING,

		/** The autodialing confirmation. */
		AUTODIALING_CONFIRMATION
	};

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;

	/** The name. */
	private String name;

	/** The description. */
	private String description;

	/** The routing. */
	@OneToMany(mappedBy = "workPlace", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RoutingC2A> routing;

	/** The schedule. */
	@OneToMany(mappedBy = "workPlace", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ScheduleC2A> schedule;

	/** The keep alive init. */
	@Column(columnDefinition = "INTEGER DEFAULT '10'")
	private int keepAliveInit;

	/** The keep alive. */
	@Column(columnDefinition = "INTEGER DEFAULT '30'")
	private int keepAlive;

	/** The dialing type. */
	@Column(columnDefinition = "INTEGER DEFAULT '0'")
	private WorkPlaceC2ADialingType dialingType;

	/** The can do delayed. */
	private Boolean canDoDelayed;

	/**
	 * Instantiates a new work place c2 a.
	 */
	public WorkPlaceC2A()
	{

		super();
	}

	/**
	 * Instantiates a new work place c2 a.
	 * 
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 */
	public WorkPlaceC2A(Long id, String name, String description)
	{

		super();
		this.setId(id);
		this.setName(name);
		this.setDescription(description);

	}

	/**
	 * Instantiates a new work place c2 a.
	 * 
	 * @param name
	 *            the name
	 * @param description
	 *            the description
	 * @param keepAliveInit
	 *            the keep alive init
	 * @param keepAlive
	 *            the keep alive
	 * @param dialingType
	 *            the dialing type
	 * @param canDoDelayed
	 *            the can do delayed
	 */
	public WorkPlaceC2A(String name, String description, int keepAliveInit, int keepAlive, WorkPlaceC2ADialingType dialingType, Boolean canDoDelayed)
	{

		super();
		this.setName(name);
		this.setDescription(description);
		this.setKeepAliveInit(keepAliveInit);
		this.setKeepAlive(keepAlive);
		this.setDialingType(dialingType);
		this.setCanDoDelayed(canDoDelayed);
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
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description)
	{
		this.description = description;
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

	/**
	 * Gets the schedule.
	 * 
	 * @return the schedule
	 */
	public Set<ScheduleC2A> getSchedule()
	{
		return schedule;
	}

	/**
	 * Sets the schedule.
	 * 
	 * @param schedule
	 *            the new schedule
	 */
	public void setSchedule(Set<ScheduleC2A> schedule)
	{
		this.schedule = schedule;
	}

	/**
	 * Gets the keep alive init.
	 * 
	 * @return the keep alive init
	 */
	public int getKeepAliveInit()
	{
		return keepAliveInit;
	}

	/**
	 * Sets the keep alive init.
	 * 
	 * @param keepAliveInit
	 *            the new keep alive init
	 */
	public void setKeepAliveInit(int keepAliveInit)
	{
		this.keepAliveInit = keepAliveInit;
	}

	/**
	 * Gets the keep alive.
	 * 
	 * @return the keep alive
	 */
	public int getKeepAlive()
	{
		return keepAlive;
	}

	/**
	 * Sets the keep alive.
	 * 
	 * @param keepAlive
	 *            the new keep alive
	 */
	public void setKeepAlive(int keepAlive)
	{
		this.keepAlive = keepAlive;
	}

	/**
	 * Gets the dialing type.
	 * 
	 * @return the dialing type
	 */
	public WorkPlaceC2ADialingType getDialingType()
	{
		return dialingType;
	}

	/**
	 * Sets the dialing type.
	 * 
	 * @param dialingType
	 *            the new dialing type
	 */
	public void setDialingType(WorkPlaceC2ADialingType dialingType)
	{
		this.dialingType = dialingType;
	}

	/**
	 * Gets the can do delayed.
	 * 
	 * @return the can do delayed
	 */
	public Boolean getCanDoDelayed()
	{
		return canDoDelayed;
	}

	/**
	 * Sets the can do delayed.
	 * 
	 * @param canDoDelayed
	 *            the new can do delayed
	 */
	public void setCanDoDelayed(Boolean canDoDelayed)
	{
		this.canDoDelayed = canDoDelayed;
	}

}
