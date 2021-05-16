package co.vinod.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.vinod.demo.entity.Product;

public class ProductDao {

	public Product getById(Integer id) throws DaoException {
		String url = "jdbc:mysql://localhost/batch5";
		String user = "root";
		String password = "Welcome#123";

		String sql = "select * from products where id = " + id;

		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			rs.next();
			return resultSetToProduct(rs);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	public List<Product> getAll() throws DaoException {
		List<Product> list = new ArrayList<>();
		String url = "jdbc:mysql://localhost/batch5";
		String user = "root";
		String password = "Welcome#123";

		String sql = "select * from products";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				list.add(resultSetToProduct(rs));
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return list;
	}

	Product resultSetToProduct(ResultSet rs) throws SQLException {
		Product p = new Product();

		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setDescription(rs.getString("description"));
		p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
		p.setPicture(rs.getString("picture"));
		p.setUnitPrice(rs.getDouble("unit_price"));
		p.setDiscount(rs.getDouble("discount"));
		p.setBrand(rs.getString("brand"));
		p.setCategory(rs.getString("category"));
		return p;
	}

	public static void main(String[] args) throws Exception {
		new ProductDao().getAll().stream().forEach(System.out::println);
	}
}
