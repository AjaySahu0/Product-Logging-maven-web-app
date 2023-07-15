package in.ind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ind.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
