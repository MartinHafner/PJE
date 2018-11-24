package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fh.albsig.hafnerm1.weatherapp.OWMProvider;

/**
 * Servlet implementation class WeatherServlet.
 */
public class WeatherServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public final void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        final PrintWriter out = response.getWriter();
        final OWMProvider provider = new OWMProvider();
        out.println(provider.provideWeather(request.getParameter("id")));
        out.flush();
        out.close();
    }

}
