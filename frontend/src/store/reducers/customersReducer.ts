import {CustomersActions, GET_CUSTOMERS, GET_CUSTOMERS_SUCCESS} from "../actions/customersActions";

export type Customer = {
  id: number;
  phone: string;
  email: string;
  firstName: string;
  lastName: string;
}

export type CustomersStateType = {
  customers: Array<Customer>
}

const initialState: CustomersStateType = {
  customers: [],
}

export default (state: CustomersStateType = initialState, action: CustomersActions): CustomersStateType => {
  switch (action.type) {
    case GET_CUSTOMERS:
    case GET_CUSTOMERS_SUCCESS:
      return {
        ...state,
      }

    default:
      return {
        ...state,
      }
  }

}
