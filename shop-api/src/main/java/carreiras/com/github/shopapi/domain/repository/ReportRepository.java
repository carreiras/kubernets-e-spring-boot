package carreiras.com.github.shopapi.domain.repository;

import carreiras.com.github.shopapi.domain.entity.Shop;
import carreiras.com.github.shopapi.rest.dto.ShopReportDTO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository {

    List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
