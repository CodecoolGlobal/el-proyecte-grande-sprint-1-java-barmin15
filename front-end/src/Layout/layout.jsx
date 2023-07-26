import { Outlet } from "react-router-dom"
import "./layout.css"

function Layout(){
    return <div >
    <div class="topnav">
    <a class="active" href="#home">Profile</a>
    <div href="" id="logo">EVENET</div>
  </div>
  <div id="mySidenav" class="sidenav">
  <a href="/" id="addEvent">Add</a>
  <a href="/" id="allEvents">All</a>
</div>
   <Outlet/>
  </div>
}



export default Layout