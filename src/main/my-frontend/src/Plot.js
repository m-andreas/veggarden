import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Row, Col} from 'react-bootstrap';

function PlotRow(props){
  const WidthItems = Array.from({ length: props.width }).map((u, i) =>
    <Col
      key={props.rowNumber.toString() + "-" + i}
      className={"colCounter-" + i +
        " plot-col"
      }
    >
      {props.rowNumber}/{i+1}
    </Col>
  );
  return(
    WidthItems
  )
}

function Plot(props){
  const HeightItems = Array.from({ length: props.height }).map((u, i) =>
    <Row
      key={"rowCounter-" + i}
      className={"rowCounter-" + i}
    >
      <PlotRow
        rowNumber={i}
        width={props.width}>
      </PlotRow>
    </Row>
  );
  return(
    HeightItems
  )
}

export default Plot;
