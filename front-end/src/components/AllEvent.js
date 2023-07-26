import { useEffect, useState } from "react";

function AllEvent() {
  const [events, setEvents] = useState(null);

  useEffect(() => {
    fetch("http://127.0.0.1:0420/event/all")
      .then((response) => response.json())
      .then((data) => setEvents(data));
  }, []);

  return (
    <div>
      {events && events.map((e, index) => (
        <div style={{border:"3px", color:"black", borderStyle:"dotted"}} className="event" key={index}>
          <h2>{e.name}</h2>
          <h2>{e.description}</h2>
          <h2>{e.date}</h2>
          <h2>{e.location}</h2>
        </div>
      ))}
    </div>
  );
}

export default AllEvent;
