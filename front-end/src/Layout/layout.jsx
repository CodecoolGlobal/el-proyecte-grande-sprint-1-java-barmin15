import { Outlet } from "react-router-dom"
import "./layout.css"

function Layout(){
    return <div>
    <div className="topnav">
    <a className="active" href="/event/ownprofile">Profile</a>
    <div href="" id="logo">EVENET</div>
  </div>
  <div id="mySidenav" className="sidenav">
  <a href="/event/create" id="addEvent">Add</a>
  <a href="/event/all" id="allEvents">All</a>
  <a href="/" id="logOut">Log Out</a>
</div>
   <Outlet/>
  </div>
}



export default Layout