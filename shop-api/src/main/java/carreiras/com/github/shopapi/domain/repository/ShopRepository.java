package carreiras.com.github.shopapi.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import carreiras.com.github.shopapi.domain.entity.Shop;
import carreiras.com.github.shopapi.rest.dto.ShopReportDTO;

public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    List<Shop> findAllByDateShopGreaterThanEqual(Date date);

    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(Float total);
}
