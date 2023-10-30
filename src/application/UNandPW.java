package application;

import java.util.HashMap;

public class UNandPW {

	//in application, an external database will be used to hold credentials
	//for prototype we use a HashMap and store the credentials in memory
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	UNandPW()
	{
		
		loginInfo.put("a", "a");
		loginInfo.put("Bob", "bob2002");
		loginInfo.put("jfett2", "xle952!");
		loginInfo.put("nsripapa3", "w!rtG%l");
		loginInfo.put("rsingh7", "pft4u7$z");
		loginInfo.put("apsuter", "SmH_imAg1ne");
		
	}
	
	protected HashMap getLoginInfo()
	{
		return loginInfo;
	}
}