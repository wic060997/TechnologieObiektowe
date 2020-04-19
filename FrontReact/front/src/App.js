import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import Text from './Components/Text';
import HomePage from './Components/HomePage';
import Table from './Components/Table';
import { paths } from './paths.js';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route exact path={paths.home} component={HomePage} />
          <Route path={paths.homeText} component={Text} />
          <Route path={paths.homeTable} component={Table} />
        </Switch>
      </Router>
    );
  }
}

export default App;
