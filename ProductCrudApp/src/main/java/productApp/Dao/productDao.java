package productApp.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productApp.Model.Product;

@Component
public class productDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct( Product product ) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	public List<Product> getProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	@Transactional
	public void deleteProduct( int product_id ) {
		Product p = this.hibernateTemplate.load(Product.class, product_id);
		this.hibernateTemplate.delete(p);
	}
	
	public Product getProduct( int product_id ) {
		return this.hibernateTemplate.load(Product.class, product_id);
	}
}
