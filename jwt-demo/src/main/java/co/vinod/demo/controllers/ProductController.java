package co.vinod.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// http://example.com/api/products
	// http://example.com/api/products?brand=Fresho
	// http://example.com/api/products?category=fruit
	// http://example.com/api/products?brand=Fresho&category=fruit

	//@GetMapping
	public List<Product> filter(
		@RequestParam(name="category", required=false) String category, 
		@RequestParam(name="brand", required = false) String brand) throws DaoException {

		if(category==null && brand==null){
			return dao.getAll();
		}
		else if(category==null) {
			// return dao.getByBrand(brand);
		}
		else if(brand==null){
			// return dao.getByCategory(category);
		}
		else {
			// return dao.getByBrandAndCategory(brand, category);
		}
		return null;
	}

}
