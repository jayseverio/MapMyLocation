package in.co.madhur.mapmylocation.preferences;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import in.co.madhur.mapmylocation.App;
import in.co.madhur.mapmylocation.Consts;
import in.co.madhur.mapmylocation.R;
import in.co.madhur.mapmylocation.activity.FriendPickerActivity;
import in.co.madhur.mapmylocation.activity.MainActivity;
import in.co.madhur.mapmylocation.preferences.Preferences.Keys.*;

public final class Preferences implements OnSharedPreferenceChangeListener 
{
	private SharedPreferences sharedPreferences;
	Context context;
	private final int FB_REQUESTCODE=1;
	private final int FB_SELCTFRIENDS=2;
	
	public enum Keys
	{
		
		ENABLE_TRACKME("pref_enable_trackme"),
		SECRET_CODE("pref_setsecretcode"),
		ALLOW_CONTACTS("pref_onlyallowcontacts"),
		SELECT_CONTACTS("pref_selectcontacts"),
		MAX_RATE("pref_max_rate"),
		ENABLE_LIVETRACK("pref_enable_livetrack"),
		CONNECT_FB("pref_connectfb"),
		FB_INTERVAL("pref_fbinterval"),
		SELECT_FB_FRIENDS("pref_selectfbfriends"),
		FB_MESSAGE("pref_fbmessage"),
		ABOUT("pref_about_desc"),
		FAQ("pref_faq_desc"),
		SHOW_TRACKME_NOTIFICATION("pref_trackme_shownotification"),
		SHOW_LIVETRACK_NOTIFICATION("pref_livetrack_shownotification"),
		//FB_ACCESS_TOKEN("fb_access_token"),
		//FB_ACCESS_EXPIRES("fb_access_expires"),
		FB_FRIENDS("pref_selectfbfriends"),
		SETTINGS_TRACKME("pref_settings_trackme"),
		SETTINGS_LIVETRACK("pref_settings_livetrack"),
		FB_USERNAME("fb_username");
		
		public final String key;
		private Keys(String key)
		{
			this.key=key;
			
		}
		
		
	};
	
	public Preferences(Context context)
	{
		this.context=context;
		this.sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
		sharedPreferences.registerOnSharedPreferenceChangeListener(this);
	}
	
	public String getSecretCode()
	{
		return sharedPreferences.getString(Keys.SECRET_CODE.key, null);
		
	}
	
	public String getFBMessage()
	{
		return sharedPreferences.getString(Keys.FB_MESSAGE.key, null);
		
	}
	
	public boolean isTrackMeEnabled()
	{
		return sharedPreferences.getBoolean(Keys.ENABLE_TRACKME.key, false);
		
	}
	
	public boolean isLiveTrackEnabled()
	{
		return sharedPreferences.getBoolean(Keys.ENABLE_LIVETRACK.key, false);
		
	}
	
	public boolean isFBConnected()
	{
		return sharedPreferences.getBoolean(Keys.CONNECT_FB.key, false);
		
	}
	
	public int getMaxRate()
	{
		return getStringAsInt(Keys.MAX_RATE.key, Defaults.MAX_SMS_RATE);
		
		
	}
	
	public String getFBFriends()
	{
		
		return sharedPreferences.getString(Keys.FB_FRIENDS.key, Defaults.FB_FRIENDS);
	}
	
	public int getFBInterval()
	{
		return getStringAsInt(Keys.FB_INTERVAL.key, Defaults.FB_RATE);
		
	}
	
	private int getStringAsInt(String key, int def)
	{
		try
		{
			String s = sharedPreferences.getString(key, null);
			if (s == null)
				return def;

			return Integer.valueOf(s);
		}
		catch (NumberFormatException e)
		{
			return def;
		}
	}

	public boolean isOnlyAllowContacts()
	{
		return sharedPreferences.getBoolean(Keys.ALLOW_CONTACTS.key, false);
		
	}
	
	public boolean showLiveTrackNotifications()
	{
		return sharedPreferences.getBoolean(Keys.SHOW_LIVETRACK_NOTIFICATION.key, true);
		
	}
	
	public boolean showTrackMeNotifications()
	{
		return sharedPreferences.getBoolean(Keys.SHOW_TRACKME_NOTIFICATION.key, true);
		
	}

	/*
	public void clearFBData()
	{
		SharedPreferences.Editor editor=sharedPreferences.edit();
		editor.putString(Keys.FB_ACCESS_TOKEN.key, "");
		editor.putString(Keys.FB_ACCESS_EXPIRES.key, "");
		editor.putString(Keys.FB_USERNAME.key, "");
		editor.commit();
	}
	
	public void setFBTokenData(String access_token, String access_expires, String username)
	{
		SharedPreferences.Editor editor=sharedPreferences.edit();
		editor.putString(Keys.FB_ACCESS_TOKEN.key, access_token);
		editor.putString(Keys.FB_ACCESS_EXPIRES.key, access_expires);
		editor.putString(Keys.FB_USERNAME.key, username);
		editor.commit();
	}
	
	public String getFBAccessToken()
	{
		
		return sharedPreferences.getString(Keys.FB_ACCESS_TOKEN.key,"");
	}
	
	
	public String getFBAccessExpires()
	{
		return sharedPreferences.getString(Keys.FB_ACCESS_EXPIRES.key, "");
	}

	public String getFBUserName()
	{
		// TODO Auto-generated method stub
		return sharedPreferences.getString(Keys.FB_ACCESS_EXPIRES.key, "");
	}*/

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key)
	{

		if (key.equals(Keys.FB_FRIENDS.key))
		{
			String fbFriendsVal = getFBFriends();
			if (fbFriendsVal.equals(Consts.FB_FRIENDS_FIRE))
			{
				Activity activity = (Activity) context;
				activity.startActivityForResult(new Intent(context,
						FriendPickerActivity.class), FB_SELCTFRIENDS);
			}
		}

	}
	
}
	
	

