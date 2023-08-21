import { postNewEvent } from "../Fetches/postNewEvent";
import { updateEvent } from "../Fetches/updateEvent";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import "../style/eventForm.css";
import AllCategoiresSelectInput from "./AllCategoriesSelectInput";

function EventForm(event) {
  const navigate = useNavigate();
  const user = { id: 1 };

  const [categories, setCategories] = useState(null);
  const [actualCategory, setActualCategory] = useState([1]);
  const [newCategory, setNewCategory] = useState(0);

  useEffect(() => {
fetch("/category")
      .then((response) => response.json())
      .then((data) => setCategories(data));
  }, []);

useEffect(() => {
    console.log("szerzek neked uj adatokat");
    fetch("/category")
    .then((response) => response.json())
    .then((data) => setCategories(data));
  }, [newCategory]);

  function handleChange(e) {
    setActualCategory([Number(e.target.value)]);
  }

  function onCreateCategory() {
    setNewCategory(newCategory + 1);
    console.log("uj adataim vannak");

  }

  actualCategory && console.log(actualCategory);

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

  const onCreate = async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const event = Object.fromEntries(formData.entries());

    event.dateTime = event.date + " - " + event.time + ":00";
    delete event.time;
    delete event.date;
    delete event.categories;
    delete event.id;
    delete event.isPrivate;
    event.userId = 1;
    event.categoryIds = actualCategory;

    await postNewEvent(event);
    navigate("/event/all");
  };

  return (
    <form className="eventForm" onSubmit={onCreate}>
      <h2>Create a new Event!</h2>

      <div className="category">
        <AllCategoiresSelectInput
          handleChange={handleChange}
          chosenValue={categories && actualCategory}
          categories={categories && categories}
          onCreateCategory={onCreateCategory}
        />
      </div>

      <div className="creatorId">
        <input type="hidden" name="userId" defaultValue={user.id} />
      </div>
      <div className="id">
        <input type="hidden" name="id" defaultValue={event ? event.id : null} />
      </div>

      <div className="name">
        <label htmlFor="name">Name your event:</label>
        <input
          type="text"
          defaultValue={event ? event.title : null}
          name="title"
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
        <input
          type="time"
          defaultValue={event ? event.time : null}
          name="time"
          id="time"
        />
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
      <div className="link">
        <button
          style={{ height: "60px", fontSize: "larger" }}
          classname="formButton"
          // onClick={onCreate}
          //   type="submit"
        >
          Save
        </button>
      </div>
    </form>
  );
}

export default EventForm;
