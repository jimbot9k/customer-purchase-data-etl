import { useEffect, useState } from 'react'
import type { CustomerSpendSummary } from './types/CustomerSpendSummary';
import { fetchTopFiveCustomersSpendSummary } from './api/FetchCustomerSpendSummary';
import CustomerSpendSummaryTable from './components/CustomerSpendSummaryTable';
import { Card, CardBody, Typography, Button, Spinner } from '@material-tailwind/react';

function App() {
  const [customerSummaries, setCustomerSummaries] = useState<CustomerSpendSummary[]>([]);
  const [loading, setLoading] = useState(false);

  const load = async () => {
      setLoading(true);
      const loadedSummaries = await fetchTopFiveCustomersSpendSummary();
      setCustomerSummaries(loadedSummaries);
      setLoading(false);
  };

  useEffect(() => {
    load();
  }, []);

  return (
    <div className="mx-auto max-w-5xl p-6">
      <Card className="shadow-lg">
        <CardBody className="space-y-4">
          <div className="flex items-center justify-between gap-3">
            <div>
              <Typography variant="h4" className="!mb-0">
                Top 5 Customers Spend Summary
              </Typography>
            </div>
            <Button
              onClick={() => load()}
              className="flex items-center gap-2 bg-blue-500 text-white hover:bg-blue-600 cursor-pointer "
              disabled={loading}
              variant="gradient"
            >
              Refresh
            </Button>
          </div>

          {loading && (
            <div className="flex items-center gap-3 text-gray-700">
              <Spinner className="h-5 w-5" />
              <span>Loading…</span>
            </div>
          )}

          {!loading && (
            <CustomerSpendSummaryTable customerSpendSummaries={customerSummaries} />
          )}
        </CardBody>
      </Card>
    </div>
  );
}

export default App
