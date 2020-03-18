import React from "react";

export const Results = props => {
  function formatPercentage(decimal) {
    return Math.floor(decimal * 100);
  }
  return (
    props.result && (
      <h3>
        Simulating {props.result.simulations} games with{" "}
        {props.result.isSwitching ? "switching doors" : "not switching doors"}{" "}
        resulted in {props.result.wins} wins. That's a{" "}
        {formatPercentage(props.result.winPercentage)}% win rate!
      </h3>
    )
  );
};
