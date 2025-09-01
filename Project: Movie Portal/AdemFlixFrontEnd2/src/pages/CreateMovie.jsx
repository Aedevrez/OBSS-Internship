import React, { useState, useEffect } from "react";

export default function CreateMovie() {
  const [title, setTitle] = useState("");
  const [genre, setGenre] = useState("");
  const [summary, setSummary] = useState("");
  const [directors, setDirectors] = useState([]);
  const [selectedDirectors, setSelectedDirectors] = useState([]);

  useEffect(() => {
  fetch("http://localhost:8080/directors")
    .then(res => {
      console.log("Status:", res.status);
      return res.json();
    })
    .then(data => {
      console.log("Directors from backend:", data);
      setDirectors(data);
    })
    .catch(err => console.error("Error fetching directors:", err));
    }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const movieDTO = {
      title,
      genre,
      summary,
      directors: selectedDirectors.map(id => ({ id })) // ✅ important
    };

    const response = await fetch("http://localhost:8080/api/movies/create", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": "Bearer " + localStorage.getItem("token") // if you use JWT
      },
      body: JSON.stringify(movieDTO)
    });

    if (response.ok) {
      alert("Movie created!");
    } else {
      alert("Failed to create movie.");
    }
  };

  const handleDirectorChange = (e) => {
    const options = Array.from(e.target.selectedOptions, option => option.value);
    setSelectedDirectors(options);
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Create Movie</h2>
      <div>
        <label>Title: </label>
        <input value={title} onChange={e => setTitle(e.target.value)} />
      </div>
      <div>
        <label>Genre: </label>
        <input value={genre} onChange={e => setGenre(e.target.value)} />
      </div>
      <div>
        <label>Summary: </label>
        <textarea value={summary} onChange={e => setSummary(e.target.value)} />
      </div>
      <div>
        <label>Directors: </label>
        <select multiple value={selectedDirectors} onChange={handleDirectorChange}>
          {directors.map(d => (
            <option key={d.id} value={d.id}>{d.name}</option>
          ))}
        </select>
      </div>
      <button type="submit">Create Movie</button>
    </form>
  );
}
