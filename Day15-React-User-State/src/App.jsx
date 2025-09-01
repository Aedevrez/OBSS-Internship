import { useState, useEffect } from 'react'
import UserView from './UserView.jsx';
import UserSelector from './UserSelector.jsx';
import './App.css'

export default function App() {
  const [users] = useState([
    { name: "Adem Devrez", email: "adem@devrez.com" },
    { name: "Efe Devrez", email: "efe@devrez.com" },
    { name: "Devrez Devrez", email: "devrez@devrez.com" }
  ]);

  const [selectedUser, setSelectedUser] = useState(null);

  useEffect(() => {
    setSelectedUser(users[0]);
  }, [users]);

  const handleSelectUser = (index) => {
      setSelectedUser(users[index]);
  };

  return (
    <div>
      <h1>User App</h1>
      <UserSelector users={users} onSelect={handleSelectUser} />
      <UserView user={selectedUser} />
    </div>
  );
}