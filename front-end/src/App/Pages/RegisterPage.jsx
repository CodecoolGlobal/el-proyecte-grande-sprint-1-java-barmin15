import { useState } from "react";
import { RegisterUser } from "../Fetches/RegisterUser";

export default function RegisterPage(){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");


    function register(){
        if(password.includes(typeof "number") && password.includes(typeof "string")){
            const isUser = RegisterUser(username, password)
            if (isUser.typeof === "boolean" && isUser === true) {
                window.location.replace("http://localhost:3000/event/all")
            }
        }
    }

    return (<div className="container flex">
        <form action="#">
            <input type="" placeholder="Username" required onChange={(e) => setUsername(e.target.value)}></input>
            <input type="password" placeholder="Password" required onChange={(e) => setPassword(e.target.value)}></input>
            <div className="link">
                <button type="submit" className="login" onClick={() => register()}>Register</button>
            </div>
            <hr></hr>
            <div className="button">
                <a href="/login">Already A User?</a>
            </div></form></div>)
}