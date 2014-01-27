/**********************************************************************
 * CallC2A.java, 16-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

import java.sql.Timestamp;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.olsms.persistence.ScheduleC2A.ScheduleC2APersistence;

//import javax.persistence.OneToMany;



// TODO: Auto-generated Javadoc
/**
 * The Class CallC2A.
 */
@Entity
public class CallC2A {

	
	/**
	 * The Enum ServiceCall.
	 */
	public enum ServiceCall{
		
		/** The C2 a. */
		C2A,
		
		/** The Linea_900. */
		Linea_900,
		
		/** The agenda. */
		AGENDA
	};
	
	/** The id. */
	@Id
	@GeneratedValue
	private Long id;
	  
	/** The campaign id. */
	private Long campaignId; // copia del valor del id, no fk
	
	/** The campaign alias. */
	@Column(length=100)
	private String campaignAlias; // copia del valor del nombre, no fk
	
	/** The products. */
	private String products; //separados por pipe
	
	/** The idu. */
	@Column(length=200)
	private String idu;
	
	/** The urls. */
	private String urls; // URLs separadas por |, se reciben por mq
	
	/** The init date camp. */
	private Timestamp initDateCamp; //fecha inicio campaña, copia del valor de campaña
	
	/** The end date camp. */
	private Timestamp endDateCamp; // fecha fin campaña, copia del valor de campaña
	
	/** The timetable. */
	@Column(length=100)
	private String timetable; // horario en formato "human readable" copia de campaña
	
	/** The routing type. */
	@Column(length=50)
	private String routingType;// etiqueta enrutamiento o número destino, viene en mq
	
	/** The routing label. */
	private String routingLabel;
	
	/** The codifications. */
	private String codifications; // codificaciones separadas por |
	
	/** The argumentarios. */
	private String argumentarios; // argumentarios separados por |
	
	/** The session id. */
	private String sessionId; // sessionId de C2C, viene por mq
	
	/** The initial session id. */
	private String initialSessionId; // sessionId de C2C, viene por mq
	
	/** The url host. */
	private String urlHost; // url de la pagina de C2a, viene por mq
	
	/** The destination phone. */
	@Column(length=50)
	private String destinationPhone;
	
	/** The translate phone. */
	@Column(length=50)
	private String translatePhone;
		
	/** The register. */
	@Column(length=20)
	private String register;// matricula del agente, sacamos de usersession
	
	/** The login. */
	@Column(length=20)
	private String login;
	
	/** The client phone. */
	@Column(length=50)
	private String clientPhone;
	
	/** The client phone act. */
	@Column(length=50)
	private String clientPhoneAct;

	/** The init date call. */
	private Timestamp initDateCall;
	
	/** The end date call. */
	private Timestamp endDateCall;  
	
	/** The provider. */
	@Column(length=100)
	private String provider;
	
	/** The workplace. */
	private String workplace;
	
	/** The routing. */
	private String routing;
	
	/** The type campaign. */
	private String typeCampaign;
	
	/** The client ip. */
	@Column(length=50)
	private String ipC2c;
	
	/** The client segment. */
	@Column(length=100)
	private String segmentation;
	
	/** The service call. */
	@Enumerated(EnumType.STRING)
	private ServiceCall serviceCall;
	
	/** The persistence. */
	private ScheduleC2APersistence persistence;
	
	/** The schedules. */
//	@OneToMany(mappedBy= "call", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<ScheduleC2A> schedules;
	
	/** The schedule. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	//@JoinColumn(name = "schedule_id", nullable = true, updatable = false, insertable = false)
	private ScheduleC2A schedule;
	
	/**
	 * Instantiates a new call c2 a.
	 */
	public CallC2A()
	{
		super();
	}
	
