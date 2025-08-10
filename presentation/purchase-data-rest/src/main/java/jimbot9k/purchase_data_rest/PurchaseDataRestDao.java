package jimbot9k.purchase_data_rest;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jimbot9k.purchase_data_rest.dto.CustomerSpendSummaryDto;

@Repository
public class PurchaseDataRestDao {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseDataRestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CustomerSpendSummaryDto> getTopFiveCustomers() {

        String sql = """
            SELECT customer_id, full_name, email, total_spent_aud, first_purchase_date, last_purchase_date
            FROM customer_spend_summary
            ORDER BY total_spent_aud DESC
            LIMIT 5
            """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String customerId = rs.getString("customer_id");
            String fullName = rs.getString("full_name");
            String email = rs.getString("email");
            double totalSpentAud = rs.getDouble("total_spent_aud");
            Date firstPurchaseDate = rs.getDate("first_purchase_date");
            Date lastPurchaseDate = rs.getDate("last_purchase_date");

            return new CustomerSpendSummaryDto(customerId, fullName, email, totalSpentAud, firstPurchaseDate, lastPurchaseDate);
        });
    }
}
