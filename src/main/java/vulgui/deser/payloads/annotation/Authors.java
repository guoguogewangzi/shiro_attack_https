package vulgui.deser.payloads.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authors {
    String FROHOFF = "frohoff";
    String KORLR = "KORLR";
    String MATTHIASKAISER = "MATTHIASKAISER";
    String GEBL = "GEBL";

    String[] value() default {};

    public static class Utils {
        public static String[] getAuthors(AnnotatedElement annotated) {
            Authors authors = annotated.getAnnotation(Authors.class);
            if (authors != null && authors.value() != null) {
                return authors.value();
            } else {
                return new String[0];
            }
        }
    }
}
