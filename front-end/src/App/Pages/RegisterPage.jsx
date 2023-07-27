import { useState } from "react";
import "./LogIn.css"
import { RegisterUser } from "../Fetches/RegisterUser";

export default function RegisterPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    
    function register() {
        if (username.length > 5 && password.length > 5) {
            if (RegisterUser(username, password).then(response => response === true)) {
                window.location.href = "http://localhost:3000/event/all"
            }
        }
    }

    return (<div className="container flex">
        <div className="form">
            <input type="" placeholder="Username" required onChange={(e) => setUsername(e.target.value)}></input>
            <input type="password" placeholder="Password" required onChange={(e) => setPassword(e.target.value)}></input>
            <div className="link">
                <button  className="login" onClick={() => register()}>Register</button>
            </div>
            <div className="button">
                <a href="/login">Already A User?</a>
            </div>
            </div>
            </div>)
}