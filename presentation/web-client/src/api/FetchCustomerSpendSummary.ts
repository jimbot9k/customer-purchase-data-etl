import type { CustomerSpendSummary } from '../types/CustomerSpendSummary';

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || '/api';

export async function fetchTopFiveCustomersSpendSummary(): Promise<CustomerSpendSummary[]> {
    try {
        const response = await fetch(`${API_BASE_URL}/purchases/top-five-customers`);

        if (!response.ok) {
            throw new Error(`${response.status}`);
        }

        const data: CustomerSpendSummary[] = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching top five customers spend summary:', error);
        throw error;
    }
}