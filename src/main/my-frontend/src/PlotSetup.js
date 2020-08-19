import React from 'react';
import { Button, Row, Col, Container } from 'react-bootstrap';

function SetupRow(props){
  return(
    <Row>
      <Col>
        <Button onClick={() => props.setValue(props.value - 1)}>-</Button>
      </Col>
      <Col>
        <h4 className="text-center">
          Anzahl der Felder in der {props.name} {props.value}
        </h4>
      </Col>
      <Col className="text-center">
        <Button onClick={() => props.setValue(props.value + 1)}>+</Button>
      </Col>
    </Row>
  )
}

class PlotSetup extends React.Component {
  render(){
    return (
      <>
        <Container>
          <SetupRow
            setValue={this.props.setWidth}
            name={"Breite"}
            value={this.props.width}
          >
          </SetupRow>
          <SetupRow
            setValue={this.props.setHeight}
            name={"Höhe"}
            value={this.props.height}
          >
          </SetupRow>
        </Container>
      </>
    );
  }
}

export default PlotSetup;
