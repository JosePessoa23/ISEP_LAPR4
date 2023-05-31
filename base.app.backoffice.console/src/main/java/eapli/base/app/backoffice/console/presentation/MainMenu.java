/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.agv.AssignOrderAction;
import eapli.base.app.backoffice.console.presentation.agv.AutoAssignOrderAction;
import eapli.base.app.backoffice.console.presentation.order.DeliveredOrderAction;
import eapli.base.app.backoffice.console.presentation.order.DispatchOrderAction;
import eapli.base.app.backoffice.console.presentation.survey.RegisterSurveyAction;
import eapli.base.app.backoffice.console.presentation.survey.ShowReportAction;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.app.backoffice.console.presentation.agv.ConfigureAGVAction;
import eapli.base.app.backoffice.console.presentation.customer.RegisterCustomerAction;
import eapli.base.app.backoffice.console.presentation.order.RegisterProduct_OrderAction;
import eapli.base.app.backoffice.console.presentation.product.CreateProductCategoryAction;
import eapli.base.app.backoffice.console.presentation.product.OptionalProductAction;
import eapli.base.app.backoffice.console.presentation.product.ProductAction;
import eapli.base.app.backoffice.console.presentation.product.ViewCatalogAction;
import eapli.base.app.backoffice.console.presentation.warehouse.AddJsonFileAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

//    // SETTINGS
//    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

//    // DISH TYPES
//    private static final int DISH_TYPE_REGISTER_OPTION = 1;
//    private static final int DISH_TYPE_LIST_OPTION = 2;
//    private static final int DISH_TYPE_CHANGE_OPTION = 3;
//    private static final int DISH_TYPE_ACTIVATE_DEACTIVATE_OPTION = 4;
//
//    // DISHES
//    private static final int DISH_REGISTER_OPTION = 5;
//    private static final int DISH_LIST_OPTION = 6;
//    private static final int DISH_REGISTER_DTO_OPTION = 7;
//    private static final int DISH_LIST_DTO_OPTION = 8;
//    private static final int DISH_ACTIVATE_DEACTIVATE_OPTION = 9;
//    private static final int DISH_CHANGE_OPTION = 10;
//
//    // DISH PROPERTIES
//    private static final int CHANGE_DISH_NUTRICIONAL_INFO_OPTION = 1;
//    private static final int CHANGE_DISH_PRICE_OPTION = 2;
//
//    // MATERIALS
//    private static final int MATERIAL_REGISTER_OPTION = 1;
//    private static final int MATERIAL_LIST_OPTION = 2;
//
//    // REPORTING
//    private static final int REPORTING_DISHES_PER_DISHTYPE_OPTION = 1;
//    private static final int REPORTING_HIGH_CALORIES_DISHES_OPTION = 2;
//    private static final int REPORTING_DISHES_PER_CALORIC_CATEGORY_OPTION = 3;
//
//    // MEALS
//    private static final int LIST_MEALS_OPTION = 1;
//    private static final int MEAL_REGISTER_OPTION = 2;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;
//    private static final int DISH_OPTION = 5;
//    private static final int TRACEABILITY_OPTION = 6;
//    private static final int MEALS_OPTION = 7;
//    private static final int REPORTING_DISHES_OPTION = 8;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
//            final Menu settingsMenu = buildAdminSettingsMenu();
//            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.WAREHOUSE_EMPLOYEE)) {
            final Menu usersMenu = buildWarehouseMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALESCLERK)) {
            final Menu usersMenu = buildSalesClerkMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALESMANAGER)) {
            final Menu usersMenu = buildSalesManagerMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

//    private Menu buildAdminSettingsMenu() {
//        final Menu menu = new Menu("Settings >");
//
//        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
//                new ShowMessageAction("Not implemented yet"));
//        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
//
//        return menu;
//    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildWarehouseMenu() {
        final Menu menu = new Menu("Warehouse >");

        menu.addItem(1, "Set up the warehouse plant", new AddJsonFileAction());
        menu.addItem(2, "Configure a AGV", new ConfigureAGVAction());
        menu.addItem(3,"Assign Order",new AssignOrderAction());
        menu.addItem(4,"Auto Assign Order",new AutoAssignOrderAction());
        menu.addItem(5,"Dispatch Order",new DispatchOrderAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesClerkMenu() {
        final Menu menu = new Menu("Sales Clerk >");

        menu.addItem(1, "Specify a new Category", new CreateProductCategoryAction());
        menu.addItem(2,"Specify a new Product", new ProductAction());
        menu.addItem(3,"Insert a optional product's information", new OptionalProductAction());
        menu.addItem(4,"View Catalog", new ViewCatalogAction());
        menu.addItem(5,"Register a new customer", new RegisterCustomerAction());
        menu.addItem(6,"Register a new Order in behalf of a customer", new RegisterProduct_OrderAction());
        menu.addItem(7,"Change order state to Delivered by Carrier", new DeliveredOrderAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesManagerMenu() {
        final Menu menu = new Menu("Sales Manager >");

        menu.addItem(1,"Register Survey",new RegisterSurveyAction());
        menu.addItem(2,"See Report",new ShowReportAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }



}
