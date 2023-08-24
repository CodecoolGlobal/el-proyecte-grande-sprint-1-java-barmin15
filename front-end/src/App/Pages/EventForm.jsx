import { postNewEvent } from "../Fetches/postNewEvent";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import "../style/eventForm.css";
import AllCategoiresSelectInput from "./AllCategoriesSelectInput";
import { getRequest, request } from "../../axios_helper";

function EventForm(event) {
  const navigate = useNavigate();
  const user = { id: 1 };

  const [categories, setCategories] = useState(null);
  const [actualCategory, setActualCategory] = useState([1]);
  const [newCategory, setNewCategory] = useState(0);
  const [date, setDate] = useState("");
  useEffect(() => {
    getRequest("/category")
      .then((response) => setCategories(response.data))
  }, [newCategory]);

  function handleChange(e) {
    setActualCategory([Number(e.target.value)]);
  }

  function onCreateCategory() {
    setNewCategory(newCategory + 1);
  }

  const onCreate = async (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const event = Object.fromEntries(formData.entries());
    delete event.categories;
    delete event.id;
    delete event.isPrivate;
    event.userId = 1;
    event.categoryIds = actualCategory;
    event.time = event.time + ":00";
    event.date = date;
  
    await request("POST", "/event", event)
    .then((response) => {
      navigate("/event/all");
    })
    .catch((error) => {
     navigate("/error");
    });
  
  };

  return (
    <div>
      <form className="eventForm" onSubmit={onCreate}>
        <div className="form">
          <h2>Create a new Event!</h2>

          <div className="creatorId">
            <input type="hidden" name="userId" defaultValue={user.id} />
          </div>
          <div className="id">
            <input
              type="hidden"
              name="id"
              defaultValue={event ? event.id : null}
            />
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
              onChange={(e) => setDate(e.target.value)}
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
          <div className="category">
            <AllCategoiresSelectInput
              handleChange={handleChange}
              chosenValue={categories && actualCategory}
              categories={categories && categories}
              onCreateCategory={onCreateCategory}
            />
          </div>

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
                // type="submit"
            >
              Save
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}

export default EventForm;
