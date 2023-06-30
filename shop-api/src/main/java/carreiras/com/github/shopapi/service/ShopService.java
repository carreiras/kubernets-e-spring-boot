package carreiras.com.github.shopapi.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import carreiras.com.github.shopapi.domain.entity.Shop;
import carreiras.com.github.shopapi.domain.repository.ShopRepository;
import carreiras.com.github.shopapi.exception.ResourceNotFoundException;
import carreiras.com.github.shopapi.rest.dto.ShopReportDTO;
import carreiras.com.github.shopapi.rest.dto.ShopRequestDTO;
import carreiras.com.github.shopapi.rest.dto.ShopResponseDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    // private final ReportRepository reportRepository;

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public List<Shop> findAllByUserIdentifier(String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier);
    }

    public Shop findById(Long id) {
        return shopRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado."));
    }

    public ShopResponseDTO include(ShopRequestDTO shopRequestDTO) throws ParseException {
        shopRequestDTO.setTotal(
                shopRequestDTO.getItems()
                        .stream()
                        .map(x -> x.getPrice())
                        .reduce((float) 0, Float::sum));
        Shop shop = shopRepository.save(Shop.convert(shopRequestDTO));
        return ShopResponseDTO.convert(shop);
    }

    public List<Shop> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
        return shopRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
    }

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return shopRepository.getReportByDate(dataInicio, dataFim);
    }
}
