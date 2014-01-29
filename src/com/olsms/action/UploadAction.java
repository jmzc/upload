package com.olsms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.olsms.action.exception.CellException;
import com.olsms.action.exception.RowException;
import com.olsms.persistence.ScheduleC2A;
import com.olsms.persistence.ScheduleC2A.ScheduleC2APriority;
import com.olsms.persistence.ScheduleC2A.ScheduleC2AState;
import com.olsms.service.ScheduleC2AManagementService;
import com.opensymphony.xwork2.ActionSupport;


/*
 * When a file is uploaded it will typically be stored in a temporary directory. 
 * Uploaded files should be processed or moved by your Action class to ensure the data is not lost. 
 * Be aware that servers may have a security policy in place that prohibits you from writing to directories other 
 * than the temporary directory and the directories that belong to your web application.
 */

/*
 * All uploaded files are saved to a temporary directory by the framework before being passed in to an Action. 
 * Depending on the allowed file sizes it may be necessary to have the framework store these temporary files 
 * in an alternate location. 
 * To do this change struts.multipart.saveDir to the directory where the uploaded files will be placed.
 * If this property is not set it defaults to javax.servlet.context.tempdir. Keep in mind that on some operating systems, like Solaris, /tmp is memory based and files stored in that directory would consume an amount of RAM approximately equal to the size of the uploaded file.
 */

 /*
  *  Unable to find 'struts.multipart.saveDir' property setting. Defaulting to javax.servlet.context.tempdir
  *  WINDOWS : C:\\tomcat624\\work\\Catalina\\localhost\\upload
  *  
  *  
  */ 

public class UploadAction extends ActionSupport 
{

	// 
    static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	
	static ScheduleC2AManagementService service = (ScheduleC2AManagementService)context.getBean("scheduleC2AManagementService");
	
