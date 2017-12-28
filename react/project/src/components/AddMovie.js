import React from 'react';

class AddMovie extends React.Component
{
    constructor()
    {
        super();
        this.state = {NewMovie: ''};//Default State
    }

    render()
    {
        return(
            <div id="newMovie">
                <strong> New Movie: </strong><strong><input id="newMovieInputText" type="text" value={this.state.newMovie} onChange={this.changeName}/></strong>
                <button id="add" onClick={this.addMovie}><strong>Add</strong></button>
            </div>
        );
    }

    changeName = (event) => {
        this.setState({newMovie: event.target.value});//New State
    }
    addMovie = () => {
        this.props.addMovie(this.state.newMovie);
        this.setState({newMovie: ''});//Reset the input
    }
}

export default AddMovie;