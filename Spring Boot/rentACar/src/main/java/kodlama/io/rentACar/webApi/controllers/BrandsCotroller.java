package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandRespose;

@RestController // annotation - bilgilendirme
@RequestMapping("/api/brands") // adresleme
public class BrandsCotroller {
	private BrandService brandService;

	@Autowired
	public BrandsCotroller(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandRespose> getAll(){
		return brandService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
}
