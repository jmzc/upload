package com.olsms.persistence.util;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import com.olsms.persistence.ScheduleC2A;
import com.olsms.persistence.ScheduleC2A.ScheduleC2AState;
import com.olsms.persistence.util.exception.FieldException;

public class Build 
{

	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	static DataFormatter formatter =  new DataFormatter();
	
	
	private ScheduleC2A scheduleC2A = null;

	
	public Build(ScheduleC2A scheduleC2A) 
	{
		super();
		this.scheduleC2A = scheduleC2A;
		
		this.scheduleC2A.setCreationDate(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		this.scheduleC2A.setState(ScheduleC2AState.PENDING_CALL);
	}

	/*
	 *  agentobservations
		campaignlabel
		clientdni
		clientname
		clientobservations
		clientphone
		clientsurname
		codifications
		creationdate
		idu
		loginagent
		origin
		state
		timetable
		urlhost
		call_id
		workplace_id
		reviseobservations
		initialsessionid
		scheduledate
		clientphoneact
		priority
		persistence

	 */
	
	public void setCell(Cell cell) throws Exception
	{
		
				
		String value = format(cell);
		logger.info("Adding [" + cell.getColumnIndex() + "][" + value + "]");
		
		
		
		
		// MAP
        switch (cell.getColumnIndex()) 
        {
          
        // CLIENTE_PHONE
        case 0: 
        	if (value == null || value.length() != 9)
        		throw new FieldException("Telefono de cliente no valido");
        	this.scheduleC2A.setClientPhone(value); 
        	break;
        // CLIENTE_NAME
        case 1: 
        	this.scheduleC2A.setClientName(value); 
        	break;
             
        
        	
            
           
        }
        
		
	}
	
	
	private static String format(Cell cell)
	{
		
		return formatter.formatCellValue(cell);
	
	
	}
	
	

	public ScheduleC2A getScheduleC2A()
	{
		return scheduleC2A;
	}

	public void setScheduleC2A(ScheduleC2A scheduleC2A)
	{
		this.scheduleC2A = scheduleC2A;
	}
	
	
	
	
	
	
	
	
}
