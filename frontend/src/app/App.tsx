import LoginForm from "../features/auth/components/LoginForm";
import { useAuth } from "../hooks/useAuth";
import ExternalDashboard from "../pages/external/ExternalDashboard";
import InternalDashboard from "../pages/internal/InternalDashboard";

function App() {
  const { user, isLoading, loginSuccess } = useAuth();

  // Prevents the login form briefly appearing while we're checking whether a session exists.
  if (isLoading) {
    return <p>Checking session...</p>;
  }

  if (!user) {
    return <LoginForm onLoginSuccess={loginSuccess} />;
  }

  if (user.roles.includes("ROLE_INTERNAL")) {
    return <InternalDashboard />;
  }

  if (user.roles.includes("ROLE_EXTERNAL")) {
    return <ExternalDashboard />;
  }

  // Won't automatically assume that someone who isn't an internal user must be an external user.
  return <p>Access denied.</p>;
}

export default App;
