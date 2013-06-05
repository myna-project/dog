/**
 * 
 */
package it.polito.elite.dog.web.admin.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bonino
 * 
 */
public class StatusServlet extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public StatusServlet()
	{
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.include(req, resp,"template?part=" + TemplatePartEnum.HEADER);
		
		StringBuffer responseBuffer = new StringBuffer();
		responseBuffer.append("\t\t<div class=\"navbar\">\n");
		responseBuffer.append("\t\t\t<div class=\"navbar-inner\">\n");
		responseBuffer.append("\t\t\t\t<div class=\"container\">\n");
		responseBuffer.append("\t\t\t\t\t<a class=\"brand\" href=\"#\">Domotic OSGi Gateway</a>\n");
		responseBuffer.append("\t\t\t\t\t<ul class=\"nav pull-right\">\n");
		responseBuffer.append("\t\t\t\t\t\t<li><a href=\"#\">Login</a></li>\n");
		responseBuffer.append("\t\t\t\t\t</ul>\n");
		responseBuffer.append("\t\t\t\t</div>\n");
		responseBuffer.append("\t\t\t</div>\n");
		responseBuffer.append("\t\t</div>\n");
		responseBuffer.append("\t\t<!-- Body views -->\n");
		responseBuffer.append("\t\t<div class=\"container-fluid\">\n");
		responseBuffer.append("\t\t\t<!-- Content -->\n");
		responseBuffer.append("\t\t\t<div class=\"row-fluid\">\n");
		responseBuffer.append("\t\t\t\t<div class=\"span12\">\n");
		responseBuffer.append("\t\t\t\t\t<ul class=\"nav nav-tabs\">\n");
		responseBuffer.append("\t\t\t\t\t\t<li class=\"active\">\n");
		responseBuffer.append("\t\t\t\t\t\t\t<a href=\"#\">Status</a>\n");
		responseBuffer.append("\t\t\t\t\t\t</li>\n");
		responseBuffer.append("\t\t\t\t\t\t<li><a href=\"#\">Monitor</a></li>\n");
		responseBuffer.append("\t\t\t\t\t\t<li><a href=\"#\">...</a></li>\n");
		responseBuffer.append("\t\t\t\t\t</ul>\n");
		responseBuffer.append("\t\t\t\t</div>\n");
		responseBuffer.append("\t\t\t</div>\n");
		responseBuffer.append("\t\t\t<div class=\"row-fluid\">\n");
		responseBuffer.append("\t\t\t\t<div class=\"span6\">\n");
		responseBuffer.append("\t\t\t\t\t<div class=\"well\">\n");
		responseBuffer
				.append("\t\t\t\t\t\t<p>Dog status: <span class=\"label label-success pull-right\">Running</span></p>\n");
		responseBuffer.append("\t\t\t\t\t\t<p>System memory: <span data-load=\"ajax\" data-src=\"services/system/memory/runtime\" data-refresh=\"1000\"></span></p>\n");
		responseBuffer.append("\t\t\t\t\t\t<p>Current memory usage: <span data-load=\"ajax\" data-src=\"services/system/memory/used\" data-refresh=\"1000\"></span></p>\n");
		responseBuffer.append("\t\t\t\t\t\t<p>Free memory: <span data-load=\"ajax\" data-src=\"services/system/memory/free\" data-refresh=\"1000\"></span></p>\n");
		responseBuffer.append("\t\t\t\t\t</div>\n");
		responseBuffer.append("\t\t\t\t</div>\n");
		responseBuffer.append("\t\t\t\t<div class=\"span6\">\n");
		responseBuffer.append("\t\t\t\t\t<div class=\"well\" data-load=\"ajax\" data-src=\"services/system/bundles\" data-refresh=\"1000\">\n");
		responseBuffer.append("\t\t\t\t\t\t<p>Loading system bundles...</p>");
		responseBuffer.append("\t\t\t\t\t</div>\n");
		responseBuffer.append("\t\t\t\t</div>\n");
		responseBuffer.append("\t\t\t</div>\n");
		responseBuffer.append("\t\t\t<div class=\"row-fluid\">\n");
		responseBuffer.append("\t\t\t\t<div class=\"span12\">\n");
		responseBuffer.append("\t\t\t\t\t<!-- Footer -->\n");
		responseBuffer.append("\t\t\t\t</div>\n");
		responseBuffer.append("\t\t\t</div>\n");
		responseBuffer.append("\t\t</div>\n");
		
		resp.getOutputStream().println(responseBuffer.toString());
		
		this.include(req, resp,"template?part=" + TemplatePartEnum.FOOTER);
	}
	
	private void include(HttpServletRequest req, HttpServletResponse resp, String pathToInclude) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = req.getRequestDispatcher(pathToInclude);
		dispatcher.include(req, resp);
	}
}
