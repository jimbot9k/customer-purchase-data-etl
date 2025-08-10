---

CREATE TABLE customers (
  customer_id BIGINT PRIMARY KEY,
  first_name TEXT,
  last_name TEXT,
  email TEXT
);

CREATE INDEX idx_customers_email ON customers(email);

---

CREATE TABLE import_batches (
  batch_id VARCHAR(36) PRIMARY KEY,
  file_name TEXT,
  file_hash VARCHAR(64) NOT NULL UNIQUE,
  file_location TEXT,
  processed_at TIMESTAMP DEFAULT NOW()
);

---

CREATE TABLE purchases (
  purchase_id BIGINT NOT NULL PRIMARY KEY,
  customer_id BIGINT NOT NULL,
  purchase_date DATE NOT NULL,
  amount_aud DECIMAL(18,2) NOT NULL CHECK (amount_aud >= 0),
  import_batch_id VARCHAR(36) NOT NULL,
  CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
  CONSTRAINT fk_import_batch FOREIGN KEY (import_batch_id) REFERENCES import_batches(batch_id) ON DELETE CASCADE
);

CREATE INDEX idx_purchases_customer ON purchases(customer_id);
CREATE INDEX idx_purchases_batch ON purchases(import_batch_id);
CREATE INDEX IF NOT EXISTS brin_purchases_date ON purchases USING BRIN (purchase_date) WITH (pages_per_range = 128);
---

CREATE TABLE rejected_rows (
  batch_id VARCHAR(36) NOT NULL,
  row_number INT,
  raw_data TEXT,
  reason TEXT,
  PRIMARY KEY (batch_id, row_number),
  CONSTRAINT fk_rejected_batch FOREIGN KEY (batch_id) REFERENCES import_batches(batch_id) ON DELETE CASCADE
);

---

CREATE MATERIALIZED VIEW customer_spend_summary AS
SELECT
  c.customer_id,
  c.first_name || ' ' || c.last_name AS full_name,
  c.email,
  SUM(p.amount_aud) AS total_spent_aud,
  MIN(p.purchase_date) AS first_purchase_date,
  MAX(p.purchase_date) AS last_purchase_date
FROM customers c
JOIN purchases p USING (customer_id)
GROUP BY c.customer_id, c.first_name, c.last_name, c.email;

CREATE UNIQUE INDEX mv_customer_spend_pk ON customer_spend_summary (customer_id);
CREATE INDEX idx_total_spent_aud ON customer_spend_summary (total_spent_aud DESC);

---



