/**********************************************************************
 * OLSMSConstants.java, 10-dic-2013
 * OnLineSMS
 * Copyright (c) 2007-2013, Prosodie Iberica All rights reserved.
 * 
 * OnLineSMS is a tool used to send SMS used by CallCenter agents.
 *********************************************************************/
package com.olsms.persistence;

// TODO: Auto-generated Javadoc
/**
 * The Class OLSMSConstants.
 */
public class OLSMSConstants {

	/** The Constant ACTION. */
	public static final String ACTION = "action";
	
	/** The Constant STRING_EMPTY. */
	public static final String STRING_EMPTY = "";
	
	/** The Constant STRING_ZERO. */
	public static final String STRING_ZERO = "0";
	
	/** The Constant SPACEBAR. */
	public static final String SPACEBAR = " ";
	
	/** The Constant EQUAL. */
	public static final String EQUAL = "=";
	
	/** The Constant QUOTE. */
	public static final String QUOTE = "\\";
	
	/** The Constant POINT. */
	public static final String POINT = ".";
	
	/** The Constant SUSPENSION_POINTS. */
	public static final String SUSPENSION_POINTS = "...";
	
	/** The Constant COMMA. */
	public static final String COMMA = ",";

	/** The Constant PIPE. */
	public static final String PIPE = "|";
	
	/** The Constant HASH. */
	public static final String HASH = "#";
	
	/** The Constant PERCENT. */
	public static final String PERCENT = "%";
	
	/** The Constant AT_SIGN. */
	public static final String AT_SIGN = "@";
	
	/** The Constant LETTER_N. */
	public static final String LETTER_N = "n";
	
	/** The Constant LETTER_A. */
	public static final String LETTER_A = "a";
	
	/** The Constant LETTER_D. */
	public static final String LETTER_D = "d";
	
	/** The Constant LETTER_O. */
	public static final String LETTER_O = "o";
	
	/** The Constant ID_SUPER. */
	public static final long ID_SUPER = 1;
	
	/** The Constant ID_SEND_SMS. */
	public static final int ID_SEND_SMS = 14;
	
	/** The Constant ID_ATTEND_SMS. */
	public static final int ID_ATTEND_SMS = 15;

	/** The Constant MAX_REG_USERS. */
	public static final int MAX_REG_USERS = 50;
	
	/** The Constant MAX_NUMBER_OF_REGISTRIES_PER_QUERY. */
	public static final Integer MAX_NUMBER_OF_REGISTRIES_PER_QUERY = 1000;
	

	/** The Constant CGI_PROTOCOL. */
	public static final String CGI_PROTOCOL = "http://";
	
	/** The Constant CGI_URL. */
	public static final String CGI_URL = "localhost:8888/cgi-bin/ldap-cgi.exe?";
	
	/** The Constant ACTIVE_DIRECTORY. */
	public static final boolean ACTIVE_DIRECTORY = false;
	
	/** The Constant TEXT. */
	public static final String TEXT = "text";

	/** The constants with the identifiers of the main roles in the application. They are
	 * used for importing the information of the "old" tool.
	 */
	public static final Long ROL_ID_FOR_SUPER_ADMIN = Long.valueOf(1);
	
	/** The Constant ROL_ID_FOR_DEPARMT_ADMIN. */
	public static final Long ROL_ID_FOR_DEPARMT_ADMIN = Long.valueOf(2);
	
	/** The Constant ROL_ID_FOR_AGENT. */
	public static final Long ROL_ID_FOR_AGENT = Long.valueOf(3);
	
	/** The Constant ROL_ID_FOR_AGENT_ONLY_SENDINGS. */
	public static final Long ROL_ID_FOR_AGENT_ONLY_SENDINGS = Long.valueOf(4);
	
	/** The Constant ROL_ID_FOR_AGENT_ONLY_ATTENDING. */
	public static final Long ROL_ID_FOR_AGENT_ONLY_ATTENDING = Long.valueOf(5);

	/** The Constant NAME_OF_1004_SERVICE. */
	public static final String NAME_OF_1004_SERVICE = "1004";

	/** The Constant ADVANCED_CONFIGURATION_NAME. */
	public static final String ADVANCED_CONFIGURATION_NAME = "AdvancedConfiguration";

	/** The Constant IMPORT_OLD_TOOL_INFORMATION_TAG. */
	public static final String IMPORT_OLD_TOOL_INFORMATION_TAG = "ImportOldToolInformation";

	/** The Constant ADMON_DB_ID. */
	public static final Long ADMON_DB_ID = new Long (1);

