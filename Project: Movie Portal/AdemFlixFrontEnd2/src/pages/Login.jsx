import React, { useState } from 'react'
import api from '../api.js'
import { useNavigate } from 'react-router-dom'

export default function Login() {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const navigate = useNavigate()

  const handleLogin = async (e) => {
    e.preventDefault()
    setError('')

    try {
      const token = btoa(`${username}:${password}`)
      localStorage.setItem('basicAuth', `Basic ${token}`)

      await api.get('/users')

      console.log(`✅ Login successful for user: ${username}`)
      navigate('/')
    } catch (err) {
      setError('Invalid credentials')
      localStorage.removeItem('basicAuth')
    }
  }

  return (
    <div className="login-page">
      <form onSubmit={handleLogin}>
        <h2>Login</h2>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={e => setUsername(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          required
        />
        <button type="submit">Login</button>
        {error && <p style={{ color: 'red' }}>{error}</p>}
      </form>
    </div>
  )
}
