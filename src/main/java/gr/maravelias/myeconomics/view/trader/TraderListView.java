package gr.maravelias.myeconomics.view.trader;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.Trader;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.core.validation.group.UiCrossFieldChecks;
import io.jmix.flowui.component.textarea.JmixTextArea;
import io.jmix.flowui.component.validation.ValidationErrors;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.DataContext;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.model.InstanceLoader;
import io.jmix.flowui.view.DialogMode;
import io.jmix.flowui.view.LookupComponent;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.Subscribe;
import io.jmix.flowui.view.Target;
import io.jmix.flowui.view.ViewComponent;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import io.jmix.flowui.view.ViewValidation;

@Route(value = "traders", layout = MainView.class)
@ViewController("myec_Trader.list")
@ViewDescriptor("trader-list-view.xml")
@LookupComponent("tradersDataGrid")
@DialogMode(width = "64em")
public class TraderListView extends StandardListView<Trader> {

    @ViewComponent
    private DataContext dataContext;

    @ViewComponent
    private CollectionContainer<Trader> tradersDc;

    @ViewComponent
    private InstanceContainer<Trader> traderDc;

    @ViewComponent
    private InstanceLoader<Trader> traderDl;

    @ViewComponent
    private VerticalLayout listLayout;

    @ViewComponent
    private FormLayout form;

    @ViewComponent
    private HorizontalLayout detailActions;

    @ViewComponent
    private JmixTextArea notesField ;

    @Subscribe
    public void onInit(final InitEvent event) {
        notesField.getStyle().set("resize", "both");
        notesField.getStyle().set("overflow", "auto");
        updateControls(false);
    }

    @Subscribe("tradersDataGrid.create")
    public void onTradersDataGridCreate(final ActionPerformedEvent event) {
        dataContext.clear();
        Trader entity = dataContext.create(Trader.class);
        traderDc.setItem(entity);
        updateControls(true);
    }

    @Subscribe("tradersDataGrid.edit")
    public void onTradersDataGridEdit(final ActionPerformedEvent event) {
        updateControls(true);
    }

    @Subscribe("saveBtn")
    public void onSaveButtonClick(final ClickEvent<JmixButton> event) {
        Trader item = traderDc.getItem();
        ValidationErrors validationErrors = validateView(item);
        if (!validationErrors.isEmpty()) {
            ViewValidation viewValidation = getViewValidation();
            viewValidation.showValidationErrors(validationErrors);
            viewValidation.focusProblemComponent(validationErrors);
            return;
        }
        dataContext.save();
        tradersDc.replaceItem(item);
        updateControls(false);
    }

    @Subscribe("cancelBtn")
    public void onCancelButtonClick(final ClickEvent<JmixButton> event) {
        dataContext.clear();
        traderDl.load();
        updateControls(false);
    }

    @Subscribe(id = "tradersDc", target = Target.DATA_CONTAINER)
    public void onTradersDcItemChange(final InstanceContainer.ItemChangeEvent<Trader> event) {
        Trader entity = event.getItem();
        dataContext.clear();
        if (entity != null) {
            traderDl.setEntityId(entity.getId());
            traderDl.load();
        } else {
            traderDl.setEntityId(null);
            traderDc.setItem(null);
        }
    }

    protected ValidationErrors validateView(Trader entity) {
        ViewValidation viewValidation = getViewValidation();
        ValidationErrors validationErrors = viewValidation.validateUiComponents(form);
        if (!validationErrors.isEmpty()) {
            return validationErrors;
        }
        validationErrors.addAll(viewValidation.validateBeanGroup(UiCrossFieldChecks.class, entity));
        return validationErrors;
    }

    private void updateControls(boolean editing) {
        form.getChildren().forEach(component -> {
            if (component instanceof HasValueAndElement<?, ?> field) {
                field.setReadOnly(!editing);
            }
        });

        detailActions.setVisible(editing);
        listLayout.setEnabled(!editing);
    }

    private ViewValidation getViewValidation() {
        return getApplicationContext().getBean(ViewValidation.class);
    }
}