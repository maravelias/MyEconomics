package gr.maravelias.myeconomics.security;

import gr.maravelias.myeconomics.entity.BankAccount;
import gr.maravelias.myeconomics.entity.BankTransaction;
import gr.maravelias.myeconomics.entity.CommonEntity;
import gr.maravelias.myeconomics.entity.ExpenseInvoice;
import gr.maravelias.myeconomics.entity.Trader;
import gr.maravelias.myeconomics.entity.ViewTraderBalances;
import io.jmix.core.entity.KeyValueEntity;
import io.jmix.flowui.entity.filter.FilterCondition;
import io.jmix.flowui.entity.filter.FilterValueComponent;
import io.jmix.flowuidata.entity.FilterConfiguration;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.model.SecurityScope;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "UI: minimal access", code = UiMinimalRole.CODE, scope = SecurityScope.UI)
public interface UiMinimalRole {

    String CODE = "ui-minimal";

    @ViewPolicy(viewIds = {"myec_MainView", "myec_Trader.list", "myec_BankAccount.list", "myec_BankAccount.detail", "flowui_AddConditionView", "flowui_GroupFilterCondition.detail", "flowui_PropertyFilterCondition.detail", "flowui_JpqlFilterCondition.detail", "myec_BankTransaction.list", "myec_BankTransaction.detail", "myec_ExpenseInvoice.list", "myec_ExpenseInvoice.detail", "myec_ViewTraderBalances.list", "myec_SupplierInfoView", "myec_TotalsView"})
    void main();

    @ViewPolicy(viewIds = "myec_LoginView")
    @SpecificPolicy(resources = {"ui.loginToUi", "ui.genericfilter.modifyConfiguration", "ui.genericfilter.modifyGlobalConfiguration", "ui.genericfilter.modifyJpqlCondition"})
    void login();

    @EntityPolicy(entityClass = KeyValueEntity.class, actions = EntityPolicyAction.READ)
    @EntityAttributePolicy(entityClass = KeyValueEntity.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    void keyValueEntity();

    @MenuPolicy(menuIds = {"myec_Trader.list", "myec_BankAccount.list", "myec_BankTransaction.list", "myec_ExpenseInvoice.list", "myec_ViewTraderBalances.list", "myec_SupplierInfoView", "myec_TotalsView"})
    void screens();

    @EntityAttributePolicy(entityClass = Trader.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Trader.class, actions = EntityPolicyAction.ALL)
    void trader();

    @EntityAttributePolicy(entityClass = BankAccount.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = BankAccount.class, actions = EntityPolicyAction.ALL)
    void bankAccount();

    @EntityAttributePolicy(entityClass = FilterConfiguration.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = FilterConfiguration.class, actions = EntityPolicyAction.ALL)
    void filterConfiguration();

    @EntityAttributePolicy(entityClass = FilterCondition.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = FilterCondition.class, actions = EntityPolicyAction.ALL)
    void filterCondition();

    @EntityAttributePolicy(entityClass = FilterValueComponent.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = FilterValueComponent.class, actions = EntityPolicyAction.ALL)
    void filterValueComponent();

    @EntityAttributePolicy(entityClass = BankTransaction.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = BankTransaction.class, actions = EntityPolicyAction.ALL)
    void bankTransaction();

    @EntityAttributePolicy(entityClass = CommonEntity.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = CommonEntity.class, actions = EntityPolicyAction.ALL)
    void commonEntity();

    @EntityAttributePolicy(entityClass = ExpenseInvoice.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = ExpenseInvoice.class, actions = EntityPolicyAction.ALL)
    void expenseInvoice();

    @EntityAttributePolicy(entityClass = ViewTraderBalances.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = ViewTraderBalances.class, actions = EntityPolicyAction.READ)
    void viewTraderBalances();
}
