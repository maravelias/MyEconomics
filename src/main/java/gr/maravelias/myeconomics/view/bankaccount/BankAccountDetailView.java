package gr.maravelias.myeconomics.view.bankaccount;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.BankAccount;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "bankAccounts/:id", layout = MainView.class)
@ViewController("myec_BankAccount.detail")
@ViewDescriptor("bank-account-detail-view.xml")
@EditedEntityContainer("bankAccountDc")
public class BankAccountDetailView extends StandardDetailView<BankAccount> {
}