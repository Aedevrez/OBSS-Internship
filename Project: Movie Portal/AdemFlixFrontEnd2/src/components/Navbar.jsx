import React from 'react';
import { Link, useNavigate } from 'react-router-dom';

export default function Navbar() {
  const navigate = useNavigate();
  const logout = () => {
    localStorage.removeItem('userId');
    navigate('/');
  };

  return (
    <nav style={{ display: 'flex', gap: '10px', padding: '10px', background: '#eee' }}>
      <Link to="/movies">Movies</Link>
      <Link to="/watchlist">Watchlist</Link>
      <Link to="/favourites">Favourites</Link>
      <button onClick={logout}>Logout</button>
    </nav>
  );
}
