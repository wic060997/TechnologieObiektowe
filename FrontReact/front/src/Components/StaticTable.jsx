import React, { Component } from 'react';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';
import '../App.css';
import data from './data/jsonDataTable.json';

class StaticTable extends Component {
  state = {
    dataTable: data,
  };
  render() {
    return (
      <div className='static-table-div'>
        <h1>Static table</h1>
        <BootstrapTable data={this.state.dataTable}>
          <TableHeaderColumn dataField='id' isKey hidden>
            Product ID
          </TableHeaderColumn>
          <TableHeaderColumn dataField='Imie'>Imie</TableHeaderColumn>
          <TableHeaderColumn dataField='Nazwisko'>Nazwisko</TableHeaderColumn>
          <TableHeaderColumn dataField='email'>email</TableHeaderColumn>
          <TableHeaderColumn dataField='gender'>Płeć</TableHeaderColumn>
          <TableHeaderColumn dataField='ip_address'>
            ip_address
          </TableHeaderColumn>
        </BootstrapTable>
      </div>
    );
  }
}

export default StaticTable;
