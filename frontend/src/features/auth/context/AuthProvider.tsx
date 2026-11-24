import { useEffect, useState } from "react";
import type { ReactNode } from "react";
import axios from "axios";

import { getCurrentUser, logout as logoutRequest } from "../api/authApi";
import { AuthContext } from "./AuthContext";
import type { AuthUser } from "../../../types/authTypes";

type AuthProviderProps = {
  children: ReactNode;
};

/**
 * Owns and manages authentication state and session restoration.
 * @param context
 * @returns isLoggedIn, isLoading, loginSuccess
 */
export default function AuthProvider({ children }: AuthProviderProps) {
  const [user, setUser] = useState<AuthUser | null>(null);
  // Derive state (we can calculate from existing state)
  const isLoggedIn = user !== null;
  const [isLoading, setIsLoading] = useState(true);

  // Check existing backend session
  useEffect(() => {
    async function checkSession() {
      try {
        const currentUser = await getCurrentUser();
        setUser(currentUser);
      } catch (error) {
        if (axios.isAxiosError(error) && error.response?.status === 401) {
          setUser(null);
        } else {
          console.error("Failed to check session:", error);
        }
      } finally {
        setIsLoading(false);
      }
    }

    checkSession();
  }, []);

  async function loginSuccess(): Promise<void> {
    const currentUser = await getCurrentUser();
    setUser(currentUser);
  }

  async function logout(): Promise<void> {
    // logout coordinates the logout process and update React state
    // logoutRequest() communicates with the backend
    await logoutRequest();
    setUser(null);
  }

  return (
    <AuthContext.Provider
      value={{
        user,
        isLoggedIn,
        isLoading,
        loginSuccess,
        logout,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}
