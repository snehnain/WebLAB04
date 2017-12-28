
import React from 'react';
import axios from 'axios';
import Customer from './Customer';
import AddCustomer from './AddCustomer';
import customerHelper from '../helpers/customerHelper';

class Customers extends React.Component
{
    constructor()
    {
        super();
        this.state = {customers: null};
    }

    componentDidMount()
    {
        axios
        .get('http://localhost:8080/customer/')
        .then((response) =>
        {
        console.log(response);
        this.setState({customers: response.data});
        });
    }

    renderCustomer = () => this.state.customers ?
        this.state.customers.map(t => <Customer {...t}/>)
        : 'Loading...'

    
    render() 
    {
        return (
            <div>
                <h2>Customers</h2>
                <AddCustomer addCustomer = {this.addCustomerToState}/>
                {this.renderCustomer()}
            </div>
        );
    }

    addCustomerToState = (name) =>
    {
      const newCustomerList = customerHelper.addCustomer(this.state.customers, name);
      this.setState({customers: newCustomerList});
    }
}

export default Customers