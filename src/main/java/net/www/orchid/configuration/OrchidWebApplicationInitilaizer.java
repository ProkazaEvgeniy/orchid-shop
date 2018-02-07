package net.www.orchid.configuration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import net.www.orchid.listener.ApplicationListener;


public class OrchidWebApplicationInitilaizer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext ctx = createWebApplicationContext(servletContext);

		servletContext.addListener(ctx.getBean(ApplicationListener.class));
		
		registerFilters(servletContext, ctx);
		
		registerSpringMVCDispatcherServlet(servletContext, ctx);
	}

	private WebApplicationContext createWebApplicationContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan("net.www.orchid.configuration");
		ctx.setServletContext(servletContext);
		ctx.refresh();
		return ctx;
	}
	
	private void registerFilters(ServletContext servletContext, WebApplicationContext ctx) {
		registerFilter(servletContext, new CharacterEncodingFilter("UTF-8", true));
		registerFilter(servletContext, buildConfigurableSiteMeshFilter(), "sitemesh");
		
	}
	
	private ConfigurableSiteMeshFilter buildConfigurableSiteMeshFilter() {
		return new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder
					.addDecoratorPath("/*",          "/WEB-INF/template/page-template.jsp")
					.addDecoratorPath("/fragment/*", "/WEB-INF/template/fragment-template.jsp")
					.addTagRuleBundle(new Sm2TagRuleBundle());
			}
		};
	}

	private void registerFilter(ServletContext servletContext, Filter filter, String... filterNames) {
		String filterName = filterNames.length > 0 ? filterNames[0] : filter.getClass().getSimpleName();
		servletContext.addFilter(filterName, filter).addMappingForUrlPatterns(null, true, "/*");
	}

	
	private void registerSpringMVCDispatcherServlet(ServletContext container, WebApplicationContext ctx) {
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
