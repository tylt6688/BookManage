package xyz.tylt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.tylt.domain.Book;
import xyz.tylt.utils.JDBCUtils;

public class BookDao {

	public List<Book> findAll() throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select bookid,bookname,author,price from book";
		ResultSet rs = stmt.executeQuery(sql);
		List<Book> lb = new ArrayList<Book>();
		while(rs.next()){
			Book bk = new Book();
			bk.setBookid(rs.getString("bookid"));
			bk.setBookname(rs.getString("bookname"));
			bk.setAuthor(rs.getString("author"));
			bk.setPrice(rs.getInt("price"));
			lb.add(bk);
		}
		JDBCUtils.release(rs, stmt, conn);
		return lb;
	}

	public int addBook(Book bk) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		String sql="insert into book(bookid,bookname,author,price) "
				+ "values("//双引号引起来的内容是sql语句
				+"'"
				+bk.getBookid()
				+"',"//引起单引号和逗号，节省
				+"'"
				+ bk.getBookname()
				+"',"
				+"'"
				+ bk.getAuthor()
				+"',"
				+ bk.getPrice()//函数返回值为int不需要引用
				+")";
		int rtn = stmt.executeUpdate(sql);
		JDBCUtils.release(rs, stmt, conn);
		return rtn;
	}

	public int updateBook(Book bk) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		String sql="update book set bookname='"
				+ bk.getBookname()
				+"',author='"
				+ bk.getAuthor()
				+"',price="
				+ bk.getPrice()//函数返回值为int不需要引用
				+" where bookid='"
				+bk.getBookid()
				+"'";
		int rtn = stmt.executeUpdate(sql);
		JDBCUtils.release(rs, stmt, conn);
		return rtn;
	}

	public int deleteBook(Book bk) throws SQLException {
		Connection conn = JDBCUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		String sql="delete from book where bookid='"
				+ bk.getBookid()
				+"'";
		int rtn = stmt.executeUpdate(sql);
		JDBCUtils.release(rs, stmt, conn);
		return rtn;
	}
}