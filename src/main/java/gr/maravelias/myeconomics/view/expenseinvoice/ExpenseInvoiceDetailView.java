package gr.maravelias.myeconomics.view.expenseinvoice;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.ExpenseInvoice;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "expenseInvoices/:id", layout = MainView.class)
@ViewController("myec_ExpenseInvoice.detail")
@ViewDescriptor("expense-invoice-detail-view.xml")
@EditedEntityContainer("expenseInvoiceDc")
public class ExpenseInvoiceDetailView extends StandardDetailView<ExpenseInvoice> {}
