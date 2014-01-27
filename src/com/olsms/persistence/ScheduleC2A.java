/**********************************************************************
 * ScheduleC2A.java, 16-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
//import javax.persistence.JoinColumn;



// TODO: Auto-generated Javadoc
/**
 * The Class ScheduleC2A.
 */
@Entity
public class ScheduleC2A {

	/** The Constant MAX_NUMBER_OF_CHARACTER_CLIENT_OBSERVATIONS. */
	private static final int MAX_NUMBER_OF_CHARACTER_CLIENT_OBSERVATIONS = 15;
	
	/** The Constant MAX_NUMBER_OF_CHARACTER_AGENT_OBSERVATIONS. */
	private static final int MAX_NUMBER_OF_CHARACTER_AGENT_OBSERVATIONS = 15;
	
	/**
	 * The Enum ScheduleC2AState.
	 */
	public enum ScheduleC2AState{
		
		/** The pending call. */
		PENDING_CALL,
		
		/** The reserved call. */
		RESERVED_CALL,
		
		/** The executed. */
		EXECUTED,
		
		/** The revise supervisor. */
		REVISE_SUPERVISOR,
		
		/** The dismiss. */
		DISMISS
	};
	
	/**
	 * The Enum ScheduleC2APriority.
	 */
	public enum ScheduleC2APriority{
		
		/** The baja. */
		BAJA,
		
		/** The media. */
		MEDIA,
		
		/** The alta. */
		ALTA		
	};
	
	/**
	 * The Enum ScheduleC2APersistence.
	 */
	public enum ScheduleC2APersistence{
		
		/** The no apply. */
		NO_APPLY,
		
		/** The apply. */
		APPLY,
		
		/** The unknow appy. */
		UNKNOW_APPY
	}
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The state. */
	private ScheduleC2AState state;
	
	/** The creation date. */
	private Timestamp creationDate;
	
	/** The origin. */
	@Column(length = 30)
	private String origin;
	
	/** The campaign label. */
	@Column(length = 10)
	private String campaignLabel;
	
	/** The client phone. */
	@Column(length = 20)
	private String clientPhone;
	
	/** The client name. */
	@Column(length = 100)
	private String clientName;
	
	/** The client surname. */
	@Column(length = 100)
	private String clientSurname;
	
	/** The client dni. */
	@Column(length = 20)
	private String clientDni;
	
	/** The time table. */
	@Column(length = 30)
	private String timeTable;
	
	/** The client observations. */
	@Column(length = 500)
	private String clientObservations;
	
	/** The url host. */
	private String urlHost;
	
	/** The agent observations. */
	@Column(length = 500)
	private String agentObservations;
	
	/** The codifications. */
	private String codifications;
	
	/** The login agent. */
	@Column(length = 100)
	private String loginAgent;
	
	/** The idu. */
	@Column(length=100)
	private String idu;
	
	/** The work place. */
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	private WorkPlaceC2A workPlace;
	*/
	
	private Long workPlace;
	
	
	/** The call. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private CallC2A call;
	
	/** The calls. */
//	@OneToMany(mappedBy= "schedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<CallC2A> calls;
	
	/** The revise observations. */
	private String reviseObservations;
	
	/** The initial session id. */
	private String initialSessionId;
	
	/** The schedule date. */
	private Timestamp scheduleDate;
	
	/** The client phone act. */
	@Column(length = 20)
	private String clientPhoneAct;
	
	/** The priority. */
	@Column(columnDefinition="INTEGER DEFAULT '0'")
	private ScheduleC2APriority priority;
	
	/** The persistence. */
	private ScheduleC2APersistence persistence;
	
	/**
	 * Instantiates a new schedule c2 a.
	 */
	public ScheduleC2A()
	{
		super();
	}

