import React, { useContext } from "react";
import { ThemeContext } from "./ThemeContext";
import "./App.css";

function App() {
  const { theme, toggleTheme } = useContext(ThemeContext);

  return (
    <div className={`app ${theme}`}>
      <h1>{theme === "light" ? "Light Mode" : "Dark Mode"}</h1>
      <button onClick={toggleTheme}>Switch Theme</button>
    </div>
  );
}

export default App;
