import User from "./User.jsx"

export default function UserView({ user }) {
  if (!user) {
    return <p>No user selected.</p>;
  }
  return <User name={user.name} email={user.email} />;
}