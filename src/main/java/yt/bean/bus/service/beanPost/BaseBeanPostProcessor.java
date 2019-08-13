package yt.bean.bus.service.beanPost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import yt.bean.bus.utils.ClassUtil;

/**
 * @author yunteng
 */
public class BaseBeanPostProcessor<T> implements BeanPostProcessor {

	private final Class<T> beanType;

	public BaseBeanPostProcessor() {
		@SuppressWarnings("unchecked")
		Class<T> genericSuperclass = (Class<T>) this.getClass().getGenericSuperclass();
		this.beanType = ClassUtil.resolveGenericType(genericSuperclass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (ClassUtil.isAssignableValue(beanType, bean)) {
			return beforeInitialization((T) bean, beanName);
		}
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (ClassUtil.isAssignableValue(beanType, bean)) {
			return afterInitialization((T) bean, beanName);
		}
		return bean;
	}

	private Object beforeInitialization(T bean, String beanName) throws BeansException {
		before(bean, beanName);
		return bean;
	}

	private Object afterInitialization(T bean, String beanName) throws BeansException {
		after(bean, beanName);
		return bean;
	}

	protected void before(T bean, String beanName) throws BeansException {
	}

	protected void after(T bean, String beanName) throws BeansException {
	}
}
