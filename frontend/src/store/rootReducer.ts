import {combineReducers} from "redux";
import customersReducer, {CustomersStateType} from "./reducers/customersReducer";

export type RootStateType = {
  customersState: CustomersStateType;
}

const rootReducer = (): any => {
  combineReducers<RootStateType>({
      customersState: customersReducer,
  })
}

export default rootReducer;