	private static Logger logger = Logger.getLogger(UploadAction.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File file;
	private String contentType;
	private String filename;

	
	/* The fileUpload interceptor will use setter injection to insert the uploaded file and related data into your Action class. 
	 * For a form field named upload you would provide the three setter methods
	 * 
	 */
	public void setUpload(File file) 
	{
		
		this.file = file;
	}

	public void setUploadContentType(String contentType) 
	{
		
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename)
	{
		this.filename = filename;
	}

	
	
	public File getFile() 
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getContentType() 
	{
		return contentType;
	}

	public void setContentType(String contentType) 
	{
		this.contentType = contentType;
	}

	public String getFilename()
{
		return filename;
	}

	public void setFilename(String filename) 
	{
		this.filename = filename;
	}


	private List<Report> reports;

	public List<Report> getReports() 
	{
		return reports;
	}

	public void setReports(List<Report> reports) 
	{
		this.reports = reports;
	}
	
	private void addReport(Report report)
	{
		
		if (reports == null)
			reports = new ArrayList<Report>();
		
		reports.add(report);
		
	}
	
	
	
	private List<ScheduleC2A> l = null;
	
	private void addScheduleC2A(ScheduleC2A scheduleC2A)
	{
		
		if ( l == null)
		{
			l = new ArrayList<ScheduleC2A>();
		}
		
		l.add(scheduleC2A);
		
	}
	
	private Map<Integer,String> header;
	

	public String execute() 
	{
		
		try
		{
			if (this.l != null && this.l.size() > 0) 
			{							
				  // PERSIST
				try
				{
					service.loadScheduleC2A(l);
				}
				catch(Exception e)
				{
					logger.error("[EXCEPTION", e);
					this.addActionError("No pudo realizarse la carga de datos [DATOS NO VALIDOS]");
					
					return ERROR;
				}
                
                
			}
			
			return SUCCESS;
		
			
		}
		catch(Exception e)
		{
			logger.error("[EXCEPTION]", e);
			
			return ERROR ;
		}
		
		
		
	}
	

		
	//http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/
	//http://stackoverflow.com/questions/5898497/java-microsoft-excel-api
	
	
	private static final int COLUMN_NUMBER = 11;
	private static final int HEADER_SIZE = 20;
	
	private void xsl(File f)
	{

		FileInputStream fis = null;
		  try
	       {
	            fis = new FileInputStream(f);
	 
	            //Create Workbook instance holding reference to .xlsx fis
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 

	            try
            	{
	            	
	            	Row header = sheet.getRow(0);
		            if (header == null )
		            	throw new RowException("Fichero vacio");
		            
		         		            
		          
		            if (header.getLastCellNum() < COLUMN_NUMBER )
	                	throw new RowException("Número de columnas incorrecto");
		            
		            
		            // CABECERAS		            
		            this.header = new HashMap<Integer,String>(COLUMN_NUMBER);
		            
	                for(int n=0; n<header.getLastCellNum(); n++)
	                {
                		Cell cell = header.getCell(n, Row.CREATE_NULL_AS_BLANK);
	   
	                   
	                    String label = format(cell);
	                    
	                    if ( label != null )
	                    {
	                    	if  (label.length() > HEADER_SIZE)
	                    			label = label.substring(0, Math.min(label.length(), HEADER_SIZE -3)) + "...";     
	                    }	
	                    else 
	                    	label = "COLUMNA " + String.valueOf(cell.getColumnIndex() + 1);
	                    
	                    this.header.put(cell.getColumnIndex(), label);

	                }
	                

	            	
		            Iterator<Row> rowit = sheet.iterator();
		            while (rowit.hasNext()) 
		            {	 
		            	
		            	
			                Row row = rowit.next();
			                   
			                // HEADER
			                if (row.getRowNum() == 0)
			                	continue;
		   	
			                try
			                {
			                	Builder builder = new Builder();
			                	for(int n=0; n<row.getLastCellNum(); n++)
				                {
			                		Cell cell = row.getCell(n, Row.CREATE_NULL_AS_BLANK);
				   
				                    builder.build(cell);
			
				                }
				                
				                this.addScheduleC2A(builder.get());
			                	
			                }
			                catch(CellException e)
			                {
			                	logger.error("[CELL EXCEPTION][" + e.getMessage() + "]");
			                	
			                	Report report = new Report();
				        		report.setRow(row.getRowNum() + 1);
				        		report.setMessage(e.getMessage());
				        		
				        		this.addReport(report);
			                	
			                }
		 
		            }
            	}
            	catch(RowException e)
            	{
            		
            		addFieldError("fichero",e.getMessage());
            	}
	          

	           
	        } 
		  	catch( org.apache.poi.POIXMLException e)
		  	{
		  		if (e.getCause() instanceof org.apache.poi.openxml4j.exceptions.InvalidFormatException)
		  		{	
		  			// TODO Leer texto de fichero
		  			addFieldError("fichero","Formato no soportado. Formatos admitidos [XSLX]");
		  		}
					
					
		  	}
	        catch (Exception e) 
	        {
	            	            
	            logger.error("Exception", e);
				
				
	        }
		  finally
		  {
			  try
			  {
				  if (fis != null)
				  {
					  fis.close();
				  }
			  }
			  catch(IOException e)
			{
					logger.error("Exception when closing reader object", e);
			}
		  }
	
	}
	
	
	public void validate()
	{
 
	    if (this.file != null) 
		{
				    	
			this.xsl(this.file);
			
			if (this.reports != null && reports.size() > 0)
		    {
				// TODO Leer texto de fichero
				addFieldError("fichero","No pudo realizarse la carga de datos [DATOS NO VALIDOS]");
		        	
		    }
	    	
		}
	    else
	    {
	    	/*
			 W/A
				http://stackoverflow.com/questions/11310016/why-does-the-error-file-too-large-is-not-being-showed-correctly-in-the-jsp
			*/
		    Collection<?> tmp = getActionErrors();

		    for (Object o : tmp) 
		    {
		        if (o.toString().contains("the request was rejected because its size")) 
		        {
		        		// TODO Leer texto de fichero
		                addFieldError("fichero","El tamaño del fichero excede del permitido (1MB)");
		                break;
		        }
		    }
	    }
 
        
	   
	}
	
	
	/*
	    0:campaignlabel 
	    1:clientphone
	    2:clientname
	    3:clientsurname
	    4:clientdni
	    5:clientphoneact	
	    6:scheduledate	
		7:timetable		
		8:workplace_id	--->				
		9:priority
		10:agentobservations
		

	 */


	private DataFormatter formatter =  new DataFormatter();
	private String format(Cell cell)
	{	
		String value = formatter.formatCellValue(cell);
		
		
		return ( value != null)? value.trim(): null;
			
	
	}
	
	private static final Pattern PATTERN1 = Pattern.compile("(\\d+?):(\\d+?)([^0-9]+)(\\d+?):(\\d+)");
	
	private String horario(String horario) throws Exception
	{

		if ("Inmediatamente".equalsIgnoreCase(horario))
			return "Inmediatamente";

		Matcher m = PATTERN1.matcher(horario);
		if (m != null && m.matches())
		{
			StringBuilder s = new StringBuilder();
			s.append(String.format("%02d", Integer.valueOf(m.group(1))));
			s.append(":");
			s.append(m.group(2));
			s.append(" - ");
			s.append(String.format("%02d", Integer.valueOf(m.group(4))));
			s.append(":");
			s.append(m.group(5));

			return s.toString();

		}
		else
		{
			throw new Exception();
		}
		
	}

	// no thread-safe
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Timestamp scheduledate(String scheduledate) throws Exception
	{

		
		Calendar c = Calendar.getInstance();

	    c.setTime(sdf.parse(scheduledate));
	    c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND,0);

	    return new java.sql.Timestamp(c.getTime().getTime());
			
		
	}

