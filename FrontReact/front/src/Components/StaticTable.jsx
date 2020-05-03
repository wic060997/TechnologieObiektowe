import React, { Component } from 'react';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';
import '../App.css';
import data from './data/jsonDataTable.json';

class StaticTable extends Component {
  state = {
    dataTable: data,
  };

  render() {
    console.log('Start: ' + Date.now());
    const elementRender = data.map((item, i) => (
      <tr key={item.id}>
        <td>{item.id}</td>
        <td>{item.Imie}</td>
        <td>{item.Nazwisko}</td>
        <td>{item.email}</td>
        <td>{item.gender}</td>
        <td>{item.ip_address}</td>
      </tr>
    ));
    return (
      <div className='static-table-div'>
        <table>
          <thead>
            <th>Id</th>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>email</th>
            <th>gender</th>
            <th>ip_address</th>
          </thead>
          <body>{elementRender}</body>
        </table>
        {console.log('Finish: ' + Date.now())}
      </div>
    );
  }
}

export default StaticTable;
