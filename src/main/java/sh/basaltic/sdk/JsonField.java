package sh.basaltic.sdk;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import java.io.IOException;
import java.util.Objects;

/** Distinguishes an omitted property from an explicit JSON null or value. */
@JsonSerialize(using = JsonField.Serializer.class)
@JsonDeserialize(using = JsonField.Deserializer.class)
public final class JsonField<T> {
  private final boolean present;
  private final T value;

  private JsonField(boolean present, T value) {
    this.present = present;
    this.value = value;
  }

  public static <T> JsonField<T> missing() {
    return new JsonField<>(false, null);
  }

  public static <T> JsonField<T> of(T value) {
    return new JsonField<>(true, value);
  }

  public static <T> JsonField<T> nullValue() {
    return of(null);
  }

  public boolean isPresent() {
    return present;
  }

  public boolean isNull() {
    return present && value == null;
  }

  public T value() {
    if (!present) throw new IllegalStateException("Field is absent");
    return value;
  }

  @Override
  public String toString() {
    return present ? "JsonField{[REDACTED]}" : "JsonField{missing}";
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof JsonField<?> f
        && present == f.present
        && Objects.equals(value, f.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(present, value);
  }

  public static final class Serializer extends JsonSerializer<JsonField<?>> {
    @Override
    public boolean isEmpty(SerializerProvider provider, JsonField<?> value) {
      return value == null || !value.present;
    }

    @Override
    public void serialize(JsonField<?> value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
      provider.defaultSerializeValue(value.value, gen);
    }
  }

  public static final class Deserializer extends JsonDeserializer<JsonField<?>>
      implements ContextualDeserializer {
    private final JavaType type;

    public Deserializer() {
      this(null);
    }

    private Deserializer(JavaType type) {
      this.type = type;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctx, BeanProperty property) {
      JavaType container = property == null ? ctx.getContextualType() : property.getType();
      return new Deserializer(container.containedTypeOrUnknown(0));
    }

    @Override
    public JsonField<?> deserialize(JsonParser parser, DeserializationContext ctx)
        throws IOException {
      return JsonField.of(ctx.readValue(parser, type));
    }

    @Override
    public JsonField<?> getNullValue(DeserializationContext ctx) {
      return JsonField.nullValue();
    }
  }
}
