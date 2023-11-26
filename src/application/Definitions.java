package application;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Definitions implements Serializable
{
	private static final long serialVersionUID = 32485972343495807L;
	private static final Definitions instance = new Definitions();
	Definitions loadedDefinitions;
	
	public void load() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("definitions.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		loadedDefinitions = (Definitions)ois.readObject();
		
		projects = loadedDefinitions.projects;
		lifeCycleSteps = loadedDefinitions.lifeCycleSteps;
		effortCategories = loadedDefinitions.effortCategories;
		plans = loadedDefinitions.plans;
		deliverables = loadedDefinitions.deliverables;
		interruptions = loadedDefinitions.interruptions;
		defectCategories = loadedDefinitions.defectCategories;
		
	}

	private Definitions()
	{
		try {
			load();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	List<Project> projects;
	List<LifeCycleStep> lifeCycleSteps;
	List<EffortCategory> effortCategories;
	List<Plan> plans;
	List<Deliverable> deliverables;
	List<Interruption> interruptions;
	List<DefectCategory> defectCategories;
	
	
	//GETTING THE LIST OF PROJECTS/LIFECYCLESTEPS/ETC. IN STRING FORM FOR FILLING OUT CHOICEBOXES
	//
	public List<String> getProjectNames() 
	{
        List<String> names = new ArrayList<>();
        for (Project project : projects) {
            names.add(project.name);
        }
        return names;
    }
	
	public List<String> getLifeCycleStepNames() 
	{
	       List<String> names = new ArrayList<>();
	       for (LifeCycleStep step : lifeCycleSteps) 
	       {
	           names.add(step.name);
	       }
	       return names;
	}
	
	public List<String> getEffortCategoryNames() 
	{
	        List<String> names = new ArrayList<>();
	        for (EffortCategory category : effortCategories) {
	            names.add(category.name);
	        }
	        return names;
	}
	 
	public List<String> getPlanNames() 
	{
	        List<String> names = new ArrayList<>();
	        for (Plan plan : plans) {
	            names.add(plan.name);
	        }
	        return names;
	}
	 
	 public List<String> getDeliverableNames() 
	 {
		 List<String> names = new ArrayList<>();
	     for (Deliverable deliverable : deliverables) 
	     {
	    	 names.add(deliverable.name);
	     }
	     return names;
	 }
	 
	 public List<String> getInterruptionNames() 
	 	{
	        List<String> names = new ArrayList<>();
	        for (Interruption interruption : interruptions) {
	            names.add(interruption.name);
	        }
	        return names;
	    }
	 
	 public List<String> getDefectCategoryNames() 
	 	{
	        List<String> names = new ArrayList<>();
	        for (DefectCategory category : defectCategories) {
	            names.add(category.name);
	        }
	        return names;
	    }

	 public List<String> getEffortLogs(Project project)
	 {
		 List<String> names = new ArrayList<>();
		 int logCounter = 1;
		 for (EffortLog el : project.logs.effortLogs)
		 {
			 String name = "" + logCounter + ". " + el.date + " (" + el.start
					 + "-" + el.stop + " ) " + el.lifeCycleStep + "; " + el.effortCategory
					 + "; " + el.delivInterEtc + ";";
			 names.add(name);
			 logCounter++;
		 }
		 
		 return names;
	 }
	 
	 //GETS THE LIFE CYCLE STEPS ASSOCIATED TO A CERTAIN PROJECT
	 public List<String> getProjectLifeCycleStepNames(Project project) 
		{
		       List<String> names = new ArrayList<>();
		       for (LifeCycleStep step : project.lifeCycleSteps) 
		       {
		           names.add(step.name);
		       }
		       return names;
		}
	  
	 public static Definitions getInstance()
	 {
		 return instance;
	 }
	 
}

//CLASSES FOR DEFINITION TYPES --------------------------------------------------------------------------------------
class Project implements Serializable
{
	private static final long serialVersionUID = 3248596783495307L;
	Project()
	{
		name = "";
		lifeCycleSteps = new ArrayList<>();
		logs = new Logs();
	}
	
	String name;
	List<LifeCycleStep> lifeCycleSteps;
	Logs logs;
	
	public LifeCycleStep getLifeCycleStep(List<LifeCycleStep> lifeCycleSteps, String name)
	{
		for (LifeCycleStep lcs : lifeCycleSteps)
		{
			if (lcs.name == name)
			{
				return lcs;
			}
		}
		
		return null;
	}
	
	public Logs getLogs()
	{
		return logs;
	}
	
}

class LifeCycleStep implements Serializable
{
	
	private static final long serialVersionUID = 7456443495807L;
	LifeCycleStep()
	{
		name = "";
		defaultEffortCategory = null;
		defaultDeliverable = null;
	}
	
	String name;
	EffortCategory defaultEffortCategory;
	Deliverable defaultDeliverable;
	
	public EffortCategory getEffortCategory(List<EffortCategory> effortCategories, String name)
	{
		for (EffortCategory ec : effortCategories)
		{
			if (ec.name == name)
			{
				return ec;
			}
		}
		
		return null;
	}
	
	public Deliverable getDeliverable(List<Deliverable> deliverables, String name)
	{
		for (Deliverable deliverable : deliverables)
		{
			if (deliverable.name == name)
			{
				return deliverable;
			}
		}
		
		return null;
	}
}

class EffortCategory implements Serializable
{
	
	private static final long serialVersionUID = 1234854585807L;
	EffortCategory()
	{
		name = "";
	}
	
	String name;
}

class Plan implements Serializable
{
	
	private static final long serialVersionUID = 32485997681L;
	Plan()
	{
		name = "";
	}
	
	String name;
}

class Deliverable implements Serializable
{
	
	private static final long serialVersionUID = 1234542343495807L;
	Deliverable()
	{
		name = "";
	}
	
	String name;
}

class Interruption implements Serializable
{
	
	private static final long serialVersionUID = 123452343495807L;
	Interruption()
	{
		name = "";
	}
	
	String name;
}

class DefectCategory implements Serializable
{
	
	private static final long serialVersionUID = 7389495807L;
	DefectCategory()
	{
		name = "";
	}
	
	String name;
}