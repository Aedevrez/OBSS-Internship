import React from 'react'
import { Routes, Route, Navigate } from 'react-router-dom'
import Navbar from './components/Navbar.jsx'
import Login from './pages/Login.jsx'
import Movies from './pages/Movies.jsx'
import Watchlist from './pages/Watchlist.jsx'
import Favourites from './pages/Favourites.jsx'
import CreateMovie from './pages/CreateMovie.jsx'

export default function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Movies />} />
          <Route path="/watchlist" element={<Watchlist />} />
          <Route path="/favourites" element={<Favourites />} />
          <Route path="/admin/movies/create" element={<CreateMovie />} />
          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </div>
    </>
  )
}
