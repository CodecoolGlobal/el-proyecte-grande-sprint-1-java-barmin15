import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../style/LogIn.css";
import { request } from "../../axios_helper";

export default function RegisterPage() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");

  function register(e) {
    e.preventDefault();

    request("POST", "/api/auth/register", {
      firstName: firstName,
      lastName: lastName,
      login: username,
      password: password,
    })
      .then((response) => {
         navigate("/login")
      })
      .catch((error) => {
        navigate("/error")
      });
  }

  return (
    <div className="container flex">
      <div className="form">
        <input
          type=""
          placeholder="Username"
          required
          onChange={(e) => setUsername(e.target.value)}
        ></input>
        <input
          type=""
          placeholder="First name"
          required
          onChange={(e) => setFirstName(e.target.value)}
        ></input>
        <input
          type=""
          placeholder="Last name"
          required
          onChange={(e) => setLastName(e.target.value)}
        ></input>
        <input
          type="password"
          placeholder="Password"
          required
          onChange={(e) => setPassword(e.target.value)}
        ></input>
        <div className="link">
          <button className="login" onClick={(e) => register(e)}>
            Register
          </button>
        </div>
        <div className="button">
          <a href="/login">Already A User?</a>
        </div>
      </div>
    </div>
  );
}
