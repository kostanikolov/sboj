package app.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({
		"/views/home.jsf",
		"/views/add-job.jsf",
		"/views/job-details.jsf",
		"/views/delete-job.jsf"
})
public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String isLogged = (String) ((HttpServletRequest) request)
				.getSession()
				.getAttribute("username");

		if (isLogged == null) {
			((HttpServletResponse)response).sendRedirect("/views/login.jsf");
			return;
		}

		chain.doFilter(request, response);
	}
}
