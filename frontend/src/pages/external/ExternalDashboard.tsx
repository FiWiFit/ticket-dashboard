import LogoutButton from "../../features/auth/components/LogoutButton";
import { useAuth } from "../../hooks/useAuth";

export default function ExternalDashboard() {
  const { user } = useAuth();

  return (
    <main>
      <h1>Client Dashboard</h1>
      <p>Hello, {user?.firstName}!</p>
      <LogoutButton />
    </main>
  );
}
