package com.springapp.mvc;

import com.vaadin.addon.sqlcontainer.SQLContainer;
import com.vaadin.addon.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.addon.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.addon.sqlcontainer.query.FreeformQuery;
import com.vaadin.annotations.Title;
import com.vaadin.data.Container;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import java.sql.SQLException;

@Title("Home")
public class Home extends UI {

    protected void init(VaadinRequest request) {
        Container data;
        final VerticalLayout layout = new VerticalLayout();
        final Window win =new Window("Welcome");
        layout.setMargin(true);
        setContent(layout);
        layout.setSizeFull();

       // data=database();
       // System.out.println("Size=="+data.size());
        final VerticalLayout subContent = new VerticalLayout();
        subContent.setMargin(true);
        win.setContent(subContent);

        trial content = new trial();
     /*   content.table_1.setContainerDataSource(data);
        content.table_1.setSizeFull();
        content.loginForm_2.addLoginListener(new LoginForm.LoginListener() {
            @Override
            public void onLogin(LoginForm.LoginEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.

                String pass=event.getLoginParameter("password");
                String Username= event.getLoginParameter("username")   ;

                subContent.addComponent(new Label("Password:"+pass));
                subContent.addComponent(new Label("Username:"+Username));
                win.center();

                // Open it in the UI
                addWindow(win);
            }
        });*/
        layout.addComponent(content);   
    }

    public Container database() {
        //To change body of created methods use File | Settings | File Templates.
        SQLContainer container = null;
        try {
            JDBCConnectionPool connectionPool = new SimpleJDBCConnectionPool(
                    "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/openmrs",
                    "root", "kipchir", 2, 2);
            System.out.println("database Loaded");

            //SQLContainer container = new SQLContainer(new FreeformQuery());
            //  TableQuery tq = new TableQuery("dataset", connectionPool);
            FreeformQuery query = new FreeformQuery("SELECT * FROM dataset",connectionPool);
            container  = new SQLContainer( query );


        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return container;
    }
}


