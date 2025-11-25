package gr.maravelias.myeconomics.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import io.jmix.data.DbView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@DbView
@JmixEntity
@Table(name = "VIEW_TRADERS_BALANCES")
@Entity(name = "myec_ViewTraderBalances")
public class ViewTraderBalances {
  @JmixGeneratedValue
  @Column(name = "TRADER_ID", nullable = false)
  @Id
  private UUID id;

  @InstanceName
  @Column(name = "TITLE")
  private String title;

  @Column(name = "BALANCE")
  private BigDecimal balance;

  @Temporal(TemporalType.DATE)
  @Column(name = "LATEST_TRANSACTION_DATE")
  private Date latestTransactionDate;

  @Column(name = "DAYS_SINCE_LAST_TRANSACTION")
  private Integer daysSinceLastTransaction;

  @Column(name = "CREDIT_DAYS")
  private Integer creditDays;

  @JmixProperty @Transient private String risk;

  public String getRisk() {

    int diffDays = getCreditDays() - getDaysSinceLastTransaction();
    int creditDays = getCreditDays();

    double percentage = ((double) diffDays / creditDays) * 100.0;

    if (percentage < 0) {
      return "High Risk";
    } else if (percentage >= 70 && percentage <= 100) {
      return "Normal";
    } else {
      return "No risk";
    }

    // return String.format("%.2f%%", percentage);
  }

  public Integer getCreditDays() {
    return creditDays;
  }

  public void setCreditDays(Integer creditDays) {
    this.creditDays = creditDays;
  }

  public Integer getDaysSinceLastTransaction() {
    return daysSinceLastTransaction;
  }

  public void setDaysSinceLastTransaction(Integer daysSinceLastTransaction) {
    this.daysSinceLastTransaction = daysSinceLastTransaction;
  }

  public void setLatestTransactionDate(Date latestTransactionDate) {
    this.latestTransactionDate = latestTransactionDate;
  }

  public Date getLatestTransactionDate() {
    return latestTransactionDate;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
