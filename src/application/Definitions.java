package application;

import java.util.List;

public class Definitions 
{
	Definitions()
	{
		projects = null;;
		lifeCycleSteps = null;
		effortCategories = null;
		plans = null;
		deliverables = null;
		interruptions = null;
		defectCategories = null;
	}
	
	List<Project> projects;
	List<LifeCycleStep> lifeCycleSteps;
	List<EffortCategory> effortCategories;
	List<Plan> plans;
	List<Deliverable> deliverables;
	List<Interruption> interruptions;
	List<DefectCategory> defectCategories;
}

class Project
{
	
	Project()
	{
		name = "";
		lifeCycleSteps = null;
	}
	
	String name;
	List<LifeCycleStep> lifeCycleSteps;
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