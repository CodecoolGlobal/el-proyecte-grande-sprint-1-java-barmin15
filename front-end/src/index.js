import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider, useParams } from "react-router-dom";
import reportWebVitals from "./Vitals/reportWebVitals";


import Layout from "./Layout/layout";

import App from "./App/App";
import EventForm from "./components/EventForm";
import AllEvent from "./components/AllEvent";
import EventPage from "./components/EventPage";



const Router = createBrowserRouter([
  
 
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/events",
        element: <AllEvent />,
      },{
        path: "/create",
        element: <EventForm />,
      },{
        path: "/ownprofile",
        element: <UserProfile />,
      },{
        path: "/event/:id",
        element: <EventPage />,
      },
      
    ],
  },
]);


const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={Router} />
  </React.StrictMode>
);

reportWebVitals();
