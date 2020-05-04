import React, { Component } from 'react';
import '../App.css';

class DynamicTable extends Component {
  constructor()
  {
    console.log('Start: ' + Date.now())
    super()
    this.state = {
      data: '',
    };

  }
  

  componentDidMount() { 
    fetch(`http://localhost:8080/${this.props.amount}`)
     .then(response => response.text())
      .then(data => this.setState({ data: data }));
      console.log('Finish: ' + Date.now())
  }
 

  render() {
    return (
      <div className='static-table-div' id='static-table-div-id-1'>
        <div>{this.state.data}</div>
      </div>
    );
  }
}

export default DynamicTable;
