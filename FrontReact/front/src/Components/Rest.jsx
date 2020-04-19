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
    name: '10k Danych',
    link: '/dynamic-table/data10k',
    id_div: 'wrap-container-table-dynamic-id-3',
    param: 'data10k'
  },
  {
    id: 4,
    class: 'div-table',
    name: '1M Danych',
    link: '/dynamic-table/data1m',
    id_div: 'wrap-container-table-id-4',
    param: 'data1m'
  },
];

class Rest extends Component {
  state = {};
  render() {

    console.log("Jestem zaladowany!!! Rest")

    const divsRender = divs.map((item) => (
      <Link to={item.link} key={item.id} params={{ amount: item.param }}>
        <div className={item.class} id={item.id_div}>
          <p>{item.name}</p>
        </div>
      </Link>
    ));
    return (
      <div>
        <div className='wrap-container' id='wrap-container-main-table'>
          {divsRender}
        </div>
      </div>
    );
  }
}

export default Rest;
