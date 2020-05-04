import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Text from './Components/Text';
import HomePage from './Components/HomePage';
import Table from './Components/Table';
import { paths } from './paths.js';
import StaticTable from './Components/StaticTable';
import DynamicTable from './Components/DynamicTable';
import Rest from './Components/Rest';
class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route exact path={paths.home} component={HomePage} />
          <Route path={paths.homeText} component={Text} />
          <Route path={paths.homeTable} component={Table} />
          <Route path={paths.staticTable} component={StaticTable} />
          <Route exact path={paths.dynamicTable} component={Rest} />
          <Route
            exact path={paths.apiRestSimple}
            render={(props) => <DynamicTable {...props} amount={'simple'} />}
          />
          <Route
            exact path={paths.apiRestData1k}
            render={(props) => <DynamicTable {...props} amount={'data1k'} />}
          />
          <Route
           exact path={paths.apiRestData10k}
            render={(props) => <DynamicTable {...props} amount={'data10k'} />}
          />
          <Route
            exact path={paths.apiRestData1m}
            render={(props) => <DynamicTable {...props} amount={'data1m'} />}
          />
        </Switch>
      </Router>
    );
  }
}

export default App;