	/** The Constant DPT_ADMON_DB_ID. */
	public static final Long DPT_ADMON_DB_ID = new Long (2);

	/** The Constant GIP_DB_ID. */
	public static final Long GIP_DB_ID = new Long (6);

	/** The Constant MAX_NUMBER_OF_SMS_BEING_ATTENDED. */
	public static final int MAX_NUMBER_OF_SMS_BEING_ATTENDED = 5;
	
	/** The Constant MAX_NUMBER_OF_SMS_CONVERSATIONS_BEING_ATTENDED. */
	public static final int MAX_NUMBER_OF_SMS_CONVERSATIONS_BEING_ATTENDED = 4;
	
	/** The Constant MAX_NUMBER_OF_SMS_NOT_CONVERSATIONS_BEING_ATTENDED. */
	public static final int MAX_NUMBER_OF_SMS_NOT_CONVERSATIONS_BEING_ATTENDED = 1;

	// ALARMS TO OAM
	/** The Constant ALARM_ATD_STATUS. */
	public static final String ALARM_ATD_STATUS = "OLSMS_ATD_STATUS";
	
	/** The Constant ALARM_LDAP_STATUS. */
	public static final String ALARM_LDAP_STATUS = "ALARM_LDAP_STATUS";
	
	/** The Constant ALARM_ATD_PREPROCECCING_SMS_SERVICE_NOT_FOUND. */
	public static final String ALARM_ATD_PREPROCECCING_SMS_SERVICE_NOT_FOUND = "OLSMS_ATD_PREPROCESSING_SERVICE";
	
	/** The Constant INITIAL_OPEN_TIMETABLE_ID. */
	public static final Long INITIAL_OPEN_TIMETABLE_ID = Long.valueOf(1);
	
	/** The Constant HISTORIC_OPTION_ONE_MONTH. */
	public static final String HISTORIC_OPTION_ONE_MONTH = "1";
	
	/** The Constant HISTORIC_OPTION_WHOLE_HISTORIC. */
	public static final String HISTORIC_OPTION_WHOLE_HISTORIC = "2";

	/** The Constant DEFAULT_NUMBER_OF_MINUTES_FOR_CALCULATING_REFERENCE_DATE. */
	public static final int DEFAULT_NUMBER_OF_MINUTES_FOR_CALCULATING_REFERENCE_DATE = 3;

	/** The Constant DEFAULT_NUMBER_OF_HOUR_FOR_CALCULATING_REFERENCE_DATE. */
	public static final int DEFAULT_NUMBER_OF_HOUR_FOR_CALCULATING_REFERENCE_DATE = 24;

	/** The Constant DEFAULT_NUMBER_OF_STRING_LENGTH. */
	public static final int DEFAULT_NUMBER_OF_STRING_LENGTH = 254;

	/** The Constant MAX_NUMBER_OF_CHARACTER_SMS_RECEPTION. */
	public static final int MAX_NUMBER_OF_CHARACTER_SMS_RECEPTION = 50;
	
	/** The Constant MAX_NUMBER_OF_CHARACTER_SMS_RESPONSE. */
	public static final int MAX_NUMBER_OF_CHARACTER_SMS_RESPONSE = 50;
	
	/** The Constant ORIGIN_CALL_DELAYED. */
	public static final String ORIGIN_CALL_DELAYED = "Codificación";

	/** The Constant AUTO_DIALING_KEEP_ALIVE_INIT. */
	public static final int AUTO_DIALING_KEEP_ALIVE_INIT = 10;

	/** The Constant AUTO_DIALING_KEEP_ALIVE. */
	public static final int AUTO_DIALING_KEEP_ALIVE = 30;

	/** The Constant AUTO_DIALING_TYPE. */
	public static final int AUTO_DIALING_TYPE = 0;

	/** The Constant STRING_NEW_LINE. */
	public static final String STRING_NEW_LINE = "\n";

	/** The Constant STRING_SIX_HYPHEN. */
	public static final String STRING_SIX_HYPHEN = "------";

	/** The Constant SCHEDULE_C2A_RANGE_TIME_TABLE_NOW. */
	public static final String SCHEDULE_C2A_RANGE_TIME_TABLE_NOW = "Inmediatamente";

	/** The Constant SCHEDULE_C2A_REVISE_SUPERVISOR. */
	public static final String SCHEDULE_C2A_REVISE_SUPERVISOR = "SUPERVISOR: ";
	
	/** The Constant SCHEDULE_C2A_REVISE_AGENT. */
	public static final String SCHEDULE_C2A_REVISE_AGENT = "AGENTE: ";
}
