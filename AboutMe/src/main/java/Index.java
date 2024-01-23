

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet ("/Index")
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

	        // Tạo nội dung phản hồi
	        String myInfo = "<html><body>"
	                + "<h2>Thông tin cá nhân của tôi</h2>"
	                + "<p>Họ tên: Phung Nguyen Anh Thu</p>"
	                + "<p>Ngày sinh: 01-01-2001</p>"
	                + "<p>Quê quán: Nha Trang</p>"
	                + "</body></html>";

	        // Gửi phản hồi với thông tin cá nhân
	        response.getWriter().println(myInfo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

        // Lấy thông tin từ client
        String newName = request.getParameter("name");
        String newBirthDate = request.getParameter("birthDate");
        String newHometown = request.getParameter("hometown");

        // Tạo nội dung phản hồi dựa trên thông tin mới
        String updatedInfo = "<html><body>"
                + "<h2>Thông tin cá nhân được cập nhật</h2>"
                + "<p>Họ tên: " + newName + "</p>"
                + "<p>Ngày sinh: " + newBirthDate + "</p>"
                + "<p>Quê quán: " + newHometown + "</p>"
                + "</body></html>";

        // Gửi phản hồi với thông tin cá nhân cập nhật
        response.getWriter().println(updatedInfo);
	}

}
