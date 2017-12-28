import React from 'react';
import ReactDOM from 'react-dom';
import App from '../components/App';
import movieHelper from '../helpers/movieHelper';
import customerHelper from '../helpers/customerHelper';
import logingHelper from '../helpers/logingHelper';
import Home from '../components/Home';

//Check renders
it('Renders', () => 
{
  const div = document.createElement('div');
  ReactDOM.render(<App />, div);

});

//Check the logging with wrong credentials
it('Wrong loging', () => 
{
    const username = 'x';
    const password = 'y';
    const expectedValue = false;

    expect(logingHelper(username,password)).toEqual(expectedValue);   
});

//Check the logging with wrong credentials
it('Good loging', () => 
{
    const username = 'admin';
    const password = 'adminPwd';
    const expectedValue = true;

    expect(logingHelper(username,password)).toEqual(expectedValue);   
});

//Check if there is no change in the initial list of movies
it('Initial Movies', () => {
  const initialMovies = [ 
      {id:1, title:'ACADEMY DINOSAUR', duration: 86},
      {id:2, title:'ACE GOLDFINGER', duration: 48},
      {id:3, title:'ADAPTATION HOLES', duration: 50}
  ]
  const expectedMovies = [...initialMovies];

  movieHelper.addMovie(initialMovies, 'Last Movie');
  expect(initialMovies).toEqual(expectedMovies);
  
});

//Check if there is no change in the initial list of customers
it('Initial Customers', () => {
  const initialCustomers = [ 
      {id:1, firstName:'MARY', lastName: 'SMITH',email:'MARY.SMITH@sakilacustomer.org',address:'1913 Hanoi Way',active:1 ,store:1},
      {id:2, firstName:'JOHNSON', lastName: 'PATRICIA',email:'PATRICIA.JOHNSON@sakilacustomer.org',address:'1121 Loja Avenue',active:1,store:1},
      {id:3, firstName:'LINDA', lastName: 'WILLIAMS',email:'LINDA.WILLIAMS@sakilacustomer.org',address:'692 Joliet Street',active:1,store:1}
  ]
  const expectedCustomers = [...initialCustomers];

  customerHelper.addCustomer(initialCustomers, 'Last Customer');
  expect(initialCustomers).toEqual(expectedCustomers);
  
});



