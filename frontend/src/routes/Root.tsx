// @flow
import * as React from 'react';
import {Link} from "react-router-dom";

type Props = {

};
export const Root = (props: Props) => {
  return (
        <nav>
          <Link to={`/customers`}>Customers</Link>
          <Link to={`/employees`}>Employees</Link>
          <Link to={`/goods`}>Goods</Link>
          <Link to={`/orders`}>Orders</Link>
        </nav>
  );
};