	private class Builder
	{
		

		ScheduleC2A scheduleC2A = new ScheduleC2A();	
		
		public Builder()
		{
			this.scheduleC2A.setCreationDate(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
			this.scheduleC2A.setState(ScheduleC2AState.PENDING_CALL);
			this.scheduleC2A.setOrigin("Importación");
	
		}
		public ScheduleC2A get() throws CellException
		{
			return this.scheduleC2A;
			
		}
		public void build(Cell cell) throws CellException
		{
				
						
	
				String value = format(cell);
							
				logger.info("[" + cell.getColumnIndex() + "][" + value + "]");
					
					// MAP
			        switch (cell.getColumnIndex()) 
			        {
			          	
				        // CAMPAIGN_LABEL
				        case 0: 
				        	//TODO Validar campaña
				        	this.scheduleC2A.setCampaignLabel(value); 
				        	break;
				        	
				        // CLIENT_PHONE
				        case 1: 
				        	
				        	if ( value == null || value.length() != 9)
				        		throw new CellException(header.get(cell.getColumnIndex()) +  " no válido");
				        	this.scheduleC2A.setClientPhone(value); 
				        	break;
				        	
				         // CLIENT_NAME
				        case 2: 
				        	
				        	if ( value != null && value.length() > 100)
				        		throw new CellException(header.get(cell.getColumnIndex()) +  " supera tamaño permitido");
				        	this.scheduleC2A.setClientName(value); 
				        	break;
				        	
				        // CLIENT_SURNAME
				        case 3: 
				        	if ( value != null && value.length() > 100)
				        		throw new CellException(header.get(cell.getColumnIndex()) +  " supera tamaño permitido");
				        	this.scheduleC2A.setClientSurname(value); 
				        	break;
				        
				        // CLIENT_DNI
				        case 4: 
				        	if ( value != null && value.length() > 20)
				        		throw new CellException(header.get(cell.getColumnIndex()) +  " supera tamaño permitido");
				        	
				        	this.scheduleC2A.setClientDni(value); 
				        	break;
				        	
				         // CLIENT_PHONE_ACT
				        case 5: 
				        	if ( value == null || value.length() != 9)
				        		throw new CellException(header.get(cell.getColumnIndex()) +  " no válido");
				        	this.scheduleC2A.setClientPhoneAct(value); 
				        	break;
		
				        // SCHEDULE_DATE
				        case 6: 
				        	
				        	if ( value != null && value.length() > 0 )
				        	{
				        		try
				        		{
				        			Timestamp scheduledate = scheduledate(value);
				        			this.scheduleC2A.setScheduleDate(scheduledate); 
				        			
				        		}
				        		catch(Exception e)
				        		{
				        			throw new CellException(header.get(cell.getColumnIndex()) +  " no válida [dd/mm/yyyy]");
				        		}
				        	}
				        	
				        	break;
				        	
				        // TIMETABLE
				        case 7:
				        	if ( value != null && value.length() > 0 )
				        	{
					        	try
				        		{
					        		String horario = horario(value);
					        		this.scheduleC2A.setTimeTable(horario); 
				        		}
					        	catch(Exception e)
				        		{
				        			throw new CellException(header.get(cell.getColumnIndex()) +  " no válido [Inmediatamente|NN:NN-NN:NN]");
				        		}
				        		
				        	}
				        	
				        	break;
				        	
				        // WORKPLACE
				        case 8: 
				        	//scheduleC2A.setWorkPlace(value); 
				        	break;
				        	
				       // PRIORITY
				        case 9: 				        	
				        	if ( value != null  && value.length() > 0)
				        	{
				        		try
				        		{
				        			ScheduleC2APriority priority = ScheduleC2APriority.valueOf(value.toUpperCase());
				        			this.scheduleC2A.setPriority(priority);
				        		}
				        		catch(Exception e)
				        		{
				        			throw new CellException(header.get(cell.getColumnIndex()) + " no válido [ALTA|MEDIA|BAJA]");
				        		}
				        		
				        		
				        	}
				        		
				        	break;	
				       // AGENT_OBSERVATION
				        case 10: 
				        	if ( value != null && value.length() > 500)
				        		throw new CellException(header.get(cell.getColumnIndex()) +  " supera tamaño permitido");
				        	this.scheduleC2A.setAgentObservations(value); 
				        	break;
			 
			        }

			      
				
			}
			
		
		
		
	}
	

	
	
	

	
}
