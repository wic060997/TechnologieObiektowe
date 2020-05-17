import React, { Component } from 'react';
import '../App.css';
import data from './data/text.json';

class Text extends Component {
  constructor()
  {
    super()
    console.log('Start: ' + Date.now());
  }

  componentDidMount(){
    console.log('Finish: ' + Date.now())
  }
  render() {
   
    const text = data.map((item, i) => {
      return <div key={i}>{item.Text} </div>;
    });
    return (
      <div className='text-file'>
        <div id='show-text'>{text}</div>
      </div>
    );
  }
}

export default Text;
