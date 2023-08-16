import { useEffect, useState } from "react";
import "../style/AllEvent.css";
import React from "react";

function AllEvent() {
  const [events, setEvents] = useState(null);

  useEffect(() => {
    console.log("useEffect");

    fetch("/event")
      .then((response) => response.json())
      .then((data) => {
        setEvents(data);
        console.log(data);
      });
  }, []);

  return (
    <div className="events">
      {events &&
        events.map((e, index) => (
          <div className={index % 2 === 0 ? "event even" : "event odd"} key={index}>
            <div className="picture"> <img src="https://i.pinimg.com/564x/4b/50/9a/4b509acbc36049b967d12e705a7990a1.jpg" alt="event pic" height={270} width={205}/> </div>
            <div className="details">

              <div className="date category">
              <h2>{e.dateTime.substring(0, 10)}</h2>
              <h2> | </h2>
              <h2>{e.categories.length > 0 && e.categories[0].name}</h2>
              </div>

              <h1>{e.title}</h1>
              <h2 className="location">{e.location}</h2>
              <a href={`http://127.0.0.1:3000/event/${e.id}`}>  
              <button>Details</button>
              </a>
            </div>
            {/* <div>
              <p>{e.description}</p>
              
            </div> */}
          </div>
        ))}
    </div>
  );
}

export default AllEvent;
