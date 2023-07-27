import { useEffect, useState } from "react"
import "./LogIn.css"
import { LogInUser } from "../Fetches/LogInUser";


export default function LogInPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");


    function logIn() {
        const isUser = LogInUser(username, password)
        if (isUser.typeof === "boolean" && isUser === true) {
            window.location.replace("http://localhost:3000/event/all")
        }
    }



    return (<div className="container flex">
        <form action="#">
            <input type="" placeholder="Username" required onChange={(e) => setUsername(e.target.value)}></input>
            <input type="password" placeholder="Password" required onChange={(e) => setPassword(e.target.value)}></input>
            <div className="link">
                <button type="submit" className="login" onClick={() => logIn()}>Login</button>
            </div>
            <hr></hr>
            <div className="button">
                <a href="/">Create new account</a>
            </div></form></div>)
}