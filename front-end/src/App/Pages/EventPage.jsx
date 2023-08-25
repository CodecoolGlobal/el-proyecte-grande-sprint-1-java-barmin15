import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import "../style/eventPage.css";
import { getRequest, request } from "../../axios_helper";
import { useNavigate } from "react-router-dom";

function EventPage() {
  const navigate = useNavigate();
  const [event, setEvent] = useState(null);
  const [user, setUser] = useState(null);
  const { id } = useParams();

  useEffect(() => {
    const eventUrl = `/event/${id}`;
    const userUrl = "/user/current/id"

    getRequest(eventUrl)
      .then((response) => {
        console.log(response.data)
        setEvent(response.data)
      })
      .catch((error) => {
        navigate("/error");
      });

    getRequest(userUrl)
      .then((response) => {
        setUser(response.data)
      }).catch((error) => {
        navigate("/error")
      })
  }, [])

  function handleClick() {
    const interestedUrl = "/event";
    const method = "PUT";
    const body = { userId: user, eventId: id }
    console.log(body)
    request(method, interestedUrl, body)
      .then((response) => {
        navigate("/event/all");
      })
      .catch((error) => {
        navigate("/error");
      })
  }

  ////TODO ITEMS////
  if (event) {
    event.items = [
      { name: "food" },
      { name: "drink" },
      { name: "sunscreen" },
      { name: "boardgames" },
      { name: "backpack" },
    ];
  }
  ////////////////


  if (event !== null) {
    console.log(event)
    return (
      <div className="Event">
        <div className="items">
          <h4>Necessary items:</h4>
          {event.items.length > 0 && (
            <ul>
              {event.items.map((item, index) => (
                <li id={index}>{item.name}</li>
              ))}
            </ul>
          )}
        </div>

        {event && (
          <div className="eventt">
            <div className="details">
              <div className="title saveButton">
                <h1 id="title">{event.title}</h1>
                <button onClick={handleClick}>Save</button>
              </div>

              <div className="dateTime location">
                <h2 id="dateTime">{event.date + " - " + event.time}</h2>
                <h2> | </h2>
                <h2 id="location">{event.location}</h2>
              </div>
              <h2 id="category">
                {event.categories.length > 0 && event.categories[0].name}
              </h2>
              <p id="description">{event.description}</p>
            </div>

            <div>
              <div className="pic">
                {" "}
                <img
                  src="https://i.pinimg.com/564x/4b/50/9a/4b509acbc36049b967d12e705a7990a1.jpg"
                  alt="event pic"
                  height={486}
                  width={369}
                />{" "}
              </div>
            </div>

            <div className="participants">
              <div className="creator">
                <h4>Creator:</h4>
                <h4>{event.creatorName}</h4>
              </div>

              <h4>Participants:</h4>
              <ul>
              {event.interestedUsers.map((username) =>(
                <li>{username}</li>))}
              </ul>
            </div>
          </div>
        )}
      </div>
    );
  }
}

export default EventPage;
