import React from 'react';
import '../App.css';
import {
  Route,
  NavLink,
  HashRouter
} from "react-router-dom";
import Home from "./Home";
import Customers from "./Customers";
import Actors from "./Actors";
import Movies from "./Movies";

class App extends React.Component 
{
  render() {
    return (
      <HashRouter>
      <div className="App">
       <h1>RENTAL STORE MANAGEMENT</h1>
        <div>
          <ul className="header">
            <li><NavLink to ="/">Home</NavLink></li>
            <li><NavLink to ="/movies">Movies </NavLink></li>
            <li><NavLink to ="/actors">Actors</NavLink></li>
            
          </ul>
          <div className="content">
            <Route exact path="/" component={Home}/>
            <Route path="/actors" component={Actors}/>
            <Route path="/movies" component={Movies}/>
            <Route path="/customers" component={Customers}/>
          </div>
        </div>
      </div>
      </HashRouter>
    );
  }
}

export default App;
