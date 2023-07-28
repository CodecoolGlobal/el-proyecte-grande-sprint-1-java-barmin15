import { useEffect, useState } from "react";
import "./AllEvent.css";

function AllEvent() {
  const [events, setEvents] = useState(null);

  useEffect(() => {
    fetch("http://127.0.0.1:0420/event/all")
      .then((response) => response.json())
      .then((data) => setEvents(data));
  }, []);

  return (
    <div className="events">
      {events &&
        events.map((e, index) => (
          <div className={(index % 2 === 0) ? 'event even' : 'event odd'} key={index}>
            <div className="details">
              <h1>{e.name}</h1>
              <h2>{e.date}</h2>
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
