package common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Common {

	// 테스트용
	// ver1  ->  String, int만, 정수 + 대소문자
	// 갯수, 필요한 오브젝트, String 길이, int 범위
	public static List<Object> autoObject(int a, Object ob, int b, int d) throws IllegalAccessException, InstantiationException {
		Class<?> c = ob.getClass();
		Field[] fields = c.getDeclaredFields();
		if (fields.length == 0) fields = c.getSuperclass().getDeclaredFields();

		List<Object> li = new ArrayList<>();

		for (int i = 0; i < a; i++) {
			Object obj = new Object();
			try {
				obj = c.newInstance();
				// obj를 사용할 수 있음
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			for (Field f : fields) {
				f.setAccessible(true);
				int random_int = 0;
				if (f.getType() == String.class) {
					int leftLimit = 48; // numeral '0'
					int rightLimit = 122; // letter 'z'
					int targetStringLength = b; // 문자열 길이
					Random random = new Random();

					String generatedString = random.ints(leftLimit, rightLimit + 1)
							.filter(j -> (j <= 57 || j >= 65) && (j <= 90 || j >= 97))
							.limit(targetStringLength)
							.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
							.toString();
					f.set(obj, generatedString);
				} else if (f.getType() == int.class) {
					random_int = (int) (Math.random() * d) + 1;
					f.set(obj, random_int);
				}
			}
			li.add(obj);
		}
		return li;
	}

	// ver2
	// ver1(정수 + 대소문자)의 String 구성 -> ver2(선택)
	// ch ->
	// ver1 = "a", 대소문자(정수x) = "up&low", 소문자 = "low", 대문자 = "up"
	public static List<Object> autoObject(int a, Object ob, int b, int d, String ch) throws IllegalAccessException, InstantiationException {
		Class<?> c = ob.getClass();
		Field[] fields = c.getDeclaredFields();
		if (fields.length == 0) fields = c.getSuperclass().getDeclaredFields();

		List<Object> li = new ArrayList<>();

		for (int i = 0; i < a; i++) {
			Object obj = new Object();
			try {
				obj = c.newInstance();
				// obj를 사용할 수 있음
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			for (Field f : fields) {
				f.setAccessible(true);
				int random_int = 0;
				if (f.getType() == String.class) {
					int leftLimit = 48; // numeral '0'
					int rightLimit = 122; // letter 'z'
					int targetStringLength = b; // 문자열 길이
					Random random = new Random();

					String generatedString = random.ints(leftLimit, rightLimit + 1)
							.filter(j -> (j <= 57 || j >= 65) && (j <= 90 || j >= 97))
							.limit(targetStringLength)
							.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
							.toString();

					if(ch.equals("up&low")) {    //대소문자
						leftLimit = 90;
						rightLimit = 122;
						generatedString = random.ints(leftLimit, rightLimit + 1)
								.filter(j -> (j >= 65 || j <= 90) && (j >= 97 || j <= 122))
								.limit(targetStringLength)
								.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
								.toString();
					} else if(ch.equals("low")) { //소문자
						leftLimit = 97;
						rightLimit = 122;
						generatedString = random.ints(leftLimit, rightLimit + 1)
								.filter(j -> (j >= 97 || j <= 122))
								.limit(targetStringLength)
								.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
								.toString();
					} else if(ch.equals("up")) { //대문자
						leftLimit = 65;
						rightLimit = 90;
						generatedString = random.ints(leftLimit, rightLimit + 1)
								.filter(j -> (j >= 65 || j <= 90))
								.limit(targetStringLength)
								.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
								.toString();
					} else {
						System.out.println("ver1");
					}

					f.set(obj, generatedString);
				} else if (f.getType() == int.class) {
					random_int = (int) (Math.random() * d) + 1;
					f.set(obj, random_int);
				}
			}
			li.add(obj);
		}
		return li;
	}


}
