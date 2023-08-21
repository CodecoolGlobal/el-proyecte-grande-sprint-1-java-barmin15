import { useEffect, useState } from "react";
import "../style/AllEvent.css";
import InfiniteScroll from "react-infinite-scroll-component";
import React from "react";

function AllEvent() {
  const [events, setEvents] = useState([]);
  const [counter, setCounter] = useState(1)
  const [hasMore, setHasMore] = useState(true)
  const [dataLength, setDataLength] = useState(0);
  const [maxLength, setMaxLength] = useState(0)

  useEffect(() => {
    const limit = 4;
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
      }, 600)
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
