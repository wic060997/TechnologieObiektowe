import React, { Component } from 'react';
import '../App.css';
import { Link } from 'react-router-dom';
const divs = [
  {
    id: 1,
    class: 'div',
    name: 'Tekst',
    link: '/text',
    id_div: 'wrap-container-id-1',
  },
  {
    id: 2,
    class: 'div',
    name: 'Tabela',
    link: '/table',
    id_div: 'wrap-container-id-2',
  },
];

class HomePage extends Component {
  state = {};
  render() {
    const divsRender = divs.map((item) => (
      <Link to={item.link}>
        <div className={item.class} key={item.id} id={item.id_div}>
          <p>{item.name}</p>
        </div>
      </Link>
    ));
    return (
      <div>
        <div className='App' id='router-main-id'>
          <div className='wrap-container' id='wrap-container-main'>
            {divsRender}
          </div>
        </div>
      </div>
    );
  }
}

export default HomePage;
