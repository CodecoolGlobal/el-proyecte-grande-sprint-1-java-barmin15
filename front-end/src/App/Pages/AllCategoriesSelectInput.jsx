import { useState } from "react";
import { postNewCategory } from "../Fetches/postNewCategory";
import { request, getAuthToken } from "../../axios_helper";
import { useNavigate } from "react-router-dom";

function AllCategoiresSelectInput(props) {
  const { categories, handleChange, chosenValue, onCreateCategory } = props;

  const navigate = useNavigate();

  const [inputCategory, setInputCategory] = useState(null);

  async function handleSaveCategory(e) {
    e.preventDefault();
    //await postNewCategory(inputCategory);
    await request("POST", "/category", inputCategory)
    .then((response) => {
      navigate("/event/all");
    })
    .catch((error) => {
      console.log(error);
    });

    navigate("/event/all");

    setInputCategory("");
    onCreateCategory();
  }

  return (
    <div className="categories">
      <label htmlFor="categories">Choose a category:</label>
      <select
        onChange={handleChange}
        value={chosenValue}
        name="categories"
        id="categories"
      >
        {categories &&
          categories.map((e) => (
            <option value={e.id} key={e.id}>
              {e.name}
            </option>
          ))}
      </select>

      <div className="date">
        <label htmlFor="date">Or add a new one:</label>
        <div className="addCategory">
        <input
          type="text"
          placeholder={"new category..."}
          name="date"
          id="date"
          onChange={(e) => setInputCategory(e.target.value)}
          value={inputCategory}
        />
     { inputCategory &&  <button
          onClick={(e) => {
            inputCategory && handleSaveCategory(e);
          }}
        >
          +
        </button>}
          </div>
      </div>
    </div>
  );
}

export default AllCategoiresSelectInput;
