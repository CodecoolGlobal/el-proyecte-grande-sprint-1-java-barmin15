import { PostNewEvent } from "../Fetches/postNewEvent";
import { updateEvent } from "../Fetches/updateEvent";
import { useNavigate } from "react-router-dom";
import "../style/eventForm.css";

function EventForm(event) {

  const navigate = useNavigate();
  const user = { id: 9 };

  //   event =  {
  //     id: 0,
  //     creatorId: 9,
  //     name: "lekvar fozes",
  //     description: "szilva alma barack cserko",
  //     date: "2026-03-21",
  //     location: "konyhaba",
  //     isPrivate: false
  // }

  // const onUpdate = (e) => {
  //     e.preventDefault();
  //     const formData = new FormData(e.target);
  //     const entries = [...formData.entries()];

  //     const event = entries.reduce((acc, entry) => {
  //       const [k, v] = entry;
  //       acc[k] = v;
  //       return acc;
  //     }, {});

  //     delete(event.isPrivate);
  //     delete(event.location);
  //     updateEvent(event);
  //     console.log(":-)")
  //     console.log(event)

  // }

  const onCreate = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    const event = entries.reduce((acc, entry) => {
      const [k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});
    event.time += ":00"

    PostNewEvent(event);
    navigate("/events");
  };

  return (
    <form className="eventForm" onSubmit={onCreate}>
      <h2>Create a new Event!</h2>

      <div className="creatorId">
        <input type="hidden" name="creatorId" defaultValue={user.id} />
      </div>
      <div className="id">
        <input type="hidden" name="id" defaultValue={event ? event.id : null} />
      </div>

      <div className="name">
        <label htmlFor="name">Name your event:</label>
        <input
          type="text"
          defaultValue={event ? event.name : null}
          name="name"
          id="name"
        />
      </div>

      <div className="description">
        <label htmlFor="description">Describe your event:</label>
        <input
          type="text"
          defaultValue={event ? event.description : null}
          name="description"
          id="description"
        />
      </div>

      <div className="date">
        <label htmlFor="date">When is it?</label>
        <input
          type="date"
          defaultValue={event ? event.date : null}
          name="date"
          id="date"
        />
        <input type="time" defaultValue={event ? event.time : null}
          name="time"
          id="time"/>
      </div>

      <div className="location">
        <label htmlFor="location">Where is it?</label>
        <input
          type="text"
          defaultValue={event ? event.location : null}
          name="location"
          id="location"
        />
      </div>

      {/* <div className="isPrivate">
        <label htmlFor="isPrivate">Is the event private? </label>
        <input
          type="checkbox"
          defaultChecked={event.isPrivate ? true : false}
          name="isPrivate"
          id="isPrivate"
        />
      </div> */}
      <div className="isPrivate">
        <input
          type="hidden"
          name="isPrivate"
          defaultValue={event ? event.isPrivate : false}
        />
      </div>

      <button type="submit">Save</button>
    </form>
  );
}

export default EventForm;
