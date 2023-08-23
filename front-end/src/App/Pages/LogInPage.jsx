import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom";
import "../style/LogIn.css";
import { LogInUser } from "../Fetches/LogInUser";
import { request, setAuthToken } from "../../axios_helper";


export default function LogInPage() {
    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    function logIn() {
        request("POST",
            "/api/auth/login",
            { login: username, password: password }
        ).then((response) => {
            setAuthToken(response.data.token)
            navigate("/event/all");
        }).catch((error) => {
            console.log(error)
        })


        /* if (await LogInUser(username, password)) {
             navigate("/event/all")
         }*/
    }


    return (
        <div className="container flex">
            <div className="form">
                <input placeholder="Username" required onChange={(e) => setUsername(e.target.value)}></input>
                <input type="password" placeholder="Password" required onChange={(e) => setPassword(e.target.value)}></input>
                <div className="link">
                    <button className="login" onClick={() => logIn()}>Login</button>
                </div>
                <div className="button">
                    <a href="/">Create new account</a>
                </div>
            </div>
        </div>)

}
