import { Outlet } from "react-router-dom"
import "./layout.css"

function Layout(){
    return <div >
    <div className="topnav">
    <a className="active" href="/ownprofile">Profile</a>
    <div href="" id="logo">EVENET</div>
  </div>
  <div id="mySidenav" className="sidenav">
  <a href="/create" id="addEvent">Add</a>
  <a href="/events" id="allEvents">All</a>
</div>
   <Outlet/>
  </div>
}



export default Layout