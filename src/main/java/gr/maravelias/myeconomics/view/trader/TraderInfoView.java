package gr.maravelias.myeconomics.view.trader;

import java.util.UUID;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.Trader;
import gr.maravelias.myeconomics.view.invoicesfragment.InvoicesFragment;
import gr.maravelias.myeconomics.view.main.MainView;
import gr.maravelias.myeconomics.view.supplierstransactionsfragment.SuppliersTransactionsFragment;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.Target;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "tradersinfo", layout = MainView.class)
@ViewController("myec_Trader.info")
@ViewDescriptor("trader-info-view.xml")
@DialogMode(width = "64em")
public class TraderInfoView extends StandardListView<Trader> {

    @Autowired
    private InvoicesFragment invoicesFragment;

    @Autowired
    private SuppliersTransactionsFragment transactionsFragment;

    @Subscribe(id = "tradersDc", target = Target.DATA_CONTAINER)
    public void tradersDcItemChange(final InstanceContainer.ItemChangeEvent<Trader> event) {
        if (event.getItem() != null) {

            System.out.println("is not NUlL:"+ event.getItem().getTitle() + " ID:"+event.getItem().getId());

            UUID traderId = event.getItem().getId();
            invoicesFragment.setTraderId(traderId);
            transactionsFragment.setTraderId(traderId);
        }
    }
}

