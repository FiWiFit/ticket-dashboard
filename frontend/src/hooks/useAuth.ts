import { useContext } from "react";
import { AuthContext } from "../features/auth/context/AuthContext";

/**
 * Custom hook that provides convenient, validated access authentication context.
 * Without this hook, every component would need to import useContext, import AuthContext and potentially check whether the context exists.
 * Instead, any component can just write: const { isLoggedIn, isLoading, loginSuccess } = useAuth();
 * Gives access to isLoggedIn, isLoading, loginSuccess
 * @returns context
 */
export function useAuth() {
  // Read the authentication context supplied by the nearest AuthProvider above the component.
  const context = useContext(AuthContext);

  // If useAuth() is used outside of AuthProvider, throw an error immediately.
  if (context === undefined) {
    throw new Error("useAuth must be used within an AuthProvider");
  }

  return context;
}
