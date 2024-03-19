import {call, all, takeLatest, AllEffect, ForkEffect} from 'redux-saga/effects'
import {GET_CUSTOMERS} from "../actions/customersActions";
import {API} from "./rest";
import {CUSTOMERS_URL} from "./constants";


function* handleGetCustomers() {
  yield call(API.get, CUSTOMERS_URL);


}
function* watchGetCustomers() {
  yield takeLatest(GET_CUSTOMERS, handleGetCustomers)
}

export type CustomersSagaStateType = Generator<AllEffect<Generator<ForkEffect<never>, void>>>;
export default function* customersSaga(): CustomersSagaStateType {
  yield all([watchGetCustomers()])
}