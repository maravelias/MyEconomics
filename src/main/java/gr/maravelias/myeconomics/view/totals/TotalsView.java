package gr.maravelias.myeconomics.view.totals;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "totals-view", layout = MainView.class)
@ViewController(id = "myec_TotalsView")
@ViewDescriptor(path = "totals-view.xml")
public class TotalsView extends StandardView {}
