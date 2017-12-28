import React from 'react';
import '../Customer.css';

const Actor = (props) =>
(

<div className="panel panel-default" key={props.actorId}>
  <div className="tablecontainer">
      <table className="table table-hover">
          <thead>
              <tr>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th width="20%"></th>
              </tr>
          </thead>
          <tbody>
              <tr>
                  <td>{props.firstName}</td> 
                  <td>{props.lastName}</td>
              </tr>
          </tbody>
      </table>
  </div>
</div>
);


export default Actor;
