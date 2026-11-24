import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import AuthProvider from "./features/auth/context/AuthProvider.tsx";
import "./styles/index.css";
import App from "./app/App.tsx";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <AuthProvider>
      <App />
    </AuthProvider>
  </StrictMode>,
);
