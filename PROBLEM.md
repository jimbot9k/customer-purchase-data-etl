# 🧪 Senior Full Stack - ETL Developer Technical Test

## 📦 Deliverables

- ✅ Source code (scripts, pipelines, SQL queries)
- ✅ A short README including:
  - Assumptions
  - Tools used
  - How to run the solution
- ✅ Diagrams or screenshots to illustrate your pipeline

---

## 📄 Scenario

You are part of a data engineering team building a pipeline to process customer purchase data. The raw data is delivered daily in CSV format to a storage location (local or cloud).

Your goal is to build a **reliable** and **testable ETL process** that transforms raw data into a reporting-friendly format in a **data warehouse** or **relational database**.

---

## 🔹 Part 1: Data Ingestion

### Simulated Raw CSV Input

```
csv
customer_id,first_name,last_name,email,purchase_id,purchase_date,amount,currency
101,John,Doe,john@example.com,5001,2023-10-01,200,USD
102,Jane,Smith,jane@example.com,5002,2023-10-02,150,USD
101,John,Doe,john@example.com,5003,2023-10-03,300,USD
```

### Tasks
- Read the CSV file from a local directory or simulated cloud path (e.g., AWS S3, Azure Blob Storage, or Google Cloud Storage)
- Handle missing or malformed data gracefully

---

## 🔧 Part 2: Data Transformation

### Tasks
- Convert currency from USD to AUD (Assume 1 USD = 1.5 AUD)
- Aggregate total spend per customer
- Create: `first_purchase_date` `last_purchase_date`

Output Format
```
customer_id,full_name,email,total_spent_aud,first_purchase_date,last_purchase_date
101,John Doe,john@example.com,750,2023-10-01,2023-10-03
102,Jane Smith,jane@example.com,225,2023-10-02,2023-10-02
```
---

## 🧱 Part 3: Load

### Tasks

Load the transformed data into a relational database or warehouse, such as: 
- PostgreSQL
- MySQL
- BigQuery
- Or in memory

Provide the DDL (schema) for the final table

---

## 📊 Part 4: Querying & Optimization

### Tasks

- Write a SQL query to return the top 5 customers by total_spent_aud
- Demonstrate how you would ensure performance at scale (100M+ rows) by:
- Partitioning the table
- Indexing key columns

---

## ☁️ Optional Cloud Bonus

- Use a tool like CloverDX or Azure Data Factory to orchestrate the pipeline
- Store intermediate or final outputs in a cloud platform (e.g. AWS S3, Azure Blob, GCS)

---

## 🧠 Notes

This test is designed to assess your understanding of:
- Data ingestion and validation
- Transforming and aggregating data
- Writing scalable SQL
- Working with relational or cloud data platforms

---

## 🙌 Good Luck!

We're looking forward to seeing how you approach this challenge.