	/**
	 * Instantiates a new schedule c2 a.
	 *
	 * @param id the id
	 * @param state the state
	 * @param creationDate the creation date
	 * @param origin the origin
	 * @param campaignLabel the campaign label
	 * @param clientPhone the client phone
	 * @param clientPhoneAct the client phone act
	 * @param clientName the client name
	 * @param clientSurname the client surname
	 * @param clientDni the client dni
	 * @param timeTable the time table
	 * @param clientObservations the client observations
	 * @param urlHost the url host
	 * @param agentObservations the agent observations
	 * @param priority the priority
	 * @param codifications the codifications
	 * @param loginAgent the login agent
	 * @param idu the idu
	 * @param workPlace the work place
	 * @param call the call
	 * @param reviseObservations the revise observations
	 * @param initialSessionId the initial session id
	 * @param scheduleDate the schedule date
	 * @param persistence the persistence
	 */
	public ScheduleC2A(Long id, ScheduleC2AState state, Timestamp creationDate, String origin, String campaignLabel, 
			String clientPhone, String clientPhoneAct, String clientName, String clientSurname, String clientDni, String timeTable, 
			String clientObservations, String urlHost, String agentObservations, String priority, String codifications, String loginAgent, 
			String idu, Long workPlace, CallC2A call, String reviseObservations, String initialSessionId, Timestamp scheduleDate, 
			ScheduleC2APersistence persistence){
		
		super();
		this.setId(id);
		this.setState(state);
		this.setCreationDate(creationDate);
		this.setOrigin(origin);
		this.setCampaignLabel(campaignLabel);
		this.setClientPhone(clientPhone);
		this.setClientPhoneAct(clientPhoneAct);
		this.setClientName(clientName);
		this.setClientSurname(clientSurname);
		this.setClientDni(clientDni);
		this.setTimeTable(timeTable);
		this.setClientObservations(clientObservations);
		this.setUrlHost(urlHost);
		this.setAgentObservations(agentObservations);
		this.setPriorityFromString(priority);
		this.setCodifications(codifications);
		this.setLoginAgent(loginAgent);
		this.setIdu(idu);
		this.setWorkPlace(workPlace);
		this.setCall(call);
		this.setReviseObservations(reviseObservations);
		this.setInitialSessionId(initialSessionId);
		this.setScheduleDate(scheduleDate);
		this.setPersistence(persistence);
	}
	
	/**
	 * Instantiates a new schedule c2 a.
	 *
	 * @param state the state
	 * @param creationDate the creation date
	 * @param origin the origin
	 * @param campaignLabel the campaign label
	 * @param clientPhone the client phone
	 * @param clientPhoneAct the client phone act
	 * @param clientName the client name
	 * @param clientSurname the client surname
	 * @param clientDni the client dni
	 * @param timeTable the time table
	 * @param clientObservations the client observations
	 * @param urlHost the url host
	 * @param agentObservations the agent observations
	 * @param priority the priority
	 * @param codifications the codifications
	 * @param loginAgent the login agent
	 * @param idu the idu
	 * @param workPlace the work place
	 * @param call the call
	 * @param reviseObservations the revise observations
	 * @param initialSessionId the initial session id
	 * @param scheduleDate the schedule date
	 * @param persistence the persistence
	 */
	public ScheduleC2A(ScheduleC2AState state, Timestamp creationDate, String origin, String campaignLabel, String clientPhone, 
			String clientPhoneAct, String clientName, String clientSurname, String clientDni, String timeTable, String clientObservations, 
			String urlHost, String agentObservations, String priority, String codifications, String loginAgent, String idu, Long workPlace, 
			CallC2A call, String reviseObservations, String initialSessionId, Timestamp scheduleDate, ScheduleC2APersistence persistence){
		
		super();
		
		this.setState(state);
		this.setCreationDate(creationDate);
		this.setOrigin(origin);
		this.setCampaignLabel(campaignLabel);
		this.setClientPhone(clientPhone);
		this.setClientPhoneAct(clientPhoneAct);
		this.setClientName(clientName);
		this.setClientSurname(clientSurname);
		this.setClientDni(clientDni);
		this.setTimeTable(timeTable);
		this.setClientObservations(clientObservations);
		this.setUrlHost(urlHost);
		this.setAgentObservations(agentObservations);
		this.setPriorityFromString(priority);
		this.setCodifications(codifications);
		this.setLoginAgent(loginAgent);
		this.setIdu(idu);
		this.setWorkPlace(workPlace);
		this.setCall(call);
		this.setReviseObservations(reviseObservations);
		this.setInitialSessionId(initialSessionId);
		this.setScheduleDate(scheduleDate);
		this.setPersistence(persistence);
	}
	
