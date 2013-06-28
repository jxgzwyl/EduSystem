package com.zikool.edu.frame.common;

public class GlobalConfigure {

	public static final String SPRING_APPLICATION_CONTEXT_KEY = GlobalConfigure.class.getName() + "_SPRING_APPLICATION_CONTEXT_KEY";
	
	public static final String[] NO_INTERCEPTOR_URL = {"/login.do","/dologin.do","/getMenu.do","/test/**"};
	
	public static final String IMAGE_REGEX_TYPE = "image/[\\w|-]+";
	
	public static final int DEFAULT_PAGE_SIZE = 20;
	
	public static final int MAX_PAGE_SIZE = 100;
	
	public static final String PAGINATION_SQL_START = "start";

	public static final String PAGINATION_SQL_END = "end";

    public static final String ROLE_DEFINITION_KEY = "_ROLE_DEFINITION_KEY";
    
    public static final String URI_DEFINITION_KEY = "_URI_DEFINITION_KEY";
    
    public static final String PERMISSION_DEFINITION_KEY = "_PERMISSION_DEFINITION_KEY";
    
    public static final String PERMISSION_OPT_DEFINITION_KEY = "_PERMISSION_OPT_DEFINITION_KEY";
    
    public static final String DEFAULT_PERMISSION_VIEW = ":view";

	
	
}
