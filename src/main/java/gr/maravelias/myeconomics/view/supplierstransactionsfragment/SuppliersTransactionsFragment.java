package gr.maravelias.myeconomics.view.supplierstransactionsfragment;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import gr.maravelias.myeconomics.entity.BankTransaction;
import io.jmix.flowui.fragment.Fragment;
import io.jmix.flowui.fragment.FragmentDescriptor;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.Target;
import io.jmix.flowui.view.View;
import io.jmix.flowui.view.ViewComponent;
import java.util.UUID;

@FragmentDescriptor("suppliers-transactions-fragment.xml")
public class SuppliersTransactionsFragment extends Fragment<VerticalLayout> {

  @ViewComponent protected CollectionLoader<BankTransaction> supplierTransactionsDl;

  @Subscribe(target = Target.HOST_CONTROLLER)
  public void onHostBeforeShow(View.BeforeShowEvent event) {

    // supplierTransactionsDl.load();
  }

  public void setTraderId(UUID traderId) {
    supplierTransactionsDl.setParameter("traderId", traderId);
    supplierTransactionsDl.load();
  }
}