	/**
	 * Instantiates a new schedule c2 a.
	 *
	 * @param state the state
	 * @param creationDate the creation date
	 * @param origin the origin
	 * @param campaignLabel the campaign label
	 * @param clientPhone the client phone
	 * @param clientName the client name
	 * @param clientSurname the client surname
	 * @param clientDni the client dni
	 * @param timeTable the time table
	 * @param clientObservations the client observations
	 * @param urlHost the url host
	 * @param agentObservations the agent observations
	 * @param codifications the codifications
	 * @param loginAgent the login agent
	 * @param idu the idu
	 * @param workPlace the work place
	 * @param reviseObservations the revise observations
	 * @param initialSessionId the initial session id
	 */
	public ScheduleC2A(ScheduleC2AState state, Timestamp creationDate, String origin, String campaignLabel, String clientPhone, 
			String clientName, String clientSurname, String clientDni, String timeTable, String clientObservations, 
			String urlHost, String agentObservations, String codifications, String loginAgent, String idu, Long workPlace, 
			String reviseObservations, String initialSessionId){
		
		super();
		
		this.setState(state);
		this.setCreationDate(creationDate);
		this.setOrigin(origin);
		this.setCampaignLabel(campaignLabel);
		this.setClientPhone(clientPhone);
		this.setClientName(clientName);
		this.setClientSurname(clientSurname);
		this.setClientDni(clientDni);
		this.setTimeTable(timeTable);
		this.setClientObservations(clientObservations);
		this.setUrlHost(urlHost);
		this.setAgentObservations(agentObservations);
		this.setCodifications(codifications);
		this.setLoginAgent(loginAgent);
		this.setIdu(idu);
		this.setWorkPlace(workPlace);
		this.setReviseObservations(reviseObservations);
		this.setInitialSessionId(initialSessionId);
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
	 * Gets the state.
	 *
	 * @return the state
	 */
	public ScheduleC2AState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(ScheduleC2AState state) {
		this.state = state;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Timestamp getCreationDate() {
		return creationDate;
	}
	
	/**
	 * Gets the friendly creation date.
	 *
	 * @return the friendly creation date
	 */
	public String getFriendlyCreationDate(){
		
		String result = "";
		
		if (creationDate != null) {
			result = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(creationDate);
		}
		
		return result;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the origin.
	 *
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the origin.
	 *
	 * @param origin the new origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Gets the campaign label.
	 *
	 * @return the campaign label
	 */
	public String getCampaignLabel() {
		return campaignLabel;
	}

	/**
	 * Sets the campaign label.
	 *
	 * @param campaignLabel the new campaign label
	 */
	public void setCampaignLabel(String campaignLabel) {
		this.campaignLabel = campaignLabel;
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
	 * Gets the client name.
	 *
	 * @return the client name
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * Sets the client name.
	 *
	 * @param clientName the new client name
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * Gets the client surname.
	 *
	 * @return the client surname
	 */
	public String getClientSurname() {
		return clientSurname;
	}

	/**
	 * Sets the client surname.
	 *
	 * @param clientSurname the new client surname
	 */
	public void setClientSurname(String clientSurname) {
		this.clientSurname = clientSurname;
	}

	/**
	 * Gets the client dni.
	 *
	 * @return the client dni
	 */
	public String getClientDni() {
		return clientDni;
	}

	/**
	 * Sets the client dni.
	 *
	 * @param clientDni the new client dni
	 */
	public void setClientDni(String clientDni) {
		this.clientDni = clientDni;
	}

	/**
	 * Gets the time table.
	 *
	 * @return the time table
	 */
	public String getTimeTable() {
		return timeTable;
	}

	/**
	 * Sets the time table.
	 *
	 * @param timeTable the new time table
	 */
	public void setTimeTable(String timeTable) {
		this.timeTable = timeTable;
	}

	/**
	 * Gets the client observations.
	 *
	 * @return the client observations
	 */
	public String getClientObservations() {
		return clientObservations;
	}
	
	/**
	 * Gets the friendly client observations.
	 *
	 * @return the friendly client observations
	 */
	public String getFriendlyClientObservations() {
		if(StringUtils.isNotEmpty(this.clientObservations) 
				&& this.clientObservations.length() > MAX_NUMBER_OF_CHARACTER_CLIENT_OBSERVATIONS)
		{
			String friendlyClientObservations = this.clientObservations.substring(0, MAX_NUMBER_OF_CHARACTER_CLIENT_OBSERVATIONS-3);
			return friendlyClientObservations + OLSMSConstants.SUSPENSION_POINTS;
		}
		return this.clientObservations;
	}

	/**
	 * Sets the client observations.
	 *
	 * @param clientObservations the new client observations
	 */
	public void setClientObservations(String clientObservations) {
		this.clientObservations = clientObservations;
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
	 * Gets the agent observations.
	 *
	 * @return the agent observations
	 */
	public String getAgentObservations() {
		return agentObservations;
	}

	/**
	 * Gets the friendly agent observations.
	 *
	 * @return the friendly agent observations
	 */
	public String getFriendlyAgentObservations() {
		if(StringUtils.isNotEmpty(this.agentObservations) 
				&& this.agentObservations.length() > MAX_NUMBER_OF_CHARACTER_AGENT_OBSERVATIONS)
		{
			String friendlyClientObservations = this.agentObservations.substring(0, MAX_NUMBER_OF_CHARACTER_AGENT_OBSERVATIONS-3);
			return friendlyClientObservations + OLSMSConstants.SUSPENSION_POINTS;
		}
		return this.agentObservations;
	}
	
	/**
	 * Sets the agent observations.
	 *
	 * @param agentObservations the new agent observations
	 */
	public void setAgentObservations(String agentObservations) {
		this.agentObservations = agentObservations;
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
	 * Gets the login agent.
	 *
	 * @return the login agent
	 */
	public String getLoginAgent() {
		return loginAgent;
	}

	/**
	 * Sets the login agent.
	 *
	 * @param loginAgent the new login agent
	 */
	public void setLoginAgent(String loginAgent) {
		this.loginAgent = loginAgent;
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

	
	
	

	public Long getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(Long workPlace) {
		this.workPlace = workPlace;
	}

	/**
	 * Gets the call.
	 *
	 * @return the call
	 */
	public CallC2A getCall() {
		return call;
	}

	/**
	 * Sets the call.
	 *
	 * @param call the new call
	 */
	public void setCall(CallC2A call) {
		this.call = call;
	}

	/**
	 * Gets the calls.
	 *
	 * @return the calls
	 */
//	public Set<CallC2A> getCalls() {
//		return calls;
//	}

	/**
	 * Sets the calls.
	 *
	 * @param calls the new calls
	 */
//	public void setCalls(Set<CallC2A> calls) {
//		this.calls = calls;
//	}
	
	/**
	 * Adds the call.
	 *
	 * @param call the call
	 */
//	public void addCall(CallC2A call){
//		if(this.calls == null){
//			calls = new HashSet<CallC2A>();
//		}
//		calls.add(call);
//	}

	/**
	 * Gets the revise observations.
	 *
	 * @return the revise observations
	 */
	public String getReviseObservations() {
		return reviseObservations;
	}
	
	/**
	 * Gets the friendly revise observations.
	 *
	 * @return the friendly revise observations
	 */
	public String getFriendlyReviseObservations(){
		
		if(StringUtils.isNotEmpty(this.reviseObservations)){
			
			String auxReviseObservations = this.reviseObservations;
			auxReviseObservations = auxReviseObservations.replaceAll(OLSMSConstants.STRING_NEW_LINE + OLSMSConstants.STRING_SIX_HYPHEN + OLSMSConstants.STRING_NEW_LINE, 
					"<br/>"+ OLSMSConstants.STRING_SIX_HYPHEN + "<br/>");
			
			return auxReviseObservations;
		}
		return this.reviseObservations;
	}

	/**
	 * Sets the revise observations.
	 *
	 * @param reviseObservations the new revise observations
	 */
	public void setReviseObservations(String reviseObservations) {
		this.reviseObservations = reviseObservations;
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
	 * Gets the schedule date.
	 *
	 * @return the schedule date
	 */
	public Timestamp getScheduleDate() {
		return scheduleDate;
	}
	
	/**
	 * Gets the friendly schedule date.
	 *
	 * @return the friendly schedule date
	 */
	public String getFriendlyScheduleDate(){
		String result = "";
		
		if (scheduleDate != null) {
			result = new SimpleDateFormat("dd/MM/yyyy").format(scheduleDate);
		}
		
		return result;
	}

	/**
	 * Sets the schedule date.
	 *
	 * @param scheduleDate the new schedule date
	 */
	public void setScheduleDate(Timestamp scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	/**
	 * Gets the client phone act.
	 *
	 * @return the client phone act
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
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public ScheduleC2APriority getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(ScheduleC2APriority priority) {
		this.priority = priority;
	}
	
	/**
	 * Sets the priority from string.
	 *
	 * @param priority the new priority from string
	 */
	public void setPriorityFromString(String priority){
		try{
			int iPriority = Integer.valueOf(priority);
			
			switch (iPriority) {
				case 0:
					this.setPriority(ScheduleC2APriority.BAJA);
					break;
				case 1:
					this.setPriority(ScheduleC2APriority.MEDIA);
					break;
				case 2:
					this.setPriority(ScheduleC2APriority.ALTA);
					break;
				default:
					this.setPriority(ScheduleC2APriority.BAJA);
					break;
			}
			
		}catch(Exception excep){
			this.setPriority(ScheduleC2APriority.BAJA);
		}
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
	 * Update with revise.
	 *
	 * @param scheduleDate the schedule date
	 * @param newRangeTimeTable the new range time table
	 * @param clientPhone the client phone
	 * @param clientPhoneAct the client phone act
	 * @param priority the priority
	 * @param observations the observations
	 */
	public void updateWithRevise(String scheduleDate, String newRangeTimeTable, String clientPhone, String clientPhoneAct, 
			String priority, String observations) {
		
		Timestamp tsScheduleDate= null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateInit = dateFormat.parse(scheduleDate);
			tsScheduleDate = new Timestamp(dateInit.getTime());
		}
		catch (ParseException e) {
			
			Calendar cal = Calendar.getInstance();
			cal.clear(Calendar.HOUR);
			cal.clear(Calendar.MINUTE);
			cal.clear(Calendar.SECOND);
			cal.clear(Calendar.MILLISECOND);
			tsScheduleDate = new Timestamp(cal.getTime().getTime());
			
		}
		this.setScheduleDate(tsScheduleDate);
		
		this.setTimeTable(newRangeTimeTable);
		this.setClientPhone(clientPhone);
		this.setClientPhoneAct(clientPhoneAct);
		
		this.setPriorityFromString(priority);
		
		this.setState(ScheduleC2AState.PENDING_CALL);
		
		String aux = "";
    	if(StringUtils.isNotEmpty(this.getReviseObservations())){
    		aux = this.getReviseObservations();
    		aux += OLSMSConstants.STRING_NEW_LINE + OLSMSConstants.STRING_SIX_HYPHEN + OLSMSConstants.STRING_NEW_LINE;
    		aux += OLSMSConstants.SCHEDULE_C2A_REVISE_SUPERVISOR + observations;
    	}else{
    		aux = OLSMSConstants.SCHEDULE_C2A_REVISE_SUPERVISOR + observations;
    	}
    	
    	this.setReviseObservations(aux);
		
	}

	/**
	 * Update without revise.
	 *
	 * @param scheduleDate the schedule date
	 * @param newRangeTimeTable the new range time table
	 * @param clientPhone the client phone
	 * @param clientPhoneAct the client phone act
	 * @param priority the priority
	 */
	public void updateWithoutRevise(String scheduleDate, String newRangeTimeTable, String clientPhone, 
			String clientPhoneAct, String priority) {
		Timestamp tsScheduleDate= null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dateInit = dateFormat.parse(scheduleDate);
			tsScheduleDate = new Timestamp(dateInit.getTime());
		}
		catch (ParseException e) {
			Calendar cal = Calendar.getInstance();
			cal.clear(Calendar.HOUR);
			cal.clear(Calendar.MINUTE);
			cal.clear(Calendar.SECOND);
			cal.clear(Calendar.MILLISECOND);
			tsScheduleDate = new Timestamp(cal.getTime().getTime());
		}
		this.setScheduleDate(tsScheduleDate);
		
		this.setTimeTable(newRangeTimeTable);
		this.setClientPhone(clientPhone);
		this.setClientPhoneAct(clientPhoneAct);
		
		this.setPriorityFromString(priority);
	}
	
}
