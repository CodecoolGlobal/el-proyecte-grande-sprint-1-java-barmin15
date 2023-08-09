import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function EventPage() {
  const [event, setEvent] = useState(null);

  const { id } = useParams();

  useEffect(() => {
    fetch(`/event/${id}`)
      .then((response) => response.json())
      .then((data) => setEvent(data));
  }, []);

  function handleClick() {

    const data = 0;
    postJSON(id);
  }

  async function postJSON(userID, data) {
    try {
      const response = await fetch("/", {
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

  return (
    <div>
      {event && (
        <div>
          <h1>{event.title}</h1>
          <h2>{event.dateTime}</h2>
          <h2>{event.location}</h2>
          <p>{event.description}</p>
          
            <button onClick={handleClick}>Apply</button>
          
        </div>
      )}
    </div>
  );
}

export default EventPage;