	/**
	 * Instantiates a new call c2 a.
	 *
	 * @param id the id
	 * @param campaignId the campaign id
	 * @param campaignAlias the campaign alias
	 * @param products the products
	 * @param idu the idu
	 * @param urls the urls
	 * @param initDateCamp the init date camp
	 * @param endDateCamp the end date camp
	 * @param timetable the timetable
	 * @param routingType the routing type
	 * @param routingLabel the routing label
	 * @param codifications the codifications
	 * @param argumentarios the argumentarios
	 * @param sessionId the session id
	 * @param initialSessionId the initial session id
	 * @param urlHost the url host
	 * @param destinationPhone the destination phone
	 * @param translatePhone the translate phone
	 * @param register the register
	 * @param login the login
	 * @param clientPhone the client phone
	 * @param clientPhoneAct the client phone act
	 * @param initDateCall the init date call
	 * @param endDateCall the end date call
	 * @param provider the provider
	 * @param workplace the workplace
	 * @param routing the routing
	 * @param typeCampaign the type campaign
	 * @param ipC2c the ip c2c
	 * @param segmentation the segmentation
	 * @param persistence the persistence
	 * @param serviceCall the service call
	 */
	public CallC2A(Long id, Long campaignId, String campaignAlias, String products, String idu, String urls, 
			Timestamp initDateCamp, Timestamp endDateCamp, String timetable, String routingType, String routingLabel, 
			String codifications, String argumentarios, String sessionId, String initialSessionId, String urlHost, 
			String destinationPhone, String translatePhone, String register, String login, String clientPhone, 
			String clientPhoneAct, Timestamp initDateCall, Timestamp endDateCall, String provider, String workplace, 
			String routing, String typeCampaign, String ipC2c, String segmentation, ScheduleC2APersistence persistence, 
			ServiceCall serviceCall)
	{
		super();
		
		this.setCampaignId(campaignId);
		this.setCampaignAlias(campaignAlias);
		this.setProducts(products);
		this.setIdu(idu);
		this.setUrls(urls);
		this.setInitDateCamp(initDateCamp);
		this.setEndDateCamp(endDateCamp);
		this.setTimetable(timetable);
		this.setRoutingType(routingType);
		this.setRoutingLabel(routingLabel);
		this.setCodifications(codifications);
		this.setArgumentarios(argumentarios);
		this.setSessionId(sessionId);
		this.setInitialSessionId(initialSessionId);
		this.setUrlHost(urlHost);
		this.setDestinationPhone(destinationPhone);
		this.setTranslatePhone(translatePhone);
		this.setRegister(register);
		this.setLogin(login);
		this.setClientPhone(clientPhone);
		this.setClientPhoneAct(clientPhoneAct);
		this.setInitDateCall(initDateCall);
		this.setEndDateCall(endDateCall);
		this.setProvider(provider);
		this.setWorkplace(workplace);
		this.setRouting(routing);
		this.setTypeCampaign(typeCampaign);
		this.setIpC2c(ipC2c);
		this.setSegmentation(segmentation);
		this.setServiceCall(serviceCall);
		this.setPersistence(persistence);

	}
	
