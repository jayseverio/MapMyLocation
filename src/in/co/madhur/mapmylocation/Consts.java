package in.co.madhur.mapmylocation;


public final class Consts {
	
	public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
	public static final String ACCESS_EXPIRES = "ACCESS_EXPIRES";
	public static final String USER_NAME = "USER_NAME";
			
	public static int MAX_WAIT_TIME=10000;
	public static int UPDATE_TIMEOUT=5000;
	
	public static String SENT="SMS_SENT";
	public static String DELIVERED="SMS_DELIVERED";
	public static String GOOGLE_MAPS_URL="http://maps.google.com/?q=%s,%s";
	public static String FB_FRIENDS_FIRE="CUSTOM";
	
	public static String FB_POST_ACTION="FB_POST_ACTION";
	
	public static enum FBPrivacies
	{
		
		
		EVERYONE("EVERYONE"),
		FRIENDS_OF_FRIENDS("FRIENDS_OF_FRIENDS"),
		FRIENDS("FRIENDS"),
		SELF("SELF"),
		CUSTOM("CUSTOM");
		
		FBPrivacies(String key)
		{
			this.Key=key;
		}
		
		private final String Key;
		
		@Override
		public String toString()
		{
			// TODO Auto-generated method stub
			return Key;
		}
		
	}

}