package jimbot9k.purchase_data_rest;

import java.util.List;

import org.springframework.stereotype.Service;

import jimbot9k.purchase_data_rest.dto.CustomerSpendSummaryDto;

@Service
public class PurchaseDataRestService {

    private final PurchaseDataRestDao purchaseDataRestDao;

    public PurchaseDataRestService(PurchaseDataRestDao purchaseDataRestDao) {
        this.purchaseDataRestDao = purchaseDataRestDao;
    }

    public List<CustomerSpendSummaryDto> getTopFiveCustomers() {
        return purchaseDataRestDao.getTopFiveCustomers();
    }
}
