import React from "react";
import axios from "axios";

const DEFAULT = 1000;

export const Input = props => {
  const [numberOfSimulations, setNumberOfSimulations] = React.useState(DEFAULT);
  const [isSwitching, setIsSwitching] = React.useState(false);

  const handleSubmit = event => {
    event.preventDefault();

    axios
      .post(
        `/monty-hall/simulate?simulations=` +
          numberOfSimulations +
          "&isSwitching=" +
          isSwitching
      )
      .then(response => {
        if (response.status === 200) {
          props.setResult(response.data);
        } else {
          console.log("Response status: ", response.status);
        }
      })
      .catch(error => {
        console.log("Error:", error.message);
      });
  };

  return (
    <div className="settingRow">
      <form onSubmit={handleSubmit}>
        <label style={{ margin: "30px" }}>
          <span>Number of simulations: </span>
          <input
            type="number"
            name="number"
            min="1"
            value={numberOfSimulations}
            onChange={e => setNumberOfSimulations(e.target.value)}
            style={{ margin: "30px 0px" }}
          />
        </label>
        <label>
          <span>Switch? </span>
          <input
            name="isSwitching"
            type="checkbox"
            checked={isSwitching}
            onChange={e => setIsSwitching(!isSwitching)}
          />
        </label>
        <input type="submit" value="Submit" style={{ margin: "30px" }} />
      </form>
    </div>
  );
};
