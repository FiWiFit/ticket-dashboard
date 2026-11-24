import LogoutButton from "../../features/auth/components/LogoutButton";
import { useAuth } from "../../hooks/useAuth";

export default function InternalDashboard() {
  const { user } = useAuth();

  return (
    <main>
      <h1>Internal Dashboard</h1>
      <p>Hello, {user?.firstName}!</p>
      <LogoutButton />
    </main>
  );
}
