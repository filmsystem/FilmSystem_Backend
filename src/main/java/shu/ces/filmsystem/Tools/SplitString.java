package shu.ces.filmsystem.Tools;

public class SplitString {
	public static String[] splitString(String str, String spstr){
		if(str == null || spstr == null) {
			String[] array = new String[0];
			return array;
		}
		return str.split(spstr);
	}
}
