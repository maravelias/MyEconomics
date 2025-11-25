package gr.maravelias.myeconomics.entity;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@JmixEntity
@Table(name = "MYEC_TRADER")
@Entity(name = "myec_Trader")
public class Trader extends CommonEntity {
  @InstanceName
  @Column(name = "TITLE", nullable = false)
  @NotNull
  private String title;

  @Column(name = "CREDIT_DAYS")
  private Integer creditDays;

  @Column(name = "NOTES")
  private String notes;

  @Column(name = "VAT", length = 9)
  private String vat;

  @Column(name = "TRADER_TYPE", nullable = false)
  @NotNull
  private String traderType;

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Integer getCreditDays() {
    return creditDays;
  }

  public void setCreditDays(Integer creditDays) {
    this.creditDays = creditDays;
  }

  public TraderType getTraderType() {
    return traderType == null ? null : TraderType.fromId(traderType);
  }

  public void setTraderType(TraderType traderType) {
    this.traderType = traderType == null ? null : traderType.getId();
  }

  public String getVat() {
    return vat;
  }

  public void setVat(String vat) {
    this.vat = vat;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
