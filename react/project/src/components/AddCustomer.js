import React from 'react';

class AddCustomer extends React.Component
{
    constructor()
    {
        super();
        this.state = {NewCustomer: ''};//Default State
    }

    render()
    {
        return(
            <div id="newCustomer">
                <strong> New Customer: </strong><strong><input id="newCustomerInputText" type="text" value={this.state.newCustomer} onChange={this.changeName}/></strong>
                <button id="add" onClick={this.addCustomer}><strong>Add</strong></button>
            </div>
        );
    }

    changeName = (event) => {
        this.setState({newCustomer: event.target.value});//New State
    }
    addCustomer = () => {
        this.props.addCustomer(this.state.newCustomer);
        this.setState({newCustomer: ''});//Reset the input
    }
}

export default AddCustomer;