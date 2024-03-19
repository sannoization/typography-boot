import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import {Root} from "./routes/Root";
import ErrorPage from "./routes/ErrorPage";

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root/>,
    errorElement: <ErrorPage/>,
  },
  // {
  //   path: "/customers",
  //   element: <CustomersPage />
  // },
  // {
  //   path: "/employees",
  //   element: <EmployeesPage />
  // },
  // {
  //   path: "/goods",
  //   element: <GoodsPage />
  // },
  // {
  //   path: "/orders",
  //   element: <OrdersPage />
  // },
])
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
