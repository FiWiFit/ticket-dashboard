import { useState } from "react";
import type { FormEvent } from "react";
import { login } from "../api/authApi";

// Login callback
type LoginFormProps = {
  onLoginSuccess: () => Promise<void>;
};

/**
 * Login form for users to sign in using Spring Security
 * @param param0
 * @returns
 */
export default function LoginForm({ onLoginSuccess }: LoginFormProps) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    // prevent browser from refreshing the page
    event.preventDefault();

    try {
      // Authenticate before fetching the current user.
      await login(email, password);
      await onLoginSuccess();
    } catch (error) {
      console.error("Login failed:", error);
    }
  }

  return (
    <>
      <h1>Ticket Dashboard</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="email">Email</label>
        <input
          id="email"
          type="email"
          value={email}
          onChange={(event) => setEmail(event.target.value)}
          required
        />

        <label htmlFor="password">Password</label>
        <input
          id="password"
          type="password"
          value={password}
          onChange={(event) => setPassword(event.target.value)}
          required
        />

        <button type="submit">Log in</button>
      </form>
    </>
  );
}
