package org.apache.commons.beanutils.annotations;

import java.lang.annotation.*;

/**
 * <p>Property alias annotation of a standard java bean in original object.
 *  copy the property value to the property named by the alias in the destination object
 * </p>
 *
 * @version $Id$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Alias {
    /**
     * The name of the class or field alias.
     */
    public String value();
}
