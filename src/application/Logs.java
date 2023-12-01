package application;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


//Each 'Project' (see Definitions.java) will have a Logs object associated with it.
public class Logs implements Serializable 
{
	private static final long serialVersionUID = 12224563495807L;
	private static final Logs instance = new Logs();
	
	List<EffortLog> effortLogs;
	List<DefectLog> defectLogs;
	
	// Constructur method to create new Logs
	
	Logs()
	{
		effortLogs = new ArrayList<>();
		defectLogs = new ArrayList<>();
	}
	
	public static Logs getInstance()
	 {
		 return instance;
	 }
	
	public List<EffortLog> getEffortLogs()
	{
		return effortLogs;
	}
	
	public List<DefectLog> getDefectLogs()
	{
		return defectLogs;
	}
	
}

class EffortLog implements Serializable
{
	
	// Constructor to create a new effortlog with no inputs
	EffortLog()
	{
		date = "";
		start = "";
		stop = "";
		time = "";
		lifeCycleStep = "";
		effortCategory = "";
		delivInterEtc = "";
	}
	
	// Constructor to create a new effortlog with user inputted inputs
	EffortLog(String date, String start, String stop, String time, String lifeCycleStep, String effortCategory, String delivInterEtc)
	{
		this.date = date;
		this.start = start;
		this.stop = stop;
		this.time = time;
		this.lifeCycleStep = lifeCycleStep;
		this.effortCategory = effortCategory;
		this.delivInterEtc = delivInterEtc;
	}
	
	String date, start, stop, time, lifeCycleStep, effortCategory, delivInterEtc;
}

class DefectLog implements Serializable
{
	
	// Constructor to create a new defectlog with no inputs
	DefectLog()
	{
		name = "";
		detail = "";
		injected = "";
		removed = "";
		category = "";
		status = "";
		fix = "";
	}
	
	// Constructor to create a new defectlog with user inputted inputs
	DefectLog(String name, String detail, String injected, String removed, String category, String status, String fix)
	{
		this.name = name;
		this.detail = detail;
		this.injected = injected;
		this.removed = removed;
		this.category = category;
		this.status = status;
		this.fix = fix;
	}
	
	String name, detail, injected, removed, category, status, fix;
}