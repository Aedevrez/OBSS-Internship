import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:8080',
})

// Attach Basic Auth if stored
api.interceptors.request.use((config) => {
  const basic = localStorage.getItem('basicAuth')
  if (basic) {
    config.headers['Authorization'] = basic // e.g., "Basic abc123"
  }
  return config
})

export default api

