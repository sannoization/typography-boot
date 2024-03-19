import {Customer} from "../reducers/customersReducer";


export const GET_CUSTOMERS = 'customers/GET_CUSTOMERS';
export type GetCustomersActionType = {
  type: typeof GET_CUSTOMERS;
}

export const GET_CUSTOMERS_SUCCESS = 'customers/GET_CUSTOMERS_SUCCESS';
export type GetCustomersSuccessActionType = {
  type: typeof GET_CUSTOMERS_SUCCESS;
  payload: Array<Customer>;
}

export type CustomersActions = GetCustomersActionType | GetCustomersSuccessActionType