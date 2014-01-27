package com.olsms.persistence.util;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;

import com.olsms.persistence.ScheduleC2A;

public class Build 
{

	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	
	private ScheduleC2A scheduleC2A = null;

	
	public Build(ScheduleC2A scheduleC2A) 
	{
		super();
		this.scheduleC2A = scheduleC2A;
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
	
	public void setCell(Cell cell)
	{
		switch (cell.getCellType()) 
        {
			case Cell.CELL_TYPE_NUMERIC:
				logger.info("Adding [" + cell.getColumnIndex() + "][" + cell.getNumericCellValue() + "]");
				break;
			case Cell.CELL_TYPE_STRING:
				logger.info("Adding [" + cell.getColumnIndex() + "][" + cell.getStringCellValue() + "]");
				break;
        }
        
		
        switch (cell.getColumnIndex()) 
        {
                    
        case 0: 
        	this.scheduleC2A.setClientPhone(cell.getStringCellValue()); 
        	break;
        case 1: 
        	this.scheduleC2A.setClientName(cell.getStringCellValue()); 
        	break;
             
        
        	
            
           
        }
        
		
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
