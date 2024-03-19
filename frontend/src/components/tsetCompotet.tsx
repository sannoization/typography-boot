// @flow
import * as React from 'react';

type Props = {
    text?: string;
};
export const TsetCompotet = (props: Props) => {
  return (
      <div>
        {props.text}
      </div>
  );
};