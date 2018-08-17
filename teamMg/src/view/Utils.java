package view;

import org.apache.commons.lang.StringUtils;

public class Utils {
	public static boolean isEmpty(String str, String field) {
		if(StringUtils.isEmpty(str)) {
			System.out.println(field+"�� ���� �Է����ּ���!!");
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric(String str, String field) {
		if(StringUtils.isNumeric(str)) {
			return true;
		}
		System.out.println(field+"�� ���ڸ� �Է��� �ּž� �մϴ�!!");
		return false;
	}
	
	public static boolean isSmallLength(String name, String field,int length) {
		if(name == null) {
			return false;
		}
		if(length < name.length()) {
			System.out.println(field+"�� "+length+"���� ���Ϸ� �Է��� �ּ���");
			return false;
		}
		return true;
	}
}
