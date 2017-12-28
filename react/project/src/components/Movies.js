import React from 'react';
import axios from 'axios';
import Movie from './Movie';
import AddMovie from './AddMovie';
import movieHelper from '../helpers/movieHelper';

class Movies extends React.Component
{
    constructor()
    {
        super();
        this.state = {movies: null};
    }

    componentDidMount()
    {
        axios
        .get('http://localhost:8080/film/')
        .then((response) =>
        {
        this.setState({movies: response.data});
        });
    }

    renderMovie = () => this.state.movies ?
this.state.movies.map(t => (<Movie {...t}/>))
        : 'Loading...'

    
    render() 
    {
        return (
            <div>
                <h2>Movies</h2>
                <AddMovie addMovie = {this.addMovieToState}/>
                {this.renderMovie()}
            </div>
        );
    }

    addMovieToState = (name) =>
    {
      const newMovieList = movieHelper.addMovie(this.state.movies, name);
      this.setState({movies: newMovieList});
    }
}

export default Movies