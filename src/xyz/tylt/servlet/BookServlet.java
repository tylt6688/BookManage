package xyz.tylt.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.tylt.domain.Book;
import xyz.tylt.service.BookService;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,UTF-8");
		request.setCharacterEncoding("utf-8");//必须设置，否则插入到数据库的中文乱码
		String method = request.getParameter("method");
		if("findAll".equals(method)){
			findAll(request,response);
		}else if("addBook".equals(method)){
			addBook(request,response);
		}else if("updateBook".equals(method)){
			updateBook(request,response);
		}else if("deleteBook".equals(method)){
			deleteBook(request,response);
		}
	}

	private void deleteBook(HttpServletRequest request,
			HttpServletResponse response) {
		String bookid = request.getParameter("bookid");
		Book bk = new Book();
		bk.setBookid(bookid);
		BookService bs = new BookService();
		int rtn = 0;
		try {
			rtn = bs.deleteBook(bk);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String result;
		if(rtn>0){
			result = "删除成功！";
		}else{
			result = "删除失败！";
		}
		request.setAttribute("result", result);
		try {
			request.getRequestDispatcher("deleteBook.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void updateBook(HttpServletRequest request,
			HttpServletResponse response) {
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		Book bk = new Book();
		bk.setBookid(bookid);
		bk.setBookname(bookname);
		bk.setAuthor(author);
		bk.setPrice(price);
		BookService bs = new BookService();
		int rtn = 0;
		try {
			rtn = bs.updateBook(bk);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String result;
		if(rtn>0){
			result = "修改成功！";
		}else{
			result = "修改失败！";
		}
		request.setAttribute("result", result);
		try {
			request.getRequestDispatcher("updateBook.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		Book bk = new Book();
		bk.setBookid(bookid);
		bk.setBookname(bookname);
		bk.setAuthor(author);
		bk.setPrice(price);
		BookService bs = new BookService();
		int rtn = 0;
		try {
			rtn = bs.addBook(bk);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String result;
		if(rtn>0){
			result = "插入成功！";
		}else{
			result = "插入失败！";
		}
		request.setAttribute("result", result);
		try {
			request.getRequestDispatcher("addBook.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) {
		List<Book> lb = null;
		BookService bs = new BookService();
		try {
			lb = bs.findAll();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		request.setAttribute("books", lb);
		try {
			request.getRequestDispatcher("dispAll.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
