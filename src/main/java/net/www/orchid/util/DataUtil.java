package net.www.orchid.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;


public class DataUtil {
	
	private static final class CopiedFieldsCounter {
		private int counter;
	}
	
	public static <T extends Annotation> int copyFields(final Object from, final Object to, Class<T> annotation) {
		final CopiedFieldsCounter copiedFieldsCounter = new CopiedFieldsCounter();
		ReflectionUtils.doWithFields(to.getClass(), new FieldCallback(){
			@Override
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);
				copyAccessibleField(field, from, to, copiedFieldsCounter);
			}
		}, createFieldFilter(annotation));
		return copiedFieldsCounter.counter;
	}
	
	public static <T extends Annotation> int copyFields(final Object from, final Object to) {
		return copyFields(from, to, null);
	}
	
	private static <T extends Annotation> FieldFilter createFieldFilter(Class<T> annotation) {
		if (annotation == null) {
			return ReflectionUtils.COPYABLE_FIELDS;
		} else {
			return new org.springframework.data.util.ReflectionUtils.AnnotationFieldFilter(annotation);
		}
	}
	
	private static void copyAccessibleField(Field field, Object from, Object to, CopiedFieldsCounter copiedFieldsCounter) throws IllegalAccessException {
		Object fromValue = field.get(from);
		Object toValue = field.get(to);
		if (fromValue == null) {
			if (toValue != null) {
				field.set(to, null);
				copiedFieldsCounter.counter++;
			}
		} else {
			if (!fromValue.equals(toValue)) {
				field.set(to, fromValue);
				copiedFieldsCounter.counter++;
			}
		}
	}

}
