import React from 'react';
import PropTypes from 'prop-types';

const Staff = (props) =>
(
    <div>
       <strong>User Name: </strong>{props.username} 
       <strong>Password: </strong> {props.password} 
    </div>
);

Staff.propTypes = 
{
    username: PropTypes.string.isRequired,
    password: PropTypes.string.isRequired
}

export default Staff;