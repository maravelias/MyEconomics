package gr.maravelias.myeconomics.view.banktransaction;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.BankTransaction;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "bankTransactions/:id", layout = MainView.class)
@ViewController("myec_BankTransaction.detail")
@ViewDescriptor("bank-transaction-detail-view.xml")
@EditedEntityContainer("bankTransactionDc")
public class BankTransactionDetailView extends StandardDetailView<BankTransaction> {
}