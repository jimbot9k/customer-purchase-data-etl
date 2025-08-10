import csv
import os
import names
from random import randint, choice, seed
from datetime import date, timedelta
from pathlib import Path

print("Generating random purchase data...")
seed(42)
OUT_PATH = Path("purchases.csv")
BATCH_ROWS = 100
EXTRA_CUSTOMERS = 10000
purchase_id_start = 5000001
num_rows = 1000000
start_date = date(2023, 10, 1)
end_date   = date(2025, 8, 1)

customers = [
    (101, "John", "Doe", "john@example.com"),
    (102, "Jane", "Smith", "jane@example.com"),
]
print(f"Using {len(customers)} initial customers")
for idx in range(EXTRA_CUSTOMERS):
    cid = 103 + idx
    fname = names.get_first_name()
    lname = names.get_last_name()
    email = f"{fname.lower()}.{lname.lower()}@example.com"
    customers.append((cid, fname, lname, email))
    print(f"Added customer {cid}: {fname} {lname} ({email})")

delta_days = (end_date - start_date).days

def purchase_rows():
    for i in range(num_rows):
        cust = choice(customers)
        pid = purchase_id_start + i
        pdate = start_date + timedelta(days=randint(0, delta_days))
        amount = randint(1, 10000)
        yield (
            cust[0], cust[1], cust[2], cust[3],
            pid, pdate.isoformat(), amount, "USD"
        )

print(f"Generating {num_rows:,} rows of purchase data...")
header = ("customer_id","first_name","last_name","email",
          "purchase_id","purchase_date","amount","currency")
file_exists = OUT_PATH.exists()
mode = "a" if file_exists else "w"

print(f"Output file: {OUT_PATH} (mode: {mode})")
with open(OUT_PATH, mode, newline="", buffering=1024*1024) as f:
    w = csv.writer(f, lineterminator="\r\n")

    if not file_exists:
        w.writerow(header)

    buf = []
    for n, row in enumerate(purchase_rows(), 1):
        print(f"Generating row {n:,}...", end="\r")
        buf.append(row)
        if len(buf) >= BATCH_ROWS:
            w.writerows(buf)
            buf.clear()
            f.flush()
            print(f"Wrote {n:,} rows")

    if buf:
        w.writerows(buf)
        f.flush()
        print(f"Wrote {n:,} rows (final)")

print(f"Done: {OUT_PATH}")
