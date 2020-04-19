import React, { Component } from 'react';
import axios from 'axios';
import { BootstrapTable, TableHeaderColumn } from 'react-bootstrap-table';

class DynamicTable extends Component {
  state = {
    data: '',
  };

  componentDidMount() {
    const {
      match: { params },
    } = this.props;
    console.log(params.amount);
    axios
      .get(`http://localhost:8080/${params.amount}`)
      .then((json) => {
        this.setState({
          data: json.data,
        });
      })
      .catch((err) => {
        console.log(err);
      });
  }

  render() {
    console.log('Jestem załadowany!!! DynamicTable');
    return (
      <div>
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

export default DynamicTable;
