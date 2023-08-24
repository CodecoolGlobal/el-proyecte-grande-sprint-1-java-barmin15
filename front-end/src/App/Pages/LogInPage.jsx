import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../style/LogIn.css";
import { request, setAuthToken } from "../../axios_helper";

export default function LogInPage() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("anna");
  const [password, setPassword] = useState("titok");

  const saveToken = (token) => {
    window.localStorage.setItem("auth_token", token);
  };

  const url = "/api/auth/login";

  function logIn() {
    request("POST", url, { login: username, password: password })
      .then((response) => {
        console.log(response.data);
        saveToken(response.data.token);
        setAuthToken(response.data.token);
        navigate("/event/all");
      })
      .catch((error) => {
        console.log(error);
      });

    /* if (await LogInUser(username, password)) {
             navigate("/event/all")
         }*/
  }

  return (
    <div className="container flex">
      <div className="form">
        <input
          placeholder="Username"
          required
          onChange={(e) => setUsername(e.target.value)}
        ></input>
        <input
          type="password"
          placeholder="Password"
          required
          onChange={(e) => setPassword(e.target.value)}
        ></input>
        <div className="link">
          <button className="login" onClick={() => logIn()}>
            Login
          </button>
        </div>
        <div className="button">
          <a href="/">Create new account</a>
        </div>
      </div>
    </div>
  );
}
