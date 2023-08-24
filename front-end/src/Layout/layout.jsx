import { Outlet } from "react-router-dom"
import "./layout.css"
import { useNavigate } from "react-router-dom"

function Layout(){
const navigate = useNavigate();

  function onAddEvent(){navigate("/event/create");}
  function onAllEVents(){navigate("/event/all");}
  function onLogOut(){navigate("/");}
  function onProfile(){navigate("/event/ownprofile");}
    return <div>
    <div className="topnav">
    <a className="active" onClick={onProfile}>Profile</a>
    <div href="" id="logo">EVENET</div>
  </div>
  <div id="mySidenav" className="sidenav">
  <h1 onClick={onAddEvent} id="addEvent">Add</h1>
  <h1 onClick={onAllEVents} id="allEvents">All</h1>
  <h1 onClick={onLogOut} id="logOut">Log Out</h1>
</div>
   <Outlet/>
  </div>
}



export default Layout