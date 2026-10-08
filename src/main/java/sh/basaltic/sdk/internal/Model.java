package sh.basaltic.sdk.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import java.util.Map;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.SdkException;

/** Base of generated models. Required input fields are checked before network IO. */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Model {
  @Override
  public final String toString() {
    return getClass().getSimpleName() + "{[REDACTED]}";
  }

  public static void validate(Object value) {
    validate(value, new IdentityHashMap<>());
  }

  private static void validate(Object value, IdentityHashMap<Object, Boolean> seen) {
    if (value == null) return;
    if (value instanceof JsonField<?> field) {
      if (field.isPresent()) validate(field.value(), seen);
      return;
    }
    if (!(value instanceof Model || value instanceof Map<?, ?> || value instanceof Iterable<?>))
      return;
    if (seen.put(value, Boolean.TRUE) != null)
      throw new SdkException(SdkException.Kind.VALIDATION, "Cyclic request object");
    try {
      if (value instanceof Model) {
        for (Field field : value.getClass().getDeclaredFields()) {
          if (Modifier.isStatic(field.getModifiers())) continue;
          JsonProperty property = field.getAnnotation(JsonProperty.class);
          if (property == null) continue;
          field.setAccessible(true);
          Object child = field.get(value);
          if (property.required()
              && (child == null || child instanceof JsonField<?> f && !f.isPresent()))
            throw new SdkException(
                SdkException.Kind.VALIDATION, "Missing required property: " + property.value());
          validate(child, seen);
        }
      } else if (value instanceof Map<?, ?> map) {
        for (Object child : map.values()) validate(child, seen);
      } else {
        for (Object child : (Iterable<?>) value) validate(child, seen);
      }
    } catch (IllegalAccessException e) {
      throw new SdkException(SdkException.Kind.VALIDATION, "Cannot inspect request model");
    } finally {
      seen.remove(value);
    }
  }
}
