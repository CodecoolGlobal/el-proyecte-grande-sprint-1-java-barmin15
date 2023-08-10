import useCurrentUser from "../Fetches/GetCurrentUser";
import "../style/userProfile.css"

function UserProfile() {
const user = useCurrentUser();

if(user !== null){
  
console.log(user);
// //test objects
// user.createdEvents = [];
// user.createdEvents.push({title: "eskuvo", id: 1});
// user.createdEvents.push({title: "disznovagas", id: 2});
// user.interestedEvents = [];
// user.interestedEvents.push({title: "parti", id: 1});
// user.interestedEvents.push({title: "karacsonyi unnepseg", id: 2});
// user.interestedEvents.push({title: "csonakazas", id: 2});


  return  <div className="userProfile">
    <div id="profPic"><img src="https://t4.ftcdn.net/jpg/03/40/12/49/360_F_340124934_bz3pQTLrdFpH92ekknuaTHy8JuXgG7fi.jpg" alt="" width={70} height={70}/></div>
   <div id="userData">
    <h1>{user.name}</h1>

    <div className="userEvents">
      <ul className="created">
        <h2>Created:</h2>
         {user.createdEvents && user.createdEvents.map((e) =>{
           return <a className="eventTitle" href={`/event/${e.id}`}><li>{e.title} </li></a> 
          })}
      </ul>

      <ul className="interested">
        <h2>Interested in:</h2>
         {user.interestedEvents && user.interestedEvents.map((e) =>{
           return <a className="eventTitle" href={`/event/${e.id}`}><li>{e.title} </li></a> 
          })}
      </ul>

    </div>

    {/* <h3>{user.description}</h3> */}
   </div>
  </div>;
}


}
export default UserProfile;
