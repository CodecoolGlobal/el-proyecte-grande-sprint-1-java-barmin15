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
          <div
            className={index % 2 === 0 ? "event even" : "event odd"}
            key={index}
          >
            <div className="details">
              <h1>{e.title}</h1>
              <h2>{e.categories[0].name}</h2>
              <h2>{e.dateTime}</h2>
              <h2>{e.location}</h2>
            </div>
            <div>
              <p>{e.description}</p>
              <a href={`http://127.0.0.1:3000/event/${e.id}`}>
                <button>Details</button>
              </a>
            </div>
          </div>
        ))}
    </div>
  );
}

export default AllEvent;
