import React, { Component } from 'react';
import '../App.css';


const User = (props) => (
  <div className='element-user'>
    <p>
      {props.firstName} {props.lastName}
    </p>
    <p>{props.age}</p>
    {/* <button onClick={}>Usun</button> */}
  </div>
);

class CrudComponent extends Component {
  state = {
    users: [{ id: 1, firstName: 'Mateusz', lastName: 'Bonar', age: 23 }],
  };

  render() {
    const usersRender = this.state.users.map((item) => (
      <User
        firstName={item.firstName}
        lastName={item.lastName}
        age={item.age}
      ></User>
    ));
    return (
      <>
        {usersRender}
        <button>Dodaj kolejny</button>
      </>
    );
  }
}

export default CrudComponent;
