package yt.bean.bus.utils;

import yt.bean.bus.model.UserInfoDO;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yunteng
 */
public class ObjectMapUtil {

	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null) {
			return null;
		}

		Object obj = beanClass.newInstance();

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}

			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));
		}
		return obj;
	}

	public static Map<String, Object> objectToMap(Object obj) throws Exception {
		if(obj == null){
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}

		return map;
	}


	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>(16);
		map.put("userId",123);
		map.put("userName","张三");
		map.put("userIdCard","123432423532");
		map.put("age",12);
		map.put("phone","13785528123");

		try {
			UserInfoDO userInfoDO = (UserInfoDO) mapToObject(map, UserInfoDO.class);
			System.out.println(userInfoDO.getAge());
			Map<String,Object> map1 = objectToMap(userInfoDO);
			System.out.println(map1.get("phone"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
