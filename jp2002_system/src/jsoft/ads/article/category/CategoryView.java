package jsoft.ads.article.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsoft.objects.*;
import jsoft.*;


/**
 * Servlet implementation class View
 */
@WebServlet("/category/view")
public class CategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Tham chiếu phiên làm việc để tìm thông tin đăng nhập
		HttpSession session = request.getSession();

		// Tim thông tin đăng nhập trong phiên làm việc
		UserObject user = (UserObject) session.getAttribute("userLogined");

		// Kiểm tra
		if (user != null) {
			view(request, response);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}

	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();

		// Tìm header và include
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"col-md-10\">");
		out.print("<div class=\"row mt-flex\">");
		out.print("<div class=\"col-md-9\">");
		out.print("<nav aria-label=\"breadcrumb\">");
		out.print("<ol class=\"breadcrumb\">");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/view\">Dashboard</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/article/view\">Bài viết</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/category/view\">Chuyên mục</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">Danh sách</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("<div class=\"col-md-3 mysearch\">");
		out.print("<form class=\"form-inline\">");
		out.print("<div class=\"form-group\">");
		out.print("<label for=\"inputKeyword\">Tìm kiếm</label>&nbsp;");
//		out.print("<input type=\"text\" id=\"inputKeyword\" class=\"form-control mx-sm-3\" aria-describedby=\"keywordHelpInline\" placeholder=\"Từ khóa\">");
		out.print("<input type=\"text\" id=\"inputKeyword\" class=\"form-control\" aria-describedby=\"keywordHelpInline\" placeholder=\"Từ khóa\">");
		out.print("</div>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");
		
		//Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
		//Tạo đối tượng thực thi chức năng
		CategoryControl cc = new CategoryControl(cp, "Category");

		// Lấy cấu trúc trình bày
		String view = cc.viewCategories(null, (short)1, (byte)10);
		
		//Trả lại kết nối
		cc.releaseConnection();
		
		
		out.print("<div class=\"view\">"+view+"</div>");
		
		out.print("</div>");
		out.print("</div>");
		
		out.print("</div>");
		out.print("</div>");

		// Tìm footer và include
		RequestDispatcher f = request.getRequestDispatcher("/footer");
		if (f != null) {
			f.include(request, response);
		}

		// Đóng đối tượng xuất
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
