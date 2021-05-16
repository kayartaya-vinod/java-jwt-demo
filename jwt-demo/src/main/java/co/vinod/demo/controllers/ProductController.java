package co.vinod.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.vinod.demo.dao.DaoException;
import co.vinod.demo.dao.ProductDao;
import co.vinod.demo.entity.Product;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

	ProductDao dao = new ProductDao();

	@GetMapping
	public List<Product> getAllProducts() throws DaoException {
		return dao.getAll();
	}

	@GetMapping("/{id}")
	public Product getOneProduct(@PathVariable Integer id) throws DaoException {
		return dao.getById(id);
	}

}
