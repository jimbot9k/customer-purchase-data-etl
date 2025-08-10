package jimbot9k.purchase_data_rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jimbot9k.purchase_data_rest.dto.CustomerSpendSummaryDto;

@RestController
@RequestMapping("/purchases")
public class PurchaseDataRestController {

    private final PurchaseDataRestService purchaseDataRestService;

    public PurchaseDataRestController(PurchaseDataRestService purchaseDataRestService) {
        this.purchaseDataRestService = purchaseDataRestService;
    }

    @GetMapping("top-five-customers")
    public List<CustomerSpendSummaryDto> index() {
        return purchaseDataRestService.getTopFiveCustomers();
    }
}
