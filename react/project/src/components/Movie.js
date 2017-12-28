import React from 'react';
import '../Customer.css';

const Movie = (props) =>
(
<div className="panel panel-default" key={props.movieId}>
<div className="tablecontainer">
    <table className="table table-hover">
          <thead>
              <tr>
                  <th>Title</th>
                  <th>Duration</th>
                  <th width="20%"></th>
              </tr>
          </thead>
          <tbody>
              <tr>
                  <td>{props.title}</td> 
                  <td>{props.duration}</td>
              </tr>
          </tbody>
      </table>
  </div>
</div>
);
export default Movie;