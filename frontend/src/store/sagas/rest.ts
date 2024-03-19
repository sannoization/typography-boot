import queryString from "querystring";
import axios from "axios";

export const REQUEST_TIMEOUT_DEFAULT = 480000;

const paramsSerializer = (params: any) => queryString.stringify(params);

export const API = axios.create({
  baseURL: window.location.origin,
  timeout: REQUEST_TIMEOUT_DEFAULT,
  paramsSerializer,
});