package sh.basaltic.sdk.internal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import sh.basaltic.sdk.SdkException;

/** Shared JSON configuration. The mutable mapper is deliberately not exposed. */
public final class Json {
  private Json() {}

  private static final ObjectMapper MAPPER =
      JsonMapper.builder()
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
          .disable(DeserializationFeature.ACCEPT_FLOAT_AS_INT)
          .disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
          .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)
          .build();

  public static JsonNode tree(Object value) {
    try {
      return MAPPER.valueToTree(value);
    } catch (IllegalArgumentException e) {
      throw new SdkException(SdkException.Kind.VALIDATION, "Cannot serialize request value");
    }
  }

  public static JsonNode parse(byte[] value) {
    try {
      JsonNode node = MAPPER.readTree(value);
      if (node == null) throw new IllegalArgumentException();
      return node;
    } catch (Exception e) {
      throw new SdkException(SdkException.Kind.PROTOCOL, "Response is not valid JSON");
    }
  }

  public static byte[] bytes(Object value) {
    try {
      return MAPPER.writeValueAsBytes(value);
    } catch (Exception e) {
      throw new SdkException(SdkException.Kind.VALIDATION, "Cannot serialize request value");
    }
  }

  public static <T> T convert(JsonNode value, TypeReference<T> type) {
    try {
      return MAPPER.convertValue(value, type);
    } catch (IllegalArgumentException e) {
      throw new SdkException(
          SdkException.Kind.PROTOCOL, "Response does not match the expected API type");
    }
  }
}
