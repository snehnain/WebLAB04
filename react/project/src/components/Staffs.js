import React from 'react';
import axios from 'axios';
import PropTypes from 'prop-types';
import Staff from './Staff';

class Staffs extends React.Component
{
    constructor()
    {
        super();
        this.state = {staffs: null};
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
                {this.renderCustomer()}
            </div>
        );
    }
}

Customers.propTypes =
{
    customers: PropTypes.array.isRequired
}


export default Customers