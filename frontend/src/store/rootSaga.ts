import customersSaga from "./sagas/customersSaga";
import {AllEffect, all} from "redux-saga/effects";


export default function* rootSaga(): Generator<AllEffect<any>> {
  yield all([
    customersSaga(),
  ])
}