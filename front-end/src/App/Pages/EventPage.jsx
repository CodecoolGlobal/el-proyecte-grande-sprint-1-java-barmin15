import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import "../style/eventPage.css";

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
  event && console.log(event);
  if(event){
     event.items = [{name: "food"}, {name:"drink"}, {name:"sunscreen"}, {name:"boardgames"}, {name:"backpack"}]
  }
  
  return (
    <div className="Event">
         <div className="items">
          <h4>Necessary items:</h4>
            {event && (
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
           <h1 id="title">{event.title}</h1>
           <div className="dateTime location">
           <h2 id="dateTime">{event.dateTime.substring(0,18)}</h2>
           <h2> | </h2>
           <h2 id="location">{event.location}</h2>
           </div>
           <h2 id="category">{event.categories.length > 0 && event.categories[0].name}</h2>
           <p id="description">{event.description}</p>
           <button onClick={handleClick}>Save</button>
          </div>

          <div>
           <div className="picture"> <img src="https://i.pinimg.com/564x/4b/50/9a/4b509acbc36049b967d12e705a7990a1.jpg" alt="event pic" height={486} width={369}/> </div>
          </div>
       
          
          
        </div>
      )}
    </div>
  );
}

export default EventPage;
