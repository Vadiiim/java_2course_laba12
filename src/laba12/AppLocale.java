package laba12;

import java.util.*;

public class AppLocale {
	private static final String strMsg = "Msg";
	private static Locale loc = Locale.getDefault();
	private static ResourceBundle res = 
			ResourceBundle.getBundle( AppLocale.strMsg, AppLocale.loc );
	
	static Locale get() {
		return AppLocale.loc;
	}
	
	static void set( Locale loc ) {
		AppLocale.loc = loc;
		res = ResourceBundle.getBundle( AppLocale.strMsg, AppLocale.loc );
	}
	
	static ResourceBundle getBundle() {
		return AppLocale.res;
	}
	
	static String getString( String key ) {
		return AppLocale.res.getString(key);
	}
	
	// Resource keys:
	
	public static final String Crime_and_Punishment="Crime and Punishment";
	public static final String Fedor_Dostoevsky="Fedor Dostoevsky";
	public static final String War_and_Peace="War and Peace";
	public static final String Lev_Tolstoy="Lev Tolstoy";
	public static final String William_Shakespeare="William Shakespeare";
	public static final String Romeo_and_Juliet="Romeo and Juliet";
	public static final String Charles_Dickens="Charles Dickens";
	public static final String A_Tale_of_Two_Cities="A Tale of Two Cities";
	public static final String George_Orwell ="George Orwell ";
	public static final String roman1984="1984";
	public static final String Politics_and_English="Politics and English";
	public static final String At_a_dead_end="At a dead end";
	public static final String Julius_Caesar="Julius Caesar";
	public static final String Auditor="Auditor";
	public static final String Nikolay_Gogol="Nikolay Gogol";
	public static final String Dead_Souls="Dead Souls";
	public static final String libraries="libraries";
}

