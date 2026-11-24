// Including ROLE_ prefix because that's what Spring Security returns through our /api/auth/me endpoint.
export type UserRole = "ROLE_INTERNAL" | "ROLE_EXTERNAL";

// Represents the response structure of our current-user endpoint: {"email": "test@example.com", "roles": ["ROLE_EXTERNAL"]}
export type AuthUser = {
  id: string;
  firstName: string;
  lastName: string;
  email: string;
  roles: UserRole[];
};
