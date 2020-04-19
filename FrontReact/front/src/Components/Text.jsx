import React, { Component } from 'react';
import '../App.css';
class Text extends Component {
  state = {};

  showFile = () => {
    if (window.File && window.FileReader && window.FileList && window.Blob) {
      var preview = document.getElementById('show-text');
      var file = document.querySelector('input[type=file]').files[0];
      var reader = new FileReader();

      var textFile = /text.*/;

      if (file.type.match(textFile)) {
        reader.onload = function (event) {
          preview.innerHTML = event.target.result;
        };
      } else {
        preview.innerHTML =
          "<span class='error'>Plik nie istnieje</span>";
      }
      reader.readAsText(file);
    } else {
      alert('Twoja przegladaraka jest za stara');
    }
  };

  render() {
    return (
      <div className='text-file'>
        <input type='file' onChange={this.showFile} />
        <div id='show-text'>Wybierz plik tekstowy</div>
      </div>
    );
  }
}

export default Text;
