package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandRespose;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

//public class BrandService { ya da aşağıdaki gibi olabilir
@Service // Bu sınıf bir Business nesnesidir - IoC ye ekliyor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	
	@Autowired // yeni spring boot ile yazılmasa dahi otomatik çalışıyor
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<GetAllBrandRespose> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandRespose> brandRespose = new ArrayList<GetAllBrandRespose>();
		for(Brand brand:brands) {
			GetAllBrandRespose resposeItem = new GetAllBrandRespose();
			resposeItem.setId(brand.getId());
			resposeItem.setName(brand.getName());
			brandRespose.add(resposeItem);
		}
		// iş kuralları
		return brandRespose;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		Brand brand =  new Brand();
		brand.setName(createBrandRequest.getName());
		
		this.brandRepository.save(brand);		
	}

}
