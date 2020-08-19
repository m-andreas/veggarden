import React, { useState } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Jumbotron } from 'react-bootstrap';
import PlotSetup from './PlotSetup';
import Plot from './Plot';

function App() {
  const [width, setWidth] = useState(1)
  const [height, setHeight] = useState(1)

  return (
    <div className="App">
      <Jumbotron>
        <h1 className="header">Welcome at the GardenPlanner</h1>
        <PlotSetup
          setWidth={setWidth}
          width={width}
          setHeight={setHeight}
          height={height}
        >
        </PlotSetup>
        <Plot
          width={width}
          height={height}
        >
        </Plot>
      </Jumbotron>
    </div>
  );
}

export default App;
