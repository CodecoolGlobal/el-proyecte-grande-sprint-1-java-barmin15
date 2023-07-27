import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function EventPage() {
  const [event, setEvent] = useState(null);

  const { id } = useParams();

  useEffect(() => {
    fetch(`http://127.0.0.1:0420/event/${id}`)
      .then((response) => response.json())
      .then((data) => setEvent(data));
  }, []);

  function handleClick() {

    const data = 0;
    postJSON(id);
  }

  async function postJSON(userID, data) {
    try {
      const response = await fetch("http://127.0.0.1:0420/", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });

      const result = await response.json();
      console.log("Success:", result);
    } catch (error) {
      console.error("Error:", error);
    }
  }

  //event && console.log(event);

  return (
    <div>
      {event && (
        <div>
          <h1>{event.name}</h1>
          <h2>{event.date}</h2>
          <h2>{event.location}</h2>
          <p>{event.description}</p>
          
            <button onClick={handleClick}>Apply</button>
          
        </div>
      )}
    </div>
  );
}

export default EventPage;
