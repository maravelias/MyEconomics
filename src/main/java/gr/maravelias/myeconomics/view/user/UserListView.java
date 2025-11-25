package gr.maravelias.myeconomics.view.user;

import com.vaadin.flow.router.Route;
import gr.maravelias.myeconomics.entity.User;
import gr.maravelias.myeconomics.view.main.MainView;
import io.jmix.flowui.view.*;

@Route(value = "users", layout = MainView.class)
@ViewController("myec_User.list")
@ViewDescriptor("user-list-view.xml")
@LookupComponent("usersDataGrid")
@DialogMode(width = "64em")
public class UserListView extends StandardListView<User> {}
