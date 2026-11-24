import { apiClient } from "../../../api/client";
import type { AuthUser } from "../../../types/authTypes";

/**
 * Communicates with and knows which authentication endpoint to call.
 * @returns API response data
 */

export async function getCurrentUser(): Promise<AuthUser> {
  const response = await apiClient.get<AuthUser>("/api/auth/me");

  return response.data; // of type AuthUser
}

// Login
export async function login(email: string, password: string): Promise<void> {
  // Retrieve CSRF tocken
  const csrfResponse = await apiClient.get("/api/auth/csrf");

  const csrf = csrfResponse.data;

  // Prepare credentials using form-encoded data (spring security feature)
  const credentials = new URLSearchParams({
    username: email,
    password: password,
  });

  // Send login request & preserve session
  await apiClient.post("/api/auth/login", credentials, {
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
      [csrf.headerName]: csrf.token,
    },
  });
}

// Logout
export async function logout(): Promise<void> {
  // Get a fresh CSRF token BEFORE LOGOUT since Spring Security clears the previous token following successful authentication
  // (Logout changes server-side state, so it requires CSRF protection)
  const csrfResponse = await apiClient.get("/api/auth/csrf");
  const csrf = csrfResponse.data;

  await apiClient.post("/api/auth/logout", null, {
    headers: {
      [csrf.headerName]: csrf.token,
    },
  });
}
