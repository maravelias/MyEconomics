package gr.maravelias.myeconomics.view.supplierinfo;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.Trader;
import gr.maravelias.myeconomics.view.invoicesfragment.InvoicesFragment;
import gr.maravelias.myeconomics.view.main.MainView;
import gr.maravelias.myeconomics.view.supplierstransactionsfragment.SuppliersTransactionsFragment;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.Target;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import java.util.UUID;

@Route(value = "supplier-info-view", layout = MainView.class)
@ViewController("myec_SupplierInfoView")
@ViewDescriptor("supplier-info-view.xml")
public class SupplierInfoView extends StandardView {

  @ViewComponent private InvoicesFragment suppliersInvoicesFragment;

  @ViewComponent private SuppliersTransactionsFragment suppliersTransactionsFragment;

  @Subscribe(id = "tradersDc", target = Target.DATA_CONTAINER)
  public void tradersDcItemChange(final InstanceContainer.ItemChangeEvent<Trader> event) {
    if (event.getItem() != null) {

      System.out.println(
          "is not NUlL:" + event.getItem().getTitle() + " ID:" + event.getItem().getId());

      UUID traderId = event.getItem().getId();
      suppliersInvoicesFragment.setTraderId(traderId);
      suppliersTransactionsFragment.setTraderId(traderId);
    }
  }
}
