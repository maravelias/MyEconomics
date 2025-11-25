package gr.maravelias.myeconomics.view.invoicesfragment;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import gr.maravelias.myeconomics.entity.ExpenseInvoice;
import io.jmix.flowui.fragment.Fragment;
import io.jmix.flowui.fragment.FragmentDescriptor;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.Target;
import io.jmix.flowui.view.View;
import io.jmix.flowui.view.ViewComponent;
import java.util.UUID;

@FragmentDescriptor("invoices-fragment.xml")
public class InvoicesFragment extends Fragment<VerticalLayout> {

  @ViewComponent protected CollectionLoader<ExpenseInvoice> expenseInvoicesDl;

  @Subscribe(target = Target.HOST_CONTROLLER)
  public void onHostBeforeShow(View.BeforeShowEvent event) {

    // expenseInvoicesDl.load();
  }

  public void setTraderId(UUID traderId) {
    expenseInvoicesDl.setParameter("traderId", traderId);
    expenseInvoicesDl.load();
  }
}
