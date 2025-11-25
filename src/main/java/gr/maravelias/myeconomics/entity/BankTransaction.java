package gr.maravelias.myeconomics.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@JmixEntity
@Table(
    name = "MYEC_BANK_TRANSACTION",
    indexes = {
      @Index(name = "IDX_MYEC_BANK_TRANSACTION_BANK", columnList = "BANK_ID"),
      @Index(name = "IDX_MYEC_BANK_TRANSACTION_TRADER", columnList = "TRADER_ID")
    })
@Entity(name = "myec_BankTransaction")
public class BankTransaction extends CommonEntity {
  @OnDeleteInverse(DeletePolicy.DENY)
  @JoinColumn(name = "BANK_ID", nullable = false)
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private BankAccount bank;

  @Column(name = "TRANSACTION_TYPE", nullable = false)
  @NotNull
  private String transactionType;

  @NotNull
  @Column(name = "AMOUNT", nullable = false, precision = 10, scale = 2)
  private BigDecimal amount;

  @Column(name = "TRANSACTION_DATE", nullable = false)
  @Temporal(TemporalType.DATE)
  @NotNull
  private Date transactionDate;

  @OnDeleteInverse(DeletePolicy.DENY)
  @JoinColumn(name = "TRADER_ID", nullable = false)
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Trader trader;

  public TransactionType getTransactionType() {
    return transactionType == null ? null : TransactionType.fromId(transactionType);
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType == null ? null : transactionType.getId();
  }

  public Trader getTrader() {
    return trader;
  }

  public void setTrader(Trader trader) {
    this.trader = trader;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal ammount) {
    this.amount = ammount;
  }

  public BankAccount getBank() {
    return bank;
  }

  public void setBank(BankAccount bank) {
    this.bank = bank;
  }
}
