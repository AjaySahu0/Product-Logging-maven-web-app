package in.ind.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ind.entity.ProductEntity;
import in.ind.repo.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping("/")
	public String loadPage(Model model) {

		model.addAttribute("product", new ProductEntity());
		return "index";

	}

	@PostMapping("/save")
	public String saveProduct(@Validated @ModelAttribute("product") ProductEntity p, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "index";
		}
		p = repo.save(p);
		if (p.getPid() != null) {
			model.addAttribute("msg", "Product saved");
		}
		return "index";

	}

	@GetMapping("/products")
	public String getAllProducts(Model model) {
		List<ProductEntity> list = repo.findAll();
		model.addAttribute("products", list);
		return "data";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("pid") Integer pid, Model model) {
		repo.deleteById(pid);
		model.addAttribute("msg", "product deleted");
		model.addAttribute("products", repo.findAll());
		return "data";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("pid") Integer pid, Model model) {
		Optional<ProductEntity> findById = repo.findById(pid);
		if (findById.isPresent()) {
			ProductEntity product = findById.get();
			model.addAttribute("product", product);
		}
		return "index";
	}

}
