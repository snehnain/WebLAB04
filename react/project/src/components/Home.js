import React from "react";
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import TextField from 'material-ui/TextField';
import '../Home.css';
import RaisedButton from 'material-ui/RaisedButton';
import logingHelper from '../helpers/logingHelper';

class Home extends React.Component {
  constructor(props){
    super(props);
    this.state={
      username:'',
      password:''
    }
   }
       
 render() {
   return (
     <div className="header">
         <MuiThemeProvider>
          <div className="body">
            <h2>LOGIN</h2>
            <div className="content">
              <TextField className="display" id="username" placeholder="Enter your Username" onChange = {(event,newValue) => this.setState({username:newValue})}/>
              <TextField className="display" id="password" type="password" placeholder="Enter your Password" onChange = {(event,newValue) => this.setState({password:newValue})}/>
              </div>
              <RaisedButton label="Submit" primary={true}  onClick={(event) => 
              {
                logingHelper(this.state.username, this.state.password) ? 
                window.location.href = "http://localhost:3000/#/customers"
                : window.alert('Credentials not correct')
              }}/>
          </div>
         </MuiThemeProvider>
     </div>
   );
 }

}

export default Home;