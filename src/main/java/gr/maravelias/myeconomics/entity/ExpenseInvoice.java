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
    name = "MYEC_EXPENSE_INVOICE",
    indexes = {@Index(name = "IDX_MYEC_EXPENSE_INVOICE_TRADER", columnList = "TRADER_ID")})
@Entity(name = "myec_ExpenseInvoice")
public class ExpenseInvoice extends CommonEntity {
  @Column(name = "TRANSACTION_DATE", nullable = false)
  @Temporal(TemporalType.DATE)
  @NotNull
  private Date transactionDate;

  @Column(name = "AMOUNT", nullable = false, precision = 10, scale = 2)
  @NotNull
  private BigDecimal amount;

  @Column(name = "INVOICE_NUMBER")
  private String invoiceNumber;

  @OnDeleteInverse(DeletePolicy.DENY)
  @JoinColumn(name = "TRADER_ID", nullable = false)
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Trader trader;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal ammount) {
    this.amount = ammount;
  }

  public Trader getTrader() {
    return trader;
  }

  public void setTrader(Trader trader) {
    this.trader = trader;
  }

  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }
}
