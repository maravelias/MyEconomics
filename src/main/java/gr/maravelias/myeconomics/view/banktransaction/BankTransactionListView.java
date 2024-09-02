package gr.maravelias.myeconomics.view.banktransaction;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.BankTransaction;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;


@Route(value = "bankTransactions", layout = MainView.class)
@ViewController("myec_BankTransaction.list")
@ViewDescriptor("bank-transaction-list-view.xml")
@LookupComponent("bankTransactionsDataGrid")
@DialogMode(width = "64em")
public class BankTransactionListView extends StandardListView<BankTransaction> {
}