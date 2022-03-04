package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;

/**
 * Servlet implementation class AddHouseServlet
 */
@WebServlet("/addHouseServlet")
public class AddHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		
		House h = new House(street, city, state, zip);
		HouseHelper hh = new HouseHelper();
		hh.addHouse(h);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
