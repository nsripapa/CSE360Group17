package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Definitions 
{
	private static final Definitions instance = new Definitions();
	
	private Definitions()
	{
		projects = new ArrayList<>();
		lifeCycleSteps = new ArrayList<>();
		effortCategories = new ArrayList<>();
		plans = new ArrayList<>();
		deliverables = new ArrayList<>();
		interruptions = new ArrayList<>();
		defectCategories = new ArrayList<>();
		
		
		//start of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//start of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//start of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//start of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//start of predefined values-----------------------------------------------------------------------------------------------------------------------------

		//PLANS
		Plan plan = new Plan();
		
		plan.name = "Project Plan";
		plans.add(plan);
		
		plan.name = "Risk Management Plan";
		plans.add(plan);
		
		plan.name = "Conceptual Design Plan";
		plans.add(plan);
		
		plan.name = "Detailed Design Plan";
		plans.add(plan);
		
		plan.name = "Implementation Plan";
		plans.add(plan);
		
		//DELIVERABLES
		Deliverable deliverable = new Deliverable();
		
		deliverable.name = "Conceptual Design";
		deliverables.add(deliverable);
		
		deliverable = new Deliverable();
		deliverable.name = "Detailed Design";
		deliverables.add(deliverable);
		
		deliverable = new Deliverable();
		deliverable.name = "Test Cases";
		deliverables.add(deliverable);
		
		deliverable = new Deliverable();
		deliverable.name = "Solution";
		deliverables.add(deliverable);
		
		deliverable = new Deliverable();
		deliverable.name = "Reflection";
		deliverables.add(deliverable);
		
		deliverable = new Deliverable();
		deliverable.name = "Outline";
		deliverables.add(deliverable);

		deliverable = new Deliverable();
		deliverable.name = "Draft";
		deliverables.add(deliverable);

		deliverable = new Deliverable();
		deliverable.name = "Report";
		deliverables.add(deliverable);

		deliverable = new Deliverable();
		deliverable.name = "User Defined";
		deliverables.add(deliverable);

		deliverable = new Deliverable();
		deliverable.name = "Other";
		deliverables.add(deliverable);
		
		//INTERRUPTIONS
		Interruption interruption = new Interruption();
		
		interruption.name = "Break";
		interruptions.add(interruption);
		
		interruption = new Interruption();
		interruption.name = "Phone";
		interruptions.add(interruption);

		interruption = new Interruption();
		interruption.name = "Teammate";
		interruptions.add(interruption);

		interruption = new Interruption();
		interruption.name = "Visitor";
		interruptions.add(interruption);

		interruption = new Interruption();
		interruption.name = "Other";
		interruptions.add(interruption);
		
		
		//DEFECT CATEGORIES
		DefectCategory dc = new DefectCategory();
		
		dc.name = "Not Specified";
		defectCategories.add(dc);
		
		dc = new DefectCategory();
		dc.name = "Documentation";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Syntax";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Build, Package";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Assignment";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Interface";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Checking";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Data";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Function";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "System";
		defectCategories.add(dc);

		dc = new DefectCategory();
		dc.name = "Environment";
		defectCategories.add(dc);
		
		//EFFORT CATEGORIES
		EffortCategory ec = new EffortCategory();
		
		ec.name = "Plans";
		effortCategories.add(ec);
		
		ec = new EffortCategory();
		ec.name = "Deliverables";
		effortCategories.add(ec);

		ec = new EffortCategory();
		ec.name = "Interruptions";
		effortCategories.add(ec);

		ec = new EffortCategory();
		ec.name = "Defects";
		effortCategories.add(ec);

		ec = new EffortCategory();
		ec.name = "Others";
		effortCategories.add(ec);
		
		//LIFE CYCLE STEPS
		LifeCycleStep lcs = new LifeCycleStep();
		
		lcs.name = "Problem Understanding";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);
		
		lcs = new LifeCycleStep();
		lcs.name = "Conceptual Design Plan";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Plans");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Test Cases");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Requirements";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Conceptual Design";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Conceptual Design Review";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Detailed Design Plan";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Plans");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Solution");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Detailed Design/Prototype";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Detailed Design Review";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Implementation Plan";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Plans");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Test Case Generation";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Test Cases");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Solution Specification";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Solution");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Solution Review";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Solution");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Solution Implementation";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Solution");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Unit/System Test";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Solution");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Reflection";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Solution");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Repository Update";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Solution");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Planning";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Plans");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Information Gathering";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Information Understanding";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Verifying";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Outlining";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Outline");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Drafting";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Draft");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Finalizing";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Report");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Team Meeting";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Coach Meeting";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);

		lcs = new LifeCycleStep();
		lcs.name = "Stakeholder Meeting";
		lcs.defaultEffortCategory = lcs.getEffortCategory(effortCategories, "Deliverables");
		lcs.defaultDeliverable = lcs.getDeliverable(deliverables, "Conceptual Design");
		lifeCycleSteps.add(lcs);
		
		//PROJECTS
		Project project = new Project();
		
		project.name = "Business Project";
		
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Planning"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Information Gathering"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Information Understanding"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Verifying"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Outlining"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Drafting"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Finalizing"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Team Meeting"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Coach Meeting"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Stakeholder Meeting"));
		
		projects.add(project);
		
		project = new Project();
		project.name = "Development Project";
		
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Problem Understanding"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Conceptual Design Plan"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Requirements"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Conceptual Design"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Conceptual Design Review"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Detailed Design Plan"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Detailed Design/Prototype"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Detailed Design Review"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Implementation Plan"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Test Case Generation"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Solution Specification"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Solution Review"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Solution Implementation"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Unit/System Test"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Reflection"));
		project.lifeCycleSteps.add(project.getLifeCycleStep(lifeCycleSteps, "Repository Update"));
		
		projects.add(project);
		
		//end of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//end of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//end of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//end of predefined values-----------------------------------------------------------------------------------------------------------------------------
		//end of predefined values-----------------------------------------------------------------------------------------------------------------------------
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

class Project
{
	
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

class LifeCycleStep
{
	
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

class EffortCategory
{
	
	EffortCategory()
	{
		name = "";
	}
	
	String name;
}

class Plan
{
	
	Plan()
	{
		name = "";
	}
	
	String name;
}

class Deliverable
{
	
	Deliverable()
	{
		name = "";
	}
	
	String name;
}

class Interruption
{
	
	Interruption()
	{
		name = "";
	}
	
	String name;
}

class DefectCategory
{
	
	DefectCategory()
	{
		name = "";
	}
	
	String name;
}