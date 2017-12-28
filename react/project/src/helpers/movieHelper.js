const movieHelper = {
    addMovie: (movies, newTitle, newDuration) => [
        ...movies,
        {
            id: Math.floor((Math.random() * 10000) + 1),
            title: newTitle,
            duration: newDuration
        }
    ]
};

export default movieHelper;