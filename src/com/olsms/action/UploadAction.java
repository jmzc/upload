package com.olsms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.olsms.persistence.ScheduleC2A;
import com.olsms.persistence.util.Build;
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
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
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
	
	

	/* workflow */
	public String execute() 
	{
		
		try
		{
			if (this.file != null) 
			{
				
				logger.info("Content-type:" + this.contentType);
			
				//return this.csv(this.file);
				return this.xsl(this.file);
				
				
			}
			else
			{
				
				
				return ERROR ;
			}
			
		}
		catch(Exception e)
		{
			logger.error("Exception", e);
			
			return ERROR ;
		}
		
		
		
	}
	

		
	//http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/
	//http://stackoverflow.com/questions/5898497/java-microsoft-excel-api
	
	private String xsl(File f)
	{

		FileInputStream fis = null;
		  try
	        {
	            fis = new FileInputStream(f);
	 
	            //Create Workbook instance holding reference to .xlsx fis
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) 
	            {	            	
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.iterator();
	                         
	
	                Build record = new Build(new ScheduleC2A());
	                
	                while (cellIterator.hasNext()) 
	                {
	                    Cell cell = cellIterator.next();
	                    
	                    record.setCell(cell);

	                    
	                }

	                // PERSIST
	                try
	                {
	                	ScheduleC2A scheduleC2A = record.getScheduleC2A();
	                	
	                	service.loadScheduleC2A(scheduleC2A);

	                	
	                }
	                catch(Exception e)
	                {
	                	logger.error("[EXCEPTION]", e);
	                	
	                	Report report = new Report();
		        		report.setRow(row.getRowNum());
		        		report.setMessage("Registro no insertado [DATOS NO VALIDOS]");
		        		
		        		this.addReport(report);
	                	
	                }
	                
	               
	               
	            }
	            
	            if (this.reports != null && reports.size() > 0)
	            {
	            	if (sheet.getLastRowNum() + 1 == this.reports.size())
	            	{
	            		 this.reports = null;
	            		 
	            		 addFieldError("fichero","Ningún registro insertado [DATOS NO VALIDOS]");
	            	}
	            	else
	            	{
	            		
	            	}
	            	
	            	return ERROR;
	            }

	            else
	            	return SUCCESS;
	            
	        } 
		  	catch( org.apache.poi.POIXMLException e)
		  	{
		  		if (e.getCause() instanceof org.apache.poi.openxml4j.exceptions.InvalidFormatException)
		  			 addFieldError("fichero","Formato no soportado. Formatos admitidos [XSLX]");
					
					return ERROR ;
		  	}
	        catch (Exception e) 
	        {
	            	            
	            logger.error("Exception", e);
				
				return ERROR ;
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
		
		/*
		 W/A
			http://stackoverflow.com/questions/11310016/why-does-the-error-file-too-large-is-not-being-showed-correctly-in-the-jsp
		*/
	    Collection<?> tmp = getActionErrors();

	    for (Object o : tmp) 
	    {
	        if (o.toString().contains("the request was rejected because its size")) 
	        {
	                addFieldError("fichero","El tamaño del fichero excede del permitido (1MB)");
	                break;
	        }
	    }
	    
	   
	}
	
	
	/*
	 * Is there a way to bind my CSV file to a list of Javabeans?
	 * ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(YourOrderBean.class);
		String[] columns = new String[] {"name", "orderNumber", "id"}; // the fields to bind do in your JavaBean
		strat.setColumnMapping(columns);
		CsvToBean csv = new CsvToBean();
		List list = csv.parse(strat, yourReader);(non-Javadoc)
		
	 * 
	 */
	/*
	private String csv(File f)
	{
		
		CSVReader reader = null;
		
		try
		{
		
				reader = new CSVReader(new FileReader(this.file));
				
			
				reader = new CSVReader(new FileReader(this.file));
				String[] l;
				while ((l = reader.readNext()) != null) 
				{
					
					if (l.length != 2)
					{
						
						this.addActionError("Numero de campos incorrecto");
						return ERROR ;
					}
					else
					{
						logger.info(l[0] +l[1]);
					}
						
					
				}	
				
				return SUCCESS;
			
			
		}
		catch(Exception e)
		{
			logger.error("Exception", e);
			
			return ERROR ;
		}
		finally
		{
			try
			{
				if (reader != null)
					reader.close();
			}
			catch(IOException e)
			{
				logger.error("Exception when closing reader object", e);
			}
			
		}
		
		
	}
	*/
	
}
