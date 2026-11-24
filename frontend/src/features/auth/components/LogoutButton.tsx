import { useState } from "react";
import { useAuth } from "../../../hooks/useAuth";

export default function LogoutButton() {
  const { logout } = useAuth();

  const [isLoggingOut, setIsLoggingOut] = useState(false);
  const [error, setError] = useState<string | null>(null);

  async function handleLogout() {
    setIsLoggingOut(true);
    setError(null);

    try {
      await logout();
    } catch (error) {
      console.error("Logout failed:", error);
      setError("Unable to log out. Please try again.");
    } finally {
      setIsLoggingOut(false);
    }
  }

  return (
    <>
      <button type="button" onClick={handleLogout} disabled={isLoggingOut}>
        {isLoggingOut ? "Logging out..." : "Log out"}
      </button>
      {error && <p role="alert">{error}</p>}
    </>
  );
}
