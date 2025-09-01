import React from 'react';

export default function MovieCard({ movie }) {
  return (
    <div className="movie-card">
      <h3>{movie.title}</h3>
      <p><strong>Genre:</strong> {movie.genre}</p>
      <p><strong>Summary:</strong> {movie.summary}</p>
      <p>
        <strong>Directors:</strong>{' '}
        {movie.directors && movie.directors.length > 0
          ? movie.directors.map(d => d.name).join(', ')
          : 'N/A'}
      </p>
    </div>
  )
}

