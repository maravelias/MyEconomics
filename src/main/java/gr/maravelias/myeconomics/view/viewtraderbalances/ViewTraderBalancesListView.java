package gr.maravelias.myeconomics.view.viewtraderbalances;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.ViewTraderBalances;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import io.jmix.core.Messages;
import io.jmix.flowui.view.Supply;


@Route(value = "viewTraderBalanceses", layout = MainView.class)
@ViewController("myec_ViewTraderBalances.list")
@ViewDescriptor("view-trader-balances-list-view.xml")
@LookupComponent("viewTraderBalancesesDataGrid")
@DialogMode(width = "64em")
public class ViewTraderBalancesListView extends StandardListView<ViewTraderBalances> {

    @Autowired
    protected UiComponents uiComponents;
    @Autowired
    protected Messages messages;

    @Supply(to = "viewTraderBalancesesDataGrid.risk", subject = "renderer")
    protected Renderer<ViewTraderBalances> statusComponentRenderer() {
        return new ComponentRenderer<>(this::createGradeComponent, this::gradeComponentUpdater);
    }

    protected Span createGradeComponent() {
        Span span = uiComponents.create(Span.class);
        span.getElement().getThemeList().add("badge");

        return span;
    }

    protected void gradeComponentUpdater(Span span, ViewTraderBalances vtb) {
        if (vtb.getRisk() != null) {

            span.setText(messages.getMessage(ViewTraderBalances.class, vtb.getRisk()));

            switch (vtb.getRisk()) {
                case "High Risk":
                    span.getElement().getThemeList().add("badge error");
                    break;
                case "Normal":
                    span.getElement().getThemeList().add("badge normal");
                    break;
                case "No risk":
                    span.getElement().getThemeList().add("badge success");
                    break;
                default:
                    // Optional: handle any unexpected values
                    throw new IllegalStateException("Unexpected value: " + vtb.getRisk());
            }

        } else {
            span.setText("No data");
        }
    }

}