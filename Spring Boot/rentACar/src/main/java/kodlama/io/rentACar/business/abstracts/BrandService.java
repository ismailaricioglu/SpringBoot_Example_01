package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandRespose;

public interface BrandService {
	List<GetAllBrandRespose> getAll();
	void add(CreateBrandRequest createBrandRequest);
}
