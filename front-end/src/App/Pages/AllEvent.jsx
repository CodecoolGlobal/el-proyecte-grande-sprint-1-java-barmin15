import { useEffect, useState } from "react";
import "../style/AllEvent.css";
import useAllCategories from "../Fetches/getAllCategories";
import InfiniteScroll from "react-infinite-scroll-component";
import React from "react";

function AllEvent() {
  const [events, setEvents] = useState([]);
  const [counter, setCounter] = useState(1)
  const [hasMore, setHasMore] = useState(true)
  const [dataLength, setDataLength] = useState(0);
  const [maxLength, setMaxLength] = useState(0)
  const [selectedCategory, setSelectedCategory] = useState("none");
  const [searchInput, setSearchInput] = useState("")

  const fetchedCategories = useAllCategories();
  
  function handleSearch(){
  }


  useEffect(() => {
    const limit = 6;
    fetch(`/event/limit/${limit * counter}`)
      .then((response) => response.json())
      .then((data) => {
        setEvents(data);
        setDataLength(data.length)
      });

    fetch(`/event`)
      .then((response) => response.json())
      .then((data) => {
        setMaxLength(data.length)
      });
  }, [counter]);

  function fetchMoreEvents() {
    if (maxLength === dataLength) {
      setHasMore(false)
    } else {
      setTimeout(() => {
        setCounter(counter + 1)
      }, 500)
    }
  }

  return (
    <div className="events">
      <InfiniteScroll
        dataLength={events.length}
        next={fetchMoreEvents}
        hasMore={hasMore}
        loader={<p>LOADING MORE EVENTS...</p>}
        endMessage={<p>NO MORE EVENTS TO LOAD</p>}
      >

        <div>
          <div role="search">
            <input id="search" type="search" placeholder="Search..."onChange={(e)=> setSearchInput(e.target.value)}/>
            <button onClick={handleSearch}>search</button>
          </div>
          <label htmlFor="categories">select a category:</label>
          <select name="categories" id="categories" onChange={(e) => setSelectedCategory(e.target.value)}>
          <option value="none">none</option>
            {fetchedCategories !== undefined && fetchedCategories.map(category => (
              <option value={category.name} key={category.id}>{category.name}</option>))}
          </select>
        </div>

        {events &&
          events.map((e, index) => (
            <div className={index % 2 === 0 ? "event even" : "event odd"} key={index}>
              <div className="picture"> <img src="https://i.pinimg.com/564x/4b/50/9a/4b509acbc36049b967d12e705a7990a1.jpg" alt="event pic" height={270} width={205} /> </div>
              <div className="details">

                <div className="date category">
                  <h2>{e.date}</h2>
                  <h2> | </h2>
                  <h2>{e.categories.length > 0 && e.categories[0].name}</h2>
                </div>

                <h1>{e.title}</h1>
                <h2 className="location">{e.location}</h2>
                <a href={`http://127.0.0.1:3000/event/${e.id}`}>
                  <button>Details</button>
                </a>
              </div>

            </div>
          ))}

      </InfiniteScroll>

    </div>
  );

}

export default AllEvent;
