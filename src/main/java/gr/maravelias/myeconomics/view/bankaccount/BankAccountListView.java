package gr.maravelias.myeconomics.view.bankaccount;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.BankAccount;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;


@Route(value = "bankAccounts", layout = MainView.class)
@ViewController("myec_BankAccount.list")
@ViewDescriptor("bank-account-list-view.xml")
@LookupComponent("bankAccountsDataGrid")
@DialogMode(width = "64em")
public class BankAccountListView extends StandardListView<BankAccount> {
}