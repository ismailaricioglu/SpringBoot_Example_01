package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

//public interface BrandDao { ya da aşağıdaki yazım ile
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	// NOT: JpaRepository ile Somut sınıf otomatik yaratılmakta (auto generate)
}
