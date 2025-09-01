export default function UserSelector({ users, onSelect }) {
  return (
    <select onChange={(o) => onSelect(o.target.value)}>
      <option value={0}>{users[0].name}</option>
      <option value={1}>{users[1].name}</option>
      <option value={2}>{users[2].name}</option>
    </select>
  );
}