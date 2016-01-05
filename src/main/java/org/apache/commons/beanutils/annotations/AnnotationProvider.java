package org.apache.commons.beanutils.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Provider to get annotation in a bean
 * </p>
 */
public class AnnotationProvider {
    /*auto use annotationMode*/
    public boolean autoAnnotationMode = false;
    /*singleton provider non-thread safe*/
	public static AnnotationProvider instance = new AnnotationProvider();
	public static Map<Field,Annotation> annotationCache = new HashMap<Field,Annotation>();

	private AnnotationProvider() {
	}

    /**
     * @return pseudo-singleton provider
     */
	public static AnnotationProvider getInstance() {
		if (null == instance) {
			return new AnnotationProvider();
		} else {
			return instance;
		}
	}

    /**
     * @param autoAnnotationMode
     */
    public void setAutoAnnotationMode(boolean autoAnnotationMode) {
        this.autoAnnotationMode = autoAnnotationMode;
    }

    public boolean isAutoAnnotationMode() {
        return autoAnnotationMode;
    }

    /**
     * <p>Get property's annotation of a standard JavaBean property</p>
     * @param field  Field of a bean
     * @param annotationClass
     * @param <T>
     * @return  annotation decorating the field in a bean
     */
	public <T extends Annotation> T getAnnotation(Field field, Class<T> annotationClass) {
		if(annotationCache.containsKey(field)){
			return  (T)annotationCache.get(field);
		}else{
            T ret = field.getAnnotation(annotationClass);
            annotationCache.put(field, ret);
            return ret;
        }
	}
}
