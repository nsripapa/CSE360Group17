package application;

import java.util.ArrayList;
import java.util.List;


//Each 'Project' (see Definitions.java) will have a Logs object associated with it.
public class Logs 
{
	private static final Logs instance = new Logs();
	
	List<EffortLog> effortLogs;
	List<DefectLog> defectLogs;
	
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

class EffortLog
{
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
	
	String date, start, stop, time, lifeCycleStep, effortCategory, delivInterEtc;
}

class DefectLog
{
	
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
	
	String name, detail, injected, removed, category, status, fix;
}