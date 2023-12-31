import { useEffect, useState } from "react";
import "../style/AllEvent.css";
import useAllCategories from "../Fetches/getAllCategories";
import InfiniteScroll from "react-infinite-scroll-component";
import React from "react";
import { getRequest, getAuthToken } from "../../axios_helper";
import { useNavigate } from "react-router-dom";

function AllEvent() {
  const navigate = useNavigate();
  const [events, setEvents] = useState([]);
  const [counter, setCounter] = useState(1);
  const [hasMore, setHasMore] = useState(true);
  const [dataLength, setDataLength] = useState(0);
  const [maxLength, setMaxLength] = useState(0);
  const [selectedCategory, setSelectedCategory] = useState("");
  const [searchInput, setSearchInput] = useState("");

  const fetchedCategories = useAllCategories();

  useEffect(() => {
    const limit = 6;
    let byName = searchInput;
    let byCategories = selectedCategory;
    if (selectedCategory.length < 1) byCategories = "all";
    if (searchInput.length < 1) byName = "all";

    const url = `/event/${byCategories}/${byName}/${limit * counter}`;
    const header = { headers: { Authorization: `Bearer ${getAuthToken()}` } };


    getRequest(url).then((response) => {
        setEvents(response.data.events);
        setMaxLength(response.data.maxLength);
        setDataLength(response.data.events.length);
      }).catch((error) => {
        navigate("/error");
      });


  }, [counter, selectedCategory, searchInput]);

  function fetchMoreEvents() {
    if (maxLength === dataLength) {
      setHasMore(false);
    } else {
      setTimeout(() => {
        setCounter(counter + 1);
      }, 500);
    }
  }

  function onDetail(id) {
    navigate("/event/" + id);

  }

  return (
    <div className="events">
      <div className="search">
        <div role="search">
          <input
            id="search"
            type="search"
            placeholder="Search..."
            onChange={(e) => setSearchInput(e.target.value)}
          />
        </div>

        <label htmlFor="categories">select a category:</label>
        <select
          name="categories"
          id="categories"
          onChange={(e) => setSelectedCategory(e.target.value)}
        >
          <option value="all">all</option>
          {fetchedCategories !== undefined &&
            fetchedCategories.map((category) => (
              <option value={category.name} id={category.id} key={category.id}>
                {category.name}
              </option>
            ))}
        </select>
      </div>

      <InfiniteScroll
        dataLength={events.length}
        next={fetchMoreEvents}
        hasMore={hasMore}
        loader={<p>LOADING MORE EVENTS...</p>}
        endMessage={<p>NO MORE EVENTS TO LOAD</p>}
      >
        {events &&
          events.map((e, index) => (
            <div
              className={index % 2 === 0 ? "event even" : "event odd"}
              key={index}
            >
              <div className="picture">
                {" "}
                <img
                  src="https://i.pinimg.com/564x/4b/50/9a/4b509acbc36049b967d12e705a7990a1.jpg"
                  alt="event pic"
                  height={270}
                  width={205}
                />{" "}
              </div>
              <div className="details">
                <div className="date category">
                <h2>{ new Date(e.date).toDateString().substring(3,new Date(e.date).length)}</h2>                  <h2> | </h2>
                  <h2>{e.categories.length > 0 && e.categories[0].name}</h2>
                </div>

                <h1>{e.title}</h1>
                <h2 className="location">{e.location}</h2>
                <div>
                  <button onClick={() => onDetail(e.id)}>Details</button>
                </div>
              </div>
            </div>
          ))}
      </InfiniteScroll>
    </div>
  );
}

export default AllEvent;
