
import type { CustomerSpendSummary } from "../types/CustomerSpendSummary";

type CustomerSpendSummaryTableProps = {
    readonly customerSpendSummaries: readonly CustomerSpendSummary[];
};

export default function CustomerSpendSummaryTable({ customerSpendSummaries }: CustomerSpendSummaryTableProps) {
    return (
        <div className="overflow-x-auto">
            <table className="min-w-full text-left text-sm">
                <thead>
                    <tr className="border-b bg-gray-50">
                        <th className="px-4 py-3 font-semibold">CustomerID</th>
                        <th className="px-4 py-3 font-semibold">Customer Name</th>
                        <th className="px-4 py-3 font-semibold">Email</th>
                        <th className="px-4 py-3 font-semibold">Total Spend (AUD)</th>
                        <th className="px-4 py-3 font-semibold">First Purchase Date</th>
                        <th className="px-4 py-3 font-semibold">Last Purchase Date</th>
                    </tr>
                </thead>
                <tbody>
                    {customerSpendSummaries.map((summary) => (
                        <tr key={summary.customerId} className="border-b last:border-none hover:bg-gray-50">
                            <td className="px-4 py-3 tabular-nums">{summary.customerId}</td>
                            <td className="px-4 py-3">{summary.fullName}</td>
                            <td className="px-4 py-3">{summary.email}</td>
                            <td className="px-4 py-3">{summary.totalSpentAud.toFixed(2)}</td>
                            <td className="px-4 py-3">{summary.firstPurchaseDate}</td>
                            <td className="px-4 py-3">{summary.lastPurchaseDate}</td>
                        </tr>
                    ))}
                    {customerSpendSummaries.length === 0 && (
                        <tr>
                            <td colSpan={5}>
                                No data available
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}

