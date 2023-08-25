import { useEffect, useState } from "react";
import "../style/userProfile.css";
import { useNavigate } from "react-router-dom";
import { getRequest, getAuthToken } from "../../axios_helper";
function UserProfile() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();
  const update = false;

  useEffect(()=>{
    const url = "/user/current"
    getRequest(url)
    .then((response)=> {
      console.log(response.data)
      setUser(response.data)
    }).catch((error)=>{
      navigate("/error")
    })
  },[])


  if (user !== null) {
    return (
      <div className="userProfile">
        <div id="profPic">
          <img
            src="https://t4.ftcdn.net/jpg/03/40/12/49/360_F_340124934_bz3pQTLrdFpH92ekknuaTHy8JuXgG7fi.jpg"
            alt=""
            width={70}
            height={70}
          />
        </div>
        <div id="userData">
          <button onClick={() => navigate("/event/user/update")}>Update</button>

          <h1>{user.firstName + " " + user.lastName}</h1>

          <div className="userEvents">
            <ul className="created">
              <h2>Created:</h2>
              {user.createdEvents &&
                user.createdEvents.map((e) => {
                  return (
                    <a className="eventTitle" href={`/event/${e.id}`}>
                      <li>{e.title} </li>
                    </a>
                  );
                })}
            </ul>

            <ul className="interested">
              <h2>Interested in:</h2>
              {user.interestedEvents &&
                user.interestedEvents.map((e) => {
                  return (
                    <a className="eventTitle" href={`/event/${e.id}`}>
                      <li>{e.title} </li>
                    </a>
                  );
                })}
            </ul>
          </div>

          <h3>{user.description}</h3>
        </div>
      </div>
    );
  }
}
export default UserProfile;
