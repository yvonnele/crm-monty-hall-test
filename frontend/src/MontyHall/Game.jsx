import React from "react";

import { Input } from "./Input";
import { Results } from "./Results";

export const Game = () => {
  const [result, setResult] = React.useState(null);

  return (
    <div>
      <Input setResult={setResult} />
      <Results result={result} />
    </div>
  );
};
