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
}

class EffortLog
{
	String date, start, stop, time, lifeCycleStep, effortCategory, delivInterEtc;
}

class DefectLog
{
	String name, detail, injected, removed, category, status, fix;
}