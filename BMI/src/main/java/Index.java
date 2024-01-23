

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Index
 */

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Index() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        response.getWriter().println("<html><body>"
                + "<h2>Chỉ số BMI - Body Mass Index</h2>"
                + "<form method='post' action='BMI'>"
                + "   Chiều cao (m): <input type='text' name='height'><br>"
                + "   Cân nặng (kg): <input type='text' name='weight'><br>"
                + "   <input type='submit' value='Submit'>"
                + "</form>"
                + "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Lấy dữ liệu từ client
        String heightStr = request.getParameter("height");
        String weightStr = request.getParameter("weight");

        // Chuyển đổi dữ liệu thành số
        double height = Double.parseDouble(heightStr);
        double weight = Double.parseDouble(weightStr);

        // Tính toán chỉ số BMI
        double bmi = calculateBMI(height, weight);

        // Gửi trả thông tin cần thiết
        response.setContentType("text/html");
        response.getWriter().println("<html><body>"
                + "<h2>Kết quả BMI</h2>"
                + "<p>Chiều cao: " + height + " m</p>"
                + "<p>Cân nặng: " + weight + " kg</p>"
                + "<p>Chỉ số BMI: " + bmi + "</p>"
                + "</body></html>");
	}
	
	 private double calculateBMI(double height, double weight) {
	        // Tính toán chỉ số BMI: BMI = weight / (height * height)
	        return weight / (height * height);
	    }

}