	/**
	 * Instantiates a new call c2 a.
	 *
	 * @param campaignId the campaign id
	 * @param campaignAlias the campaign alias
	 * @param products the products
	 * @param idu the idu
	 * @param urls the urls
	 * @param initDateCamp the init date camp
	 * @param endDateCamp the end date camp
	 * @param timetable the timetable
	 * @param routingType the routing type
	 * @param routingLabel the routing label
	 * @param codifications the codifications
	 * @param argumentarios the argumentarios
	 * @param sessionId the session id
	 * @param initialSessionId the initial session id
	 * @param urlHost the url host
	 * @param destinationPhone the destination phone
	 * @param translatePhone the translate phone
	 * @param register the register
	 * @param login the login
	 * @param clientPhone the client phone
	 * @param clientPhoneAct the client phone act
	 * @param initDateCall the init date call
	 * @param endDateCall the end date call
	 * @param provider the provider
	 * @param workplace the workplace
	 * @param routing the routing
	 * @param typeCampaign the type campaign
	 * @param ipC2c the ip c2c
	 * @param segmentation the segmentation
	 * @param serviceCall the service call
	 * @param persistence the persistence
	 * @param schedule the schedule
	 */
	public CallC2A(Long campaignId, String campaignAlias, String products, String idu, String urls, Timestamp initDateCamp, 
			Timestamp endDateCamp, String timetable, String routingType, String routingLabel, String codifications, 
			String argumentarios, String sessionId, String initialSessionId, String urlHost, String destinationPhone, 
			String translatePhone, String register, String login, String clientPhone, String clientPhoneAct, 
			Timestamp initDateCall, Timestamp endDateCall, String provider, String workplace, String routing, 
			String typeCampaign, String ipC2c, String segmentation, ServiceCall serviceCall, ScheduleC2APersistence persistence, 
			ScheduleC2A schedule)
	{
		super();
		
		this.setCampaignId(campaignId);
		this.setCampaignAlias(campaignAlias);
		this.setProducts(products);
		this.setIdu(idu);
		this.setUrls(urls);
		this.setInitDateCamp(initDateCamp);
		this.setEndDateCamp(endDateCamp);
		this.setTimetable(timetable);
		this.setRoutingType(routingType);
		this.setRoutingLabel(routingLabel);
		this.setCodifications(codifications);
		this.setArgumentarios(argumentarios);
		this.setSessionId(sessionId);
		this.setInitialSessionId(initialSessionId);
		this.setUrlHost(urlHost);
		this.setDestinationPhone(destinationPhone);
		this.setTranslatePhone(translatePhone);
		this.setRegister(register);
		this.setLogin(login);
		this.setClientPhone(clientPhone);
		this.setClientPhoneAct(clientPhoneAct);
		this.setInitDateCall(initDateCall);
		this.setEndDateCall(endDateCall);
		this.setProvider(provider);
		this.setWorkplace(workplace);
		this.setRouting(routing);
		this.setTypeCampaign(typeCampaign);
		this.setIpC2c(ipC2c);
		this.setSegmentation(segmentation);
		this.setServiceCall(serviceCall);
		this.setPersistence(persistence);
		this.setSchedule(schedule);
		
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the campaign id.
	 *
	 * @return the campaign id
	 */
	public Long getCampaignId() {
		return campaignId;
	}

	/**
	 * Sets the campaign id.
	 *
	 * @param campaignId the new campaign id
	 */
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	/**
	 * Gets the campaign alias.
	 *
	 * @return the campaign alias
	 */
	public String getCampaignAlias() {
		return campaignAlias;
	}

	/**
	 * Sets the campaign alias.
	 *
	 * @param campaignAlias the new campaign alias
	 */
	public void setCampaignAlias(String campaignAlias) {
		this.campaignAlias = campaignAlias;
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public String getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 *
	 * @param products the new products
	 */
	public void setProducts(String products) {
		this.products = products;
	}

	/**
	 * Gets the idu.
	 *
	 * @return the idu
	 */
	public String getIdu() {
		return idu;
	}

	/**
	 * Sets the idu.
	 *
	 * @param idu the new idu
	 */
	public void setIdu(String idu) {
		this.idu = idu;
	}

	/**
	 * Gets the urls.
	 *
	 * @return the urls
	 */
	public String getUrls() {
		return urls;
	}

	/**
	 * Sets the urls.
	 *
	 * @param urls the new urls
	 */
	public void setUrls(String urls) {
		this.urls = urls;
	}

	/**
	 * Gets the inits the date camp.
	 *
	 * @return the inits the date camp
	 */
	public Timestamp getInitDateCamp() {
		return initDateCamp;
	}

	/**
	 * Sets the inits the date camp.
	 *
	 * @param initDateCamp the new inits the date camp
	 */
	public void setInitDateCamp(Timestamp initDateCamp) {
		this.initDateCamp = initDateCamp;
	}

	/**
	 * Gets the end date camp.
	 *
	 * @return the end date camp
	 */
	public Timestamp getEndDateCamp() {
		return endDateCamp;
	}

	/**
	 * Sets the end date camp.
	 *
	 * @param endDateCamp the new end date camp
	 */
	public void setEndDateCamp(Timestamp endDateCamp) {
		this.endDateCamp = endDateCamp;
	}

	/**
	 * Gets the timetable.
	 *
	 * @return the timetable
	 */
	public String getTimetable() {
		return timetable;
	}

	/**
	 * Sets the timetable.
	 *
	 * @param timetable the new timetable
	 */
	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}

	/**
	 * Gets the routing type.
	 *
	 * @return the routing type
	 */
	public String getRoutingType() {
		return routingType;
	}

	/**
	 * Sets the routing type.
	 *
	 * @param routingType the new routing type
	 */
	public void setRoutingType(String routingType) {
		this.routingType = routingType;
	}

	/**
	 * Gets the routing label.
	 *
	 * @return the routing label
	 */
	public String getRoutingLabel() {
		return routingLabel;
	}

	/**
	 * Sets the routing label.
	 *
	 * @param routingLabel the new routing label
	 */
	public void setRoutingLabel(String routingLabel) {
		this.routingLabel = routingLabel;
	}

	/**
	 * Gets the codifications.
	 *
	 * @return the codifications
	 */
	public String getCodifications() {
		return codifications;
	}

	/**
	 * Sets the codifications.
	 *
	 * @param codifications the new codifications
	 */
	public void setCodifications(String codifications) {
		this.codifications = codifications;
	}

	/**
	 * Gets the argumentarios.
	 *
	 * @return the argumentarios
	 */
	public String getArgumentarios() {
		return argumentarios;
	}

	/**
	 * Sets the argumentarios.
	 *
	 * @param argumentarios the new argumentarios
	 */
	public void setArgumentarios(String argumentarios) {
		this.argumentarios = argumentarios;
	}

	/**
	 * Gets the session id.
	 *
	 * @return the session id
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the session id.
	 *
	 * @param sessionId the new session id
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Gets the initial session id.
	 *
	 * @return the initial session id
	 */
	public String getInitialSessionId() {
		return initialSessionId;
	}

	/**
	 * Sets the initial session id.
	 *
	 * @param initialSessionId the new initial session id
	 */
	public void setInitialSessionId(String initialSessionId) {
		this.initialSessionId = initialSessionId;
	}

	/**
	 * Gets the url host.
	 *
	 * @return the url host
	 */
	public String getUrlHost() {
		return urlHost;
	}

	/**
	 * Sets the url host.
	 *
	 * @param urlHost the new url host
	 */
	public void setUrlHost(String urlHost) {
		this.urlHost = urlHost;
	}

	/**
	 * Gets the destination phone.
	 *
	 * @return the destination phone
	 */
	public String getDestinationPhone() {
		return destinationPhone;
	}

	/**
	 * Sets the destination phone.
	 *
	 * @param destinationPhone the new destination phone
	 */
	public void setDestinationPhone(String destinationPhone) {
		this.destinationPhone = destinationPhone;
	}

	/**
	 * Gets the translate phone.
	 *
	 * @return the translate phone
	 */
	public String getTranslatePhone() {
		return translatePhone;
	}

	/**
	 * Sets the translate phone.
	 *
	 * @param translatePhone the new translate phone
	 */
	public void setTranslatePhone(String translatePhone) {
		this.translatePhone = translatePhone;
	}

	/**
	 * Gets the register.
	 *
	 * @return the register
	 */
	public String getRegister() {
		return register;
	}

	/**
	 * Sets the register.
	 *
	 * @param register the new register
	 */
	public void setRegister(String register) {
		this.register = register;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the client phone.
	 *
	 * @return the client phone
	 */
	public String getClientPhone() {
		return clientPhone;
	}

	/**
	 * Sets the client phone.
	 *
	 * @param clientPhone the new client phone
	 */
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	/** 
	 *Gets the client phone act.
	 *
	 *@return the client phone act
	 */
	public String getClientPhoneAct() {
		return clientPhoneAct;
	}

	/**
	 * Sets the client phone act.
	 *
	 * @param clientPhoneAct the new client phone act
	 */
	public void setClientPhoneAct(String clientPhoneAct) {
		this.clientPhoneAct = clientPhoneAct;
	}

	/**
	 * Gets the inits the date call.
	 *
	 * @return the inits the date call
	 */
	public Timestamp getInitDateCall() {
		return initDateCall;
	}

	/**
	 * Sets the inits the date call.
	 *
	 * @param initDateCall the new inits the date call
	 */
	public void setInitDateCall(Timestamp initDateCall) {
		this.initDateCall = initDateCall;
	}

	/**
	 * Gets the end date call.
	 *
	 * @return the end date call
	 */
	public Timestamp getEndDateCall() {
		return endDateCall;
	}

	/**
	 * Sets the end date call.
	 *
	 * @param endDateCall the new end date call
	 */
	public void setEndDateCall(Timestamp endDateCall) {
		this.endDateCall = endDateCall;
	}

	/**
	 * Gets the provider.
	 *
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * Sets the provider.
	 *
	 * @param provider the new provider
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * Gets the workplace.
	 *
	 * @return the workplace
	 */
	public String getWorkplace() {
		return workplace;
	}

	/**
	 * Sets the workplace.
	 *
	 * @param workplace the new workplace
	 */
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	/**
	 * Gets the routing.
	 *
	 * @return the routing
	 */
	public String getRouting() {
		return routing;
	}

	/**
	 * Sets the routing.
	 *
	 * @param routing the new routing
	 */
	public void setRouting(String routing) {
		this.routing = routing;
	}

	/**
	 * Gets the type campaign.
	 *
	 * @return the type campaign
	 */
	public String getTypeCampaign() {
		return typeCampaign;
	}

	/**
	 * Sets the type campaign.
	 *
	 * @param typeCampaign the new type campaign
	 */
	public void setTypeCampaign(String typeCampaign) {
		this.typeCampaign = typeCampaign;
	}

	/**
	 * Gets the ip c2c.
	 *
	 * @return the ip c2c
	 */
	public String getIpC2c() {
		return ipC2c;
	}

	/**
	 * Sets the ip c2c.
	 *
	 * @param ipC2c the new ip c2c
	 */
	public void setIpC2c(String ipC2c) {
		this.ipC2c = ipC2c;
	}

	/**
	 * Gets the segmentation.
	 *
	 * @return the segmentation
	 */
	public String getSegmentation() {
		return segmentation;
	}

	/**
	 * Sets the segmentation.
	 *
	 * @param segmentation the new segmentation
	 */
	public void setSegmentation(String segmentation) {
		this.segmentation = segmentation;
	}

	/**
	 * Gets the service call.
	 *
	 * @return the service call
	 */
	public ServiceCall getServiceCall() {
		return serviceCall;
	}

	/**
	 * Sets the service call.
	 *
	 * @param serviceCall the new service call
	 */
	public void setServiceCall(ServiceCall serviceCall) {
		this.serviceCall = serviceCall;
	}

	/**
	 * Gets the persistence.
	 *
	 * @return the persistence
	 */
	public ScheduleC2APersistence getPersistence() {
		return persistence;
	}

	/**
	 * Sets the persistence.
	 *
	 * @param persistence the new persistence
	 */
	public void setPersistence(ScheduleC2APersistence persistence) {
		this.persistence = persistence;
	}

	/**
	 * Gets the schedules.
	 *
	 * @return the schedules
	 */
//	public Set<ScheduleC2A> getSchedules() {
//		return schedules;
//	}

	/**
	 * Sets the schedules.
	 *
	 * @param schedules the new schedules
	 */
//	public void setSchedules(Set<ScheduleC2A> schedules) {
//		this.schedules = schedules;
//	}

	/**
	 * Gets the schedule.
	 *
	 * @return the schedule
	 */
	public ScheduleC2A getSchedule() {
		return schedule;
	}

	/**
	 * Sets the schedule.
	 *
	 * @param schedule the new schedule
	 */
	public void setSchedule(ScheduleC2A schedule) {
		this.schedule = schedule;
	}

}
