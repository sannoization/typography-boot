import * as React from 'react';
import {TsetCompotet} from "../components/tsetCompotet";

type Props = {

};
const ErrorPage = (props: Props) => {
  return (
      <div>
      <TsetCompotet  text={'Привет мир!'}/>
      </div>
  );
};


export default ErrorPage;