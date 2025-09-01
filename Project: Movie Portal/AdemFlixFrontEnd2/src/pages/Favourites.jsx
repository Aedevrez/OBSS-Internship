import React, { useState, useEffect } from 'react';
import API from '../api';

export default function Favourites() {
  const [movies, setMovies] = useState([]);
  const userId = localStorage.getItem('userId');

  useEffect(() => {
    API.get(`/users/${userId}/favourites`)
      .then((res) => setMovies(res.data))
      .catch((err) => console.error(err));
  }, [userId]);

  return (
    <div style={{ padding: 20 }}>
      <h2>Your Favourites</h2>
      {movies.map((movie) => (
        <div key={movie.id}>{movie.title}</div>
      ))}
    </div>
  );
}
