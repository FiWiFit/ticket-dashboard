import { createContext } from "react";
import type { AuthUser } from "../../../types/authTypes";
/**
 * Defines the information and actions that authentication-related components can access.
 */
export type AuthContextValue = {
  user: AuthUser | null;
  isLoggedIn: boolean;
  isLoading: boolean;
  loginSuccess: () => Promise<void>;
  logout: () => Promise<void>;
};

export const AuthContext = createContext<AuthContextValue | undefined>(
  undefined,
);
