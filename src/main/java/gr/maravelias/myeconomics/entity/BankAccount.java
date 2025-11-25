package gr.maravelias.myeconomics.entity;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@JmixEntity
@Table(name = "MYEC_BANK_ACCOUNT")
@Entity(name = "myec_BankAccount")
public class BankAccount extends CommonEntity {

  @InstanceName
  @Column(name = "TITLE", nullable = false)
  @NotNull
  private String title;

  @Column(name = "IBAN")
  private String iban;

  @Column(name = "INITIAL_AMOUNT", precision = 10, scale = 2)
  private BigDecimal initialAmount;

  public void setInitialAmount(BigDecimal initialAmmount) {
    this.initialAmount = initialAmmount;
  }

  public BigDecimal getInitialAmount() {
    return initialAmount;
  }

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
