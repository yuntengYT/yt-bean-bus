package yt.bean.bus.utils;

import org.springframework.util.ClassUtils;

import java.lang.reflect.ParameterizedType;

/**
 * ClassUtil
 *
 * @author zyt
 */
public class ClassUtil {
	public static String getPackageName(String className) {
		return ClassUtils.getPackageName(className);
	}

	public static String getPackageName(Class<?> clazz) {
		return ClassUtils.getPackageName(clazz);
	}

	/**
	 * 获取泛型
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> resolveGenericType(Class<?> declaredClass) {
		return (Class<T>) ((ParameterizedType) declaredClass.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public static boolean isAssignableValue(Class<?> type, Object value) {
		return ClassUtils.isAssignableValue(type, value);
	}

	public static boolean isAssignable(Class<?> lhsType, Class<?> rhsType) {
		return ClassUtils.isAssignable(lhsType, rhsType);
	}
}
