import useCurrentUser from "../Fetches/GetCurrentUser";
import "../style/userProfile.css"


function UserProfile() {
const user = useCurrentUser();

if(user !== null){




  return  <div className="userProfile">
    <div id="profPic"><img src="https://t4.ftcdn.net/jpg/03/40/12/49/360_F_340124934_bz3pQTLrdFpH92ekknuaTHy8JuXgG7fi.jpg" alt="" width={70} height={70}/></div>
   <div id="userData">
    <h1>{user.name}</h1>
    {/* <h3>{user.description}</h3> */}
   </div>
  </div>;
}


}
export default UserProfile;
