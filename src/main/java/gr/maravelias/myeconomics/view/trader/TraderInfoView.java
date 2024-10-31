package gr.maravelias.myeconomics.view.trader;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.Trader;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;


@Route(value = "tradersinfo", layout = MainView.class)
@ViewController("myec_Trader.info")
@ViewDescriptor("trader-info-view.xml")
@LookupComponent("tradersDataGrid")
@DialogMode(width = "64em")
public class TraderInfoView extends StandardListView<Trader> {


}