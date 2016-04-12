package com.week.configuration;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.week.view.page.WeekHomepage;

@Configuration
public class WicketApplication extends WebApplication {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void init() {
        super.init();

        getComponentInstantiationListeners().add(new SpringComponentInjector(this, applicationContext));
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return WeekHomepage.class;
    }

}
