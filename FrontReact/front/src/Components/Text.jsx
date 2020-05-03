import React, { Component } from 'react';
import '../App.css';
import data from './data/text.json';

class Text extends Component {
  render() {
    console.log('Start: ' + Date.now());
    const text = data.map((item, i) => {
      return <div key={i}>{item.Text} </div>;
    });
    return (
      <div className='text-file'>
        <div id='show-text'>{text}</div>
        {console.log('Finish: ' + Date.now())}
      </div>
    );
  }
}

export default Text;
