import axios from "axios";

/**
 * Communicates with Spring Boot.
 * Provides shared HTTP infrastructure
 */

// Creating a resuable axios client 'apiClient'
export const apiClient = axios.create({
  baseURL: "http://localhost:8080",
  withCredentials: true, // allows browser to send and receive session cookies during cross-origin requests.
});
