import React from 'react';
import axios from 'axios';
import Actor from './Actor';

class Actors extends React.Component
{
    constructor()
    {
        super();
        this.state = {actors: null};
    }

    componentDidMount()
    {
        axios
        .get('http://localhost:8080/actor/')
        .then((response) =>
        {
            this.setState({actors: response.data});
        });
    }

    renderActor = () => this.state.actors ?
        this.state.actors.map(t => <Actor {...t}/>)
        : 'Loading...'

    
    render() 
    {
        return (
            <div>
                <h2>Actors</h2>
                {this.renderActor()}
            </div>
        );
    }
}

export default Actors