


const apiCustomers = (url: string): string => `https://localhost:3030/customers/${url}`;
export const CUSTOMERS_URL = `https://localhost:3030/customers/`;
export const CUSTOMER_BY_ID_URL = (id: string) => apiCustomers(id);