package productApp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productApp.Dao.productDao;
import productApp.Model.Product;

@Controller
public class MainController {

	@Autowired
	private productDao pdao;
	
	@RequestMapping("/")
	public String home( Model m ) {
		List<Product> products = this.pdao.getProducts();
		m.addAttribute("products",products);
		return "index"; 
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	@RequestMapping(value="/handle-product",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		pdao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.pdao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+ "/");
		return redirectView;
	}
	
	@RequestMapping("/update/{pId}")
	public String updateProduct(@PathVariable("pId") int pId,Model m) {
		Product p = this.pdao.getProduct(pId);
		m.addAttribute("product",p);
		return "update_form"; 
	}
	
}
