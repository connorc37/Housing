package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseHelper hh = new HouseHelper();
		String action = request.getParameter("doThisToHouse");
		String path = "/viewAllHousesServlet";
		
		if (action.equals("remove")) {
			try {
				int tmpId = Integer.parseInt(request.getParameter("id"));
				House houseToRemove = hh.findHouseById(tmpId);
				hh.removeHouse(houseToRemove);
			} catch (NumberFormatException e) {
				System.out.println("A house wasn't selected");
			}
		} else if (action.equals("edit")) {
			try {
				int tmpId = Integer.parseInt(request.getParameter("id"));
				House houseToEdit = hh.findHouseById(tmpId);
				request.setAttribute("houseToEdit", houseToEdit);
				path = "/edit-house.jsp";
			} catch (NumberFormatException e) {
				System.out.println("A house wasn't selected");
			}
		} else if (action.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
