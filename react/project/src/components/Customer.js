import React from 'react';
import '../Customer.css';

const Customer = (props) =>
(
<div className="panel panel-default" key={props.customerId}>
  <div className="tablecontainer">
      <table className="table table-hover">
          <thead>
              <tr>
                  <th>ID.</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Email</th>
                  <th>Address</th>
                  <th width="20%"></th>
              </tr>
          </thead>
          <tbody>
              <tr>
                  <td>{props.customerId}</td>
                  <td>{props.firstName}</td> 
                  <td>{props.lastName}</td>
                  <td>{props.email} </td>
                  <td>{props.address} </td>
                  <td>
                  <button type="button"  className="custom-width">Edit</button> 
                  <button type="button"  className="custom-width">Remove</button>
                  </td>
              </tr>
          </tbody>
      </table>
  </div>
</div>
);

export default Customer;