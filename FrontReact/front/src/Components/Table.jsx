import React, { Component } from 'react';
import { Link } from 'react-router-dom';
const divs = [
  {
    id: 1,
    class: 'div-table',
    name: 'Dane w tabeli statyczne',
    link: '/static-table',
    id_div: 'wrap-container-table-id-1',
  },
  {
    id: 2,
    class: 'div-table',
    name: 'Dane z REST API',
    link: '/dynamic-table',
    id_div: 'wrap-container-table-id-2',
  },
  {
    id: 3,
    class: 'div-table',
    name: 'CRUD',
    link: '/crud',
    id_div: 'wrap-container-table-id-2',
  },
];

class Table extends Component {
  state = {};

  render() {
    const divsRender = divs.map((item) => (
      <Link to={item.link} key={item.id}>
        <div className={item.class} id={item.id_div}>
          <p>{item.name}</p>
        </div>
      </Link>
    ));
    return (
      <div className='App' id='router-main-id'>
        <div className='wrap-container' id='wrap-container-main-table'>
          {divsRender}
        </div>
      </div>
    );
  }
}

export default Table;
