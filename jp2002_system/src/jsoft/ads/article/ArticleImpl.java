package jsoft.ads.article;

import java.sql.*;

import jsoft.objects.*;
import jsoft.*;
import jsoft.ads.article.section.*;;

public class ArticleImpl extends SectionImpl implements Article {

	public ArticleImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		//super(cp, "Article");
	}

	@Override
	public boolean addArticle(ArticleObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblarticle(";
		//sql += "article_id, ";
		sql += "article_title, ";
		sql += "article_summary, ";
		sql += "article_content, ";
		sql += "article_created_date, ";
		sql += "article_last_modified, ";
		sql += "article_image, ";
		sql += "article_category_id, ";
		sql += "article_section_id, ";
		sql += "article_visited, ";
		sql += "article_author_name, ";
		sql += "article_enable, ";
		sql += "article_url_link, ";
		sql += "article_tag, ";
		sql += "article_title_en, ";
		sql += "article_summary_en, ";
		sql += "article_content_en, ";
		sql += "article_tag_en, ";
		sql += "article_fee, ";
		sql += "article_isfee, ";
		sql += "article_delete, ";
		sql += "article_deleted_date, ";
		sql += "article_restored_date, ";
		sql += "article_modified_author_name, ";
		sql += "article_author_permission, ";
		sql += "article_source, ";
		sql += "article_language, ";
		sql += "article_focus, ";
		sql += "article_type, ";
		sql += "article_forhome ";
		sql += ") ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sql += "";
		
		//Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			//truyền giá trị
			pre.setString(1, item.getArticle_title());
			pre.setString(2, item.getArticle_summary());
			pre.setString(3, item.getArticle_content());
			pre.setString(4, item.getArticle_created_date());
			pre.setString(5, item.getArticle_last_modified());
			pre.setString(6, item.getArticle_image());
			pre.setShort(7, item.getArticle_category_id());
			pre.setShort(8, item.getArticle_section_id());
			pre.setShort(9, item.getArticle_visited());
			pre.setString(10, item.getArticle_author_name());
			pre.setBoolean(11, item.isArticle_enable());
			pre.setString(12, item.getArticle_url_link());
			pre.setString(13, item.getArticle_tag());
			pre.setString(14, item.getArticle_title_en());
			pre.setString(15, item.getArticle_summary_en());
			pre.setString(16, item.getArticle_content_en());
			pre.setString(17, item.getArticle_tag_en());
			pre.setInt(18, item.getArticle_fee());
			pre.setBoolean(19, item.isArticle_isfee());
			pre.setBoolean(20, item.isArticle_delete());
			pre.setString(21, item.getArticle_deleted_date());
			pre.setString(22, item.getArticle_restored_date());
			pre.setString(23, item.getArticle_modified_author_name());
			pre.setByte(24, item.getArticle_author_permission());
			pre.setString(25, item.getArticle_source());
			pre.setByte(26, item.getArticle_language());
			pre.setBoolean(27, item.isArticle_focus());
			pre.setByte(28, item.getArticle_type());
			pre.setBoolean(29, item.isArticle_forhome());
			
			
			return this.add(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		return false;
	}

	@Override
	public boolean editArticle(ArticleObject item) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE tblarticle SET ";
		
		sql += "article_title=?, ";
		sql += "article_summary=?, ";
		sql += "article_content=?, ";
//		sql += "article_created_date=?, ";
		sql += "article_last_modified=?, ";
		sql += "article_image=?, ";
		sql += "article_category_id=?, ";
		sql += "article_section_id=?, ";
		sql += "article_visited=?, ";
		sql += "article_author_name=?, ";
		sql += "article_enable=?, ";
		sql += "article_url_link=?, ";
		sql += "article_tag=?, ";
		sql += "article_title_en=?, ";
		sql += "article_summary_en=?, ";
		sql += "article_content_en=?, ";
		sql += "article_tag_en=?, ";
		sql += "article_fee=?, ";
		sql += "article_isfee=?, ";
		sql += "article_delete=?, ";
		sql += "article_deleted_date=?, ";
		sql += "article_restored_date=?, ";
		sql += "article_modified_author_name=?, ";
		sql += "article_author_permission=?, ";
		sql += "article_source=?, ";
		sql += "article_language=?, ";
		sql += "article_focus=?, ";
		sql += "article_type=?, ";
		sql += "article_forhome=? ";
		
		sql += "WHERE article_id=?";
		sql += "";
		
		//Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			//truyền giá trị
			pre.setString(1, item.getArticle_title());
			pre.setString(2, item.getArticle_summary());
			pre.setString(3, item.getArticle_content());
			pre.setString(4, item.getArticle_created_date());
			pre.setString(5, item.getArticle_last_modified());
			pre.setString(6, item.getArticle_image());
			pre.setShort(7, item.getArticle_category_id());
			pre.setShort(8, item.getArticle_section_id());
			pre.setShort(9, item.getArticle_visited());
			pre.setString(10, item.getArticle_author_name());
			pre.setBoolean(11, item.isArticle_enable());
			pre.setString(12, item.getArticle_url_link());
			pre.setString(13, item.getArticle_tag());
			pre.setString(14, item.getArticle_title_en());
			pre.setString(15, item.getArticle_summary_en());
			pre.setString(16, item.getArticle_content_en());
			pre.setString(17, item.getArticle_tag_en());
			pre.setInt(18, item.getArticle_fee());
			pre.setBoolean(19, item.isArticle_isfee());
			pre.setBoolean(20, item.isArticle_delete());
			pre.setString(21, item.getArticle_deleted_date());
			pre.setString(22, item.getArticle_restored_date());
			pre.setString(23, item.getArticle_modified_author_name());
			pre.setByte(24, item.getArticle_author_permission());
			pre.setString(25, item.getArticle_source());
			pre.setByte(26, item.getArticle_language());
			pre.setBoolean(27, item.isArticle_focus());
			pre.setByte(28, item.getArticle_type());
			pre.setBoolean(29, item.isArticle_forhome());
			
			pre.setInt(30, item.getArticle_id());
			
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return false;
	}

	@Override
	public boolean delArticle(ArticleObject item) {
		// TODO Auto-generated method stub
		
		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblarticle WHERE article_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getArticle_id());
			
			return this.del(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		return false;
	}
	
	private boolean isEmpty(ArticleObject item) {
		boolean flag = true;
		
		String sql = "SELECT section_id FROM tblsection ";
		sql += "WHERE (article_section_id="+item.getArticle_id()+")";
		
		ResultSet rs = this.gets(sql);
		if(rs!=null) {
			try {
				if(rs.next()) {
					flag = false;
				}
				
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public ResultSet getArticle(int id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblarticle ";
		sql += "LEFT JOIN tblcategory ON article_category_id=category_id ";
		sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
		sql += "WHERE article_id=?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getArticles(ArticleObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblarticle ";
		sql += "LEFT JOIN tblcategory ON article_category_id=category_id ";
		sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
		sql += "";
		sql += "ORDER BY article_id DESC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	public static void main(String[] args) {
		// Tạo đói tượng kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng vào CSDL mức Giao tiếp (interface)
		Article art = new ArticleImpl(cp, "Article");

		// Lấy tập kết quả
		ResultSet rs = art.getArticles(null, 0, (byte) 10);
		
		//Trả lại kết nối
		art.releaseConnection();

		// Duyệt và hiển thị kết quả
		String row;
		if (rs != null) {
			try {
				while (rs.next()) {
					row = "ID: " + rs.getInt("article_id");
					row += "\t\tTITLE: " + rs.getString("article_title");

					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
