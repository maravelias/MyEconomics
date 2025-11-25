package gr.maravelias.myeconomics.entity;

import io.jmix.core.metamodel.datatype.EnumClass;
import org.springframework.lang.Nullable;

public enum TraderType implements EnumClass<String> {
  CUSTOMER("CUSTOMER"),
  SUPPLIER("SUPPLIER");

  private final String id;

  TraderType(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Nullable
  public static TraderType fromId(String id) {
    for (TraderType at : TraderType.values()) {
      if (at.getId().equals(id)) {
        return at;
      }
    }
    return null;
  }
}
