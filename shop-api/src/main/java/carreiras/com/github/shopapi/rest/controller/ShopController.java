package carreiras.com.github.shopapi.rest.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import carreiras.com.github.shopapi.domain.entity.Shop;
import carreiras.com.github.shopapi.rest.dto.ShopReportDTO;
import carreiras.com.github.shopapi.rest.dto.ShopRequestDTO;
import carreiras.com.github.shopapi.rest.dto.ShopResponseDTO;
import carreiras.com.github.shopapi.service.ShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public List<Shop> findAll() {
        return shopService.findAll();
    }

    @GetMapping("/shop_by_user/{userIdentifier}")
    public List<Shop> findAllByUserIdentifier(@PathVariable String userIdentifier) {
        return shopService.findAllByUserIdentifier(userIdentifier);
    }

    @GetMapping("/{id}")
    public Shop findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @PostMapping
    public ShopResponseDTO newShop(@RequestBody @Valid ShopRequestDTO shopRequestDTO) throws ParseException {
        return shopService.include(shopRequestDTO);
    }

    @GetMapping("/search")
    public List<Shop> getShopsByFilter(
            @RequestParam(name = "dataInicio", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
            @RequestParam(name = "valorMinimo", required = false) Float valorMinimo) {
        return shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
    }

    @GetMapping("/report")
    public ShopReportDTO getReportByDate(
            @RequestParam(name = "dataInicio", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim) {
        return shopService.getReportByDate(dataInicio, dataFim);
    }
}