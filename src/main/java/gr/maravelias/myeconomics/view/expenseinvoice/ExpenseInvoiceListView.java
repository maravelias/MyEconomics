package gr.maravelias.myeconomics.view.expenseinvoice;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.ExpenseInvoice;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;


@Route(value = "expenseInvoices", layout = MainView.class)
@ViewController("myec_ExpenseInvoice.list")
@ViewDescriptor("expense-invoice-list-view.xml")
@LookupComponent("expenseInvoicesDataGrid")
@DialogMode(width = "64em")
public class ExpenseInvoiceListView extends StandardListView<ExpenseInvoice> {
}