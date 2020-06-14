import React, { Component } from 'react';
import '../App.css';

class CrudComponent extends Component {
  constructor(props) {
    console.warn('Start: ' + Date.now())
    super(props);
    this.state = {
      act: 0,
      index: '',
      users: [],
    };
  }

  static getDerivedStateFromProps(){
    console.warn('Start Update: ' + Date.now())
  }
  componentDidMount() {
    this.refs.name.focus();
    console.warn('Finish: ' + Date.now())
  }

  componentDidUpdate(){
    console.warn('Finish Update: ' + Date.now())
  }
  addData = (e) => {
    e.preventDefault();
    let users = this.state.users;
    let name = this.refs.name.value;
    let surname = this.refs.surname.value;

    if (this.state.act === 0) {
      let data = {
        name,
        surname: surname,
      };
      //console.log(this.state.users);
      users.push(data);
    } else {
      let index = this.state.index;
      users[index].name = name;
      users[index].surname = surname;
    }

    this.setState({
      users: users,
    });

    this.refs.myForm.reset();
    this.refs.name.focus();
  };

  removeData = (i) => {
    let users = this.state.users;
    users.splice(i, 1);
    this.setState({
      datas: users,
    });

    this.refs.myForm.reset();
    this.refs.name.focus();
  };

  editData = (i) => {
    let data = this.state.users[i];
    this.refs.name.value = data.name;
    this.refs.surname.value = data.surname;

    this.setState({
      act: 1,
      index: i,
    });
    this.refs.name.focus();
  };

  render() {
    return (
      <div>
        <h2>Lista użytkowników</h2>
        <form ref='myForm'>
          <input type='text' ref='name' placeholder='twoje imie' />
          <input type='text' ref='surname' placeholder='twoje nazwisko' />
          <button onClick={(e) => this.addData(e)}>Dodaj</button>
        </form>
        <pre>
          {this.state.users.map((user, i) => (
            <div key={i} className='div-user'>
              <p className=''>
                {user.name}, {user.surname}
              </p>
              <button onClick={() => this.removeData(i)}>Usuń</button>
              <button onClick={() => this.editData(i)}>Modyfikuj</button>
            </div>
          ))}
        </pre>
      </div>
    );
  }
}

export default CrudComponent;
