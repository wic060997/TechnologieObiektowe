import React, { Component } from 'react';
import '../App.css';
import { Link } from 'react-router-dom';
const divs = [
  {
    id: 1,
    class: 'div-table',
    name: '1 Danych',
    link: '/dynamic-table/simple',
    id_div: 'wrap-container-table-dynamic-id-1',
    param: 'simple'
  },
  {
    id: 2,
    class: 'div-table',
    name: '1k Danych',
    link: '/dynamic-table/data1k',
    id_div: 'wrap-container-table-dynamic-id-2',
    param: 'data1k'
  },
  {
    id: 3,
    class: 'div-table',
    name: '3k Danych',
    link: '/dynamic-table/data3k',
    id_div: 'wrap-container-table-dynamic-id-2',
    param: 'data3k'
  },
  {
    id: 4,
    class: 'div-table',
    name: '5k Danych',
    link: '/dynamic-table/data5k',
    id_div: 'wrap-container-table-dynamic-id-2',
    param: 'data5k'
  },
  {
    id: 5,
    class: 'div-table',
    name: '10k Danych',
    link: '/dynamic-table/data10k',
    id_div: 'wrap-container-table-dynamic-id-3',
    param: 'data10k'
  },
  {
    id: 6,
    class: 'div-table',
    name: '20k Danych',
    link: '/dynamic-table/data20k',
    id_div: 'wrap-container-table-dynamic-id-3',
    param: 'data20k'
  },
  {
    id: 7,
    class: 'div-table',
    name: '50k Danych',
    link: '/dynamic-table/data50k',
    id_div: 'wrap-container-table-dynamic-id-3',
    param: 'data50k'
  },
  {
    id: 8,
    class: 'div-table',
    name: '1M Danych',
    link: '/dynamic-table/data1m',
    id_div: 'wrap-container-table-id-4',
    param: 'data1m'
  },
  {
    id: 9,
    class: 'div-table',
    name: '3M Danych',
    link: '/dynamic-table/data3m',
    id_div: 'wrap-container-table-id-4',
    param: 'data3m'
  },
  {
    id: 10,
    class: 'div-table',
    name: '5M Danych',
    link: '/dynamic-table/data5m',
    id_div: 'wrap-container-table-id-4',
    param: 'data5m'
  },
  {
    id: 11,
    class: 'div-table',
    name: '10M Danych',
    link: '/dynamic-table/data10m',
    id_div: 'wrap-container-table-id-4',
    param: 'data10m'
  },
];

class Rest extends Component {
  state = {};
  render() {

    const divsRender = divs.map((item) => (
      <Link to={item.link} key={item.id} params={{ testvalue: "simple" }}>
        <div className={item.class} id={item.id_div}>
          <p>{item.name}</p>
        </div>
      </Link>
    ));
    return (
      <div id='rest-wrap-id'>
        <div className='wrap-container' id='wrap-container-main-table'>
          {divsRender}
        </div>
      </div>
    );
  }
}

export default Rest;
