import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom' 
import api from '../api.js'
import MovieCard from '../components/MovieCard.jsx'

export default function Movies() {
  const [movies, setMovies] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  const load = async () => {
    setLoading(true)
    setError('')
    try {
      const { data } = await api.get('/admin/movies')
      setMovies(Array.isArray(data) ? data : data.movies || [])
    } catch (err) {
      setError('Failed to load movies')
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => { load() }, [])

  if (loading) return <div>Loading...</div>
  if (error) return <div style={{ color: 'red' }}>{error}</div>

  return (
    <>
      <div style={{ marginBottom: '1rem' }}>
        <Link to="/admin/movies/create">
          <button>Create Movie</button>
        </Link>
      </div>
      <div className="grid">
        {movies.map(m => (
          <MovieCard key={m.id} movie={m} />
        ))}
      </div>
    </>
  )
}
